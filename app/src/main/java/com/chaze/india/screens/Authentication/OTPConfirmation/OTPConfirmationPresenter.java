package com.chaze.india.screens.Authentication.OTPConfirmation;

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

public class OTPConfirmationPresenter<V extends OTPConfirmationContract.View> extends BasePresenter<V>
        implements OTPConfirmationContract.Presenter<V> {

    @Inject
    public OTPConfirmationPresenter(ICommonAPIManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, SessionManager sessionManager) {
        super(dataManager, schedulerProvider, compositeDisposable, sessionManager);
    }

    @SuppressLint("CheckResult")
    @Override
    public void doOTPConfirmation(String mobile, int otp) {
        getCommonAPIManager().getChazeAPIService().confirmOtp(mobile, otp)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(confirmOTPResponse -> {
                    Timber.e("Success");

                    getMvpView().startHomeActivity();
                }, Throwable -> {
                   Timber.e("Failure: "+Throwable.getMessage());
                });
    }

    @SuppressLint("CheckResult")
    @Override
    public void doResendOTP(String mobile) {
        getCommonAPIManager().getChazeAPIService().resendOTP(mobile)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(resendOTPResponse -> {
                    Timber.e("Success");
                    }, Throwable -> {
                    Timber.e("Failure: "+Throwable.getMessage());
                });
    }

    @SuppressLint("CheckResult")
    @Override
    public void doOTPConfirmationForForgotPass(String mobile, int otp) {
        getCommonAPIManager().getChazeAPIService().confirmOtp(mobile, otp)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(resendOTPResponse -> {
                    getMvpView().startChangePassActivity();
                    Timber.e("Success");
                }, Throwable -> {
                    Timber.e("Failure: "+Throwable.getMessage());
                });
    }
}

