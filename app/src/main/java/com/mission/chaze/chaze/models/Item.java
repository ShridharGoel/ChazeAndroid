package com.mission.chaze.chaze.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;

public abstract class  Item implements Serializable {


    private String name;
    private String productCode;
    private double itemOffer;
    private boolean isRecommended;
    private double price;
    private boolean isFavourite;
    private String currentRatingByUser;
    private float rating;
    private int ratingCount;
    private  boolean hasOffer;



    public Item(String name, String productCode, boolean isRecommended,double price, boolean isFavourite, String currentRatingByUser, float rating, int ratingCount,double itemOffer, boolean hasOffer) {
        this.name = name;
        this.itemOffer = itemOffer;
        this.productCode = productCode;
        this.isRecommended = isRecommended;
        this.price = price;
        this.isFavourite = isFavourite;
        this.currentRatingByUser = currentRatingByUser;
        this.rating = rating;
        this.ratingCount = ratingCount;
        this.hasOffer=hasOffer;
    }

    public boolean isRecommended() {
        return isRecommended;
    }


    public boolean isHasOffer() {
        return hasOffer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }


    public double getPrice() {
        return price;
    }

    public double getItemOffer(){return this.itemOffer;}

    public void setPrice(double price) {
        this.price = price;
    }


    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
    }


    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    public String getCurrentRatingByUser() {
        return currentRatingByUser;
    }

    public void setCurrentRatingByUser(String currentRatingByUser) {
        this.currentRatingByUser = currentRatingByUser;
    }

    public abstract Business getBusiness();
}
