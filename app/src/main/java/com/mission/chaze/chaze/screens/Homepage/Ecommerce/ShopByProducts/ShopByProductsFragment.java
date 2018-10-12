package com.mission.chaze.chaze.screens.Homepage.Ecommerce.ShopByProducts;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mission.chaze.chaze.R;
import com.mission.chaze.chaze.di.LinLayoutVert;
import com.mission.chaze.chaze.models.EcomerceCategory;
import com.mission.chaze.chaze.screens.base.BaseFragment;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class ShopByProductsFragment extends BaseFragment implements ShopByProductsContract.View {
    public ShopByProductsFragment() {
        Timber.e("ShopByProducts");
    }


    @BindView(R.id.ecomerceRecyclerView)
    RecyclerView recyclerView;
    @Inject
    @LinLayoutVert
    LinearLayoutManager mLayoutManager;
    @Inject
    ProductsPostAdapter adapter;

    @Inject
    ShopByProductsContract.Presentor<ShopByProductsContract.View> mPresentor;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_shop_by_products, container, false);

        onAttach(getContext());
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this, view));
        mPresentor.onAttach(this);
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter.addItems();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(mLayoutManager);
        Toast.makeText(getContext(), "products", Toast.LENGTH_SHORT).show();
    }


}
