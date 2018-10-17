package com.chaze.india.models;

import java.io.Serializable;


public class Business implements Serializable {

    private String name;
    private String contact;
    private String address;
    private String code;
    private String imageResourceId;
    private String minOrderAmount;
    private String timing;
    private String status;
    private float rating;
    private int messageStatus;
    private String message;

    private String taxDescription;
    private double tax;

    public Business(String name, String contact, String address, String code, String imageResourceId, String minOrderAmount, String timing, String status, float rating, int messageStatus, String message, String taxDescription, double tax) {
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.code = code;
        this.imageResourceId = imageResourceId;
        this.minOrderAmount = minOrderAmount;
        this.timing = timing;
        this.status = status;
        this.rating = rating;
        this.messageStatus = messageStatus;
        this.message = message;
        this.taxDescription = taxDescription;
        this.tax = tax;
    }

    public Business() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(String imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public String getMinOrderAmount() {
        return minOrderAmount;
    }

    public void setMinOrderAmount(String minOrderAmount) {
        this.minOrderAmount = minOrderAmount;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(int messageStatus) {
        this.messageStatus = messageStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTaxDescription() {
        return taxDescription;
    }

    public void setTaxDescription(String taxDescription) {
        this.taxDescription = taxDescription;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }
}
