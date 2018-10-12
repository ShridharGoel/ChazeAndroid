

package com.mission.chaze.chaze.screens.Homepage.Ecommerce.ShopByShops;

import com.mission.chaze.chaze.repository.network.ICommonAPIManager;
import com.mission.chaze.chaze.screens.base.BasePresenter;
import com.mission.chaze.chaze.utils.rx.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;


/**
 * Created by Shubham Vishwakarma on 12/10/18.
 */

public class ShopByShopsPresenter<V extends ShopByShopsContract.View> extends BasePresenter<V>
        implements ShopByShopsContract.Presentor<V> {

    public ShopByShopsPresenter(ICommonAPIManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
