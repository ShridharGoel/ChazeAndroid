

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

    public void next(){
        pageNumber++;
        paginator.onNext(pageNumber);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);

    }


    @Override
    public void subscribeForData() {
        Disposable disposable = paginator
                .onBackpressureDrop()
                .concatMap((Function<Integer, Publisher<List<EcomerceCategory>>>) page -> {

                    getMvpView().showLoading();
                    return dataFromNetwork(page);
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(items -> {
                    getMvpView().addItems(items);
                    getMvpView().hideLoading();
                });

        getCompositeDisposable().add(disposable);

        next();
    }

    private Flowable<List<EcomerceCategory>> dataFromNetwork(final int page) {
        Timber.e("" + page);
        return Flowable.just(true)
                .delay(2, TimeUnit.SECONDS)
                .map(value -> {
                    List<EcomerceCategory> items = new ArrayList<>();
                    for (int i = 1; i <= 10; i++) {
                        items.add(new EcomerceCategory("Item " + (page * 10 + i), "asdf","https://drive.google.com/file/d/15b68H448F4jszurUpAAQV6lFPHdY1dv2/view?usp=sharing"));
                    }
                    return items;
                });
    }

}
