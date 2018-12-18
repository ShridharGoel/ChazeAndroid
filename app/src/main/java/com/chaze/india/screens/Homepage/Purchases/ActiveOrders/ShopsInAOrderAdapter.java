package com.chaze.india.screens.Homepage.Purchases.ActiveOrders;

import android.content.Context;
import android.content.Intent;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chaze.india.R;
import com.chaze.india.models.Ecommerce.CartBusiness;
import com.chaze.india.screens.Homepage.Purchases.ActiveOrders.OrderOfAShop.OrderOfAShopActivity;

import java.util.ArrayList;


public class ShopsInAOrderAdapter extends RecyclerView.Adapter<ShopsInAOrderAdapter.ShopsInAOrderViewHolder> {

    private static String TAG = ShopsInAOrderAdapter.class.getSimpleName();

    private ArrayList<CartBusiness> shops = new ArrayList<>();

    private Context context;

    public ShopsInAOrderAdapter(ArrayList CartBusiness) {
        this.shops = CartBusiness;
    }

    @Override
    public ShopsInAOrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();

        View view = LayoutInflater.from(context).inflate(R.layout.business_orders, parent, false);

        return new ShopsInAOrderViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ShopsInAOrderViewHolder holder, int position) {
        Log.d(TAG, "#" + position);
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return shops.size();
    }

    public class ShopsInAOrderViewHolder extends RecyclerView.ViewHolder {


        public ShopsInAOrderViewHolder(View v) {
            super(v);

            v.setOnClickListener(view -> context.startActivity(new Intent(context, OrderOfAShopActivity.class)));


        }

        void bind(int listIndex) {

        }
    }


}

