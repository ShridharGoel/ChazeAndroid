package com.chaze.india.screens.base;

/**
 * Created by Shubham Vishwakarma on 4/10/18.
 */


import com.chaze.india.repository.network.ICommonAPIManager;
import com.chaze.india.repository.session.SessionManager;
import com.chaze.india.utils.rx.SchedulerProvider;
import com.chaze.india.repository.network.ICommonAPIManager;
import com.chaze.india.repository.session.SessionManager;
import com.chaze.india.utils.rx.SchedulerProvider;

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
    private final SessionManager sessionManager;


    @Inject
    public BasePresenter(ICommonAPIManager dataManager,
                         SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable, SessionManager sessionManager) {
        this.mCommonAPIManager = dataManager;
        this.mSchedulerProvider = schedulerProvider;
        this.mCompositeDisposable = compositeDisposable;
        this.sessionManager=sessionManager;
    }

    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
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

    public ICommonAPIManager getCommonAPIManager() {
        return mCommonAPIManager;
    }

    public SessionManager getSessionManager() {
        return sessionManager;
    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }

}
