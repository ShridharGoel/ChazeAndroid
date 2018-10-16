

package com.mission.chaze.chaze.screens.Homepage.Food;

import com.mission.chaze.chaze.models.Restaurant;
import com.mission.chaze.chaze.repository.network.ICommonAPIManager;
import com.mission.chaze.chaze.screens.base.BasePresenter;
import com.mission.chaze.chaze.utils.rx.SchedulerProvider;

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
    public FoodPresenter(ICommonAPIManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
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
