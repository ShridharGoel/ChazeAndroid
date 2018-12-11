package com.chaze.india.screens.Homepage.Purchases;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.SearchView;

import com.chaze.india.R;
import com.chaze.india.di.Qualifiers.LinLayoutHori;
import com.chaze.india.screens.Cart.RestaurantCart.RestaurantCartActivity;
import com.chaze.india.screens.Homepage.Food.CuisinesAdapter;
import com.chaze.india.screens.Homepage.Food.FoodContract;
import com.chaze.india.screens.Homepage.Food.FoodPagerAdapter;
import com.chaze.india.screens.base.BaseFragment;
import com.chaze.india.screens.search.SearchActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class PurchasesFragment extends BaseFragment implements PurchasesContract.View{


    @Inject
    PurchasesContract.Presenter<PurchasesContract.View> mPresenter;
    ProgressDialog progressDialog;
    @BindView(R.id.postorder_slider)
    TabLayout tabLayout;
    @BindView(R.id.postorder_view_pager)
    ViewPager viewPager;
    @Inject
    PurchasesPagerAdapter postOrderPagerAdapter;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Timber.d("Ecommerce Fragment");

        View view = inflater.inflate(R.layout.activity_post_order_status, container, false);

        onAttach(getContext());
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this, view));
        progressDialog = new ProgressDialog(getContext());
        mPresenter.onAttach(this);

        return view;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Timber.d("FoodFragment");

        viewPager.setAdapter(postOrderPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
