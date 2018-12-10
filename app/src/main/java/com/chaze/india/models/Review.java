package com.chaze.india.models;

import java.io.Serializable;


public class Review implements Serializable {


    private String userName;

    private String review;

    public Review(String name, String review) {
        this.userName = name;
        this.review = review;
    }

    public Review() {
        super();
    }


}
