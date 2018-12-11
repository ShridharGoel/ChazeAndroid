package com.chaze.india.screens.Authentication.ForgotPassword;


import com.chaze.india.repository.network.ICommonAPIManager;
import com.chaze.india.repository.session.SessionManager;
import com.chaze.india.screens.base.BasePresenter;
import com.chaze.india.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;


public class ForgotPasswordPresenter<V extends ForgotPasswordContract.View> extends BasePresenter<V>
        implements ForgotPasswordContract.Presenter<V> {

    @Inject
    public ForgotPasswordPresenter(ICommonAPIManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, SessionManager sessionManager) {
        super(dataManager, schedulerProvider, compositeDisposable, sessionManager);
    }


}

