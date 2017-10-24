package com.artitk.RESTfulSpringBoot.model

import org.junit.Before

class StoreTest {
    private lateinit var store: Store

    @Before
    fun createStore() {
        store = Store()
    }
}
