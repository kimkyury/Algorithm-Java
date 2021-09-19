from django.db import models
from django.contrib.auth.models import AbstractBaseUser, BaseUserManager
from datetime import datetime
from core import models as core_models
import uuid

USER_STATUS = {
    "ACTIVE": "ACTIVE",  # 활동계정
    "STOP": "STOP",  # 탈퇴
    "PAUSE": "PAUSE",  # 휴면계정
    "BAN": "BAN",  # 정지계정
}

ROLES = {
    "ROLE_CLIENT": "CLIENT",  # 고객용
    "ROLE_OWNER": "OWNER",  # 점주용
    "ROLE_SUPERHOST": "SUPERHOST",  # 총 관리자
}



class UserManager(BaseUserManager):
    def _create_user(self, email, password, **extra_fields): 
        if not email : # 이메일이 없다면 
            raise ValueError('이메일은 필수 요소입니다.') 
        if not password : # 패스워드가 없다면 
            raise ValueError('패스워드는 필수 요소입니다.') # 이메일 주소를 소문자로 변환하는 과정을 거친 뒤에 저장한다. 
        email = self.normalize_email(email) # 사용자 모델 객체를 생성한다. 
        user = self.model( 
            email = email , 
            is_active = extra_fields.get('is_active') 
            ) 
        
        # 사용자 패스워드는 Django에서 제공해주는 해시화 과정(SHA 256)을 거쳐서 저장한다. 
        user.set_password(password) # 실제로 DB에 사용자 정보를 저장한다. 
        user.save(using=self._db) # 기본적으로 모든 사용자는 일반사용자 권한을 갖게된다. 
        self.create_auth(user, ROLES.get('ROLE_NORMAL', 'NORMAL')) 
        
        # 스탭 권한을 부여할지 확인 후 MANAGER 권한을 부여한다. 
        if extra_fields.get('is_staff') is True : 
            self.create_auth(user, ROLES.get('ROLE_MANAGER', 'MANAGER')) # 슈퍼 관리자 권한을 부여할지 확인 후 SUPER 권한을 부여한다. 
        if extra_fields.get('is_superuser') is True : 
            self.create_auth(user, ROLES.get('ROLE_SUPER', 'SUPER')) return user # 일반 사용자 생성 
    def create_user(self, email, password=None, **extra_fields): 
        extra_fields['is_active'] = False 
        extra_fields['is_staff'] = False 
        extra_fields['is_superuser'] = False 
        return self._create_user(email, password, **extra_fields) # 스탭 사용자 생성 
    def create_staff(self, email, password=None, **extra_fields): 
        extra_fields['is_active'] = True 
        extra_fields['is_staff'] = True 
        extra_fields['is_superuser'] = False 
        return self._create_user(email, password, **extra_fields) # 슈퍼 관리자 생성 
    def create_superuser(self, email, password=None, **extra_fields): 
        extra_fields['is_active'] = True 
        extra_fields['is_staff'] = True 
        extra_fields['is_superuser'] = True 
        return self._create_user(email, password, **extra_fields) # 권한 정보 등록 
    def create_auth( self, user, role=ROLES.get('ROLE_NORMAL', 'NORMAL')): 
        role_obj = Auth( 
            user = user, 
            role = role ) 
        role_obj.save(using=self.db) 
        return role_obj




class User(AbstractBaseUser):

    # 필드 설정
    id = models.BigAutoField(primary_key=True)
    email = models.EmailField(max_length=254, unique=True)
    secret = models.UUIDField(default=uuid.uuid4)  # 사용자 비밀키
    status = models.CharField(
        max_length=10, default=USER_STATUS.get("ACTIVE", "ACTIVE")
    )  # 계정상태
    is_active = models.BooleanField(default=False)  # 계정 활성화 여부
    created_at = models.DateTimeField(auto_now_add=True)  # 계정 생성일
    updated_at = models.DateTimeField(auto_now=True)  # 계정 수정일
    

    objects = UserManager() # 유저 유형 관리
    USERNAME_FIELD = 'email' #사용자 이름 필드

    
    def get_id(self) :
        return self.id # PK값

        # 성별 선택
    GENDER_MALE = "남성"
    GENDER_FEMALE = "여성"
    GENDER_OTHER = "other"
    GENDER_CHOICES = (
        (GENDER_MALE, "남성"),
        (GENDER_FEMALE, "여성"),
        (GENDER_OTHER, "Other"),
    )

    # 지역 선택(경기 강원, 충청납/북, 전라남/북, 경상남/북, 제주)
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


    class Meta:
        abstract = True
    

"""
from django.contrib.auth.models import AbstractUser
from django.db import models

"""



class Auth(models.Model): 
    user = models.ForeignKey(User, related_name='auths', on_delete=models.CASCADE) 
    role = models.CharField(max_length=30, default=ROLES.get('ROLE_NORMAL', 'NORMAL'))
