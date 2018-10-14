package com.mission.chaze.chaze.models;

public class Restaurant {
    String category;
    String image;

    public Restaurant(String category, String image) {
        this.category = category;
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ecomerceCategory{" +
                "category='" + category + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
