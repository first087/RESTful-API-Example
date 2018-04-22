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

    def testis_have_index_item(self):
        """
        Store.is_have_index_item 
        must return True when index have in items
        and must return False when not have in items
        """
        is_have_index_0 = Store.is_have_index_item(0)
        is_have_index_1 = Store.is_have_index_item(1)
        self.assertTrue(is_have_index_0)
        self.assertFalse(is_have_index_1)

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
        new_items = ['Item 1 in test_add_item', 'Item 2 in test_add_item']
        Store.add_item(new_items[0])
        Store.add_item(new_items[1])

        # get from mock item
        items = Store.get_all_items()
        self.assertIs(len(items), 3)
        self.assertIs(items[1], new_items[0])
        self.assertIs(items[2], new_items[1])

    def test_update_item(self):
        """
        Store.update_item must update item with
        specific in items and return old is before update.
        """
        # add 1 item
        new_item = 'New Item in case update_item'
        Store.add_item(new_item)

        # update item
        update_item = 'Update Item'
        old_item = Store.update_item(1, update_item)

        # get all item
        items = Store.get_all_items()

        self.assertIs(len(items), 2)
        self.assertIs(items[1], update_item)
        self.assertIs(old_item, new_item)

    def test_remove_item(self):
        """
        Store.remove_item must remove item with
        specific in items and return item is before remove.
        """
        # add 1 item
        new_item = 'New Item in case remove_item'
        Store.add_item(new_item)

        # remove item
        remove_item = Store.remove_item(1)

        # get all item
        items = Store.get_all_items()

        self.assertIs(len(items), 1)
        self.assertIs(remove_item, new_item)
