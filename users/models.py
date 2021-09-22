from django.contrib.auth.models import (
    AbstractBaseUser,
    BaseUserManager,
    PermissionsMixin,
)
from django.db import models
import uuid

from core import models as core_models
from datetime import datetime

USER_STATUS = {
    "ACTIVE": "ACTIVE",  # 활동 계정
    "STOP": "STOP",  # 정지(탈퇴)
    "PAUSE": "PAUSE",  # 휴면 계정
    "BAN": "BAN",  # 정지 계정
}

ROLES = {
    "ROLE_CLIENT": "CLIENT",  # 일반 사용자
    "ROLE_MANAGER": "MANAGER",  # 점주
    "ROLE_SUPER": "SUPER",  # 슈퍼 관리자
}


GENDER_MALE = "남성"
GENDER_FEMALE = "여성"
GENDER = (
    (GENDER_MALE, "남성"),
    (GENDER_FEMALE, "여성"),
)


PROVINCE_GG = "경기도"
PROVINCE_GW = "강원도"
PROVINCE_CB = "충청남도"
PROVINCE_CN = "충청북도"
PROVINCE_JB = "전라남도"
PROVINCE_JN = "전라북도"
PROVINCE_GB = "경상남도"
PROVINCE_GN = "경상북도"
PROVINCE_JJD = "제주도"
PROVINCE_CHOICES = (
    (PROVINCE_GG, "경기도"),
    (PROVINCE_GW, "강원도"),
    (PROVINCE_CB, "충청남도"),
    (PROVINCE_CN, "충청북도"),
    (PROVINCE_JB, "전라남도"),
    (PROVINCE_JN, "전라북도"),
    (PROVINCE_GB, "경상남도"),
    (PROVINCE_GN, "경상북도"),
    (PROVINCE_JJD, "제주도"),
)


class UserManager(BaseUserManager):
    def create_user(self, email, nickname, password=None):

        if not email:
            raise ValueError("이메일은 필수입니다. ")
        if not password:
            raise ValueError("패스워드는 필수입니다. ")

        user = self.model(email=self.normalize_email(email), nickname=nickname)
        user.set_password(password)
        user.save(using=self._db)
        self.create_auth(user, ROLES.get("ROLE_CLIENT", "CLIENT"))
        return user

    def create_superuser(self, email, nickname, password):
        if password is None:
            raise TypeError("패스워드는 필수입니다. ")

        user = self.create_user(email, nickname, password)
        user.is_superuser = True
        user.is_staff = True
        user.is_active = True
        user.save(using=self._db)
        return user

        # 권한 등록 함수

    def create_auth(self, user, role=ROLES.get("ROLE_CLIENT", "CLIENT")):
        role_obj = Auth(user=user, role=role)
        role_obj.save(using=self.db)
        return role_obj


class User(AbstractBaseUser, PermissionsMixin):

    id = models.UUIDField(primary_key=True, default=uuid.uuid4, editable=False)
    email = models.EmailField(
        verbose_name="이메일",
        max_length=255,
        unique=True,
    )
    nickname = models.CharField(max_length=20, null=False, unique=True)

    is_active = models.BooleanField(default=True)
    is_staff = models.BooleanField(default=False)
    is_superuser = models.BooleanField(default=False)

    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    USERNAME_FIELD = "email"
    REQUIRED_FIELDS = [
        "nickname",
    ]

    objects = UserManager()

    status = models.CharField(
        max_length=10, default=USER_STATUS.get("ACTIVE", "ACTIVE")
    )

    def __str__(self):
        return self.email

    class Meta:
        db_table = "user"


# 권한 테이블
class Auth(models.Model):
    user = models.ForeignKey(User, related_name="auths", on_delete=models.CASCADE)
    role = models.CharField(max_length=30, default=ROLES.get("ROLE_CLIENT", "CLIENT"))


"""
    # 필드설정 (이미지, 성별, 소개, 연령, 지역)
    phone_number = models.IntegerField("전화번호", blank=True, null=True)
    avatar = models.ImageField("대표이미지", upload_to="대표이미지", blank=True, null=True)
    gender = models.CharField(
        "성별", choices=GENDER_CHOICES, max_length=10, blank=True, null=True
    )
    bio = models.TextField("간략소개", blank=True, null=True)
    birthdate = models.DateField("생년월일", blank=True, null=True)
    province = models.CharField(
        "지역(도)", choices=PROVINCE_CHOICES, max_length=20, blank=True, null=True
    )
    city = models.CharField("지역(시)", max_length=80, null=True)

    class Meta:
        abstract = True


    고객정보

    # 이용중인 헬스장 선택

    # 실시간 상태정보
    resent_checkIn_time = models.IntegerField("최근 입실시간", blank=True, null=True)
    resent_checkOut_time = models.IntegerField("최근 퇴실시간", blank=True, null=True)
    Total_hoursOfExercise = models.IntegerField("총 운동 시간", blank=True, null=True)
    Total_hoursOfVisits = models.IntegerField("총 방문일 수", blank=True, null=True)
    # 이용권 만료날짜
    Expiration_date = models.DateField("이용권 만료날짜", blank=True, null=True)

    class Meta:
        verbose_name_plural = "고객"

    def save(self, *args, **kwargs):
        self.city = str.capitalize(self.city)
        super().save(*args, **kwargs)

    # 결제정보 (api 가져와야하나)
    """
