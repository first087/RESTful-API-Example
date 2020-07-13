package com.artitk.restful.controller;

import com.artitk.restful.bean.*;
import com.artitk.restful.exception.*;
import com.artitk.restful.model.Store;
import org.springframework.http.HttpStatus;
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
        String item;
        try {
            item = store.getItem(index);
        } catch (IndexOutOfBoundsException e) {
            throw new NotFoundException(e);
        }

        return new Item(item);
    }

    @PostMapping("/item/")
    @ResponseStatus(HttpStatus.CREATED)
    public void addItem(@RequestBody Item item) {
        String newItem = item.getItem();
        if (newItem == null) throw new BadRequestException();

        store.addItem(newItem);
    }

    @PutMapping("/item/{index}")
    public HashMap<String, String> updateItem(@PathVariable Integer index, @RequestBody Item item) {
        String newItem = item.getItem();
        if (newItem == null) throw new BadRequestException();

        String oldItem;
        try {
            oldItem = store.updateItem(index, newItem);
        } catch (IndexOutOfBoundsException e) {
            throw new NotFoundException(e);
        }

        HashMap<String, String> itemHashMap = new HashMap<>();
        itemHashMap.put("oldItem", oldItem);

        return itemHashMap;
    }

    @DeleteMapping("/item/{index}")
    public HashMap<String, String> removeItem(@PathVariable Integer index) {
        String removeItem;
        try {
            removeItem = store.removeItem(index);
        } catch (IndexOutOfBoundsException e) {
            throw new NotFoundException(e);
        }

        HashMap<String, String> itemHashMap = new HashMap<>();
        itemHashMap.put("removeItem", removeItem);

        return itemHashMap;
    }
}
