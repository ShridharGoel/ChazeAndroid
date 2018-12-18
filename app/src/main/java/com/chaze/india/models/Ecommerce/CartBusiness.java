package com.chaze.india.models.Ecommerce;

import android.util.Log;

import java.io.Serializable;
import java.util.LinkedList;


public class CartBusiness implements Serializable {

    private static String TAG = CartBusiness.class.getSimpleName();

    private Shop business;
    private LinkedList<EcommerceCartItem> cartItems;
    private int discount;


    public CartBusiness() {
        this.cartItems = new LinkedList<>();
        business = null;
    }

    public CartBusiness(Shop business, LinkedList<EcommerceCartItem> cartItems) {
        this.business = business;
        this.cartItems = cartItems;

        Log.d(TAG, String.valueOf(discount));
    }

    public Shop getBusiness() {
        return business;
    }

    public void setRestaurantInCart(Shop business) {
        this.business = business;
    }

    public LinkedList<EcommerceCartItem> getCartItems() {
        return cartItems;
    }


    public void addItem(EcommerceCartItem cartItem) {
        Boolean found = false;
        for (int i = 0; i < getCartItems().size(); i++) {
            ShopItem item =  getCartItems().get(i).getItem();
            if (item.getProductCode().equals(cartItem.getItem().getProductCode())) {
                found = true;
                cartItems.set(i, cartItem);
            }
        }
        if (!found) {
            cartItems.add(cartItem);
            business = cartItem.getItem().getShop();
        }

    }

    public void deleteItem(EcommerceCartItem cartItem) {
        for (int i = 0; i < getCartItems().size(); i++) {
            ShopItem item =  getCartItems().get(i).getItem();
            if (item.getProductCode().equals(cartItem.getItem().getProductCode())) {
                cartItems.remove(i);
            }
        }
        if (getCartItems().size() == 0) {
            clearCart();
        }
    }

    public void updateItemQuantity(EcommerceCartItem cartItem, int itemQuantity) {
        EcommerceCartItem newCartItem = new EcommerceCartItem(cartItem.getItem(), itemQuantity);
        int oldItemIndex = cartItems.indexOf(cartItem);
        if (itemQuantity == 0) {
            deleteItem(cartItem);
        } else {
            cartItems.remove(cartItem);
            cartItems.add(oldItemIndex, newCartItem);
        }

    }


    public int getTotalBeforeDiscount() {
        int price = 0;
        for (EcommerceCartItem cartItem : getCartItems()) {
            price = (int) (price + cartItem.getItem().getPrice());
        }
        return price;
    }

    public CartBusiness clearCart() {
        this.cartItems = new LinkedList<>();

        setRestaurantInCart(null);
        this.discount = 0;

        return new CartBusiness();
    }

    public boolean isCartEmpty() {
        if (cartItems.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}