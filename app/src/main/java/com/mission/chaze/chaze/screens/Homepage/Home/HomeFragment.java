package com.mission.chaze.chaze.screens.Homepage.Home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.mission.chaze.chaze.R;
import com.mission.chaze.chaze.models.HomeGrid;
import com.mission.chaze.chaze.screens.base.BaseFragment;

import java.util.ArrayList;

import timber.log.Timber;

public class HomeFragment extends BaseFragment {
    GridView grid;
    ArrayList<HomeGrid> gridList=new ArrayList<HomeGrid>();
    private String[] gridText={
            "icon_text","image_text",
            "icon_text","image_text",
            "icon_text","image_text",
            "icon_text","image_text",
            "icon_text","image_text",
            "icon_text","image_text",
    };

    public Integer[] gridImages={
            R.drawable.ic_dashboard_black_24dp, R.drawable.ic_dashboard_black_24dp,
            R.drawable.ic_dashboard_black_24dp, R.drawable.ic_dashboard_black_24dp,
            R.drawable.ic_dashboard_black_24dp, R.drawable.ic_dashboard_black_24dp,
            R.drawable.ic_dashboard_black_24dp, R.drawable.ic_dashboard_black_24dp,
            R.drawable.ic_dashboard_black_24dp, R.drawable.ic_dashboard_black_24dp,
            R.drawable.ic_dashboard_black_24dp, R.drawable.ic_dashboard_black_24dp,
    };
    public HomeFragment() {
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        Timber.d("Home");
        gridList.add(new HomeGrid("nolnsv",R.drawable.ic_dashboard_black_24dp));
        gridList.add(new HomeGrid("bgknf",R.drawable.ic_dashboard_black_24dp));
        gridList.add(new HomeGrid("sbnls",R.drawable.ic_dashboard_black_24dp));
        gridList.add(new HomeGrid("bnlsz",R.drawable.ic_dashboard_black_24dp));
        gridList.add(new HomeGrid("bk,bskl",R.drawable.ic_dashboard_black_24dp));
        gridList.add(new HomeGrid("dsvnlls",R.drawable.ic_dashboard_black_24dp));
        gridList.add(new HomeGrid("dvkbk",R.drawable.ic_dashboard_black_24dp));
        gridList.add(new HomeGrid("nvls",R.drawable.ic_dashboard_black_24dp));

        return inflater.inflate(R.layout.fragment_home,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /*HomeGridAdapter adapter = new HomeGridAdapter(getContext(), gridText, gridImages);
        grid=(GridView)view.findViewById(R.id.grid);
        grid.setAdapter(adapter);*/
        grid=(GridView) view.findViewById(R.id.grid);


        HomeGridAdapter adapter=new HomeGridAdapter(getContext(),R.layout.grid_single,gridList);
        grid.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        gridList.clear();
        super.onDestroyView();
    }


}