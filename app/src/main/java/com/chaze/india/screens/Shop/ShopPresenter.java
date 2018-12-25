

package com.chaze.india.screens.Shop;

import android.annotation.SuppressLint;

import com.chaze.india.repository.CartManager;import com.chaze.india.repository.network.ICommonAPIManager;
import com.chaze.india.utils.rx.SchedulerProvider;
import com.chaze.india.repository.session.SessionManager;
import com.chaze.india.screens.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;


/**
 * Created by Shubham Vishwakarma on 12/10/18.
 */

public class ShopPresenter<V extends ShopContract.View> extends BasePresenter<V>
        implements ShopContract.Presenter<V> {

    @Inject
    public ShopPresenter(ICommonAPIManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, SessionManager sessionManager, CartManager cartManager) {
        super(dataManager, schedulerProvider, compositeDisposable, sessionManager, cartManager);
    }

    private int pageNumber;

    public void next() {
        pageNumber++;
        getMvpView().showLoading();
        getPosts(pageNumber);
    }

    @SuppressLint("CheckResult")
    @Override
    public void getSubCategories() {

        getCommonAPIManager().getECommerceAPIService().getSubCategories(getMvpView().getShopId(), getMvpView().getCategoryId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    getMvpView().showCategories(response.getResults());
                    Timber.e("Size:" + response.getResults().size());
                }, throwable -> {
                    Timber.e(throwable.getMessage());
                });

    }

    @SuppressLint({"CheckResult", "TimberExceptionLogging"})
    @Override
    public void getShop() {
        getCommonAPIManager().getECommerceAPIService().getShop(getMvpView().getShopId()).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(shopResponse -> {
                    getMvpView().showShopDetails(shopResponse.getShops().get(0));
                }, Throwable -> {
                    Timber.e(Throwable.getMessage());
                });
    }

    @SuppressLint("CheckResult")
    @Override
    public void getProducts() {
        getCommonAPIManager().getECommerceAPIService().getProductsByShopAndCategory(getMvpView().getCategoryId(), getMvpView().getShopId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(productListResponse -> {
                    getMvpView().showProducts(productListResponse.getProducts());
                },throwable -> {
                    getMvpView().showError(throwable.getMessage());
                });

    }

    /**
     * subscribing for data
     */
    @SuppressLint("CheckResult")
    public void getPosts(int limit) {


        if (getMvpView().getCategoryId().equals(Long.valueOf(-1))) {
            getCommonAPIManager().getECommerceAPIService().getPostsForShop(getMvpView().getShopId())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(postsResponse -> {
                        getMvpView().hideLoading();
                        getMvpView().shopPosts(postsResponse.getPosts());

                        Timber.e("Size:" + postsResponse.getPosts().size());
                    }, throwable -> {
                        Timber.e(throwable.getMessage());
                        pageNumber--;
                    });
        } else {
            getCommonAPIManager().getECommerceAPIService().getPostsForShopAndCategory(getMvpView().getShopId(), getMvpView().getCategoryId())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(postsResponse -> {
                        getMvpView().hideLoading();
                        getMvpView().shopPosts(postsResponse.getPosts());

                        Timber.e("Size:" + postsResponse.getPosts().size());
                    }, throwable -> {
                        Timber.e(throwable.getMessage());
                        pageNumber--;
                    });
        }


    }
}
