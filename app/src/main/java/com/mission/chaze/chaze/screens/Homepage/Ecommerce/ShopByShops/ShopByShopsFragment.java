package com.mission.chaze.chaze.screens.Homepage.Ecommerce.ShopByShops;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mission.chaze.chaze.R;
import com.mission.chaze.chaze.screens.base.BaseFragment;

import timber.log.Timber;

public class ShopByShopsFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        Timber.d("ShopByProductsFragment");

        View view = inflater.inflate(R.layout.fragment_shop_by_shops, container, false);
        return view;
    }

}
