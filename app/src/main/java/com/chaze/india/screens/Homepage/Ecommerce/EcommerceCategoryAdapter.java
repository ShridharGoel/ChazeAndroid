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
import com.chaze.india.models.Ecommerce.EcomerceCategory;
import com.chaze.india.screens.Category.CategoryActivity;

import java.util.List;

import timber.log.Timber;

public class EcommerceCategoryAdapter extends RecyclerView.Adapter<EcommerceCategoryAdapter.ViewHolder> {
    Context context;
    List<EcomerceCategory> categoryList;

    public EcommerceCategoryAdapter(Context context, List<EcomerceCategory> categoryList) {
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
        EcomerceCategory item = categoryList.get(i);
        viewHolder.categoryText.setText(item.getName());
        //viewHolder.imageView.setImageDrawable(item.getImage());

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public void addItems() {

        for (int i = 0; i < 20; i++)
            categoryList.add(new EcomerceCategory("peofgdfgple", "bdbdbdb", "https://drive.google.com/file/d/15b68H448F4jszurUpAAQV6lFPHdY1dv2/view?usp=sharing"));
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

                context.startActivity(new Intent(context, CategoryActivity.class));

            });

        }
    }
}
