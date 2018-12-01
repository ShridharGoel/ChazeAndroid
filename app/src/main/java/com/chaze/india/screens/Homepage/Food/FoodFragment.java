package com.chaze.india.screens.Homepage.Food;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SearchView;

import com.chaze.india.screens.Homepage.HomeActivity;
import com.chaze.india.screens.base.BaseFragment;
import com.chaze.india.screens.search.SearchActivity;
import com.chaze.india.R;
import com.chaze.india.di.Qualifiers.LinLayoutHori;
import com.chaze.india.di.Qualifiers.LinLayoutVert;
import com.chaze.india.screens.Cart.CartActivity;
import com.chaze.india.screens.Homepage.Ecommerce.EcommerceCategoryAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class FoodFragment extends BaseFragment implements FoodContract.View {


    @BindView(R.id.category_recycler_view)
    RecyclerView categoryRecyclerView;

    @BindView(R.id.food_recycler_view)
    RecyclerView recyclerView;

    @Inject
    @LinLayoutVert
    LinearLayoutManager mLayoutManager;

    @Inject
    @LinLayoutHori
    LinearLayoutManager mLayoutManagerCategory;

    @BindView(R.id.toolbar)
    RelativeLayout toolbar;

    @BindView(R.id.searchbar)
    SearchView searchView;

    @Inject
    RestaurantListAdapter paginationAdapter;

    @Inject
    EcommerceCategoryAdapter categoryAdapter;

    @Inject
    FoodContract.Presenter<FoodContract.View> mPresenter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Timber.d("Food");
        View view = inflater.inflate(R.layout.fragment_food, container, false);
        onAttach(getContext());
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this, view));

        Window window = getActivity().getWindow();
        window.setStatusBarColor(getResources().getColor(R.color.colorPumpkinDark));

        mPresenter.onAttach(this);
        setupToolBar();


        return view;
    }

    private void goToSearch() {
        Intent intent = new Intent(getActivity(), SearchActivity.class);
        intent.putExtra("SearchType", 2);
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

    void setup() {

        categoryAdapter.addItems();
        paginationAdapter.addItems();


        recyclerView.setAdapter(paginationAdapter);
        recyclerView.setLayoutManager(mLayoutManager);

        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryRecyclerView.setLayoutManager(mLayoutManagerCategory);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Timber.d("FoodFragment");


        setup();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
