package com.mission.chaze.chaze.screens.Homepage.Home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.mission.chaze.chaze.models.HomeGrid;
import com.mission.chaze.chaze.R;

import java.util.ArrayList;
import java.util.List;

public class HomeGridAdapter extends ArrayAdapter {
    ArrayList<HomeGrid> imageList;
    Context context;

    public HomeGridAdapter(@NonNull Context context, ArrayList<HomeGrid> imageList) {
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
        imageList.add(new HomeGrid("nolnsv", R.drawable.ic_dashboard_black_24dp));
        imageList.add(new HomeGrid("bgknf", R.drawable.ic_dashboard_black_24dp));
        imageList.add(new HomeGrid("sbnls", R.drawable.ic_dashboard_black_24dp));
        imageList.add(new HomeGrid("bnlsz", R.drawable.ic_dashboard_black_24dp));
        imageList.add(new HomeGrid("bk,bskl", R.drawable.ic_dashboard_black_24dp));
        imageList.add(new HomeGrid("dsvnlls", R.drawable.ic_dashboard_black_24dp));
        imageList.add(new HomeGrid("dvkbk", R.drawable.ic_dashboard_black_24dp));
        imageList.add(new HomeGrid("nvls", R.drawable.ic_dashboard_black_24dp));
        imageList.add(new HomeGrid("bk,bskl", R.drawable.ic_dashboard_black_24dp));
        imageList.add(new HomeGrid("dsvnlls", R.drawable.ic_dashboard_black_24dp));
        imageList.add(new HomeGrid("dvkbk", R.drawable.ic_dashboard_black_24dp));
        imageList.add(new HomeGrid("nvls", R.drawable.ic_dashboard_black_24dp));
        notifyDataSetChanged();
    }
}