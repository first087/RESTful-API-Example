package com.artitk.restful.model

class Store {
    companion object {
        const val INIT_ITEM = "Init item"
    }

    private val items: ArrayList<String> = arrayListOf(INIT_ITEM)

    fun getAllItems(): Array<String> = items.toTypedArray()

    fun getItem(index: Int): String = items[index]

    fun addItem(newItem: String) {
        items.add(newItem)
    }

    fun updateItem(index: Int, updateItem: String): String = items.set(index, updateItem)

    fun removeItem(index: Int): String = items.removeAt(index)
}
