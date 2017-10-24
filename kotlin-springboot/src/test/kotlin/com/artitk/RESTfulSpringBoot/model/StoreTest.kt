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
}
