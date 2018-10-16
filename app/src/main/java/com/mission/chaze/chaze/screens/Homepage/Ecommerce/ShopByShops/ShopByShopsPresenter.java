

package com.mission.chaze.chaze.screens.Homepage.Ecommerce.ShopByShops;

import android.annotation.SuppressLint;

import com.mission.chaze.chaze.repository.network.ICommonAPIManager;
import com.mission.chaze.chaze.screens.base.BasePresenter;
import com.mission.chaze.chaze.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;


/**
 * Created by Shubham Vishwakarma on 12/10/18.
 */

public class ShopByShopsPresenter<V extends ShopByShopsContract.View> extends BasePresenter<V>
        implements ShopByShopsContract.Presentor<V> {


    private int pageNumber;

    @Inject
    public ShopByShopsPresenter(ICommonAPIManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable, sessionManager);
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
