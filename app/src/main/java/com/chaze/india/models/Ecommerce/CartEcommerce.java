package com.chaze.india.models.Ecommerce;

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


    public void addItem(EcommerceCartItem cartItem) {
        Boolean found = false;
        Boolean isBusinessFound = false;


        Shop business = cartItem.getItem().getShop();

        for (int i = 0; i < carts.size(); i++) {

            CartBusiness cartBusiness = carts.get(i);

            if (business.getCode().equals(cartBusiness.getBusiness().getCode())) {

                isBusinessFound = true;


                for (int j = 0; j < cartBusiness.getCartItems().size(); i++) {
                    ShopItem item = cartBusiness.getCartItems().get(j).getItem();
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
                LinkedList<EcommerceCartItem> cartItemsNew = new LinkedList<>();
                cartItemsNew.add(cartItem);
                carts.add(new CartBusiness(cartItem.getItem().getShop(), cartItemsNew));
            }


        }


    }

    public void deleteItem(EcommerceCartItem cartItem) {

        for (int i = 0; i < carts.size(); i++) {

            CartBusiness cartBusiness = carts.get(i);

            if (cartBusiness.getBusiness().getCode().equals(cartItem.getItem().getShop())) {

                for (int j = 0; j < cartBusiness.getCartItems().size(); j++) {
                    ShopItem item = cartBusiness.getCartItems().get(j).getItem();
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

    public void updateItemQuantity(EcommerceCartItem cartItem, int itemQuantity) {
        EcommerceCartItem newCartItem = new EcommerceCartItem(cartItem.getItem(), itemQuantity);
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
