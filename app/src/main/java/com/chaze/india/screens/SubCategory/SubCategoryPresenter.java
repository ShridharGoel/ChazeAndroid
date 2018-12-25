

package com.chaze.india.screens.SubCategory;

import android.annotation.SuppressLint;

import com.chaze.india.repository.CartManager;import com.chaze.india.repository.network.ICommonAPIManager;
import com.chaze.india.repository.session.SessionManager;
import com.chaze.india.screens.base.BasePresenter;
import com.chaze.india.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;


/**
 * Created by Shubham Vishwakarma on 17/10/18.
 */

public class SubCategoryPresenter<V extends SubCategoryContract.View> extends BasePresenter<V>
        implements SubCategoryContract.Presenter<V> {

    private Long pageNumber = Long.valueOf(0);


    @Inject
    public
    SubCategoryPresenter(ICommonAPIManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, SessionManager sessionManager, CartManager cartManager) {
        super(dataManager, schedulerProvider, compositeDisposable, sessionManager, cartManager);
    }

    @SuppressLint("CheckResult")
    @Override
    public void getPosts(Long limit, int i) {
        getCommonAPIManager().getECommerceAPIService().getPostsForCategory(getMvpView().getCategory())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(postsResponse -> {
                    getMvpView().hideLoading();
                    getMvpView().addItems(postsResponse.getPosts());
                    Timber.e("Size:" + postsResponse.getPosts().size());
                }, throwable -> {
                    Timber.e(throwable.getMessage());
                    pageNumber--;
                });
    }

    public void next(){
        pageNumber++;
        getMvpView().showLoading();
        getPosts(pageNumber, 0);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);

    }



}
