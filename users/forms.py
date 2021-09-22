from django import forms
from django.contrib.auth.forms import ReadOnlyPasswordHashField
from .models import User

# 유저생성
class UserCreationForm(forms.ModelForm):
    password1 = forms.CharField(label="비밀번호", widget=forms.PasswordInput)
    password2 = forms.CharField(label="비밀번호 확인", widget=forms.PasswordInput)

    class Meta:
        model = User
        fields = ("email", "nickname")

    def clean_password2(self):
        password1 = self.cleaned_data.get("password1")
        password2 = self.cleaned_data.get("password2")
        if password1 and password2 and password1 != password2:
            raise forms.ValidationError("비밀번호가 일치하지 않습니다. ")
        return password2

    def save(self, commit=True):
        user = super().save(commit=False)
        user.set_pasword(self.cleaned_data["password1"])
        if commit:
            user.save()
        return user


# 유저수정
class UserChangeForm(forms.ModelForm):
    password = ReadOnlyPasswordHashField()

    class Meta:
        model = User
        fields = (
            "email",
            "nickname",
            "password",
            "is_active",
            "is_staff",
            "is_superuser",
        )

    def clean_password(self):
        return self.initial["password"]
