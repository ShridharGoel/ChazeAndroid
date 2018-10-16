

package com.mission.chaze.chaze.screens.Authentication;

import android.annotation.SuppressLint;

import com.mission.chaze.chaze.repository.network.ICommonAPIManager;
import com.mission.chaze.chaze.repository.session.SessionManager;
import com.mission.chaze.chaze.screens.base.BasePresenter;
import com.mission.chaze.chaze.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Shubham Vishwakarma on 12/10/18.
 */

public class LoginPresenter<V extends LoginContract.View> extends BasePresenter<V>
        implements LoginContract.Presenter<V> {

    @Inject
    public LoginPresenter(ICommonAPIManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, SessionManager sessionManager) {
        super(dataManager, schedulerProvider, compositeDisposable, sessionManager);
    }

    @SuppressLint("CheckResult")
    @Override
    public void doLogin(String mobile, String pass) {
        getCommonAPIManager().getChazeAPIService().loginUser(mobile, pass)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(loginResponse -> {
                    getMvpView().showloginResult();
                    //On success
                }, Throwable -> {
                    getMvpView().showloginResult();
                    //On error
                });
    }
}
