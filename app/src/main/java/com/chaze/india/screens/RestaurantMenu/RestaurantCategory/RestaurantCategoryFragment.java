package com.chaze.india.screens.RestaurantMenu.RestaurantCategory;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chaze.india.R;
import com.chaze.india.models.Food.Restaurant;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RestaurantCategoryFragment extends Fragment {

    private JSONObject categoryObject;
    private JSONArray itemArray;
    private Restaurant restaurant;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.restaurant_menu_fragment, container, false);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            String objectString = bundle.getString("restaurantMenu");
            String restaurantString = bundle.getString("restaurant");

        }



       /* restaurantItems.add(restaurantItem);

        RestaurantItemListAdapter adapter = new RestaurantItemListAdapter(restaurantItems, getContext());
        ShimmerRecyclerView rv;
        rv = (ShimmerRecyclerView) rootView.findViewById(R.id.restaurant_menu_recycler);
        rv.showShimmerAdapter();
        //RecyclerView rv = (RecyclerView)rootView.findViewById(R.id.restaurant_menu_recycler) ;
        //GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false);
        LinearLayoutManager la = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(la);
        rv.setHasFixedSize(true);


        rv.setAdapter(adapter);*/

        return rootView;
    }

}
