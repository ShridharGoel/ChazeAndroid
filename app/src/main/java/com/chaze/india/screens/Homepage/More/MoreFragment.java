package com.chaze.india.screens.Homepage.More;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chaze.india.screens.base.BaseFragment;
import com.chaze.india.R;
import com.chaze.india.screens.base.BaseFragment;

public class MoreFragment extends BaseFragment {
    public MoreFragment() {
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_more,container,false);
    }


}
