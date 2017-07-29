package com.artitk.RESTfulSpringBoot.controller;

import com.artitk.RESTfulSpringBoot.bean.*;
import com.artitk.RESTfulSpringBoot.model.Store;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

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

    @PostMapping("/item/")
    public void addItem(@RequestBody Item item) {
        store.addItem(item.getItem());
    }

    @PutMapping("/item/{index}")
    public HashMap<String, String> updateItem(@PathVariable Integer index, @RequestBody Item item) {
        String oldItem = store.updateItem(index, item.getItem());

        HashMap<String, String> itemHashMap = new HashMap<>();
        itemHashMap.put("oldItem", oldItem);

        return itemHashMap;
    }

    @DeleteMapping("/item/{index}")
    public HashMap<String, String> removeItem(@PathVariable Integer index) {
        String removeItem = store.removeItem(index);

        HashMap<String, String> itemHashMap = new HashMap<>();
        itemHashMap.put("removeItem", removeItem);

        return itemHashMap;
    }
}
