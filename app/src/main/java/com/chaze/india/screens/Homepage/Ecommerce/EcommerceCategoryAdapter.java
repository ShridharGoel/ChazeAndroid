package com.chaze.india.screens.Homepage.Ecommerce;

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
import com.chaze.india.screens.Category.CategoryActivity;
import com.chaze.india.screens.SubCategory.SubCategoryActivity;

import java.util.List;

import timber.log.Timber;

public class EcommerceCategoryAdapter extends RecyclerView.Adapter<EcommerceCategoryAdapter.ViewHolder> {
    Context context;
    List<Category> categoryList;

    public EcommerceCategoryAdapter(Context context, List<Category> categoryList) {
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
        Category item = categoryList.get(i);
        viewHolder.categoryText.setText(item.getName());
        //viewHolder.imageView.setImageDrawable(item.getImage());

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public void addItems(List<Category> categories) {

        categoryList.addAll(categories);
        notifyDataSetChanged();

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

                if (categoryList.get(getPosition()).getCategories().size() > 0) {
                    Intent intent = new Intent(context, SubCategoryActivity.class);
                    intent.putExtra("Category", categoryList.get(getPosition()));
                    context.startActivity(intent);
                } else {
                    Intent intent = new Intent(context, CategoryActivity.class);
                    intent.putExtra("Category", categoryList.get(getPosition()));
                    context.startActivity(intent);
                }

            });

        }
    }
}
