items = []
items = ['Init item']


class Store():
    @staticmethod
    def init():
        items.clear()
        items.append('Init item')

    @staticmethod
    def get_all_items():
        return items

    @staticmethod
    def get_item(index):
        return items[index]

    @staticmethod
    def add_item(new_item):
        items.append(new_item)

    @staticmethod
    def update_item(index, update_item):
        old_item = items[index]
        items[index] = update_item
        return old_item

    @staticmethod
    def remove_item(index):
        pass
