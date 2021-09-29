from django.db import models

class Board(models.Model):
    title = models.CharField(max_length=30, null=True)
    content = models.TextField()
    writer = models.CharField(max_length=30, null=True)