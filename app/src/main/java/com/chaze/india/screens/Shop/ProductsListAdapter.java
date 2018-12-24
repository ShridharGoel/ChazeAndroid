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
                .inflate(R.layout.product_view_grid, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        (viewHolder).nameView.setText("" + products.get(i).getName());

        (viewHolder).priceView.setText("Rs. " + products.get(i).getPrice().intValue());
        Picasso.get().load(products.get(i).getImageFirst())
                .error(R.drawable.ic_menu_manage)
                .into((viewHolder).imageView);

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


        TextView nameView;
        ImageView imageView;
        TextView priceView;

        public ViewHolder(@NonNull View v) {
            super(v);
            nameView = v.findViewById(R.id.name_view);
            imageView = v.findViewById(R.id.image_view);
            priceView = v.findViewById(R.id.price_view);

            v.setOnClickListener(view -> {

                Intent intent = new Intent(context, ProductInfoActivity.class);
                intent.putExtra("Product", products.get(getPosition()));

                Pair<View, String> p1 = Pair.create((View) imageView, "image_view");
                Pair<View, String> p2 = Pair.create((View) nameView, "name_view");
                Pair<View, String> p3 = Pair.create((View) priceView, "price_view");
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation((Activity) context, p1, p2, p3);

                context.startActivity(intent, options.toBundle());
            });
        }
    }
}
