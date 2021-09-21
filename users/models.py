from django.contrib.auth.models import (
    AbstractBaseUser,
    BaseUserManager,
    PermissionsMixin,
)
from django.db import models
from core import models as core_models
import uuid
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

    use_in_migrations = True

    def create_user(self, email, nickname, password=None):

        if not email:
            raise ValueError("이메일은 필수 입니다.")
        if not password:
            raise ValueError("패스워드는 필수 입니다.")

        user = self.model(email=self.normalize_email(email), nickname=nickname)
        user.set_password(password)
        user.save(using=self._db)

        self.create_auth(user, ROLES.get("ROLE_CLIENT", "CLIENT"))

        return user

    def create_superuser(self, email, nickname, password):

        user = self.create_user(
            email=self.normalize_email(email), nickname=nickname, password=password
        )
        user.is_admin = True
        user.is_superuser = True
        user.is_staff = True
        user.save(using=self._db)
        return user


class User(AbstractBaseUser, PermissionsMixin):

    objects = UserManager()

    email = models.EmailField(
        max_length=255,
        unique=True,
    )
    secret = models.UUIDField(default=uuid.uuid4)
    status = models.CharField(
        max_length=10, default=USER_STATUS.get("ACTIVE", "ACTIVE")
    )

    nickname = models.CharField(max_length=20, null=False, unique=True)
    is_active = models.BooleanField(default=True)
    is_admin = models.BooleanField(default=False)
    is_superuser = models.BooleanField(default=False)
    is_staff = models.BooleanField(default=False)
    date_joined = models.DateTimeField(auto_now_add=True)
    USERNAME_FIELD = "nickname"
    REQUIRED_FIELDS = ["email"]

    """
    nickname = models.CharField(max_length=20, null=False, unique=True)
    id = models.BigAutoField(primary_key=True)
    email = models.EmailField(max_length=320, unique=True)
    secret = models.UUIDField(default=uuid.uuid4)
    status = models.CharField(
        max_length=10, default=USER_STATUS.get("ACTIVE", "ACTIVE")
    )

    is_active = models.BooleanField(default=True)
    is_admin = models.BooleanField(default=False)
    is_superuser = models.BooleanField(default=False)
    is_staff = models.BooleanField(default=False)
    date_joined = models.DateTimeField(auto_now_add=True)

    objects = UserManager()
    USERNAME_FIELD = "nickname"
    REQUIRED_FILEDS = ["email"]

    def get_id(self):
        return self.id
    """

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
