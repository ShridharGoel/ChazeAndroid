

package com.chaze.india.screens.Homepage.Ecommerce;

import android.annotation.SuppressLint;

import com.chaze.india.models.Ecommerce.Category;
import com.chaze.india.repository.CartManager;
import com.chaze.india.repository.network.ICommonAPIManager;
import com.chaze.india.repository.session.SessionManager;
import com.chaze.india.screens.base.BasePresenter;
import com.chaze.india.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;


/**
 * Created by Shubham Vishwakarma on 12/10/18.
 */

public class EcommercePresenter<V extends EcommerceContract.View> extends BasePresenter<V>
        implements EcommerceContract.Presenter<V> {

    @Inject
    public EcommercePresenter(ICommonAPIManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, SessionManager sessionManager, CartManager cartManager) {
        super(dataManager, schedulerProvider, compositeDisposable, sessionManager, cartManager);
    }


    @Override
    public void getCartCount() {
        getMvpView().setCartCountBadge(getCartManager().getItemsCount());
    }

    @SuppressLint("CheckResult")
    @Override
    public void loadCategories() {
        getCommonAPIManager().getECommerceAPIService().getCategories().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> getMvpView().showCategories((ArrayList<Category>) response.getResults()), throwable -> {
                    Timber.e("Error" + throwable.getMessage());
                });
    }
}
