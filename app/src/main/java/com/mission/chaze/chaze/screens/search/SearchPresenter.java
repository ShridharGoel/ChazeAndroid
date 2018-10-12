

package com.mission.chaze.chaze.screens.search;

import com.mission.chaze.chaze.repository.network.ICommonAPIManager;
import com.mission.chaze.chaze.screens.base.BasePresenter;
import com.mission.chaze.chaze.utils.rx.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;


/**
 * Created by Shubham Vishwakarma on 4/10/18.
 */

public class SearchPresenter<V extends SearchContract.View> extends BasePresenter<V>
        implements SearchContract.Presentor<V> {

    public SearchPresenter(ICommonAPIManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
