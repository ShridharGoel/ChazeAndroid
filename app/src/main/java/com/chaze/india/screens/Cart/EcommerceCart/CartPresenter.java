

package com.chaze.india.screens.Cart.EcommerceCart;

import com.chaze.india.models.Ecommerce.CartResponse;
import com.chaze.india.models.Ecommerce.CartShop;
import com.chaze.india.repository.CartManager;
import com.chaze.india.repository.CartManager;
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

public class CartPresenter<V extends CartContract.View> extends BasePresenter<V>
        implements CartContract.Presenter<V> {




    @Inject
    public CartPresenter(ICommonAPIManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, SessionManager sessionManager, CartManager cartManager) {
        super(dataManager, schedulerProvider, compositeDisposable, sessionManager, cartManager);
    }


}
