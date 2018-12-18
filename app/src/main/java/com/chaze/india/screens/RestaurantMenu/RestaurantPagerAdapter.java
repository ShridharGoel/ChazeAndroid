package com.chaze.india.screens.RestaurantMenu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.chaze.india.models.Food.Restaurant;
import com.chaze.india.screens.RestaurantMenu.RestaurantCategory.RestaurantCategoryFragment;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RestaurantPagerAdapter extends FragmentStatePagerAdapter {

    private int numberOfTabs = 0;
    private Restaurant restaurant;
    private Fragment fragment;
    private ArrayList<String> restaurantCategoriesArrayList;
    private JSONArray restaurantMenu;


    public RestaurantPagerAdapter(FragmentManager fm, int numberOfTabs, ArrayList<String> restaurantCategoriesArrayList, JSONArray restaurantMenu, Restaurant restaurant) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
        this.restaurantCategoriesArrayList = restaurantCategoriesArrayList;
        this.restaurantMenu = restaurantMenu;
        this.restaurant = restaurant;
    }


    @Override
    public Fragment getItem(int position) {
        for (int i = 0; i < numberOfTabs; i++) {
            if (i == position) {
                fragment = new RestaurantCategoryFragment();
                Bundle bundle = new Bundle();
                try {
                    JSONObject restaurantMenuCategory = restaurantMenu.getJSONObject(position);
                    bundle.putString("restaurantMenu", restaurantMenuCategory.toString());
                    Gson gson = new Gson();
                    String json = gson.toJson(restaurant);
                    bundle.putString("restaurant", json);
                    fragment.setArguments(bundle);
                    break;
                } catch (JSONException e) {

                }

            }
        }
        return fragment;

    }


    @Override
    public int getCount() {
        return numberOfTabs;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return restaurantCategoriesArrayList.get(position);
    }
}
