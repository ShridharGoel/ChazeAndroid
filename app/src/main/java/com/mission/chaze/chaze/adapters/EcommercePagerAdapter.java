package com.mission.chaze.chaze.adapters;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.google.gson.Gson;
import com.mission.chaze.chaze.fragments.ShopByProducts;
import com.mission.chaze.chaze.fragments.ShopByShop;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class EcommercePagerAdapter extends FragmentStatePagerAdapter {
    private String TAG = EcommercePagerAdapter.class.getSimpleName();


    private Fragment fragment;


    public EcommercePagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {

            if (position == 0) {
                fragment = new ShopByProducts();
            } else {
                fragment = new ShopByShop();
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
        return "Tab: " + position;
    }
}
