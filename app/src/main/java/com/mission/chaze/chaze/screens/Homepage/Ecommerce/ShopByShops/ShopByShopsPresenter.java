

package com.mission.chaze.chaze.screens.Homepage.Ecommerce.ShopByShops;

import android.annotation.SuppressLint;
import android.util.Log;

import com.mission.chaze.chaze.models.EcomerceCategory;
import com.mission.chaze.chaze.repository.network.ICommonAPIManager;
import com.mission.chaze.chaze.screens.base.BasePresenter;
import com.mission.chaze.chaze.utils.rx.SchedulerProvider;

import org.reactivestreams.Publisher;

import java.util.ArrayList;
import java.util.List;
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
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;


/**
 * Created by Shubham Vishwakarma on 12/10/18.
 */

public class ShopByShopsPresenter<V extends ShopByShopsContract.View> extends BasePresenter<V>
        implements ShopByShopsContract.Presentor<V> {


    private int pageNumber;

    @Inject
    public ShopByShopsPresenter(ICommonAPIManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);

    }

    @Override
    public void subscribeForData() {
        next();
    }

    public void next(){
        pageNumber++;
        dataFromNetwork(pageNumber);
    }



    /**
     * Simulation of network data
     */
    @SuppressLint("CheckResult")
    private void dataFromNetwork(final int page) {
        Timber.e("" + page);
        getCommonAPIManager().getECommerceAPIService().getShopsList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getMvpView()::showShops, throwable -> getMvpView().showError());
    }
}
