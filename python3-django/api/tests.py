from django.test import TestCase
from .store import Store
# Create your tests here.


class APITestCase(TestCase):
    def setUp(self):
        Store.init()

    def test_get_all_items(self):
        """
        Store.get_all_items must return all item in store
        """
        item = Store.get_all_items()
        self.assertTrue(isinstance(item, list))
        self.assertIs(len(item), 1)
