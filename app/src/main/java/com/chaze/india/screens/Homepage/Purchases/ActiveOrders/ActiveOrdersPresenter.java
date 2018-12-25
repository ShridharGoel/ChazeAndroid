package com.chaze.india.screens.Homepage.Purchases.ActiveOrders;

import com.chaze.india.repository.CartManager;import com.chaze.india.repository.network.ICommonAPIManager;
import com.chaze.india.repository.session.SessionManager;
import com.chaze.india.screens.base.BasePresenter;
import com.chaze.india.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;

public class ActiveOrdersPresenter<V extends ActiveOrdersContract.View> extends BasePresenter<V> implements ActiveOrdersContract.Presenter<V> {
    PublishSubject<String> subject;
    @Inject
    public ActiveOrdersPresenter(ICommonAPIManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, SessionManager sessionManager, CartManager cartManager) {
        super(dataManager, schedulerProvider, compositeDisposable, sessionManager, cartManager);
    }

    @Override
    public void show() {
        getMvpView().showOnActivity();
    }
    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);

        subject = PublishSubject.create();

        getMvpView().setSubjectToAdapter(subject);


        subject.subscribe((str)-> getMvpView().showFull(str));

    }
}
