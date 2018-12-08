package com.chaze.india.screens.Homepage.Food;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.chaze.india.screens.Homepage.Ecommerce.ShopByProducts.ShopByProductsFragment;
import com.chaze.india.screens.Homepage.Ecommerce.ShopByShops.ShopByShopsFragment;
import com.chaze.india.screens.Homepage.Food.Restaurants.RestaurantsFragment;

public class FoodPagerAdapter extends FragmentStatePagerAdapter {
    private String TAG = FoodPagerAdapter.class.getSimpleName();


    private Fragment fragment;


    public FoodPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            fragment = new RestaurantsFragment();
        } else if (position == 1) {
            fragment = new RestaurantsFragment();
        } else {
            fragment = new RestaurantsFragment();
        }

        return fragment;

    }


    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        if (position == 0) {
            return "Restaurants";
        } else if (position == 1) {
            return "Cafes";
        } else {
            return "Cakes and Bakeries";
        }
    }
}
