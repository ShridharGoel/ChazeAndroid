package com.mission.chaze.chaze.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.LinearLayout;

import android.widget.Toast;


import com.mission.chaze.chaze.R;
import com.mission.chaze.chaze.adapters.EcommercePagerAdapter;
import com.mission.chaze.chaze.adapters.ecomerceCategoryAdapter;
import com.mission.chaze.chaze.models.ecomerceCategory;
import com.mission.chaze.chaze.screens.base.BaseFragment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import timber.log.Timber;

public class Ecomerce extends BaseFragment {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    ecomerceCategoryAdapter adapter;
    ArrayList<ecomerceCategory> categoryList;
    ViewPager viewPager;
    TabLayout tabLayout;

    public Ecomerce() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Toast.makeText(getContext(), "Ecommerce", Toast.LENGTH_SHORT).show();


        return inflater.inflate(R.layout.fragment_ecomerce, container, false);
    }

    private void addItemsToAdapter() {

        for (int i = 0; i < 40; i++)
            categoryList.add(new ecomerceCategory("people", "bdbdbdb"));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        categoryList = new ArrayList<>();
        addItemsToAdapter();
        //recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView = getActivity().findViewById(R.id.ecomerceRecyclerView);
        mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        adapter = new ecomerceCategoryAdapter(getActivity().getApplicationContext(), categoryList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(mLayoutManager);

        viewPager = view.findViewById(R.id.ecommerce_view_pager);
        tabLayout = (TabLayout) view.findViewById(R.id.ecommerce_slider);

        EcommercePagerAdapter restaurantMenuFragmentPagerAdapter = new EcommercePagerAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(restaurantMenuFragmentPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }

    @Override
    public void hideKeyboard() {

    }
}
