

package com.chaze.india.screens.Authentication.Login;

import android.annotation.SuppressLint;

import com.chaze.india.repository.network.ICommonAPIManager;
import com.chaze.india.repository.session.SessionManager;
import com.chaze.india.screens.base.BasePresenter;
import com.chaze.india.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by Shridhar Goel on 14/10/18.
 */

public class LoginPresenter<V extends LoginContract.View> extends BasePresenter<V>
        implements LoginContract.Presenter<V> {

    @Inject
    public LoginPresenter(ICommonAPIManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, SessionManager sessionManager) {
        super(dataManager, schedulerProvider, compositeDisposable, sessionManager);
    }

    @Override
    public void doLogin(String mobile, String pass) {
        getCommonAPIManager().getChazeAPIService().loginUser(mobile, pass)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(loginResponse -> {
                   getMvpView().showloginResult();
                    Timber.e("Success");
                    //On success
                }, Throwable -> {
                    getMvpView().showloginResult();
                    Timber.e(Throwable.getMessage());
                    //On error
                });
    }
}
