package com.chaze.india.screens.Shop;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.GridView;
import android.widget.SearchView;

import com.chaze.india.R;
import com.chaze.india.di.Qualifiers.LinLayoutVert;
import com.chaze.india.models.CategorySearchResults;
import com.chaze.india.models.EcomerceCategory;
import com.chaze.india.screens.Homepage.HomeGridAdapter;
import com.chaze.india.screens.ProductsPostAdapter;
import com.chaze.india.screens.SubCategory.SubCategoryContract;
import com.chaze.india.screens.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShopActivity extends BaseActivity implements ShopContract.View {

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
    ProductsPostAdapter postAdapter;

    @Inject
    HomeGridAdapter adapter;


    @Inject
    ShopContract.Presenter<ShopContract.View> mPresenter;


    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.searchbar)
    ConstraintLayout searchView;

    @BindView(R.id.nestedScroll)
    NestedScrollView nestedScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

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

        recyclerView.setAdapter(postAdapter);
        recyclerView.setLayoutManager(mLayoutManager);
        postAdapter.addItems(null);
        setUpLoadMoreListener();

        mPresenter.subscribeForData();

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
        postAdapter.addItems(null);
    }
}
