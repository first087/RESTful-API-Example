package com.artitk.restful.controller

import com.artitk.restful.bean.*
import com.artitk.restful.exception.*
import com.artitk.restful.model.Store
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class ItemController {
    private var store = Store()

    @GetMapping("/item/")
    fun getAllItems() = Items(store.getAllItems())

    @GetMapping("/item/{index}")
    fun getItem(@PathVariable index: Int): Item {
        val item: String
        try {
            item = store.getItem(index)
        } catch (e: IndexOutOfBoundsException) {
            throw NotFoundException(e)
        }

        return Item(item)
    }

    @PostMapping("/item/")
    @ResponseStatus(HttpStatus.CREATED)
    fun addItem(@RequestBody item: Item) {
        val newItem: String = item.item ?: throw BadRequestException()

        store.addItem(newItem)
    }

    @PutMapping("/item/{index}")
    fun updateItem(@PathVariable index: Int, @RequestBody item: Item): Map<String, String> {
        val newItem: String = item.item ?: throw BadRequestException()

        val oldItem: String
        try {
            oldItem = store.updateItem(index, newItem)
        } catch (e: IndexOutOfBoundsException) {
            throw NotFoundException(e)
        }

        val itemHashMap = hashMapOf<String, String>()
        itemHashMap["oldItem"] = oldItem

        return itemHashMap
    }

    @DeleteMapping("/item/{index}")
    fun removeItem(@PathVariable index: Int): Map<String, String> {
        val removeItem: String
        try {
            removeItem = store.removeItem(index)
        } catch (e: IndexOutOfBoundsException) {
            throw NotFoundException(e)
        }

        val itemHashMap = hashMapOf<String, String>()
        itemHashMap["removeItem"] = removeItem

        return itemHashMap
    }
}
