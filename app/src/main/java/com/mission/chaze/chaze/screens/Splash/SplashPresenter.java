

package com.mission.chaze.chaze.screens.Splash;

import com.mission.chaze.chaze.repository.network.ICommonAPIManager;
import com.mission.chaze.chaze.screens.base.BasePresenter;
import com.mission.chaze.chaze.utils.rx.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;


/**
 * Created by Shubham Vishwakarma on 4/10/18.
 */

public class SplashPresenter<V extends SplashContract.View> extends BasePresenter<V>
        implements SplashContract.Presentor<V> {
    public SplashPresenter(ICommonAPIManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void handleApiError(Exception error) {
        super.handleApiError(error);
    }
}
