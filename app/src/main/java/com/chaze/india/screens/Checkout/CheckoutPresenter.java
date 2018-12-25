

package com.chaze.india.screens.Checkout;

import com.chaze.india.repository.CartManager;import com.chaze.india.repository.network.ICommonAPIManager;
import com.chaze.india.repository.session.SessionManager;
import com.chaze.india.screens.base.BasePresenter;
import com.chaze.india.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;


/**
 * Created by Shubham Vishwakarma on 12/10/18.
 */

public class CheckoutPresenter<V extends CheckoutContract.View> extends BasePresenter<V>
        implements CheckoutContract.Presenter<V> {

    @Inject
    public CheckoutPresenter(ICommonAPIManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, SessionManager sessionManager, CartManager cartManager) {
        super(dataManager, schedulerProvider, compositeDisposable,sessionManager, cartManager);
    }
}
