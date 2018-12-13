package com.chaze.india.screens.Category;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.cooltechworks.views.shimmer.ShimmerRecyclerView;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chaze.india.R;
import com.chaze.india.models.Item;
import com.chaze.india.screens.ProductInfo.ProductInfoPopupActivity.ProductInfoPopupActivity;

import java.util.ArrayList;


public class CategoryItemsInAShopAdapter extends RecyclerView.Adapter<CategoryItemsInAShopAdapter.SearchItemsFoundInARestaurantViewHolder> {

    private static String TAG = CategoryItemsInAShopAdapter.class.getSimpleName();

    private ArrayList<Item> items = new ArrayList<>();

    private Context context;

    public CategoryItemsInAShopAdapter(ArrayList items) {
        this.items = items;
    }

    @Override
    public SearchItemsFoundInARestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();

        View view = LayoutInflater.from(context).inflate(R.layout.category_item_in_a_shop_recycler_item, parent, false);

        return new SearchItemsFoundInARestaurantViewHolder(view);

    }

    @Override
    public void onBindViewHolder(SearchItemsFoundInARestaurantViewHolder holder, int position) {
        Log.d(TAG, "#" + position);
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class SearchItemsFoundInARestaurantViewHolder extends RecyclerView.ViewHolder {


        public SearchItemsFoundInARestaurantViewHolder(View v) {
            super(v);

            v.setOnClickListener(view -> {
                context.startActivity(new Intent(context, ProductInfoPopupActivity.class));

                Activity activity = (Activity) context;
                activity.overridePendingTransition(R.anim.popup_in, R.anim.popup_out);
            });
        }

        void bind(int listIndex) {

        }
    }


}

