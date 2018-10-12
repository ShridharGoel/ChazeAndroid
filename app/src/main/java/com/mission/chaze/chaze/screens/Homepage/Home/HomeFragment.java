package com.mission.chaze.chaze.screens.Homepage.Home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.mission.chaze.chaze.R;
import com.mission.chaze.chaze.di.component.ActivityComponent;
import com.mission.chaze.chaze.models.HomeGrid;
import com.mission.chaze.chaze.screens.base.BaseFragment;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class HomeFragment extends BaseFragment implements HomeFragmentContract.View {

    @BindView(R.id.grid)
    GridView grid;
    @Inject
    HomeGridAdapter adapter;
    @Inject
    HomeFragmentContract.Presentor<HomeFragmentContract.View> mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        onAttach(getContext());
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this, view));
        mPresenter.onAttach(this);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Timber.d("HomeFragment");
        adapter.addItems();
        grid.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        adapter.clear();
        super.onDestroyView();
    }


}