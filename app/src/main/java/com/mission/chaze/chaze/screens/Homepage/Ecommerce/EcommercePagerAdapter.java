package com.mission.chaze.chaze.screens.Homepage.Ecommerce;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.mission.chaze.chaze.screens.Homepage.Ecommerce.ShopByProducts.ShopByProductsFragment;
import com.mission.chaze.chaze.screens.Homepage.Ecommerce.ShopByShops.ShopByShopsFragment;

public class EcommercePagerAdapter extends FragmentStatePagerAdapter {
    private String TAG = EcommercePagerAdapter.class.getSimpleName();


    private Fragment fragment;


    public EcommercePagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            fragment = new ShopByProductsFragment();
        } else {
            fragment = new ShopByShopsFragment();
        }

        return fragment;

    }


    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position

        if (position == 0) {
            return "Shop By Products";
        }
        return "Shop by Shops";
    }
}
