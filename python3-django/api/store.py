items = []
items = ['Init item']


class Store():
    @staticmethod
    def init():
        items.clear()
        items.append('Init item')


    @staticmethod
    def is_have_index_item(index):
        if index >= len(items) :
            return False
        return True

    @staticmethod
    def get_all_items():
        return items

    @staticmethod   
    def get_item(index):
        if not Store.is_have_index_item(index):
            return None
        return items[index]

    @staticmethod
    def add_item(new_item):
        items.append(new_item)

    @staticmethod
    def update_item(index, update_item):
        if not Store.is_have_index_item(index):
            return None
        old_item = items[index]
        items[index] = update_item
        return old_item

    @staticmethod
    def remove_item(index):
        if not Store.is_have_index_item(index):
            return None
        remove_item = items[index]
        del(items[index])
        return remove_item
