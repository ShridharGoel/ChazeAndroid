package com.chaze.india.screens.Homepage.Purchases.ActiveOrders.OrderOfAShop;

import com.chaze.india.repository.network.ICommonAPIManager;
import com.chaze.india.repository.session.SessionManager;
import com.chaze.india.screens.base.BasePresenter;
import com.chaze.india.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;

public class OrderOfAShopPresenter<V extends OrderOfAShopContract.View> extends BasePresenter<V> implements OrderOfAShopContract.Presenter<V> {
    PublishSubject<String> subject;
    @Inject
    public OrderOfAShopPresenter(ICommonAPIManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, SessionManager sessionManager) {
        super(dataManager, schedulerProvider, compositeDisposable, sessionManager);
    }


}
