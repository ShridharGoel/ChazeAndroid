

package com.mission.chaze.chaze.screens.search;

import android.annotation.SuppressLint;

import com.mission.chaze.chaze.repository.network.ICommonAPIManager;
import com.mission.chaze.chaze.repository.session.SessionManager;
import com.mission.chaze.chaze.screens.base.BasePresenter;
import com.mission.chaze.chaze.utils.rx.SchedulerProvider;

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

public class SearchPresenter<V extends SearchContract.View> extends BasePresenter<V>
        implements SearchContract.Presentor<V> {

    @Inject
    public SearchPresenter(ICommonAPIManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, SessionManager sessionManager) {
        super(dataManager, schedulerProvider, compositeDisposable, sessionManager);
    }


    @SuppressLint("CheckResult")
    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);

        RxSearchObservable.fromView(getMvpView().getSearchView())
                .debounce(300, TimeUnit.MILLISECONDS)
                .distinctUntilChanged()
                .switchMap((Function<String, ObservableSource<String>>) this::dataFromNetwork)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result->getMvpView().recreateList(result), Timber::e, () -> Timber.d("completed"));
    }

    //Simulation of network data..
    private Observable<String> dataFromNetwork(final String query) {
        return Observable.just(true)
                .delay(2, TimeUnit.SECONDS)
                .map(value -> query);
    }

    @Override
    public void initSearchHome() {

    }

    @Override
    public void initSearchEcommerce() {

    }

    @Override
    public void initSearchEngineLocal() {

    }

    @Override
    public void initSearchEngineFood() {

    }
}
