package com.chaze.india.models;

import java.io.Serializable;
import java.util.LinkedList;


public class CartEcommerce implements Serializable {

    private static String TAG = CartEcommerce.class.getSimpleName();

    private LinkedList<CartBusiness> carts;
    private int threshold = 5;

    public CartEcommerce() {
        this.carts = new LinkedList<>();
    }

    public CartEcommerce(LinkedList<CartBusiness> carts) {
        this.carts = carts;
    }

    public int getCartSize() {
        return carts.size();
    }


    public void addItem(CartItem cartItem) {
        Boolean found = false;
        Boolean isBusinessFound = false;


        Business business = cartItem.getItem().getBusiness();

        for (int i = 0; i < carts.size(); i++) {

            CartBusiness cartBusiness = carts.get(i);

            if (business.getCode().equals(cartBusiness.getBusiness().getCode())) {

                isBusinessFound = true;


                for (int j = 0; j < cartBusiness.getCartItems().size(); i++) {
                    Item item = cartBusiness.getCartItems().get(j).getItem();
                    if (item.getProductCode().equals(cartItem.getItem().getProductCode())) {
                        found = true;
                        carts.get(i).getCartItems().set(i, cartItem);
                    }
                }
                if (!found) {
                    carts.get(i).getCartItems().add(cartItem);
                }

            }

            if (!isBusinessFound && threshold > carts.size() + 1) {
                LinkedList<CartItem> cartItemsNew = new LinkedList<>();
                cartItemsNew.add(cartItem);
                carts.add(new CartBusiness(cartItem.getItem().getBusiness(), cartItemsNew));
            }


        }


    }

    public void deleteItem(CartItem cartItem) {

        for (int i = 0; i < carts.size(); i++) {

            CartBusiness cartBusiness = carts.get(i);

            if (cartBusiness.getBusiness().getCode().equals(cartItem.getItem().getBusiness())) {

                for (int j = 0; j < cartBusiness.getCartItems().size(); j++) {
                    Item item = cartBusiness.getCartItems().get(j).getItem();
                    if (item.getProductCode().equals(cartItem.getItem().getProductCode())) {
                        carts.get(i).getCartItems().remove(j);
                    }
                }
                if (carts.size() == 1 && carts.get(0).getCartItems().size() == 0) {
                    clearCart();
                }


            }


        }


    }

    public void updateItemQuantity(CartItem cartItem, int itemQuantity) {
        CartItem newCartItem = new CartItem(cartItem.getItem(), itemQuantity);
       /* int oldItemIndex = carts.indexOf(cartItem);
        if (itemQuantity == 0) {
            deleteItem(cartItem);
        } else {
            cartItems.remove(cartItem);
            cartItems.add(oldItemIndex, newCartItem);
        }*/

    }


    public void clearCart() {
        this.carts = new LinkedList<>();
    }

    public boolean isCartEmpty() {
        if (carts.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

}
