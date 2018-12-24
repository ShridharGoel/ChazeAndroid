package com.chaze.india.screens.Category;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.chaze.india.R;
import com.chaze.india.models.CategorySearchResults;
import com.chaze.india.models.Ecommerce.ShopForCategory;
import com.chaze.india.screens.Shop.ShopActivity;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShopCategoryAdapter extends RecyclerView.Adapter<ShopCategoryAdapter.ViewHolder> {


    Context context;
    List<ShopForCategory> shopsForCategory;

    Long categoryId;

    public ShopCategoryAdapter(List<ShopForCategory> shopForCategories, Context mActivity) {
        this.shopsForCategory = shopForCategories;
        this.context = mActivity;
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
        viewHolder.shopNameView.setText(shopsForCategory.get(i).getName());


    }

    @Override
    public int getItemCount() {
        return shopsForCategory.size();
    }

    public void addItems(List<ShopForCategory> shopForCategories) {


        for (int i = 0; i < 20; i++) {
            this.shopsForCategory.add(shopForCategories.get(0));
        }
        notifyDataSetChanged();
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.recycler_view_shop_items)
        ShimmerRecyclerView shopItemsView;

        @BindView(R.id.shop_name)
        TextView shopNameView;

        @BindView(R.id.view_all)
        Button viewAll;

        CategoryItemsInAShopAdapter categoryItemsInAShopAdapter;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            categoryItemsInAShopAdapter = new CategoryItemsInAShopAdapter(new ArrayList());
            shopItemsView.setAdapter(categoryItemsInAShopAdapter);
            shopItemsView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            viewAll.setOnClickListener(v -> {
                Intent intent = new Intent(context, ShopActivity.class);
                intent.putExtra("Shop", shopsForCategory.get(getPosition()).getSellerId());
                intent.putExtra("Category", categoryId);
                context.startActivity(intent);
            });
        }
    }
}
