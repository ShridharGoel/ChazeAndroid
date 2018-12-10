package com.chaze.india.screens.Shop;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.chaze.india.R;
import com.chaze.india.models.Category;

import java.util.ArrayList;

public class ShopCategoryGridAdapter extends ArrayAdapter {
    ArrayList<Category> categories;
    Context context;

    public ShopCategoryGridAdapter(@NonNull Context context, ArrayList<Category> categories) {
        super(context, R.layout.grid_single, categories);
        this.categories = categories;
        this.context = context;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        v = inflater.inflate(R.layout.grid_single, parent, false);

        TextView textView = (TextView) v.findViewById(R.id.grid_text);
        ImageView imageView = (ImageView) v.findViewById(R.id.grid_image);
        textView.setText(categories.get(position).getText());
        imageView.setImageResource(categories.get(position).getImage());
        return v;

    }

    public void addItems() {
        categories.add(new Category("nolnsv", R.drawable.ic_dashboard_black_24dp));
        categories.add(new Category("bgknf", R.drawable.ic_dashboard_black_24dp));
        categories.add(new Category("sbnls", R.drawable.ic_dashboard_black_24dp));
        categories.add(new Category("bnlsz", R.drawable.ic_dashboard_black_24dp));
        categories.add(new Category("bk,bskl", R.drawable.ic_dashboard_black_24dp));
        categories.add(new Category("dsvnlls", R.drawable.ic_dashboard_black_24dp));
        categories.add(new Category("dvkbk", R.drawable.ic_dashboard_black_24dp));
        categories.add(new Category("nvls", R.drawable.ic_dashboard_black_24dp));
        categories.add(new Category("bk,bskl", R.drawable.ic_dashboard_black_24dp));
        categories.add(new Category("dsvnlls", R.drawable.ic_dashboard_black_24dp));
        categories.add(new Category("dvkbk", R.drawable.ic_dashboard_black_24dp));
        categories.add(new Category("nvls", R.drawable.ic_dashboard_black_24dp));
        notifyDataSetChanged();
    }
}