package com.mission.chaze.chaze.screens.Homepage.Ecommerce;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.mission.chaze.chaze.R;
import com.mission.chaze.chaze.di.LinLayoutHori;
import com.mission.chaze.chaze.models.EcomerceCategory;
import com.mission.chaze.chaze.screens.base.BaseFragment;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class EcommerceFragment extends BaseFragment implements EcommerceContract.View {


    @Inject
    @LinLayoutHori
    LinearLayoutManager mLayoutManager;
    @Inject
    EcommerceCategoryAdapter adapter;

    @Inject
    EcommercePagerAdapter ecommercePagerAdapter;

    @BindView(R.id.ecommerce_view_pager)
    ViewPager viewPager;
    @BindView(R.id.ecommerce_slider)
    TabLayout tabLayout;
    @BindView(R.id.ecomerceRecyclerView)
    RecyclerView recyclerView;

    @Inject
    EcommerceContract.Presentor<EcommerceContract.View> mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Timber.d("Ecommerce Fragment");

        View view = inflater.inflate(R.layout.fragment_ecomerce, container, false);

        onAttach(getContext());
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this, view));
        mPresenter.onAttach(this);
        return view;

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Timber.e("Ecommerce View created");
        adapter.addItems();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(mLayoutManager);
        viewPager.setAdapter(ecommercePagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }

}
