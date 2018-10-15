package com.mission.chaze.chaze.screens.Homepage.Food;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SearchView;

import com.mission.chaze.chaze.R;
import com.mission.chaze.chaze.di.LinLayoutHori;
import com.mission.chaze.chaze.di.LinLayoutVert;
import com.mission.chaze.chaze.models.Restaurant;
import com.mission.chaze.chaze.screens.Cart.CartActivity;
import com.mission.chaze.chaze.screens.Homepage.Ecommerce.EcommerceCategoryAdapter;
import com.mission.chaze.chaze.screens.Homepage.Ecommerce.ShopByShops.ShopsAdapter;
import com.mission.chaze.chaze.screens.Homepage.Home.HomeFragmentContract;
import com.mission.chaze.chaze.screens.Homepage.Home.HomeGridAdapter;
import com.mission.chaze.chaze.screens.Homepage.HomeActivity;
import com.mission.chaze.chaze.screens.base.BaseFragment;
import com.mission.chaze.chaze.screens.search.SearchActivity;

import java.util.List;

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


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Timber.d("FoodFragment");

        categoryAdapter.addItems();
        paginationAdapter.addItems();


        recyclerView.setAdapter(paginationAdapter);
        recyclerView.setLayoutManager(mLayoutManager);

        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryRecyclerView.setLayoutManager(mLayoutManagerCategory);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
