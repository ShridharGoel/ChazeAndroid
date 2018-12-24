

package com.chaze.india.screens.Category;

import android.annotation.SuppressLint;

import com.chaze.india.models.CategorySearchResults;
import com.chaze.india.repository.network.ICommonAPIManager;
import com.chaze.india.repository.session.SessionManager;
import com.chaze.india.screens.base.BasePresenter;
import com.chaze.india.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Shubham Vishwakarma on 12/10/18.
 */

public class CategoryPresenter<V extends CategoryContract.View> extends BasePresenter<V>
        implements CategoryContract.Presenter<V> {

    @Inject
    public CategoryPresenter(ICommonAPIManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, SessionManager sessionManager) {
        super(dataManager, schedulerProvider, compositeDisposable, sessionManager);
    }


    @SuppressLint("CheckResult")
    @Override
    public void getShops() {
        getCommonAPIManager().getECommerceAPIService().getShopForCategory(getMvpView().getCategory())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(categoriesShopResponse -> {
                    getMvpView().addShops(categoriesShopResponse.getmShopForCategories());
                }, throwable -> {
                    getMvpView().onError(throwable.getMessage());
                });
    }
}
