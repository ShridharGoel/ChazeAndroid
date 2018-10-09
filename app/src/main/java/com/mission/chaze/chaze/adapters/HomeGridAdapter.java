package com.mission.chaze.chaze.adapters;

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

public class HomeGridAdapter extends ArrayAdapter{
    ArrayList<HomeGrid> imageList;

    public HomeGridAdapter(@NonNull Context context, int resource, ArrayList<HomeGrid> imageList) {
        super(context, resource, imageList);
        this.imageList = imageList;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.grid_single, null);
        TextView textView = (TextView) v.findViewById(R.id.grid_text);
        ImageView imageView = (ImageView) v.findViewById(R.id.grid_image);
        textView.setText(imageList.get(position).getText());
        imageView.setImageResource(imageList.get(position).getImage());
        return v;

    }
}