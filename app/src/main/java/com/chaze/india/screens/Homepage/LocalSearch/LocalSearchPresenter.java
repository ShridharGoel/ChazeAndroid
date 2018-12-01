

package com.chaze.india.screens.Homepage.LocalSearch;

import com.chaze.india.repository.network.ICommonAPIManager;
import com.chaze.india.utils.rx.SchedulerProvider;
import com.chaze.india.repository.network.ICommonAPIManager;
import com.chaze.india.repository.session.SessionManager;
import com.chaze.india.screens.base.BasePresenter;
import com.chaze.india.utils.rx.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;


/**
 * Created by Shubham Vishwakarma on 12/10/18.
 */

public class LocalSearchPresenter<V extends LocalSearchContract.View> extends BasePresenter<V>
        implements LocalSearchContract.Presenter<V> {

    public LocalSearchPresenter(ICommonAPIManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, SessionManager sessionManager) {
        super(dataManager, schedulerProvider, compositeDisposable, sessionManager);
    }
}
