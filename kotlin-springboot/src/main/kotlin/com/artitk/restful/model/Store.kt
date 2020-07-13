package com.artitk.restful.model

class Store {
    companion object {
        const val INIT_ITEM = "Init item"
    }

    private val items = arrayListOf(INIT_ITEM)

    fun getAllItems() = items.toTypedArray()

    fun getItem(index: Int) = items[index]

    fun addItem(newItem: String) {
        items.add(newItem)
    }

    fun updateItem(index: Int, updateItem: String) = items.set(index, updateItem)

    fun removeItem(index: Int) = items.removeAt(index)
}
