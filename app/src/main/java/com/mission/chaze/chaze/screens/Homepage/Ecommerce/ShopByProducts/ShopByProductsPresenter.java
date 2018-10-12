

package com.mission.chaze.chaze.screens.Homepage.Ecommerce.ShopByProducts;

import com.mission.chaze.chaze.repository.network.ICommonAPIManager;
import com.mission.chaze.chaze.screens.base.BasePresenter;
import com.mission.chaze.chaze.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;


/**
 * Created by Shubham Vishwakarma on 12/10/18.
 */

public class ShopByProductsPresenter<V extends ShopByProductsContract.View> extends BasePresenter<V>
        implements ShopByProductsContract.Presentor<V> {

    @Inject
    public ShopByProductsPresenter(ICommonAPIManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
