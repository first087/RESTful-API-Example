from django.test import TestCase
from .store import Store
# Create your tests here.


class APITestCase(TestCase):
    def setUp(self):
        Store.init()

    def test_get_all_items(self):
        """
        Store.get_all_items must return all item in store.
        """
        items = Store.get_all_items()
        self.assertIsInstance(items, list)
        self.assertIs(len(items), 1)
    
    def test_get_item(self):
        """
        Store.get_item must return item with specific.
        """
        item = Store.get_item(0)
        self.assertIsInstance(item, str)
