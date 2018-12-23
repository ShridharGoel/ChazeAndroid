package com.chaze.india.screens.Shop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.chaze.india.R;
import com.chaze.india.models.Ecommerce.Product;
import com.chaze.india.models.Ecommerce.Shop;
import com.chaze.india.screens.ProductInfo.ProductInfoActivity;
import com.chaze.india.screens.ProductsPostAdapter;
import com.iarcuschin.simpleratingbar.SimpleRatingBar;
import com.squareup.picasso.Picasso;

import java.util.List;

import io.supercharge.shimmerlayout.ShimmerLayout;

public class ProductsListAdapter extends RecyclerView.Adapter<ProductsListAdapter.ViewHolder> {
    Context context;
    List<Product> products;

    public ProductsListAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.product_view_linear, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        (viewHolder).topic.setText("" + products.get(i).getName());
        (viewHolder).name.setText(products.get(i).getName());

        (viewHolder).price.setText("Rs. " + products.get(i).getPrice().intValue());
        Picasso.get().load(products.get(i).getImageFirst())
                .error(R.drawable.ic_menu_manage)
                .into((viewHolder).image1);

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public void addItems(List<Product> lst) {
        products.addAll(lst);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image1;
        TextView name, topic, price;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image1 = itemView.findViewById(R.id.card4_image);
            name = itemView.findViewById(R.id.name);

            price = itemView.findViewById(R.id.price);
            topic = itemView.findViewById(R.id.topic_name);

            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(context, ProductInfoActivity.class);
                intent.putExtra("Product", products.get(getPosition()));
                context.startActivity(intent);
            });
        }
    }
}
