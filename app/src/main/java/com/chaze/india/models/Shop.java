package com.chaze.india.models;

import java.io.Serializable;


public class Shop extends Business implements Serializable {


    private String category;


    public Shop(String name, String contact, String address, String code, String imageResourceId, String minOrderAmount, String timing, String status, float rating, int messageStatus, String message, String taxDescription, double tax, String category) {
        super(name, contact, address, code, imageResourceId, minOrderAmount, timing, status, rating, messageStatus, message, taxDescription, tax);
        this.category = category;
    }

    public Shop() {

    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
