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
}
