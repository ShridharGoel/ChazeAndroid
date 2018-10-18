package com.mission.chaze.chaze.screens.SubCategory;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.GridView;
import android.widget.SearchView;

import com.mission.chaze.chaze.R;
import com.mission.chaze.chaze.di.LinLayoutVert;
import com.mission.chaze.chaze.models.CategorySearchResults;
import com.mission.chaze.chaze.models.EcomerceCategory;
import com.mission.chaze.chaze.screens.Homepage.Ecommerce.ShopByShops.ShopsAdapter;
import com.mission.chaze.chaze.screens.Homepage.Home.HomeGridAdapter;
import com.mission.chaze.chaze.screens.base.BaseActivity;
import com.mission.chaze.chaze.screens.search.SearchActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SubCategoryActivity extends BaseActivity implements SubCategoryContract.View {


    private int totalItemCount, lastVisibleItem, pageNumber = 1;
    private final int VISIBLE_THRESHOLD = 1;
    boolean loading;


    @BindView(R.id.grid)
    GridView grid;

    @BindView(R.id.home_recycler_view)
    RecyclerView recyclerView;

    @Inject
    @LinLayoutVert
    LinearLayoutManager mLayoutManager;

    @Inject
    ShopsAdapter paginationAdapter;

    @Inject
    HomeGridAdapter adapter;


    @Inject
    SubCategoryContract.Presenter<SubCategoryContract.View> mPresenter;


    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.searchbar)
    SearchView searchView;

    @BindView(R.id.nestedScroll)
    NestedScrollView nestedScrollView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category);
        setUnBinder(ButterKnife.bind(this));
        getActivityComponent().inject(this);

        int color = ResourcesCompat.getColor(getResources(), R.color.colorCyan, null); //without theme
        Drawable drawable = new ColorDrawable(color);

        onAttach(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("SubCategoryName: ");
        getSupportActionBar().setBackgroundDrawable(drawable);

        mPresenter.onAttach(this);

        adapter.addItems();

        grid.setAdapter(adapter);

        recyclerView.setAdapter(paginationAdapter);
        recyclerView.setLayoutManager(mLayoutManager);

        setUpLoadMoreListener();

        mPresenter.subscribeForData();

    }


    private void goToSearch() {
        Intent intent = new Intent(this, SearchActivity.class);
        intent.putExtra("SearchType", 1);
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this, (View) searchView, "search");
        startActivity(intent, options.toBundle());
    }


    /**
     * setting listener to get callback for load more
     */
    private void setUpLoadMoreListener() {


        nestedScrollView.setOnScrollChangeListener((NestedScrollView.OnScrollChangeListener) (v, scrollX, scrollY, oldScrollX, oldScrollY) -> {
            if (v.getChildAt(v.getChildCount() - 1) != null) {
                if ((scrollY >= (v.getChildAt(v.getChildCount() - 1).getMeasuredHeight() - v.getMeasuredHeight())) &&
                        scrollY > oldScrollY) {

                    totalItemCount = mLayoutManager.getItemCount();
                    lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
                    if (!loading
                            && totalItemCount <= (lastVisibleItem + VISIBLE_THRESHOLD)) {
                        mPresenter.next();
                    }
                }
            }
        });

    }

    @Override
    public void hideLoading() {
        super.hideLoading();
        loading = false;
    }

    @Override
    public void showLoading() {
        super.showLoading();
        loading = true;
    }

    @Override
    public void showData(CategorySearchResults results) {

    }

    @Override
    public void addItems(List<EcomerceCategory> items) {
        paginationAdapter.addItems(items);
    }


}
