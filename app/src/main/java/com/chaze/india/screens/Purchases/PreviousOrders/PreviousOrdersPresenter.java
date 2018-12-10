package com.chaze.india.screens.Purchases.PreviousOrders;

import com.chaze.india.repository.network.ICommonAPIManager;
import com.chaze.india.repository.session.SessionManager;
import com.chaze.india.screens.base.BasePresenter;
import com.chaze.india.utils.rx.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;

public class PreviousOrdersPresenter<V extends PreviousOrdersContract.View> extends BasePresenter<V> implements PreviousOrdersContract.Presenter<V>{
    public PreviousOrdersPresenter(ICommonAPIManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, SessionManager sessionManager) {
        super(dataManager, schedulerProvider, compositeDisposable, sessionManager);
    }
}