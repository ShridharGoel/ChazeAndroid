package com.chaze.india.screens.Authentication;

import android.annotation.SuppressLint;

import com.chaze.india.repository.network.ICommonAPIManager;
import com.chaze.india.repository.session.SessionManager;
import com.chaze.india.screens.base.BasePresenter;
import com.chaze.india.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Shridhar Goel on 14/10/18.
 */

public class SignUpPresenter<V extends SignUpContract.View> extends BasePresenter<V>
        implements SignUpContract.Presenter<V> {

    @Inject
    public SignUpPresenter(ICommonAPIManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, SessionManager sessionManager) {
        super(dataManager, schedulerProvider, compositeDisposable, sessionManager);
    }

    @SuppressLint("CheckResult")
    @Override
    public void doSignUp(String name, String mobile, String pass) {
        getCommonAPIManager().getChazeAPIService().createUser(name, mobile, pass)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(loginResponse -> {
                    getMvpView().showSignUpResult();
                    //On success
                }, Throwable -> {
                    getMvpView().showSignUpResult();
                    //On error
                });
    }
}

