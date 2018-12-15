

package com.chaze.india.screens.Homepage.Ecommerce.ShopByProducts;

import android.annotation.SuppressLint;

import com.chaze.india.models.Ecommerce.EcomerceCategory;
import com.chaze.india.models.Ecommerce.Post;
import com.chaze.india.models.Ecommerce.PostsResponse;
import com.chaze.india.repository.network.ICommonAPIManager;
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


    private PublishProcessor<Integer> paginator = PublishProcessor.create();
    private int pageNumber;

    @Inject
    public ShopByProductsPresenter(ICommonAPIManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, SessionManager sessionManager) {
        super(dataManager, schedulerProvider, compositeDisposable, sessionManager);
    }

    public void next() {
        pageNumber++;
        subscribeForData(pageNumber);
    }

    Single<PostsResponse> p;


    /**
     * subscribing for data
     */
    public void subscribeForData(int limit) {

        getCommonAPIManager().getECommerceAPIService().getPosts(10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(postsResponse -> {
                    getMvpView().addItems(postsResponse.getPosts());
                }, throwable -> {
                    Timber.e(throwable.getMessage());
                    pageNumber--;
                });

    }


}
