package com.mission.chaze.chaze.screens.search;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;
import android.widget.SearchView;

import com.mission.chaze.chaze.R;
import com.mission.chaze.chaze.di.LinLayoutVert;
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
    SearchContract.Presentor<SearchContract.View> mPresenter;

    @Inject
    @LinLayoutVert
    LinearLayoutManager mLayoutManager;

    @Inject
    SearchSuggestionsAdapter adapter;

    @BindView(R.id.searchbar)
    SearchView searchView;
    @BindView(R.id.recycler_view_search)
    RecyclerView recyclerView;


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
        searchView.setIconified(false);


        //RecyclerView for suggestions...
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(mLayoutManager);

        Bundle extras = getIntent().getExtras();
        searchType = (int) extras.get("SearchType");

        switch (searchType) {
            case 0:
                mPresenter.initSearchHome();
                break;

            case 1:
                mPresenter.initSearchEcommerce();
                break;

            case 2:
                mPresenter.initSearchEngineFood();
                break;

            case 3:
                mPresenter.initSearchEngineLocal();

        }
    }


    public void recreateList(String txt) {
        adapter.recreateList(txt);

    }

    @Override
    public SearchView getSearchView() {
        return searchView;
    }
}
