

package com.chaze.india.screens.Referral;

import com.chaze.india.repository.network.ICommonAPIManager;
import com.chaze.india.repository.session.SessionManager;
import com.chaze.india.screens.base.BasePresenter;
import com.chaze.india.utils.rx.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;


/**
 * Created by Shubham Vishwakarma on 12/10/18.
 */

public class ReferralPresenter<V extends ReferralContract.View> extends BasePresenter<V>
        implements ReferralContract.Presentor<V> {

    public ReferralPresenter(ICommonAPIManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, SessionManager sessionManager) {
        super(dataManager, schedulerProvider, compositeDisposable, sessionManager);
    }
}
