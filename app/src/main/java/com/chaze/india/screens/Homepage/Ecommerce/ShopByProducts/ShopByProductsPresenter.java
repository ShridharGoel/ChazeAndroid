

package com.chaze.india.screens.Homepage.Ecommerce.ShopByProducts;

import android.annotation.SuppressLint;

import com.chaze.india.models.Ecommerce.EcomerceCategory;
import com.chaze.india.models.Ecommerce.Post;
import com.chaze.india.repository.CartManager;import com.chaze.india.repository.network.ICommonAPIManager;
import com.chaze.india.repository.session.SessionManager;
import com.chaze.india.screens.base.BasePresenter;
import com.chaze.india.utils.rx.SchedulerProvider;

import org.reactivestreams.Publisher;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
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

public class ShopByProductsPresenter<V extends ShopByProductsContract.View> extends BasePresenter<V>
        implements ShopByProductsContract.Presenter<V> {


    private int pageNumber;

    @Inject
    public ShopByProductsPresenter(ICommonAPIManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, SessionManager sessionManager, CartManager cartManager) {
        super(dataManager, schedulerProvider, compositeDisposable, sessionManager, cartManager);
    }


    public void next() {
        pageNumber++;
        Timber.e("Next" + pageNumber);

        getMvpView().showLoading();
        subscribeForData(pageNumber);
    }


    /**
     * subscribing for data
     */
    @SuppressLint("CheckResult")
    public void subscribeForData(int limit) {


        getCommonAPIManager().getECommerceAPIService().getPosts(pageNumber * 10)
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
