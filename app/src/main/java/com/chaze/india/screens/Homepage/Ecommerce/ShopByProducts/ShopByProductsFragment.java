package com.chaze.india.screens.Homepage.Ecommerce.ShopByProducts;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.chaze.india.screens.Homepage.HomeActivity;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chaze.india.screens.ProductsPostAdapter;
import com.chaze.india.screens.base.BaseFragment;
import com.chaze.india.R;
import com.chaze.india.di.Qualifiers.LinLayoutVert;
import com.chaze.india.models.EcomerceCategory;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class ShopByProductsFragment extends BaseFragment implements ShopByProductsContract.View {


    public ShopByProductsFragment() {
        Timber.e("ShopByProducts");
    }

    private int totalItemCount, lastVisibleItem, pageNumber = 1;
    private final int VISIBLE_THRESHOLD = 1;
    boolean loading;

    @BindView(R.id.ecomerceRecyclerView)
    ShimmerRecyclerView recyclerView;
    @Inject
    @LinLayoutVert
    LinearLayoutManager mLayoutManager;

    @Inject
    ProductsPostAdapter adapter;

    @Inject
    ShopByProductsContract.Presenter<ShopByProductsContract.View> mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_shop_by_products, container, false);

        onAttach(getContext());
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this, view));

        recyclerView.showShimmerAdapter();
        mPresenter.onAttach(this);
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

      //  recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(mLayoutManager);
       // addItems(null);
        setUpLoadMoreListener();
       // mPresenter.subscribeForData();

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
        adapter.addItems(items);
    }

}
