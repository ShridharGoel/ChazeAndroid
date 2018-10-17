package com.chaze.india.screens.search;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;
import android.widget.SearchView;

import com.chaze.india.R;
import com.chaze.india.di.LinLayoutVert;
import com.chaze.india.models.SearchResult;
import com.chaze.india.screens.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
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
        adapter.recreateList(txt, searchView);

    }

    @Override
    public SearchView getSearchView() {
        return searchView;
    }
}
