package com.chaze.india.screens.Authentication.OTPConfirmation;

import com.chaze.india.repository.network.ICommonAPIManager;
import com.chaze.india.repository.session.SessionManager;
import com.chaze.india.screens.base.BasePresenter;
import com.chaze.india.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class OTPConfirmationPresenter<V extends OTPConfirmationContract.View> extends BasePresenter<V>
        implements OTPConfirmationContract.Presenter<V> {

    @Inject
    public OTPConfirmationPresenter(ICommonAPIManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, SessionManager sessionManager) {
        super(dataManager, schedulerProvider, compositeDisposable, sessionManager);
    }

}

