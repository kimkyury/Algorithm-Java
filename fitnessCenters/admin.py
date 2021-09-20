from django.contrib import admin
from django.utils.html import mark_safe
from . import models

# Register your models here.


@admin.register(models.Fitnessequipment, models.Facility, models.Option)
class ItemAdmin(admin.ModelAdmin):

    """각 아이템 정보 띄우기"""

    list_display = ("name", "used_by")

    def used_by(self, obj):
        return obj.fitness.count()

    pass


class PhotoInline(admin.TabularInline):

    model = models.Photo


@admin.register(models.Fitness)
class fitnessAdmin(admin.ModelAdmin):

    """RoomAdmin Admin Definition"""

    inlines = (PhotoInline,)

    fieldsets = (
        (
            "기본정보",
            {
                "fields": (
                    "name",
                    "description",
                    "province",
                    "price",
                )
            },
        ),
        (
            "영업시간",
            {
                "fields": (
                    "open_time",
                    "close_time",
                )
            },
        ),
        (
            "헬스장 상세정보",
            {"fields": ("fitnessequipments", "facilities")},
        ),
        ("참고사항", {"fields": ("options",)}),
    )

    list_display = (
        "name",
        "province",
        "city",
        "price",
        "guests",
    )

    list_filter = ("facilities",)

    # search_fields = "=city"

    filter_horizontal = (
        "facilities",
        "options",
    )

    def count_photos(self, obj):
        return obj.photos.count()

    count_photos.short_description = "Photo Count"


@admin.register(models.Photo)
class PhotoAdmin(admin.ModelAdmin):
    """Photo Admin Definition"""

    list_display = ("__str__", "get_thumbnail")

    def get_thumbnail(self, obj):
        return mark_safe(f'<img width="50px" src="{obj.file.url}" />')

    get_thumbnail.short_description = "Thumnail"
