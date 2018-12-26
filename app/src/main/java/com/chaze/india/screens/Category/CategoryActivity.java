package com.chaze.india.screens.Category;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.chaze.india.models.Ecommerce.Category;

import com.chaze.india.R;
import com.chaze.india.di.Qualifiers.LinLayoutVert;
import com.chaze.india.models.CategorySearchResults;
import com.chaze.india.models.Ecommerce.ShopForCategory;
import com.chaze.india.screens.base.BaseActivity;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryActivity extends BaseActivity implements CategoryContract.View {


    private String TAG = CategoryActivity.class.getSimpleName();

    @Inject
    ShopCategoryAdapter shopCategoryAdapter;

    @Inject
    CategoryContract.Presenter<CategoryContract.View> mPresenter;


    @Inject
    @LinLayoutVert
    LinearLayoutManager layoutManager;

    @BindView(R.id.category_text)
    TextView toolbarText;

    @BindView(R.id.recycler_view_for_shops_item_list)
    RecyclerView recyclerView;

    Category category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        setUnBinder(ButterKnife.bind(this));
        getActivityComponent().inject(this);

        category = (Category) getIntent().getExtras().getSerializable("Category");
        shopCategoryAdapter.setCategoryId(category.getId());
        setup();
        mPresenter.onAttach(this);
        mPresenter.getShops();

    }


    private void setup() {
        toolbarText.setText(category.getName());

        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public Long getCategory() {
        return category.getId();
    }

    @Override
    public void addShops(List<ShopForCategory> shopForCategories) {
        recyclerView.setAdapter(shopCategoryAdapter);
        shopCategoryAdapter.addItems(shopForCategories);
    }
}
