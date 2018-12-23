package com.chaze.india.screens.SubCategory;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chaze.india.R;
import com.chaze.india.di.Qualifiers.LinLayoutHori;
import com.chaze.india.di.Qualifiers.LinLayoutVert;
import com.chaze.india.models.CategorySearchResults;
import com.chaze.india.models.Ecommerce.Category;
import com.chaze.india.models.Ecommerce.Post;
import com.chaze.india.screens.Homepage.Ecommerce.EcommerceCategoryAdapter;
import com.chaze.india.screens.ProductsPostAdapter;
import com.chaze.india.screens.base.BaseActivity;
import com.chaze.india.screens.search.SearchActivity;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SubCategoryActivity extends BaseActivity implements SubCategoryContract.View {


    private int totalItemCount, lastVisibleItem, pageNumber = 1;
    private final int VISIBLE_THRESHOLD = 1;
    boolean loading;


    @Inject
    @LinLayoutHori
    LinearLayoutManager mLayoutManagerH;

    @BindView(R.id.home_recycler_view)
    RecyclerView recyclerView;

    @Inject
    @LinLayoutVert
    LinearLayoutManager mLayoutManager;

    @Inject
    ProductsPostAdapter postAdapter;

    @Inject
    EcommerceCategoryAdapter adapter;

    @BindView(R.id.ecomerceRecyclerView)
    ShimmerRecyclerView categoriesRecyclerView;

    @Inject
    SubCategoryContract.Presenter<SubCategoryContract.View> mPresenter;


    @BindView(R.id.toolbar)
    RelativeLayout toolbar;

    @BindView(R.id.searchbar)
    ConstraintLayout searchView;

    @BindView(R.id.nestedScroll)
    NestedScrollView nestedScrollView;

    Category category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category);
        setUnBinder(ButterKnife.bind(this));
        getActivityComponent().inject(this);
        onAttach(this);
        mPresenter.onAttach(this);

        category = (Category) getIntent().getExtras().getSerializable("Category");
        setup();
    }

    private void setup() {
        setupToolBar();
        categoriesRecyclerView.setLayoutManager(mLayoutManagerH);
        categoriesRecyclerView.setAdapter(adapter);
        adapter.addItems(category.getCategories());
        recyclerView.setAdapter(postAdapter);
        recyclerView.setLayoutManager(mLayoutManager);
        setUpLoadMoreListener();
        mPresenter.getPosts(category.getId(), 0);
    }

    private void setupToolBar() {
        TextView toolbarText = toolbar.findViewById(R.id.toolbar_text);
        toolbarText.setText(category.getName());
        searchView.setOnClickListener(v -> goToSearch());
    }


    private void goToSearch() {
        Intent intent = new Intent(this, SearchActivity.class);
        intent.putExtra("SearchType", 0);
        intent.putExtra("Shop", "-1");
        intent.putExtra("Category", category);
        Pair<View, String> p1 = Pair.create((View) searchView, "search");
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this, p1);
        startActivity(intent, options.toBundle());
    }


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
    public void addItems(List<Post> items) {
        postAdapter.setIsFromCategory(true, category.getId());
        postAdapter.addItems(items);
    }

    @Override
    public Long getCategory() {
        return category.getId();
    }


}
