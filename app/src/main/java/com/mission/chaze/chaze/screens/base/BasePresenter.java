package com.mission.chaze.chaze.screens.base;

/**
 * Created by Shubham Vishwakarma on 4/10/18.
 */


import com.mission.chaze.chaze.repository.network.CommonAPIManager;
import com.mission.chaze.chaze.repository.network.ICommonAPIManager;
import com.mission.chaze.chaze.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Base class that implements the Presenter interface and provides a base implementation for
 * onAttach() and onDetach(). It also handles keeping a reference to the mvpView that
 * can be accessed from the children classes by calling getMvpView().
 */

public class BasePresenter<V extends MvpContract.View> implements MvpContract.Presenter<V> {

    private V mMvpView;

    private static final String TAG = "BasePresenter";

    private final ICommonAPIManager mCommonAPIManager;
    private final SchedulerProvider mSchedulerProvider;
    private final CompositeDisposable mCompositeDisposable;


    @Inject
    public BasePresenter(ICommonAPIManager dataManager,
                         SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable) {
        this.mCommonAPIManager = dataManager;
        this.mSchedulerProvider = schedulerProvider;
        this.mCompositeDisposable = compositeDisposable;
    }

    @Override
    public void onAttach(V mvpView) {
        mvpView = mvpView;
    }

    @Override
    public void onDetach() {
        mCompositeDisposable.dispose();
        mMvpView = null;
    }

    @Override
    public void handleApiError(Exception error) {

    }


    public V getMvpView() {
        return mMvpView;
    }

    public SchedulerProvider getSchedulerProvider() {
        return mSchedulerProvider;
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    public ICommonAPIManager getDataManager() {
        return mCommonAPIManager;
    }


    public boolean isViewAttached() {
        return mMvpView != null;
    }

}
