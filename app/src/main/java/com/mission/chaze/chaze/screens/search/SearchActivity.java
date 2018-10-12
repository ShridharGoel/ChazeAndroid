package com.mission.chaze.chaze.screens.search;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;
import android.widget.SearchView;
import com.mission.chaze.chaze.R;
import com.mission.chaze.chaze.models.SearchResult;
import com.mission.chaze.chaze.screens.base.BaseActivity;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public class SearchActivity extends BaseActivity implements SearchContract.View {

    int searchType;

    @Inject
    SearchContract.Presentor<SearchContract.View> mPresentor;

    @BindView(R.id.searchbar)
    SearchView searchView;
    @BindView(R.id.recycler_view_search)

    RecyclerView recyclerView;
    SearchSuggestionsAdapter adapter;
    ArrayList<SearchResult> searches;


    SearchPresenter<SearchContract.View> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Timber.d("SearchType: %s", searchType);

        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);

        init();
    }

    private void init() {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        searches = new ArrayList<>();
        searchView.setIconified(false);

        setUpSearchObservable();

        //RecyclerView for suggestions...
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        adapter = new SearchSuggestionsAdapter(getApplicationContext(), searches);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(mLayoutManager);

        Bundle extras = getIntent().getExtras();
        searchType = (int) extras.get("SearchType");

        switch (searchType) {
            case 0:
                initSearchHome();
                break;

            case 1:
                initSearchEcommerce();
                break;

            case 2:
                initSearchFood();
                break;

            case 3:
                initLocalSearch();

        }
    }

    private void addItemsToAdapter(String txt) {

        for (int i = 0; i < 40; i++)
            searches.add(new SearchResult(txt));
    }

    private void recreateList(String txt) {
        searches.clear();
        addItemsToAdapter(txt);
        adapter.notifyDataSetChanged();


    }


    @SuppressLint("CheckResult")
    private void setUpSearchObservable() {
        RxSearchObservable.fromView(searchView)
                .debounce(300, TimeUnit.MILLISECONDS)
                .distinctUntilChanged()
                .switchMap((Function<String, ObservableSource<String>>) this::dataFromNetwork)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::recreateList, Timber::e, () -> Timber.d("completed"));
    }

    //Simulation of network data..
    private Observable<String> dataFromNetwork(final String query) {
        return Observable.just(true)
                .delay(2, TimeUnit.SECONDS)
                .map(value -> query);
    }


    private void initLocalSearch() {
        Timber.d("LocalSearch");
    }

    private void initSearchFood() {
        Timber.d("SearchFood");
    }

    private void initSearchEcommerce() {
        Timber.d("SearchEcommerce");
    }

    private void initSearchHome() {
        Timber.d("SearchHome");
    }


}
