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
<<<<<<< HEAD
import android.widget.LinearLayout;
=======
import android.widget.Toast;
>>>>>>> 6d7cd0bd8ca8696a2b0255cd19f5e50e882d30a4

import com.mission.chaze.chaze.R;
import com.mission.chaze.chaze.adapters.ecomerceCategoryAdapter;
import com.mission.chaze.chaze.models.ecomerceCategory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import timber.log.Timber;

public class Ecomerce extends Fragment {
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

        Toast.makeText(getContext(),"Ecommerce", Toast.LENGTH_SHORT).show();




        return inflater.inflate(R.layout.fragment_ecomerce,container,false);
    }

    private void addItemsToAdapter() {
        categoryList.add(new ecomerceCategory("people","bdbdbdb"));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        categoryList=new ArrayList<>();
        addItemsToAdapter();
        //recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView=getActivity().findViewById(R.id.ecomerceRecyclerView);
        mLayoutManager=new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.HORIZONTAL,false);
        adapter=new ecomerceCategoryAdapter(getActivity().getApplicationContext(),categoryList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(mLayoutManager);

        viewPager=getActivity().findViewById(R.id.tab_viewpager);
        tabLayout = (TabLayout) getActivity().findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);

    }
}
