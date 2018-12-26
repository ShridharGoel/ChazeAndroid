

package com.chaze.india.screens.search;

import android.annotation.SuppressLint;

import com.chaze.india.models.SuggestionsResponse;
import com.chaze.india.repository.CartManager;import com.chaze.india.repository.network.ICommonAPIManager;
import com.chaze.india.repository.session.SessionManager;
import com.chaze.india.screens.base.BasePresenter;
import com.chaze.india.utils.rx.SchedulerProvider;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;


/**
 * Created by Shubham Vishwakarma on 4/10/18.
 */

public class SearchPresenter<V extends SearchContract.View> extends BasePresenter<V>
        implements SearchContract.Presenter<V> {

    @Inject
    public SearchPresenter(ICommonAPIManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, SessionManager sessionManager, CartManager cartManager) {
        super(dataManager, schedulerProvider, compositeDisposable, sessionManager, cartManager);
    }


    @SuppressLint("CheckResult")
    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);

        RxSearchObservable.fromView(getMvpView().getSearchView())
                .debounce(300, TimeUnit.MILLISECONDS)
                .distinctUntilChanged()
                .map(a -> getCommonAPIManager().getECommerceAPIService().getSuggestions(a))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> {
                            result.subscribeOn(Schedulers.io())
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribe(suggestionsResponse -> {
                                        getMvpView().recreateList(suggestionsResponse.getData());
                                    }, Throwable -> getMvpView().showError(Throwable.getMessage()));
                        }
                        , throwable -> getMvpView().showError(throwable.getMessage()));
    }
    @Override
    public void initByShopAndCategory() {

    }

    @Override
    public void initSearchEcommerce() {

    }

    @Override
    public void initCategory() {

    }

    @Override
    public void initSearchEngineFood() {

    }
}
