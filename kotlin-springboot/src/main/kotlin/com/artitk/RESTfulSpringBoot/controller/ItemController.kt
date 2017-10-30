package com.artitk.RESTfulSpringBoot.controller

import com.artitk.RESTfulSpringBoot.model.Store
import org.springframework.web.bind.annotation.RestController

@RestController
class ItemController {
    private var store: Store? = null

    init {
        store = Store()
    }
}
