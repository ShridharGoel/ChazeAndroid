package com.chaze.india.screens.Authentication.ChangePassword;


import com.chaze.india.repository.network.ICommonAPIManager;
import com.chaze.india.repository.session.SessionManager;
import com.chaze.india.screens.base.BasePresenter;
import com.chaze.india.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;


public class ChangePasswordPresenter<V extends ChangePasswordContract.View> extends BasePresenter<V>
        implements ChangePasswordContract.Presenter<V> {

    @Inject
    public ChangePasswordPresenter(ICommonAPIManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, SessionManager sessionManager) {
        super(dataManager, schedulerProvider, compositeDisposable, sessionManager);
    }


}

