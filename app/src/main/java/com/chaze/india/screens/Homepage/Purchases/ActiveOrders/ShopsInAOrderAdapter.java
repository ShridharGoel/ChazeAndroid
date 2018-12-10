package com.chaze.india.screens.Homepage.Purchases.ActiveOrders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chaze.india.R;
import com.chaze.india.models.CartBusiness;
import com.chaze.india.models.Item;

import java.util.ArrayList;


public class ShopsInAOrderAdapter extends RecyclerView.Adapter<ShopsInAOrderAdapter.SearchItemsFoundInARestaurantViewHolder> {

    private static String TAG = ShopsInAOrderAdapter.class.getSimpleName();

    private ArrayList<CartBusiness> shops = new ArrayList<>();

    private Context context;

    public ShopsInAOrderAdapter(ArrayList CartBusiness) {
        this.shops = CartBusiness;
    }

    @Override
    public SearchItemsFoundInARestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();

        View view = LayoutInflater.from(context).inflate(R.layout.business_orders, parent, false);

        return new SearchItemsFoundInARestaurantViewHolder(view);

    }

    @Override
    public void onBindViewHolder(SearchItemsFoundInARestaurantViewHolder holder, int position) {
        Log.d(TAG, "#" + position);
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return shops.size();
    }

    public class SearchItemsFoundInARestaurantViewHolder extends RecyclerView.ViewHolder {


        public SearchItemsFoundInARestaurantViewHolder(View searchItemsFoundInARestaurantView) {
            super(searchItemsFoundInARestaurantView);
        }

        void bind(int listIndex) {

        }
    }


}

