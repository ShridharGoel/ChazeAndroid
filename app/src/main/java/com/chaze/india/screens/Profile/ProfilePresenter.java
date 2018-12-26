

package com.chaze.india.screens.Profile;

import com.chaze.india.repository.CartManager;import com.chaze.india.repository.network.ICommonAPIManager;
import com.chaze.india.repository.session.SessionManager;
import com.chaze.india.screens.base.BasePresenter;
import com.chaze.india.utils.rx.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;


/**
 * Created by Shubham Vishwakarma on 12/10/18.
 */

public class ProfilePresenter<V extends ProfileContract.View> extends BasePresenter<V>
        implements ProfileContract.Presenter<V> {

    public ProfilePresenter(ICommonAPIManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, SessionManager sessionManager, CartManager cartManager) {
        super(dataManager, schedulerProvider, compositeDisposable, sessionManager, cartManager);
    }

    @Override
    public void fetchDetails(String mobile) {

    }

    @Override
    public void fetchDetailsWithEmail(String email) {

    }
}
