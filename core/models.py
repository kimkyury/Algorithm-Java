from django.db import models


class TimeStampedModel(models.Model):

    """생성/업데이트 추상 모델"""

    created = models.DateTimeField(auto_now=True)
    updated = models.DateTimeField(auto_now=True)

    class Meta:
        abstract = True


class CheckOut_TimeStampedModel(models.Model):

    """입실/퇴실 추상 모델"""

    check_in = models.DateTimeField('최근 입실시간', blank=True, null=True);
    check_out = models.DateTimeField('최근 퇴실시간', blank=True, null=True)

    class Meta:
        abstract = True
