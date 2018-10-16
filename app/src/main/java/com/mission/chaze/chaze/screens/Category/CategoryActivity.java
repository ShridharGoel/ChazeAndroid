package com.mission.chaze.chaze.screens.Category;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.mission.chaze.chaze.R;
import com.mission.chaze.chaze.di.LinLayoutVert;
import com.mission.chaze.chaze.models.CategorySearchResults;
import com.mission.chaze.chaze.screens.Cart.CartActivity;
import com.mission.chaze.chaze.screens.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryActivity extends BaseActivity implements CategoryContract.View {


    private String TAG = CartActivity.class.getSimpleName();

    @Inject
    ShopCategoryAdapter shopCategoryAdapter;

    @Inject
    CategoryContract.Presenter<CategoryContract.View> mPresenter;


    @Inject
    @LinLayoutVert
    LinearLayoutManager layoutManager;


    @BindView(R.id.recycler_view_for_shops_item_list)
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        setUnBinder(ButterKnife.bind(this));
        getActivityComponent().inject(this);

        setup();
        mPresenter.onAttach(this);


    }



    private void setup() {
        recyclerView.setAdapter(shopCategoryAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }


    @Override
    public void showData(CategorySearchResults results) {
        shopCategoryAdapter.addItems();
    }
}
