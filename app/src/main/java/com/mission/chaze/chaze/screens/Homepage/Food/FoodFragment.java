package com.mission.chaze.chaze.screens.Homepage.Food;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mission.chaze.chaze.R;
import com.mission.chaze.chaze.di.LinLayoutHori;
import com.mission.chaze.chaze.di.LinLayoutVert;
import com.mission.chaze.chaze.models.Restaurant;
import com.mission.chaze.chaze.screens.Homepage.Ecommerce.EcommerceCategoryAdapter;
import com.mission.chaze.chaze.screens.Homepage.Ecommerce.ShopByShops.ShopsAdapter;
import com.mission.chaze.chaze.screens.Homepage.Home.HomeFragmentContract;
import com.mission.chaze.chaze.screens.Homepage.Home.HomeGridAdapter;
import com.mission.chaze.chaze.screens.base.BaseFragment;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class FoodFragment extends BaseFragment implements FoodContract.View {


    @BindView(R.id.category_recycler_view)
    RecyclerView categoryRecyclerView;

    @BindView(R.id.food_recycler_view)
    RecyclerView recyclerView;

    @Inject
    @LinLayoutVert
    LinearLayoutManager mLayoutManager;

    @Inject
    @LinLayoutHori
    LinearLayoutManager mLayoutManagerCategory;

    @Inject
    RestaurantListAdapter paginationAdapter;

    @Inject
    EcommerceCategoryAdapter categoryAdapter;

    @Inject
    FoodContract.Presenter<FoodContract.View> mPresenter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Timber.d("Food");
        View view = inflater.inflate(R.layout.fragment_food, container, false);
        onAttach(getContext());
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this, view));
        mPresenter.onAttach(this);

        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Timber.d("FoodFragment");

        categoryAdapter.addItems();
        paginationAdapter.addItems();


        recyclerView.setAdapter(paginationAdapter);
        recyclerView.setLayoutManager(mLayoutManager);

        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryRecyclerView.setLayoutManager(mLayoutManagerCategory);

    }





    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
