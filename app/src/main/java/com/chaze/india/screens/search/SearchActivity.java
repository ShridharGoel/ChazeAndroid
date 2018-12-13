package com.chaze.india.screens.search;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.cooltechworks.views.shimmer.ShimmerRecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;
import android.widget.SearchView;
import android.widget.TextView;

import com.chaze.india.R;
import com.chaze.india.di.Qualifiers.LinLayoutVert;
import com.chaze.india.screens.base.BaseActivity;

import java.security.acl.Group;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class SearchActivity extends BaseActivity implements SearchContract.View {

    int searchType;

    @Inject
    SearchContract.Presenter<SearchContract.View> mPresenter;

    @Inject
    @LinLayoutVert
    LinearLayoutManager mLayoutManager;

    @Inject
    SearchSuggestionsAdapter adapter;


    @BindView(R.id.firstbutton)
    TextView firstButton;

    @BindView(R.id.secondButton)
    TextView secondButton;

    @BindView(R.id.searchbar)
    SearchView searchView;
    @BindView(R.id.recycler_view_search)
    RecyclerView recyclerView;


    boolean firstButtonSelected = true;

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

        firstButton.setOnClickListener(v -> firstButtonClicked());

        secondButton.setOnClickListener(v -> secondButtonClicked());

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
                changeButtonsTo("Products", "Shops");
                mPresenter.initSearchEcommerce();
                break;

            case 2:
                changeButtonsTo("Dishes", "Eating Joints");
                mPresenter.initSearchEngineFood();
                break;

            case 3:
                mPresenter.initSearchEngineLocal();

        }
    }

    private void firstButtonClicked() {

        if (firstButtonSelected) return;
        firstButton.setTextColor(getResources().getColor(R.color.textLightPrimary));
        firstButton.setBackground(getDrawable(R.drawable.yellow_rectangle_border_purple));

        secondButton.setTextColor(getResources().getColor(R.color.textDarkPrimary));
        secondButton.setBackground(getDrawable(R.drawable.white_rectangle_border_purple));
        firstButtonSelected = true;
    }

    private void secondButtonClicked() {

        if (!firstButtonSelected) return;
        firstButton.setTextColor(getResources().getColor(R.color.textDarkPrimary));
        firstButton.setBackground(getDrawable(R.drawable.white_rectangle_border_purple));

        secondButton.setTextColor(getResources().getColor(R.color.textLightPrimary));
        secondButton.setBackground(getDrawable(R.drawable.yellow_rectangle_border_purple));

        firstButtonSelected = false;

    }


    public void changeButtonsTo(String strOne, String strTwo) {
        firstButton.setText(strOne);
        secondButton.setText(strTwo);
    }


    public void recreateList(String txt) {


        adapter.recreateList(txt, searchView);

    }

    @Override
    public SearchView getSearchView() {
        return searchView;
    }
}
