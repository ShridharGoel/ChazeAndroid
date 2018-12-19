

package com.chaze.india.screens.Shop;

import android.annotation.SuppressLint;

import com.chaze.india.models.Category;
import com.chaze.india.models.Ecommerce.EcomerceCategory;
import com.chaze.india.repository.network.ICommonAPIManager;
import com.chaze.india.utils.rx.SchedulerProvider;
import com.chaze.india.repository.session.SessionManager;
import com.chaze.india.screens.base.BasePresenter;

import org.reactivestreams.Publisher;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.processors.PublishProcessor;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;


/**
 * Created by Shubham Vishwakarma on 12/10/18.
 */

public class ShopPresenter<V extends ShopContract.View> extends BasePresenter<V>
        implements ShopContract.Presenter<V> {

    @Inject
    public ShopPresenter(ICommonAPIManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, SessionManager sessionManager) {
        super(dataManager, schedulerProvider, compositeDisposable, sessionManager);
    }

    private int pageNumber;

    public void next() {
        pageNumber++;
        getMvpView().showLoading();
        subscribeForData(pageNumber);
    }

    @SuppressLint("CheckResult")
    @Override
    public void getSubCategories() {

        if (getMvpView().getCategory().equals("-1")) {
            getCommonAPIManager().getECommerceAPIService().getSubCategories(getMvpView().getShop(), getMvpView().getCategory())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(response -> {
                        getMvpView().showCategories(response.getResults());
                        Timber.e("Size:" + response.getResults().size());
                    }, throwable -> {
                        Timber.e(throwable.getMessage());
                    });
        } else {
            getCommonAPIManager().getECommerceAPIService().getSubCategories(getMvpView().getShop(), getMvpView().getCategory())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(response -> {
                        getMvpView().showCategories(response.getResults());
                        Timber.e("Size:" + response.getResults().size());
                    }, throwable -> {
                        Timber.e(throwable.getMessage());
                    });
        }
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);

    }


    /**
     * subscribing for data
     */
    @SuppressLint("CheckResult")
    public void subscribeForData(int limit) {


        if (getMvpView().getCategory().equals("-1")) {
            getCommonAPIManager().getECommerceAPIService().getPostsForShop(getMvpView().getShop())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(postsResponse -> {
                        getMvpView().hideLoading();
                        getMvpView().addItems(postsResponse.getPosts());

                        Timber.e("Size:" + postsResponse.getPosts().size());
                    }, throwable -> {
                        Timber.e(throwable.getMessage());
                        pageNumber--;
                    });
        } else {
            getCommonAPIManager().getECommerceAPIService().getPostsForShopAndCategory(getMvpView().getShop(), getMvpView().getCategory())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(postsResponse -> {
                        getMvpView().hideLoading();
                        getMvpView().addItems(postsResponse.getPosts());

                        Timber.e("Size:" + postsResponse.getPosts().size());
                    }, throwable -> {
                        Timber.e(throwable.getMessage());
                        pageNumber--;
                    });
        }


    }
}
