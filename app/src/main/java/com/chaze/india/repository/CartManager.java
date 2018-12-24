package com.chaze.india.repository;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.widget.Toast;

import com.chaze.india.R;
import com.chaze.india.models.Ecommerce.CartResponse;
import com.chaze.india.models.Ecommerce.CartShop;
import com.chaze.india.models.Ecommerce.Product;
import com.chaze.india.repository.network.ICommonAPIManager;
import com.chaze.india.repository.session.SessionManager;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

import static android.support.constraint.Constraints.TAG;

public class CartManager {

    private SessionManager sessionManager;
    private CartResponse cart;
    private Context context;
    private ICommonAPIManager commonAPIManager;

    private boolean toUpdateCart = false;

    @Inject
    public CartManager(Context c, SessionManager sessionManager, ICommonAPIManager commonAPIManager) {
        this.context = context;
        this.sessionManager = new SessionManager(context);
        this.commonAPIManager = commonAPIManager;
        this.cart = getCart();
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


    public void addItemToCart(Product product, int quantity, String description) {
        final CartResponse cartToAddItemTo = getCart();
        if (cartToAddItemTo.getmCartShops().isEmpty()) {
            toUpdateCart = true;
            addItemToServer(product.getId(), quantity, description);
        } else {


            boolean isAdded = false;
            for (CartShop cartShop :
                    cartToAddItemTo.getmCartShops()) {
                if (cartShop.getKey().equals(product.getSellerId())) {
                    addItemToServer(product.getId(), quantity, description);
                    isAdded = true;
                    break;
                }
            }

            if (isAdded && quantity == 0) updateCartFromApi();

            if (!isAdded) {
                toUpdateCart = true;
                addItemToServer(product.getId(), quantity, description);
            }
        }
    }




    @SuppressLint("CheckResult")
    private void updateCartFromApi() {
        commonAPIManager.getECommerceAPIService().getCart(sessionManager.getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(cartResponse -> {
                    this.cart = cartResponse;
                    toUpdateCart = false;
                }, throwable -> {
                    Timber.e(throwable.getMessage());
                    Toast.makeText(context, "Sorry, Some Error has Occured...", Toast.LENGTH_SHORT).show();
                });

    }

    @SuppressLint("CheckResult")
    private void addItemToServer(Long productId, int quantity, String description) {
        commonAPIManager.getECommerceAPIService().addItemToCart(sessionManager.getToken(), productId, quantity, description)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(cartUpdateResponse -> {
                    if (cartUpdateResponse.getSuccess()) {
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

    private void broadCastUpdate(Long productId, int quantity, String description) {

    }


}
