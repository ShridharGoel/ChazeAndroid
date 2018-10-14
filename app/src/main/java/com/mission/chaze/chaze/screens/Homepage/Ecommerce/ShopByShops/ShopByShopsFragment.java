package com.mission.chaze.chaze.screens.Homepage.Ecommerce.ShopByShops;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mission.chaze.chaze.R;
import com.mission.chaze.chaze.di.LinLayoutVert;
import com.mission.chaze.chaze.models.EcomerceCategory;
import com.mission.chaze.chaze.retrofit.APIService;
import com.mission.chaze.chaze.retrofit.ApiUtils;
import com.mission.chaze.chaze.screens.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class ShopByShopsFragment extends BaseFragment implements ShopByShopsContract.View {


    private int totalItemCount, lastVisibleItem, pageNumber = 1;
    private final int VISIBLE_THRESHOLD = 1;
    boolean loading;
    private List<EcomerceCategory> shopList=new ArrayList<>();

    @BindView(R.id.shops_recycler_view)
    RecyclerView recyclerView;

    @Inject
    @LinLayoutVert
    LinearLayoutManager mLayoutManager;

    @Inject
    ShopsAdapter adapter;

    @Inject
    ShopByShopsContract.Presentor<ShopByShopsContract.View> mPresenter;

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
        mPresenter.subscribeForData();

        APIService apiService = ApiUtils.getAPIService();
        Call<List<EcomerceCategory>> call=apiService.getShopsList();
        call.enqueue(new Callback<List<EcomerceCategory>>() {
            @Override
            public void onResponse(Call<List<EcomerceCategory>> call, Response<List<EcomerceCategory>> response) {
                if (response.isSuccessful()){
                    Log.v("mockapi",response.body().get(0).getName());
                    shopList.addAll(response.body());
                    adapter=new ShopsAdapter(getActivity().getApplicationContext(),shopList);

                    adapter.notifyDataSetChanged();
                    recyclerView.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<List<EcomerceCategory>> call, Throwable t) {

            }
        });

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
        adapter.addItems(items);
    }
}
