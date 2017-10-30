package com.artitk.RESTfulSpringBoot.controller

import com.artitk.RESTfulSpringBoot.bean.Items
import com.artitk.RESTfulSpringBoot.model.Store
import org.springframework.web.bind.annotation.GetMapping
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
}
