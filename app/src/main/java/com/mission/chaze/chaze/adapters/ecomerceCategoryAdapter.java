package com.mission.chaze.chaze.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mission.chaze.chaze.R;
import com.mission.chaze.chaze.models.ecomerceCategory;

import java.util.List;

public class ecomerceCategoryAdapter extends RecyclerView.Adapter<ecomerceCategoryAdapter.ViewHolder>{
    Context context;
    List<ecomerceCategory> categoryList;

    public ecomerceCategoryAdapter(Context context, List<ecomerceCategory> categoryList) {
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
        ecomerceCategory item=categoryList.get(i);
        viewHolder.categoryText.setText(item.getCategory());
        //viewHolder.imageView.setImageDrawable(item.getImage());

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView categoryText;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.categoryImage);
            categoryText=itemView.findViewById(R.id.categoryName);
        }
    }
}
