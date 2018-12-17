package com.chaze.india.screens.Homepage.Ecommerce.ShopByShops;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.chaze.india.models.Ecommerce.ShopListResponse;
import com.chaze.india.screens.Homepage.HomeActivity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chaze.india.models.Ecommerce.Shop;
import com.chaze.india.screens.base.BaseFragment;
import com.chaze.india.R;
import com.chaze.india.di.Qualifiers.LinLayoutVert;
import com.chaze.india.models.Ecommerce.EcomerceCategory;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class ShopByShopsFragment extends BaseFragment implements ShopByShopsContract.View {


    private int totalItemCount, lastVisibleItem, pageNumber = 1;
    private final int VISIBLE_THRESHOLD = 1;
    boolean loading;
    private List<EcomerceCategory> shopList = new ArrayList<>();

    @BindView(R.id.shops_recycler_view)
    RecyclerView recyclerView;

    @Inject
    @LinLayoutVert
    LinearLayoutManager mLayoutManager;

    @Inject
    ShopsAdapter adapter;

    @Inject
    ShopByShopsContract.Presenter<ShopByShopsContract.View> mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        Timber.d("ShopByProductsFragment");

        View view = inflater.inflate(R.layout.fragment_shop_by_shops, container, false);

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
        setUpLoadMoreListener();
        mPresenter.onAttach(this);
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


                if (dy > 0) {
                    ((HomeActivity) getActivity()).hideSheet();
                } else if (dy < 0) {
                    ((HomeActivity) getActivity()).showSheet();

                }
                totalItemCount = mLayoutManager.getItemCount();
                lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
                if (!loading
                        && totalItemCount <= (lastVisibleItem + VISIBLE_THRESHOLD)) {
                    mPresenter.next();
                    showLoading();
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
    public void showShops(ShopListResponse lst) {

        for (Shop e : lst.getShops()) {
            Timber.e(e.getName());
        }
        hideLoading();
        adapter.addItems(lst.getShops());
    }

    @Override
    public void showError() {
        loading = false;
    }
}
