

package com.chaze.india.screens.Category;

import com.chaze.india.models.CategorySearchResults;
import com.chaze.india.repository.network.ICommonAPIManager;
import com.chaze.india.repository.session.SessionManager;
import com.chaze.india.screens.base.BasePresenter;
import com.chaze.india.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;


/**
 * Created by Shubham Vishwakarma on 12/10/18.
 */

public class CategoryPresenter<V extends CategoryContract.View> extends BasePresenter<V>
        implements CategoryContract.Presenter<V> {

    @Inject
    public CategoryPresenter(ICommonAPIManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, SessionManager sessionManager) {
        super(dataManager, schedulerProvider, compositeDisposable, sessionManager);
    }


    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);

        //Load data
        CategorySearchResults results = new CategorySearchResults(new ArrayList<>());

        getMvpView().showData(results);

    }



}
