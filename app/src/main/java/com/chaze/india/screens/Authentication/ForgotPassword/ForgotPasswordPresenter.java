package com.chaze.india.screens.Authentication.ForgotPassword;


import android.annotation.SuppressLint;

import com.chaze.india.repository.CartManager;import com.chaze.india.repository.network.ICommonAPIManager;
import com.chaze.india.repository.session.SessionManager;
import com.chaze.india.screens.base.BasePresenter;
import com.chaze.india.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;


public class ForgotPasswordPresenter<V extends ForgotPasswordContract.View> extends BasePresenter<V>
        implements ForgotPasswordContract.Presenter<V> {

    @Inject
    public ForgotPasswordPresenter(ICommonAPIManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, SessionManager sessionManager, CartManager cartManager) {
        super(dataManager, schedulerProvider, compositeDisposable, sessionManager, cartManager);
    }


    @SuppressLint("CheckResult")
    @Override
    public void doChangePass(String mobile, int otp, String newPass) {
        getCommonAPIManager().getChazeAPIService().changePass(mobile, otp, newPass)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(changePassResponse -> {
                    getMvpView().startHomeActivity();
                    Timber.e("Success");
                }, Throwable -> {
                    Timber.e("Failure: "+Throwable.getMessage());
                });
    }

    @SuppressLint("CheckResult")
    @Override
    public void doChangePassWithEmail(String email, int otp, String newPass) {
        getCommonAPIManager().getChazeAPIService().changePassWithEmail(email, otp, newPass)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(changePassResponse -> {
                    getMvpView().startHomeActivity();
                    Timber.e("Success");
                }, Throwable -> {
                    Timber.e("Failure: "+Throwable.getMessage());
                });
    }
}

