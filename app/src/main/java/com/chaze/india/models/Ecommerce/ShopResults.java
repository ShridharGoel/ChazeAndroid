package com.chaze.india.models.Ecommerce;

import com.chaze.india.models.Item;

import java.util.ArrayList;

public class ShopResults {

    private String name;
    private String id;

    private ArrayList<Item> items;

    public ShopResults(String name, String id, ArrayList<Item> items) {
        this.name = name;
        this.id = id;
        this.items = items;
    }


    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public ArrayList<Item> getItems() {

        return items;
    }
}
