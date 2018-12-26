

package com.chaze.india.screens.RestaurantMenu;

import android.annotation.SuppressLint;

import com.chaze.india.repository.CartManager;import com.chaze.india.repository.network.ICommonAPIManager;
import com.chaze.india.repository.session.SessionManager;
import com.chaze.india.screens.base.BasePresenter;
import com.chaze.india.screens.search.RxSearchObservable;
import com.chaze.india.utils.rx.SchedulerProvider;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;


/**
 * Created by Shubham Vishwakarma on 4/10/18.
 */

public class RestaurantMenuPresenter<V extends RestaurantMenuContract.View> extends BasePresenter<V>
        implements RestaurantMenuContract.Presenter<V> {

    @Inject
    public RestaurantMenuPresenter(ICommonAPIManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, SessionManager sessionManager, CartManager cartManager) {
        super(dataManager, schedulerProvider, compositeDisposable, sessionManager, cartManager);
    }



}
