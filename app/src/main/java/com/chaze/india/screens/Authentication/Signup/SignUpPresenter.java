package com.chaze.india.screens.Authentication.Signup;

import android.annotation.SuppressLint;

import com.chaze.india.repository.network.ICommonAPIManager;
import com.chaze.india.repository.session.SessionManager;
import com.chaze.india.screens.base.BasePresenter;
import com.chaze.india.utils.rx.SchedulerProvider;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by Shridhar Goel on 14/10/18.
 */

public class SignUpPresenter<V extends SignUpContract.View> extends BasePresenter<V>
        implements SignUpContract.Presenter<V> {

    @Inject
    public SignUpPresenter(ICommonAPIManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, SessionManager sessionManager) {
        super(dataManager, schedulerProvider, compositeDisposable, sessionManager);
    }

    @SuppressLint("CheckResult")
    @Override
    public void doSignUp(String name, String mobile, int gender, String pass) {
        getCommonAPIManager().getChazeAPIService().createUser(name, mobile, gender, pass)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(signUpResponse -> {
  //                  getMvpView().showSignUpResult();
                    Timber.e("Success");

                    //On success
                }, Throwable -> {
//                    getMvpView().showSignUpResult();
                    //On error
                    Timber.e("Failure: " + Throwable.getMessage());
                });
        }
    }


