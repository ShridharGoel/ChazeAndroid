

package com.mission.chaze.chaze.screens.Category;

import com.mission.chaze.chaze.models.CategorySearchResults;
import com.mission.chaze.chaze.repository.network.ICommonAPIManager;
import com.mission.chaze.chaze.repository.session.SessionManager;
import com.mission.chaze.chaze.screens.base.BasePresenter;
import com.mission.chaze.chaze.utils.rx.SchedulerProvider;

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
