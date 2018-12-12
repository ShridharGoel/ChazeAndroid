package com.chaze.india.models.Ecommerce;

import com.chaze.india.models.Item;

import java.io.Serializable;
import java.util.ArrayList;

public class ShopItem extends Item implements Serializable {


    private ArrayList<String> imageResource;
    private Shop itemShop;
    private String category;


    public ShopItem(String name, String productCode, String category, boolean isRecommended, ArrayList<String> imageResource, Shop itemShop, double price, boolean isVeg, boolean isFavourite, String currentRatingByUser, float rating, int ratingCount, int orderCount, double itemOffer, boolean hasOffer) {

        super(name, productCode, isRecommended, price, isFavourite, currentRatingByUser, rating, ratingCount, itemOffer, hasOffer);
        this.imageResource = imageResource;
        this.itemShop = itemShop;
        this.category = category;

    }

    public ArrayList<String> getImageResource() {
        return imageResource;
    }

    public void setImageResource(ArrayList<String> imageResource) {
        this.imageResource = imageResource;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Shop getItemShop() {
        return itemShop;
    }

    public void setItemShop(Shop itemShop) {
        this.itemShop = itemShop;
    }

}
