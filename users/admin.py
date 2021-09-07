from django.contrib import admin
from django.contrib.auth.admin import UserAdmin
from . import models


@admin.register(models.Client)
class ClientAdmin(admin.ModelAdmin):
    fieldsets = (
        (
            "기본 정보",
            {
                "fields": (
                    "username",
                    "password",
                    "first_name",
                    "last_name",
                    "email",
                )
            },
        ),
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
                    "check_in",
                    "check_out",
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
