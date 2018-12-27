

package com.chaze.india.screens.Checkout;

import android.annotation.SuppressLint;

import com.chaze.india.models.Ecommerce.CartItem;
import com.chaze.india.models.Ecommerce.CartShop;
import com.chaze.india.repository.CartManager;
import com.chaze.india.repository.network.ICommonAPIManager;
import com.chaze.india.repository.session.SessionManager;
import com.chaze.india.screens.base.BasePresenter;
import com.chaze.india.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;


/**
 * Created by Shubham Vishwakarma on 12/10/18.
 */

public class CheckoutPresenter<V extends CheckoutContract.View> extends BasePresenter<V>
        implements CheckoutContract.Presenter<V> {

    @Inject
    public CheckoutPresenter(ICommonAPIManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, SessionManager sessionManager, CartManager cartManager) {
        super(dataManager, schedulerProvider, compositeDisposable, sessionManager, cartManager);
    }

    @Override
    public void getDetails() {
        getMvpView().showDetails(getSessionManager().getUser());
    }

    @SuppressLint("CheckResult")
    @Override
    public void placeOrder(Long userMobile, String userAdress) {
        StringBuilder descriptionBuilder = new StringBuilder("");
        StringBuilder quantityBuilder = new StringBuilder("");
        StringBuilder productBuilder = new StringBuilder("");

        boolean isFirst = true;

        if (getCartManager().getCart() != null && getCartManager().getCart().getCartShops() != null && !getCartManager().getCart().getCartShops().isEmpty()) {

            for (int i = 0; i < getCartManager().getCart().getCartShops().size(); i++) {
                CartShop cartShop = getCartManager().getCart().getCartShops().get(i);

                for (int j = 0; j < cartShop.getProducts().size(); j++) {
                    CartItem ci = cartShop.getProducts().get(j);
                    if (isFirst) {
                        isFirst = false;
                        descriptionBuilder.append(ci.getDescription());
                        quantityBuilder.append(ci.getQuantity());
                        productBuilder.append(ci.getId());
                    } else {
                        descriptionBuilder.append(";").append(ci.getDescription());
                        quantityBuilder.append(",").append(ci.getQuantity());
                        productBuilder.append(",").append(ci.getId());
                    }
                }
            }
            getCommonAPIManager().getECommerceAPIService().placeOrder(getSessionManager().getToken(), quantityBuilder.toString(), descriptionBuilder.toString(), userMobile, userAdress, productBuilder.toString())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(orderResponse -> {
                        if (orderResponse.getSuccess())
                            Timber.e("Success");
                        else
                            Timber.e("Failure");
                    }, throwable -> {
                        Timber.e(throwable.getMessage());
                    });
        }


    }
}
