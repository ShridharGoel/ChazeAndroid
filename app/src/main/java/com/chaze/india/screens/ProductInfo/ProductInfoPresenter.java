

package com.chaze.india.screens.ProductInfo;

import com.chaze.india.repository.network.ICommonAPIManager;
import com.chaze.india.repository.session.SessionManager;
import com.chaze.india.screens.base.BasePresenter;
import com.chaze.india.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;


/**
 * Created by Shubham Vishwakarma on 12/10/18.
 */

public class ProductInfoPresenter<V extends ProductInfoContract.View> extends BasePresenter<V>
        implements ProductInfoContract.Presenter<V> {

    @Inject
    public ProductInfoPresenter(ICommonAPIManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, SessionManager sessionManager) {
        super(dataManager, schedulerProvider, compositeDisposable, sessionManager);
    }

    @Override
    public void loadData() {



        getMvpView().showData();
    }
}
