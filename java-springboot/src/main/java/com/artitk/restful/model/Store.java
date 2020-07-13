package com.artitk.restful.model;

import java.util.ArrayList;

public class Store {
    public static final String INIT_ITEM = "Init item";

    private ArrayList<String> items;

    public Store() {
        items = new ArrayList<>();

        items.add(INIT_ITEM);
    }

    public String[] getAllItems() {
        return items.toArray(new String[0]);
    }

    public String getItem(int index) {
        return items.get(index);
    }

    public void addItem(String newItem) {
        items.add(newItem);
    }

    public String updateItem(int index, String updateItem) {
        return items.set(index, updateItem);
    }

    public String removeItem(int index) {
        return items.remove(index);
    }
}
