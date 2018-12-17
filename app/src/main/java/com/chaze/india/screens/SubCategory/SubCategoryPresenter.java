

package com.chaze.india.screens.SubCategory;

import com.chaze.india.models.Ecommerce.EcomerceCategory;
import com.chaze.india.repository.network.ICommonAPIManager;
import com.chaze.india.repository.session.SessionManager;
import com.chaze.india.screens.base.BasePresenter;
import com.chaze.india.utils.rx.SchedulerProvider;

import org.reactivestreams.Publisher;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.processors.PublishProcessor;
import timber.log.Timber;


/**
 * Created by Shubham Vishwakarma on 17/10/18.
 */

public class SubCategoryPresenter<V extends SubCategoryContract.View> extends BasePresenter<V>
        implements SubCategoryContract.Presenter<V> {

    private PublishProcessor<Integer> paginator = PublishProcessor.create();
    private int pageNumber;


    @Inject
    public
    SubCategoryPresenter(ICommonAPIManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, SessionManager sessionManager) {
        super(dataManager, schedulerProvider, compositeDisposable, sessionManager);
    }

    @Override
    public void subscribeForData() {

    }

    public void next(){
        pageNumber++;
        paginator.onNext(pageNumber);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);

    }



}
