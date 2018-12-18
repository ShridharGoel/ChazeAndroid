package com.chaze.india.models.Ecommerce;


import java.io.Serializable;
import java.util.ArrayList;

public class ShopItem implements Serializable {


    private ArrayList<String> imageResource;
    private Shop itemShop;
    private String category;


    private String name;
    private String productCode;
    private double itemOffer;
    private boolean isRecommended;
    private double price;
    private boolean isFavourite;
    private String currentRatingByUser;
    private float rating;
    private int ratingCount;
    private Shop shop;
    private boolean hasOffer;

    public ShopItem(ArrayList<String> imageResource, Shop itemShop, String category, String name, String productCode, double itemOffer, boolean isRecommended, double price, boolean isFavourite, String currentRatingByUser, float rating, int ratingCount, Shop shop, boolean hasOffer) {
        this.imageResource = imageResource;
        this.itemShop = itemShop;
        this.category = category;
        this.name = name;
        this.productCode = productCode;
        this.itemOffer = itemOffer;
        this.isRecommended = isRecommended;
        this.price = price;
        this.isFavourite = isFavourite;
        this.currentRatingByUser = currentRatingByUser;
        this.rating = rating;
        this.ratingCount = ratingCount;
        this.shop = shop;
        this.hasOffer = hasOffer;
    }

    public ArrayList<String> getImageResource() {
        return imageResource;
    }

    public void setImageResource(ArrayList<String> imageResource) {
        this.imageResource = imageResource;
    }

    public Shop getItemShop() {
        return itemShop;
    }

    public void setItemShop(Shop itemShop) {
        this.itemShop = itemShop;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public double getItemOffer() {
        return itemOffer;
    }

    public void setItemOffer(double itemOffer) {
        this.itemOffer = itemOffer;
    }

    public boolean isRecommended() {
        return isRecommended;
    }

    public void setRecommended(boolean recommended) {
        isRecommended = recommended;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public boolean isHasOffer() {
        return hasOffer;
    }

    public void setHasOffer(boolean hasOffer) {
        this.hasOffer = hasOffer;
    }
}
