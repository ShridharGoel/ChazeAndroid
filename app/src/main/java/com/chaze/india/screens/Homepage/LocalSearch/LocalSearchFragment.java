package com.chaze.india.screens.Homepage.LocalSearch;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chaze.india.screens.base.BaseFragment;
import com.chaze.india.R;
import com.chaze.india.screens.base.BaseFragment;

import timber.log.Timber;

public class LocalSearchFragment extends BaseFragment {
    public LocalSearchFragment() {

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Timber.d("Loacal search");
        return inflater.inflate(R.layout.fragment_local_search,container,false);
    }


}
