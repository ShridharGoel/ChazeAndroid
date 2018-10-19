package com.chaze.india.models;

public class ActiveOrder {
    String image;
    String RestaurantName;

    public ActiveOrder(String image, String restaurantName) {
        this.image = image;
        RestaurantName = restaurantName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRestaurantName() {
        return RestaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        RestaurantName = restaurantName;
    }
}
