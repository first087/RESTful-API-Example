package com.artitk.restful.model

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class StoreTest {
    private lateinit var store: Store

    @BeforeEach
    fun createStore() {
        store = Store()
    }

    @Test
    fun getAllItemsShouldReturnStringArrayIncludeInitItem() {
        val expected = arrayOf(Store.INIT_ITEM)
        val actual = store.getAllItems()

        Assertions.assertArrayEquals(expected, actual)
    }

    @Test
    fun getItem0ShouldReturnInitItem() {
        val expected = Store.INIT_ITEM
        val actual = store.getItem(0)

        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun addItemShouldStoreItem() {
        val newItem1 = "New item 1"
        val newItem2 = "New item 2"

        store.addItem(newItem1)
        store.addItem(newItem2)

        val expected = arrayOf(Store.INIT_ITEM, newItem1, newItem2)
        val actual = store.getAllItems()

        Assertions.assertArrayEquals(expected, actual)
    }

    @Test
    fun updateItemShouldStoreItemAndReturnOldItem() {
        val newItem = "New item"
        store.addItem(newItem)

        val updateItem = "Update item"

        val oldItem = store.updateItem(1, updateItem)

        val expected = arrayOf(Store.INIT_ITEM, updateItem)
        val actual = store.getAllItems()

        Assertions.assertArrayEquals(expected, actual)
        Assertions.assertEquals(newItem, oldItem)
    }

    @Test
    fun removeItemShouldRemovedItemAndReturnRemovedItem() {
        val newItem1 = "New item 1"
        val newItem2 = "New item 2"

        store.addItem(newItem1)
        store.addItem(newItem2)

        val removedItem1 = store.removeItem(1)
        val removedItem2 = store.removeItem(1)

        val expected = arrayOf(Store.INIT_ITEM)
        val actual = store.getAllItems()

        Assertions.assertArrayEquals(expected, actual)
        Assertions.assertEquals(newItem1, removedItem1)
        Assertions.assertEquals(newItem2, removedItem2)
    }
}
