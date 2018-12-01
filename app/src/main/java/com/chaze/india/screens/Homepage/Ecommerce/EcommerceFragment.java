package com.chaze.india.screens.Homepage.Ecommerce;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SearchView;


import com.chaze.india.screens.Homepage.HomeActivity;
import com.chaze.india.screens.base.BaseFragment;
import com.chaze.india.screens.search.SearchActivity;
import com.chaze.india.R;
import com.chaze.india.di.Qualifiers.LinLayoutHori;
import com.chaze.india.screens.Cart.CartActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class EcommerceFragment extends BaseFragment implements EcommerceContract.View {


    @Inject
    @LinLayoutHori
    LinearLayoutManager mLayoutManager;
    @Inject
    EcommerceCategoryAdapter adapter;

    @Inject
    EcommercePagerAdapter ecommercePagerAdapter;

    @BindView(R.id.ecommerce_view_pager)
    ViewPager viewPager;
    @BindView(R.id.ecommerce_slider)
    TabLayout tabLayout;
    @BindView(R.id.ecomerceRecyclerView)
    RecyclerView recyclerView;


    @BindView(R.id.toolbar)
    RelativeLayout toolbar;

    @BindView(R.id.searchbar)
    SearchView searchView;

    @Inject
    EcommerceContract.Presenter<EcommerceContract.View> mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Timber.d("Ecommerce Fragment");

        View view = inflater.inflate(R.layout.fragment_ecomerce, container, false);

        onAttach(getContext());
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this, view));
        mPresenter.onAttach(this);
        setupToolBar();
        return view;

    }


    private void goToSearch() {
        Intent intent = new Intent(getActivity(), SearchActivity.class);
        intent.putExtra("SearchType", 1);
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(getActivity(), (View) searchView, "search");
        startActivity(intent, options.toBundle());
    }

    private void setupToolBar() {
        searchView.setOnClickListener(v -> goToSearch());
        ImageView imageView = toolbar.findViewById(R.id.toolbar_image);

        RelativeLayout cartView = toolbar.findViewById(R.id.cart_container);

        cartView.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), CartActivity.class));
        });

        imageView.setOnClickListener(v -> {
            ((HomeActivity) getActivity()).openDrawer();
        });


    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Timber.e("Ecommerce View created");
        adapter.addItems();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(mLayoutManager);
        viewPager.setAdapter(ecommercePagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }

}
