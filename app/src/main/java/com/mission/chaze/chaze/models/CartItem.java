package com.mission.chaze.chaze.models;

import java.io.Serializable;

public class CartItem implements Serializable {

    private Item item;
    private int itemQuantity;


    public void setRestaurantItem(RestaurantItem restaurantItem) {
        this.item = restaurantItem;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public CartItem(Item item, int itemQuantity) {

        this.item = item;
        this.itemQuantity = itemQuantity;

    }

    public double getCartItemPrice() {
        return ((double) itemQuantity * item.getPrice());
    }

}
