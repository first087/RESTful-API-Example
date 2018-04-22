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

    def test_add_item(self):
        """
        Store.add_item must add new item in items.
        """

        # add 2 item
        new_item = ['Item 1', 'Item 2']
        Store.add_item(new_item[0])
        Store.add_item(new_item[1])

        # get from mock item
        items = Store.get_all_items()
        self.assertIs(len(items), 3)
        self.assertIs(items[1], new_item[0])
        self.assertIs(items[2], new_item[1])
