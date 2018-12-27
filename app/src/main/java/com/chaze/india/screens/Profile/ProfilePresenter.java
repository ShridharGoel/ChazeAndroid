

package com.chaze.india.screens.Profile;

import android.annotation.SuppressLint;

import com.chaze.india.repository.CartManager;import com.chaze.india.repository.network.ICommonAPIManager;
import com.chaze.india.repository.session.SessionManager;
import com.chaze.india.screens.base.BasePresenter;
import com.chaze.india.utils.rx.SchedulerProvider;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;


/**
 * Created by Shubham Vishwakarma on 12/10/18.
 */

public class ProfilePresenter<V extends ProfileContract.View> extends BasePresenter<V>
        implements ProfileContract.Presenter<V> {

    public ProfilePresenter(ICommonAPIManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, SessionManager sessionManager, CartManager cartManager) {
        super(dataManager, schedulerProvider, compositeDisposable, sessionManager, cartManager);
    }

    @SuppressLint("CheckResult")
    @Override
    public void fetchDetails() {
        getCommonAPIManager().getChazeAPIService().fetchProfile(getSessionManager().getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(profileResponse -> {
                    getMvpView().saveDetails(profileResponse.getUser());
                }, Throwable -> {
                    Timber.e("Failure: "+Throwable.getMessage());
                });

    }
}
