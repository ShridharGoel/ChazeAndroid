package com.chaze.india.models;

import java.util.ArrayList;

public class CategorySearchResults {


    private ArrayList<ShopResults> shopResults;


    public CategorySearchResults(ArrayList<ShopResults> shopResults) {
        this.shopResults = shopResults;
    }

    public CategorySearchResults() {
        shopResults = new ArrayList<>();
    }

    public ArrayList<ShopResults> getShopResults() {
        return shopResults;
    }
}
