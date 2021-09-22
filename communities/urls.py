from django.urls import path

from .views import *

urlpatterns = [
    path("/board", board, name="board"),
]
