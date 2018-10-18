package com.mission.chaze.chaze.screens.SubCategory;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mission.chaze.chaze.R;
import com.mission.chaze.chaze.models.Category;

import java.util.ArrayList;

public class CategoryGridAdapter extends ArrayAdapter {
    ArrayList<Category> imageList;
    Context context;

    public CategoryGridAdapter(@NonNull Context context, ArrayList<Category> imageList) {
        super(context, R.layout.grid_single, imageList);
        this.imageList = imageList;
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
        textView.setText(imageList.get(position).getText());
        imageView.setImageResource(imageList.get(position).getImage());
        return v;

    }

    public void addItems() {
        imageList.add(new Category("nolnsv", R.drawable.ic_dashboard_black_24dp));
        imageList.add(new Category("bgknf", R.drawable.ic_dashboard_black_24dp));
        imageList.add(new Category("sbnls", R.drawable.ic_dashboard_black_24dp));
        imageList.add(new Category("bnlsz", R.drawable.ic_dashboard_black_24dp));
        imageList.add(new Category("bk,bskl", R.drawable.ic_dashboard_black_24dp));
        imageList.add(new Category("dsvnlls", R.drawable.ic_dashboard_black_24dp));
        imageList.add(new Category("dvkbk", R.drawable.ic_dashboard_black_24dp));
        imageList.add(new Category("nvls", R.drawable.ic_dashboard_black_24dp));
        imageList.add(new Category("bk,bskl", R.drawable.ic_dashboard_black_24dp));
        imageList.add(new Category("dsvnlls", R.drawable.ic_dashboard_black_24dp));
        imageList.add(new Category("dvkbk", R.drawable.ic_dashboard_black_24dp));
        imageList.add(new Category("nvls", R.drawable.ic_dashboard_black_24dp));
        notifyDataSetChanged();
    }
}