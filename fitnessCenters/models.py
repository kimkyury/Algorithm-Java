from django.db import models
from users import models as user_models
from core import models as core_models
from django.urls import reverse

# Create your models here.


class AbstractItem(core_models.TimeStampedModel):

    """아이템 추상 클래스"""

    name = models.CharField(max_length=80)

    class Meta:
        abstract = True

    def __str__(self):
        return self.name


class Fitnessequipment(AbstractItem):
    """헬스기구 크래스"""

    class Meta:
        verbose_name_plural = "보유 기구"


class Facility(AbstractItem):
    """시설 클래스"""

    class Meta:
        verbose_name_plural = "보유 시설"


class Option(AbstractItem):
    """옵션 클래스"""

    class Meta:
        verbose_name_plural = "헬스장 옵션"


class Photo(core_models.TimeStampedModel):

    """Photo Model Definition"""

    caption = models.CharField(max_length=80)
    file = models.ImageField(upload_to="fitness_photos")
    fitness = models.ForeignKey(
        "Fitness", related_name="photos", on_delete=models.CASCADE
    )

    class Meta:
        verbose_name_plural = "헬스장 사진"

    def __str__(self):
        return self.caption


class Fitness(core_models.TimeStampedModel):

    """헬스장 클래스"""

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

    # 헬스장 기본정보 (상업명/설명/지역(도/시)/가격)
    name = models.CharField("헬스장 이름", max_length=140)
    description = models.TextField("소개", blank=True, null=True)

    province = models.CharField(
        "위치한 지역(도)", choices=PROVINCE_CHOICES, max_length=20, blank=True, null=True
    )
    city = models.CharField("지역(시)", max_length=80, null=True)
    price = models.IntegerField("월정액 가격")

    # 핼수장 부가정보(회원수/영업시간/보유기구/보유시설/옵션)
    guests = models.IntegerField("회원 수")
    open_time = models.TimeField("오픈시간")
    close_time = models.TimeField("마감시간")

    fitnessequipments = models.ManyToManyField(
        "Fitnessequipment", related_name="fitness", blank=True
    )
    facilities = models.ManyToManyField("Facility", related_name="fitness", blank=True)
    options = models.ManyToManyField("Option", related_name="fitness", blank=True)
    
    #점주 연결 
    owner = models.ForeignKey(
        "users.User", related_name="fitness", on_delete=models.SET_NULL, null=True
    )


    def __str__(self):
        return self.name

    def save(self, *args, **kwargs):
        self.city = str.capitalize(self.city)
        super().save(*args, **kwargs)

    def first_photo(self):
        (photo,) = self.photos.all()[:1]  # ','해주면 실제로 원하는 게 첫 값이라는 걸 python이 앎
        return photo.file.url

    def get_absolute_url(self):
        return reverse("fitness:detail", kwargs={"pk": self.pk})

    """ def total_rating(self):  # 총 평균을 표시하자
        all_reviews = self.reviews.all()
        all_ratings = 0

        if len(all_reviews) > 0:
            for review in all_reviews:
                all_ratings += review.rating_average()
            return all_ratings / len(all_reviews)
        return 0 """
