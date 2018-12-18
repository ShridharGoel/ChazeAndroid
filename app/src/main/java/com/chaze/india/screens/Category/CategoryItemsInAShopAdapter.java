package com.chaze.india.screens.Category;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.chaze.india.models.Ecommerce.ShopItem;
import com.chaze.india.screens.ProductInfo.ProductInfoActivity;
import com.chaze.india.screens.Shop.ShopActivity;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;

import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chaze.india.R;
import com.chaze.india.screens.ProductInfo.ProductInfoPopupActivity.ProductInfoPopupActivity;

import java.util.ArrayList;


public class CategoryItemsInAShopAdapter extends RecyclerView.Adapter<CategoryItemsInAShopAdapter.SearchItemsFoundInARestaurantViewHolder> {

    private static String TAG = CategoryItemsInAShopAdapter.class.getSimpleName();

    private ArrayList<ShopItem> items = new ArrayList<>();

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


        TextView nameView;
        ImageView imageView;
        TextView priceView;
        TextView discountView;


        public SearchItemsFoundInARestaurantViewHolder(View v) {
            super(v);

            nameView = v.findViewById(R.id.name_view);
            imageView = v.findViewById(R.id.image_view);
            priceView = v.findViewById(R.id.price_view);
            discountView = v.findViewById(R.id.discount_view);


            v.setOnClickListener(view -> {

                Pair<View, String> p1 = Pair.create((View) imageView, "image_view");
                Pair<View, String> p2 = Pair.create((View) nameView, "name_view");
                Pair<View, String> p3 = Pair.create((View) priceView, "price_view");

                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation((Activity) context, p1, p2, p3);


                context.startActivity(new Intent(context, ProductInfoActivity.class), options.toBundle());
            });
        }

        void bind(int listIndex) {

        }
    }


}

