package com.chaze.india.models;

import java.io.Serializable;

public class RestaurantItem extends Item implements Serializable {


    private String imageResource;
    private Restaurant itemRestaurant;
    private String category;


    public RestaurantItem(String name, String productCode, String category, boolean isRecommended, String imageResource, Restaurant itemRestaurant, double price, boolean isVeg, boolean isFavourite, String currentRatingByUser, float rating, int ratingCount, int orderCount, double itemOffer, boolean hasOffer) {
        super(name, productCode, isRecommended, price, isFavourite, currentRatingByUser, rating, ratingCount, itemOffer, hasOffer);

        this.imageResource = imageResource;
        this.itemRestaurant = itemRestaurant;

        this.category = category;
    }


    public String getImageResource() {
        return imageResource;
    }


    public void setImageResource(String imageResource) {
        this.imageResource = imageResource;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public Restaurant getItemRestaurant() {
        return itemRestaurant;
    }

    public void setItemRestaurant(Restaurant itemRestaurant) {
        this.itemRestaurant = itemRestaurant;
    }

    @Override
    public Business getBusiness() {
        return itemRestaurant;
    }
}
