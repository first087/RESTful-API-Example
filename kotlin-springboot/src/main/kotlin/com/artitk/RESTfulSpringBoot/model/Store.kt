package com.artitk.RESTfulSpringBoot.model

class Store {
    companion object {
        const val INIT_ITEM = "Init item"
    }

    private val items: ArrayList<String> = arrayListOf(INIT_ITEM)
}