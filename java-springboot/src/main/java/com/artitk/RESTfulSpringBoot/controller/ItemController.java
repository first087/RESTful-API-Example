package com.artitk.RESTfulSpringBoot.controller;

import com.artitk.RESTfulSpringBoot.bean.*;
import com.artitk.RESTfulSpringBoot.model.Store;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {
    private Store store;

    public ItemController() {
        store = new Store();
    }

    @GetMapping("/item/")
    public Items getAllItems() {
        return new Items(store.getAllItems());
    }

    @GetMapping("/item/{index}")
    public Item getItem(@PathVariable Integer index) {
        return new Item(store.getItem(index));
    }
}
