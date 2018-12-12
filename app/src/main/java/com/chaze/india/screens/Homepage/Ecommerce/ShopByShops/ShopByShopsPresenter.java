

package com.chaze.india.screens.Homepage.Ecommerce.ShopByShops;

import android.annotation.SuppressLint;

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

public class ShopByShopsPresenter<V extends ShopByShopsContract.View> extends BasePresenter<V>
        implements ShopByShopsContract.Presenter<V> {


    private int pageNumber = -1;

    @Inject
    public ShopByShopsPresenter(ICommonAPIManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, SessionManager sessionManager) {
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

    public void next() {
        pageNumber++;
        dataFromNetwork(pageNumber);
    }

    @SuppressLint("CheckResult")
    private void dataFromNetwork(final int page) {
        Timber.e("" + page * 10);
        getCommonAPIManager().getECommerceAPIService().getShopsList(page * 10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getMvpView()::showShops, throwable -> {
                    getMvpView().showError();
                    pageNumber--;
                });
    }
}
