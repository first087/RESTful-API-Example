from django.urls import path
from api import views
from .store import Store

# initial item
Store.init()

urlpatterns = [
    path('items/', views.item_list),
    path('item/<int:index>', views.item_detail),
]
