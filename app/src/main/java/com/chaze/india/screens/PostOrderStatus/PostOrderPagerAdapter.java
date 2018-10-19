package com.chaze.india.screens.PostOrderStatus;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.chaze.india.screens.PostOrderStatus.ActiveOrders.ActiveOrdersFragment;
import com.chaze.india.screens.PostOrderStatus.PreviousOrders.PreviousOrdersFragment;

public class PostOrderPagerAdapter  extends FragmentStatePagerAdapter {
    private Fragment fragment;



    public PostOrderPagerAdapter(FragmentManager fm) {
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
