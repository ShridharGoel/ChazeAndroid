package com.chaze.india.repository;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import com.chaze.india.models.Ecommerce.CartItem;
import com.chaze.india.models.Ecommerce.CartResponse;
import com.chaze.india.models.Ecommerce.CartShop;
import com.chaze.india.models.Ecommerce.Product;
import com.chaze.india.repository.network.ICommonAPIManager;
import com.chaze.india.repository.session.SessionManager;
import com.google.gson.Gson;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public class CartManager {

    private SessionManager sessionManager;
    private CartResponse cart;
    private Context context;
    private ICommonAPIManager commonAPIManager;

    private boolean toUpdateCart = false;


    @Inject
    public CartManager(Context c, SessionManager sessionManager, ICommonAPIManager commonAPIManager) {
        this.context = c;
        this.sessionManager = sessionManager;
        this.commonAPIManager = commonAPIManager;
        this.cart = getCart();
        updateCartFromApi();
    }

    public CartResponse getCart() {
        if (sessionManager.getCurrentCartStateEcommerce() != null) {
            return sessionManager.getCurrentCartStateEcommerce();
        }
        return new CartResponse();
    }


    public void updateCartState(CartResponse cart) {
        sessionManager.setCurrentCartStateEcommerce(cart);
    }

    public int getItemsCount() {
        int ans = 0;
        if (cart == null) return ans;
        try {
            for (CartShop cs :
                    cart.getmCartShops()) {
                ans = ans + cs.getProducts().size();
            }
        } catch (Exception e) {
            return 0;
        }
        return ans;
    }


    public void addItemToCart(Product product, Long quantity, String description, TextView cartCountBadge) {
        toUpdateCart = true;
        addItemToServer(product.getId(), quantity, description, cartCountBadge);
    }


    @SuppressLint("CheckResult")
    public void updateCartFromApi() {
        Timber.e(sessionManager.getToken());
        commonAPIManager.getECommerceAPIService().getCart(sessionManager.getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(cartResponse -> {
                    if (cartResponse.getSuccess()) {
                        this.cart = cartResponse;
                    } else {
                        this.cart = new CartResponse();
                        Timber.e(cartResponse.getError());
                    }
                    toUpdateCart = false;
                }, throwable -> {
                    Timber.e(throwable.getMessage());
                    Toast.makeText(context, "Sorry, Some Error has Occured...", Toast.LENGTH_SHORT).show();
                });
    }

    @SuppressLint("CheckResult")
    private void addItemToServer(Long productId, Long quantity, String description, TextView cartCountBadge) {
        commonAPIManager.getECommerceAPIService().addItemToCart(sessionManager.getToken(), productId, quantity, description)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(cartUpdateResponse -> {

                    Toast.makeText(context, "Product Added Succesfully...", Toast.LENGTH_SHORT).show();
                    if (cartUpdateResponse.getSuccess()) {

                        cartCountBadge.setText(String.valueOf(getItemsCount()));
                        if (toUpdateCart) {
                            updateCartFromApi();
                        } else {
                            broadCastUpdate(productId, quantity, description);
                        }
                    } else {
                        Timber.e(cartUpdateResponse.getResults());
                        Toast.makeText(context, cartUpdateResponse.getResults(), Toast.LENGTH_SHORT).show();
                    }
                }, throwable -> {
                    Timber.e(throwable.getMessage());
                    Toast.makeText(context, "Sorry, Some Error has Occured...", Toast.LENGTH_SHORT).show();
                });
    }


    @SuppressLint("CheckResult")
    private void remoteItemFromServer(Long productId) {
        commonAPIManager.getECommerceAPIService().remoteItemFromCart(sessionManager.getToken(), productId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(cartUpdateResponse -> {
                    if (cartUpdateResponse.getSuccess()) {
                        updateCartFromApi();
                    } else {
                        Timber.e(cartUpdateResponse.getResults());
                        Toast.makeText(context, cartUpdateResponse.getResults(), Toast.LENGTH_SHORT).show();
                    }
                }, throwable -> {
                    Timber.e(throwable.getMessage());
                    Toast.makeText(context, "Sorry, Some Error has Occured...", Toast.LENGTH_SHORT).show();
                });
    }

    private void broadCastUpdate(Long productId, Long quantity, String description) {

    }

    public CartItem checkIfThisProductPresent(Long productId, Long sellerId) {

        if (cart.getmCartShops() == null) return null;
        for (CartShop cs :
                cart.getmCartShops()) {

            if (cs.getKey().equals(sellerId)) {
                for (CartItem ci :
                        cs.getProducts()) {
                    if (ci.getId().equals(productId)) return ci;
                }
                return null;
            }

        }
        return null;
    }


}
