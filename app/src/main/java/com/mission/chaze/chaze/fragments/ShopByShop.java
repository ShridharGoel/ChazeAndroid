package com.mission.chaze.chaze.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mission.chaze.chaze.R;

import timber.log.Timber;

public class ShopByShop extends Fragment {
    public ShopByShop() {
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        Timber.d("Home");

        return inflater.inflate(R.layout.fragment_shop_by_shops,container,false);
    }
}
