package com.chaze.india.screens.Shop;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.widget.NestedScrollView;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chaze.india.R;
import com.chaze.india.di.Qualifiers.LinLayoutHori;
import com.chaze.india.di.Qualifiers.LinLayoutVert;
import com.chaze.india.models.CategorySearchResults;
import com.chaze.india.models.Ecommerce.Post;
import com.chaze.india.models.Ecommerce.Product;
import com.chaze.india.models.Ecommerce.Shop;
import com.chaze.india.models.Ecommerce.SubCategory;
import com.chaze.india.screens.ProductsPostAdapter;
import com.chaze.india.screens.base.BaseActivity;
import com.chaze.india.screens.search.SearchActivity;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.iarcuschin.simpleratingbar.SimpleRatingBar;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

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
    ProductsListAdapter productsAdapter;

    @Inject
    SubCategoryAdapter adapter;

    @BindView(R.id.categories_recycler_view)
    ShimmerRecyclerView categoriesRecyclerView;

    @Inject
    ShopContract.Presenter<ShopContract.View> mPresenter;
    private boolean adapterNotSet;

    @BindView(R.id.searchbar)
    ConstraintLayout searchView;

    @BindView(R.id.nestedScroll)
    NestedScrollView nestedScrollView;


    @BindView(R.id.shop_name_view)
    TextView shopName;

    @BindView(R.id.shop_address_view)
    TextView address;
    @BindView(R.id.status)
    TextView status;

    @BindView(R.id.shop_rating_view)
    SimpleRatingBar ratingBar;

    @BindView(R.id.shop_image_view)
    ImageView imageView;

    @BindView(R.id.min_order_view)
    TextView minOrderView;

    @BindView(R.id.delivery_charge_view)
    TextView deliverChargeView;

    @BindView(R.id.speaciality_text)
    TextView speciality;


    long shopId;
    long category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        setUnBinder(ButterKnife.bind(this));
        getActivityComponent().inject(this);

        Intent intent = getIntent();
        shopId = intent.getExtras().getLong("Shop");
        category = intent.getExtras().getLong("Category");

        onAttach(this);
        mPresenter.onAttach(this);
        setup();
    }

    private void setup() {


        recyclerView.showShimmerAdapter();
        categoriesRecyclerView.showShimmerAdapter();
        adapter.setShopId(shopId);
        postAdapter.setIsByShop(false, shopId);
        categoriesRecyclerView.setLayoutManager(mLayoutManagerH);

        searchView.setOnClickListener(v -> goToSearch());
        recyclerView.setLayoutManager(mLayoutManager);
        mPresenter.getShop();
        mPresenter.getSubCategories();
    }

    /**
     * setting listener to get callback for load more
     */
    private void setUpLoadMoreListener() {
        mPresenter.getPosts(0);

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
    public Long getShopId() {
        return shopId;
    }

    @Override
    public Long getCategoryId() {
        return category;
    }

    @Override
    public void showCategories(List<SubCategory> results) {
        if (results.size() > 0) {
            setUpLoadMoreListener();
        } else {
            mPresenter.getProducts();
        }
        categoriesRecyclerView.setAdapter(adapter);
        adapter.addItems(results);
    }

    @Override
    public void shopPosts(List<Post> items) {
        if (!adapterNotSet) recyclerView.setAdapter(postAdapter);
        postAdapter.addItems(items);
        adapterNotSet = true;
    }

    @Override
    public void showProducts(List<Product> products) {
        recyclerView.setAdapter(productsAdapter);
        productsAdapter.addItems(products);
    }

    @Override
    public void showShopDetails(Shop shop) {
        shopName.setText(shop.getName());

        address.setText(shop.getAddress());
        Picasso.get().load(shop.getImageUrl()).into(imageView);
        if ((shop.getStatus() == 1)) {
            status.setText("Open");
            // status.setBackgroundColor(getResources().getColor(R.color.));
        } else {
            status.setText("Closed");
        }

        speciality.setText(shop.getCode());
    }

    @Override
    public void showError(String message) {
        Timber.e(message);
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


}


//Todo: Implementation of final category and shop, just shop list of products rather than shops