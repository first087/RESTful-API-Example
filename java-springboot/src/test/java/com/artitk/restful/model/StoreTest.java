package com.artitk.restful.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StoreTest {
    private Store store;

    @BeforeEach
    public void createStore() {
        store = new Store();
    }

    @Test
    void getAllItemsShouldReturnStringArrayIncludeInitItem() {
        String[] expected = new String[]{Store.INIT_ITEM};
        String[] actual = store.getAllItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void getItem0ShouldReturnInitItem() {
        String expected = Store.INIT_ITEM;
        String actual = store.getItem(0);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void addItemShouldStoreItem() {
        String newItem1 = "New item 1";
        String newItem2 = "New item 2";

        store.addItem(newItem1);
        store.addItem(newItem2);

        String[] expected = new String[]{Store.INIT_ITEM, newItem1, newItem2};
        String[] actual = store.getAllItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void updateItemShouldStoreItemAndReturnOldItem() {
        String newItem = "New item";
        store.addItem(newItem);

        String updateItem = "Update item";

        String oldItem = store.updateItem(1, updateItem);

        String[] expected = new String[]{Store.INIT_ITEM, updateItem};
        String[] actual = store.getAllItems();

        Assertions.assertArrayEquals(expected, actual);
        Assertions.assertEquals(newItem, oldItem);
    }

    @Test
    void removeItemShouldRemovedItemAndReturnRemovedItem() {
        String newItem1 = "New item 1";
        String newItem2 = "New item 2";

        store.addItem(newItem1);
        store.addItem(newItem2);

        String removedItem1 = store.removeItem(1);
        String removedItem2 = store.removeItem(1);

        String[] expected = new String[]{Store.INIT_ITEM};
        String[] actual = store.getAllItems();

        Assertions.assertArrayEquals(expected, actual);
        Assertions.assertEquals(newItem1, removedItem1);
        Assertions.assertEquals(newItem2, removedItem2);
    }
}
