package com.artitk.RESTfulSpringBoot.controller

import com.artitk.RESTfulSpringBoot.bean.Item
import com.artitk.RESTfulSpringBoot.bean.Items
import com.artitk.RESTfulSpringBoot.exception.BadRequestException
import com.artitk.RESTfulSpringBoot.exception.NotFoundException
import com.artitk.RESTfulSpringBoot.model.Store
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class ItemController {
    private var store: Store? = null

    init {
        store = Store()
    }

    @GetMapping("/item/")
    fun getAllItems(): Items {
        return Items(store!!.getAllItems())
    }

    @GetMapping("/item/{index}")
    fun getItem(@PathVariable index: Int): Item {
        val item: String
        try {
            item = store!!.getItem(index)
        } catch (e: IndexOutOfBoundsException) {
            throw NotFoundException(e)
        }

        return Item(item)
    }

    @PostMapping("/item/")
    @ResponseStatus(HttpStatus.CREATED)
    fun addItem(@RequestBody item: Item) {
        val newItem: String = item.item ?: throw BadRequestException()

        store!!.addItem(newItem)
    }
}
