from django.contrib import admin
from django.contrib.auth.admin import UserAdmin
from . import models


@admin.register(models.User)
class UserAdmin(admin.ModelAdmin):
    fieldsets = UserAdmin.fieldsets
    list_display = (  # 목록에 보여질 필드
        "nickname",
        "email",
    )

    list_display_links = (
        "nickname",
        "email",
    )
