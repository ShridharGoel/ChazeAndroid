package com.chaze.india.screens.Homepage.Food.Restaurants;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chaze.india.R;
import com.chaze.india.models.Restaurant;
import com.chaze.india.screens.SubCategory.SubCategoryActivity;

import java.util.List;

public class RestaurantListAdapter extends RecyclerView.Adapter<RestaurantListAdapter.ViewHolder> {
    Context context;
    List<Restaurant> restaurantList;

    public RestaurantListAdapter(Context context, List<Restaurant> restaurantList) {
        this.context = context;
        this.restaurantList = restaurantList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.restaurant_view, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Restaurant item = restaurantList.get(i);
        viewHolder.categoryText.setText("Restaurant_Name");



    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }

    public void addItems() {

        for (int i = 0; i < 20; i++)
            restaurantList.add(new Restaurant());

        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView categoryText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.restaurant_image_view);
            categoryText = itemView.findViewById(R.id.restaurant_name_view);

            itemView.setOnClickListener((view)->{context.startActivity(new Intent(context, SubCategoryActivity.class));});
        }
    }
}
