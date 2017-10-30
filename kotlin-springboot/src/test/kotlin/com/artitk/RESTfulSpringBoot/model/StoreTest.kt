package com.artitk.RESTfulSpringBoot.model

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class StoreTest {
    private lateinit var store: Store

    @Before
    fun createStore() {
        store = Store()
    }

    @Test
    fun getAllItemsShouldReturnStringArrayIncludeInitItem() {
        val expected: Array<String> = arrayOf(Store.INIT_ITEM)
        val actual: Array<String> = store.getAllItems()

        Assert.assertArrayEquals(expected, actual)
    }

    @Test
    fun getItem0ShouldReturnInitItem() {
        val expected: String = Store.INIT_ITEM
        val actual: String = store.getItem(0)

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun addItemShouldStoreItem() {
        val newItem1 = "New item 1"
        val newItem2 = "New item 2"

        store.addItem(newItem1)
        store.addItem(newItem2)

        val expected: Array<String> = arrayOf(Store.INIT_ITEM, newItem1, newItem2)
        val actual: Array<String> = store.getAllItems()

        Assert.assertArrayEquals(expected, actual)
    }

    @Test
    fun updateItemShouldStoreItemAndReturnOldItem() {
        val newItem = "New item"
        store.addItem(newItem)

        val updateItem = "Update item"

        val oldItem: String = store.updateItem(1, updateItem)

        val expected: Array<String> = arrayOf(Store.INIT_ITEM, updateItem)
        val actual: Array<String> = store.getAllItems()

        Assert.assertArrayEquals(expected, actual)
        Assert.assertEquals(newItem, oldItem)
    }

    @Test
    fun removeItemShouldRemovedItemAndReturnRemovedItem() {
        val newItem1 = "New item 1"
        val newItem2 = "New item 2"

        store.addItem(newItem1)
        store.addItem(newItem2)

        val removedItem1 = store.removeItem(1)
        val removedItem2 = store.removeItem(1)

        val expected: Array<String> = arrayOf(Store.INIT_ITEM)
        val actual: Array<String> = store.getAllItems()

        Assert.assertArrayEquals(expected, actual)
        Assert.assertEquals(newItem1, removedItem1)
        Assert.assertEquals(newItem2, removedItem2)
    }
}
