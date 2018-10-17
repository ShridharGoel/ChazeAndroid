

package com.chaze.india.screens.Homepage.Food;

import com.chaze.india.models.Restaurant;
import com.chaze.india.repository.network.ICommonAPIManager;
import com.chaze.india.repository.session.SessionManager;
import com.chaze.india.screens.base.BasePresenter;
import com.chaze.india.utils.rx.SchedulerProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.processors.PublishProcessor;
import timber.log.Timber;


/**
 * Created by Shubham Vishwakarma on 12/10/18.
 */

public class FoodPresenter<V extends FoodContract.View> extends BasePresenter<V>
        implements FoodContract.Presenter<V> {


    private PublishProcessor<Integer> paginator = PublishProcessor.create();
    private int pageNumber;

    @Inject
    public FoodPresenter(ICommonAPIManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, SessionManager sessionManager) {
        super(dataManager, schedulerProvider, compositeDisposable, sessionManager);
    }



    /**
     * Simulation of network data
     */
    private Flowable<List<Restaurant>> dataFromNetwork(final int page) {
        Timber.e("" + page);
        return Flowable.just(true)
                .delay(2, TimeUnit.SECONDS)
                .map(value -> {
                    List<Restaurant> items = new ArrayList<>();
                    for (int i = 1; i <= 10; i++) {
                        items.add(new Restaurant());
                    }
                    return items;
                });
    }
}
