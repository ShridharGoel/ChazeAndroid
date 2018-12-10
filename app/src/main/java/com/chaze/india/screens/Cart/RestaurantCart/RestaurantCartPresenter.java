

package com.chaze.india.screens.Cart.RestaurantCart;

import com.chaze.india.repository.network.ICommonAPIManager;
import com.chaze.india.repository.session.SessionManager;
import com.chaze.india.screens.base.BasePresenter;
import com.chaze.india.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;


/**
 * Created by Shubham Vishwakarma on 12/10/18.
 */

public class RestaurantCartPresenter<V extends RestaurantCartContract.View> extends BasePresenter<V>
        implements RestaurantCartContract.Presenter<V> {

    PublishSubject<String> subject;

    @Inject
    public RestaurantCartPresenter(ICommonAPIManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, SessionManager sessionManager) {
        super(dataManager, schedulerProvider, compositeDisposable, sessionManager);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);

        subject = PublishSubject.create();


    }
}
