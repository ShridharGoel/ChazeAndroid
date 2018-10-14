package com.mission.chaze.chaze.screens.Homepage.Home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.mission.chaze.chaze.R;
import com.mission.chaze.chaze.di.LinLayoutVert;
import com.mission.chaze.chaze.di.component.ActivityComponent;
import com.mission.chaze.chaze.models.EcomerceCategory;
import com.mission.chaze.chaze.models.EcomerceShop;
import com.mission.chaze.chaze.models.HomeGrid;
import com.mission.chaze.chaze.screens.Homepage.Ecommerce.EcommerceCategoryAdapter;
import com.mission.chaze.chaze.screens.Homepage.Ecommerce.ShopByShops.ShopsAdapter;
import com.mission.chaze.chaze.screens.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class HomeFragment extends BaseFragment implements HomeFragmentContract.View {


    private int totalItemCount, lastVisibleItem, pageNumber = 1;
    private final int VISIBLE_THRESHOLD = 1;
    boolean loading;


    @BindView(R.id.grid)
    GridView grid;

    @BindView(R.id.home_recycler_view)
    RecyclerView recyclerView;

    @Inject
    @LinLayoutVert
    LinearLayoutManager mLayoutManager;

    @Inject
    ShopsAdapter paginationAdapter;

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


        recyclerView.setAdapter(paginationAdapter);
        recyclerView.setLayoutManager(mLayoutManager);
        setUpLoadMoreListener();
        mPresenter.subscribeForData();
    }



    /**
     * setting listener to get callback for load more
     */
    private void setUpLoadMoreListener() {


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView,
                                   int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                totalItemCount = mLayoutManager.getItemCount();
                lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
                if (!loading
                        && totalItemCount <= (lastVisibleItem + VISIBLE_THRESHOLD)) {
                    mPresenter.next();
                    loading = true;
                }
            }
        });
    }

    @Override
    public void hideLoading() {
        super.hideLoading();
        loading = false;
    }

    @Override
    public void showLoading() {
        super.showLoading();
        loading = true;
    }

    @Override
    public void addItems(List<EcomerceCategory> items) {
        paginationAdapter.addItems(items);
    }

    @Override
    public void onDestroyView() {
        adapter.clear();
        super.onDestroyView();
    }



}