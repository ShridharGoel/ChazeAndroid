package com.chaze.india.screens.Homepage.Purchases;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.chaze.india.screens.Homepage.Purchases.ActiveOrders.ActiveOrdersFragment;

public class PurchasesPagerAdapter extends FragmentStatePagerAdapter {
    private Fragment fragment;


    public PurchasesPagerAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int i) {
        if (i == 0) {
            fragment = new ActiveOrdersFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("key", 0);
            fragment.setArguments(bundle);
        } else {
            fragment = new ActiveOrdersFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("key", 1);
            fragment.setArguments(bundle);
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Active Orders";
        } else return "Previous Orders";
    }
}
