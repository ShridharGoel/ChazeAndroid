package com.chaze.india.screens.Shop;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chaze.india.R;
import com.chaze.india.models.Ecommerce.Category;
import com.chaze.india.models.Ecommerce.SubCategory;
import com.chaze.india.screens.Category.CategoryActivity;
import com.chaze.india.screens.SubCategory.SubCategoryActivity;

import java.util.List;

import timber.log.Timber;

public class SubCategoryAdapter extends RecyclerView.Adapter<SubCategoryAdapter.ViewHolder> {
    Context context;
    List<SubCategory> categoryList;

    Long shopId;

    public SubCategoryAdapter(Context context, List<SubCategory> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.category_scrollview, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        SubCategory item = categoryList.get(i);
        viewHolder.categoryText.setText(item.getName());
        //viewHolder.imageView.setImageDrawable(item.getImage());

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public void addItems(List<SubCategory> categories) {

        for (SubCategory sc : categories) {
            categoryList.add(sc);
            notifyDataSetChanged();
        }


    }

    void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView categoryText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.categoryImage);
            categoryText = itemView.findViewById(R.id.categoryName);

            imageView.setOnClickListener(v -> {

                Timber.e("Whats HAppening");

                Intent intent = new Intent(context, ShopActivity.class);
                intent.putExtra("Shop", shopId);
                intent.putExtra("Category", categoryList.get(getPosition()).getId());
                context.startActivity(intent);
            });

        }
    }
}