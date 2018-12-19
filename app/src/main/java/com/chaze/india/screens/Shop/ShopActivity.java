package com.chaze.india.screens.Shop;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.widget.NestedScrollView;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.GridView;

import com.chaze.india.R;
import com.chaze.india.di.Qualifiers.LinLayoutHori;
import com.chaze.india.di.Qualifiers.LinLayoutVert;
import com.chaze.india.models.CategorySearchResults;
import com.chaze.india.models.Ecommerce.EcomerceCategory;
import com.chaze.india.models.Ecommerce.Post;
import com.chaze.india.models.Ecommerce.SubCategory;
import com.chaze.india.screens.Homepage.Ecommerce.EcommerceCategoryAdapter;
import com.chaze.india.screens.ProductsPostAdapter;
import com.chaze.india.screens.base.BaseActivity;
import com.chaze.india.screens.search.SearchActivity;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShopActivity extends BaseActivity implements ShopContract.View {

    private int totalItemCount, lastVisibleItem, pageNumber = 1;
    private final int VISIBLE_THRESHOLD = 1;
    boolean loading;

    @Inject
    @LinLayoutHori
    LinearLayoutManager mLayoutManagerH;

    @BindView(R.id.home_recycler_view)
    ShimmerRecyclerView recyclerView;

    @Inject
    @LinLayoutVert
    LinearLayoutManager mLayoutManager;

    @Inject
    ProductsPostAdapter postAdapter;

    @Inject
    ShopItemListAdapter productsAdapter;

    @Inject
    SubCategoryAdapter adapter;

    @BindView(R.id.ecomerceRecyclerView)
    ShimmerRecyclerView categoriesRecyclerView;

    @Inject
    ShopContract.Presenter<ShopContract.View> mPresenter;
    private boolean adapterNotSet;

    @BindView(R.id.searchbar)
    ConstraintLayout searchView;

    @BindView(R.id.nestedScroll)
    NestedScrollView nestedScrollView;


    String shopId, category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        setUnBinder(ButterKnife.bind(this));
        getActivityComponent().inject(this);

        Intent intent = getIntent();
        shopId = intent.getExtras().getString("Shop");
        category = intent.getExtras().getString("Category");

        onAttach(this);
        mPresenter.onAttach(this);
        setup();
    }

    private void setup() {

        categoriesRecyclerView.setAdapter(adapter);
        categoriesRecyclerView.setLayoutManager(mLayoutManagerH);
        categoriesRecyclerView.showShimmerAdapter();
        searchView.setOnClickListener(v -> goToSearch());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.showShimmerAdapter();

        mPresenter.getSubCategories();
        mPresenter.subscribeForData(0);
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
                        loading = true;
                    }
                }
            }
        });

    }

    private void goToSearch() {
        Intent intent = new Intent(this, SearchActivity.class);
        intent.putExtra("SearchType", 0);
        intent.putExtra("Shop", shopId);
        intent.putExtra("Category", category);
        Pair<View, String> p1 = Pair.create((View) searchView, "search");
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this, p1);
        startActivity(intent, options.toBundle());
    }



    @Override
    public void addItems(List<Post> items) {
        if (!adapterNotSet) recyclerView.setAdapter(postAdapter);
        postAdapter.addItems(items);
        adapterNotSet = true;
    }

    @Override
    public String getShop() {
        return shopId;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public void showCategories(List<SubCategory> results) {
        if (results.size() > 0) {
            showPosts();
        } else {
            showProducts();
        }
        adapter.addItems(results);
    }

    private void showProducts() {
        mPresenter.getProducts();
    }

    public void showListOfProducts() {
        recyclerView.setAdapter(productsAdapter);
    }

    private void showPosts() {
        postAdapter.setIsByShop(false, shopId);
        setUpLoadMoreListener();
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

}


//Todo: Implementation of final category and shop, just shop list of products rather than shops