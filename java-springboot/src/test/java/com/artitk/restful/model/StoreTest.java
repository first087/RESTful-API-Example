package com.artitk.restful.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StoreTest {
    private Store store;

    @Before
    public void createStore() {
        store = new Store();
    }

    @Test
    public void getAllItemsShouldReturnStringArrayIncludeInitItem() {
        String[] expected = new String[]{Store.INIT_ITEM};
        String[] actual = store.getAllItems();

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void getItem0ShouldReturnInitItem() {
        String expected = Store.INIT_ITEM;
        String actual = store.getItem(0);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addItemShouldStoreItem() {
        String newItem1 = "New item 1";
        String newItem2 = "New item 2";

        store.addItem(newItem1);
        store.addItem(newItem2);

        String[] expected = new String[]{Store.INIT_ITEM, newItem1, newItem2};
        String[] actual = store.getAllItems();

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void updateItemShouldStoreItemAndReturnOldItem() {
        String newItem = "New item";
        store.addItem(newItem);

        String updateItem = "Update item";

        String oldItem = store.updateItem(1, updateItem);

        String[] expected = new String[]{Store.INIT_ITEM, updateItem};
        String[] actual = store.getAllItems();

        Assert.assertArrayEquals(expected, actual);
        Assert.assertEquals(newItem, oldItem);
    }

    @Test
    public void removeItemShouldRemovedItemAndReturnRemovedItem() {
        String newItem1 = "New item 1";
        String newItem2 = "New item 2";

        store.addItem(newItem1);
        store.addItem(newItem2);

        String removedItem1 = store.removeItem(1);
        String removedItem2 = store.removeItem(1);

        String[] expected = new String[]{Store.INIT_ITEM};
        String[] actual = store.getAllItems();

        Assert.assertArrayEquals(expected, actual);
        Assert.assertEquals(newItem1, removedItem1);
        Assert.assertEquals(newItem2, removedItem2);
    }
}
