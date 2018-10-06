package com.mission.chaze.chaze.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mission.chaze.chaze.R;

import timber.log.Timber;

public class Ecomerce extends Fragment {
    public Ecomerce() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Toast.makeText(getContext(),"Ecommerce", Toast.LENGTH_SHORT).show();



        return inflater.inflate(R.layout.fragment_ecomerce,container,false);
    }
}
