package com.chaze.india.screens.Homepage.Food.Restaurants;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.chaze.india.screens.Homepage.HomeActivity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chaze.india.R;
import com.chaze.india.di.Qualifiers.LinLayoutVert;
import com.chaze.india.models.Ecommerce.EcomerceCategory;
import com.chaze.india.screens.base.BaseFragment;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestaurantsFragment extends BaseFragment implements RestaurantsContract.View {


    private int totalItemCount, lastVisibleItem, pageNumber = 1;
    private final int VISIBLE_THRESHOLD = 1;
    boolean loading;


    @BindView(R.id.restaurants_recycler_view)
    RecyclerView recyclerView;

    @Inject
    @LinLayoutVert
    LinearLayoutManager mLayoutManager;

    @Inject
    RestaurantListAdapter adapter;


    @Inject
    RestaurantsContract.Presenter<RestaurantsContract.View> mPresenter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurants, container, false);

        onAttach(getContext());
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this, view));
        mPresenter.onAttach(this);
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(mLayoutManager);
        adapter.addItems();
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


                if (dy > 0 ) {
                    ((HomeActivity)getActivity()).hideBottomBar();
                } else if (dy < 0 ) {
                    ((HomeActivity)getActivity()).showBottomBar();

                }

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
    public void onDestroyView() {
        super.onDestroyView();
    }


    @Override
    public void hideLoading() {
        //super.hideLoading();
        loading = false;
    }

    @Override
    public void showLoading() {
       // super.showLoading();
        loading = true;
    }

    @Override
    public void addItems(List<EcomerceCategory> items) {

    }

}
