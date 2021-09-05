from django.contrib import admin
from django.contrib.auth.admin import UserAdmin
from . import models


@admin.register(models.Client)
class ClientAdmin(admin.ModelAdmin):
    fieldsets = UserAdmin.fieldsets + (
        (
            "부가 정보",
            {
                "fields": (
                    "phone_number",
                    "avatar",
                    "gender",
                    "bio",
                    "birthdate",
                    "province",
                    "city",
                )
            },
        ),
        (
            "현황",
            {
                "fields": (
                    "resent_checkIn_time",
                    "resent_checkOut_time",
                    "Total_hoursOfExercise",
                    "Total_hoursOfVisits",
                    "Expiration_date",
                )
            },
        ),
    )

    list_filter = UserAdmin.list_filter
    list_display = (
        "username",
        "first_name",
        "last_name",
        "email",
    )


@admin.register(models.Owner)
class ClientAdmin(admin.ModelAdmin):
    fieldsets = UserAdmin.fieldsets + (
        (
            "부가 정보",
            {
                "fields": (
                    "phone_number",
                    "avatar",
                    "gender",
                    "bio",
                    "birthdate",
                    "province",
                    "city",
                )
            },
        ),
    )
    list_filter = UserAdmin.list_filter
    list_display = (
        "username",
        "first_name",
        "last_name",
        "email",
    )
