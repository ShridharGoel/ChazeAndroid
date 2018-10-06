package com.mission.chaze.chaze.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mission.chaze.chaze.R;
import com.mission.chaze.chaze.adapters.ecomerceCategoryAdapter;
import com.mission.chaze.chaze.models.ecomerceCategory;

import java.util.ArrayList;
import java.util.Locale;

import timber.log.Timber;

public class ShopByProducts extends Fragment {
    public ShopByProducts() {
    }


    RecyclerView recyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    ecomerceCategoryAdapter adapter;

    ArrayList<ecomerceCategory> categories;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_shop_by_products,container,false);
    }

    private void addItemsToAdapter() {

        for (int i = 0; i < 40; i++)
            categories.add(new ecomerceCategory("people", "bdbdbdb"));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        categories = new ArrayList<>();
        addItemsToAdapter();
        //recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView = view.findViewById(R.id.ecomerceRecyclerView);
        mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        adapter = new ecomerceCategoryAdapter(getActivity().getApplicationContext(), categories);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(mLayoutManager);
        Toast.makeText(getContext(), "products", Toast.LENGTH_SHORT).show();
    }
}