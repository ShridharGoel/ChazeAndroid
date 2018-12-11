package com.chaze.india.screens.Homepage.Ecommerce.ShopByShops;

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
import com.chaze.india.models.EcomerceCategory;
import com.chaze.india.models.EcomerceShop;
import com.chaze.india.models.Shop;
import com.chaze.india.screens.Shop.ShopActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ShopsAdapter extends RecyclerView.Adapter<ShopsAdapter.ViewHolder> {
    Context context;
    List<Shop> shops;

    public ShopsAdapter(Context context, List<Shop> shops) {
        this.context = context;
        this.shops = shops;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.shop_view, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Shop item = shops.get(i);
        // viewHolder.categoryText.setText(item.getName());
        /*Picasso.get()
                .load(item.getImageResourceId())
                .placeholder(R.drawable.ic_menu_camera)
                .error(R.drawable.ic_menu_gallery)
                .into(viewHolder.imageView);*/
        //viewHolder.imageView.setImageResource(R.drawable.cart_badge);
        //viewHolder.imageView.setImageDrawable(item.getImage());

    }

    @Override
    public int getItemCount() {
        return shops.size();
    }

    public void addItems(List<Shop> lst) {

        for (int i = 0; i < 20; i++) shops.add(new Shop());

        //shops.addAll(lst);


        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView categoryText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.categoryImage);
            categoryText = itemView.findViewById(R.id.categoryName);

            itemView.setOnClickListener(v -> context.startActivity(new Intent(context, ShopActivity.class)));
        }
    }
}
