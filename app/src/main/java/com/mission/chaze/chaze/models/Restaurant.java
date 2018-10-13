package com.mission.chaze.chaze.models;

import java.io.Serializable;


public class Restaurant extends Business implements Serializable {


    private String speciality;


    public Restaurant(String name, String contact, String address, String code, String imageResourceId, String minOrderAmount, String timing, String status, float rating, int messageStatus, String message, String taxDescription, double tax, String speciality) {
        super(name, contact, address, code, imageResourceId, minOrderAmount, timing, status, rating, messageStatus, message, taxDescription, tax);
        this.speciality = speciality;
    }

    public Restaurant() {
        super();
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
