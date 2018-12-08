package com.chaze.india.screens.Purchases;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.chaze.india.screens.Purchases.ActiveOrders.ActiveOrdersFragment;
import com.chaze.india.screens.Purchases.PreviousOrders.PreviousOrdersFragment;

public class PurchasesPagerAdapter extends FragmentStatePagerAdapter {
    private Fragment fragment;



    public PurchasesPagerAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int i) {
        if (i==0){
            fragment=new ActiveOrdersFragment();
        }
        else {
            fragment=new PreviousOrdersFragment();
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
        if (position==0){
            return "Active Orders";
        }
        else return "Previous Orders";
    }
}
