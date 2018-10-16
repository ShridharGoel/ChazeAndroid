package com.mission.chaze.chaze.screens.Category;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mission.chaze.chaze.R;
import com.mission.chaze.chaze.models.Item;

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


        public SearchItemsFoundInARestaurantViewHolder(View searchItemsFoundInARestaurantView) {
            super(searchItemsFoundInARestaurantView);
        }

        void bind(int listIndex) {

        }
    }


}

