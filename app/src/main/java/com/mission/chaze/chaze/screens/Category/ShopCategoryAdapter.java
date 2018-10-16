package com.mission.chaze.chaze.screens.Category;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mission.chaze.chaze.R;
import com.mission.chaze.chaze.models.Business;
import com.mission.chaze.chaze.models.CartBusiness;
import com.mission.chaze.chaze.models.CategorySearchResults;
import com.mission.chaze.chaze.models.Item;
import com.mission.chaze.chaze.models.ShopResults;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.subjects.PublishSubject;

public class ShopCategoryAdapter extends RecyclerView.Adapter<ShopCategoryAdapter.ViewHolder> {


    Context context;
    CategorySearchResults categorySearchResults;

    RecyclerView shopItemsView;
    TextView shopNameView;


    public ShopCategoryAdapter() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        context = viewGroup.getContext();

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.category_shop_result_item, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(i);

    }

    @Override
    public int getItemCount() {
        return categorySearchResults.getShopResults().size();
    }

    public void addItems() {
        categorySearchResults = new CategorySearchResults();
        for (int i = 0; i < 4; i++) {

            ArrayList<Item> items = new ArrayList<>();

            for (int j = 0; j < 25; j++) {
                items.add(new Item("asdf" + j + i, "asdfsad", false, 43, false, "4", 3, 3, 0, false) {
                    @Override
                    public Business getBusiness() {
                        return null;
                    }
                });
            }

            categorySearchResults.getShopResults().add(new ShopResults("shopName", "asdfsdf", items));
        }
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            shopNameView = itemView.findViewById(R.id.shop_name);
            shopItemsView = itemView.findViewById(R.id.recycler_view_shop_items);

        }

        public void bind(int i) {
            ArrayList<Item> items = categorySearchResults.getShopResults().get(i).getItems();
            shopNameView.setText(categorySearchResults.getShopResults().get(i).getName());

            CategoryItemsInAShopAdapter categoryItemsInAShopAdapter = new CategoryItemsInAShopAdapter(categorySearchResults.getShopResults().get(i).getItems());
            final LinearLayoutManager foundItemsInARestaurantLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
            shopItemsView.setAdapter(categoryItemsInAShopAdapter);
            shopItemsView.setLayoutManager(foundItemsInARestaurantLayoutManager);
            shopItemsView.setHasFixedSize(true);

        }
    }
}
