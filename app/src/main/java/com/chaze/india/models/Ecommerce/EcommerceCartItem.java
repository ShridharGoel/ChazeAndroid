package com.chaze.india.models.Ecommerce;

import com.chaze.india.models.Ecommerce.ShopItem;
import com.chaze.india.models.Food.RestaurantItem;

import java.io.Serializable;

public class EcommerceCartItem implements Serializable {

    private ShopItem item;
    private int itemQuantity;

    public ShopItem getItem() {
        return item;
    }

    public void setItem(ShopItem item) {
        this.item = item;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public EcommerceCartItem(ShopItem item, int itemQuantity) {

        this.item = item;
        this.itemQuantity = itemQuantity;
    }
}
