package com.mission.chaze.chaze.models;

import android.util.Log;

import java.io.Serializable;
import java.util.LinkedList;


public class CartBusiness implements Serializable {

    private static String TAG = CartBusiness.class.getSimpleName();

    private Business business;
    private LinkedList<CartItem> cartItems;
    private int discount;


    public CartBusiness() {
        this.cartItems = new LinkedList<>();
        business = null;
    }

    public CartBusiness(Business business, LinkedList<CartItem> cartItems) {
        this.business = business;
        this.cartItems = cartItems;

        Log.d(TAG, String.valueOf(discount));
    }

    public Business getBusiness() {
        return business;
    }

    public void setRestaurantInCart(Business business) {
        this.business = business;
    }

    public LinkedList<CartItem> getCartItems() {
        return cartItems;
    }


    public void addItem(CartItem cartItem) {
        Boolean found = false;
        for (int i = 0; i < getCartItems().size(); i++) {
            Item item =  getCartItems().get(i).getItem();
            if (item.getProductCode().equals(cartItem.getItem().getProductCode())) {
                found = true;
                cartItems.set(i, cartItem);
            }
        }
        if (!found) {
            cartItems.add(cartItem);
            business = cartItem.getItem().getBusiness();
        }

    }

    public void deleteItem(CartItem cartItem) {
        for (int i = 0; i < getCartItems().size(); i++) {
            Item item =  getCartItems().get(i).getItem();
            if (item.getProductCode().equals(cartItem.getItem().getProductCode())) {
                cartItems.remove(i);
            }
        }
        if (getCartItems().size() == 0) {
            clearCart();
        }
    }

    public void updateItemQuantity(CartItem cartItem, int itemQuantity) {
        CartItem newCartItem = new CartItem(cartItem.getItem(), itemQuantity);
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
        for (CartItem cartItem : getCartItems()) {
            price = (int) (price + cartItem.getCartItemPrice());
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
