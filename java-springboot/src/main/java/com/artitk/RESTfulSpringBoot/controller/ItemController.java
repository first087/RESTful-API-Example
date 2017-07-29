package com.artitk.RESTfulSpringBoot.controller;

import com.artitk.RESTfulSpringBoot.model.Store;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {
    private Store store;

    public ItemController() {
        store = new Store();
    }
}
