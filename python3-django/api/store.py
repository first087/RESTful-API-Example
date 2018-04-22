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
    def add_item(newItem):
        pass

    @staticmethod
    def update_item(index, updateItem):
        pass

    @staticmethod
    def remove_item(index):
        pass
