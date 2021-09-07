from django.contrib.auth.models import AbstractUser
from django.db import models
from core import models as core_models


class Client(AbstractUser, core_models.CheckOut_TimeStampedModel):

    # ID, Password, 이메일은 상속받음

    # 성별 선택
    GENDER_MALE = "남성"
    GENDER_FEMALE = "여성"
    GENDER_OTHER = "other"
    GENDER_CHOICES = (
        (GENDER_MALE, "남성"),
        (GENDER_FEMALE, "여성"),
        (GENDER_OTHER, "Other"),
    )

    # 지역 선택(경기,강원,충청남/북,전라남/북,경상남/북, 제주)
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

    # 필드설정 (이미지, 성별, 소개, 생일)
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

    """고객 정보"""

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
