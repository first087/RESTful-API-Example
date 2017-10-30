package com.artitk.RESTfulSpringBoot.controller

import com.artitk.RESTfulSpringBoot.bean.Item
import com.artitk.RESTfulSpringBoot.bean.Items
import com.artitk.RESTfulSpringBoot.exception.NotFoundException
import com.artitk.RESTfulSpringBoot.model.Store
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

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
}
