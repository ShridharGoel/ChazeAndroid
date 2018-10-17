package com.mission.chaze.chaze.screens.Homepage.Home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SearchView;

import com.mission.chaze.chaze.R;
import com.mission.chaze.chaze.di.LinLayoutVert;
import com.mission.chaze.chaze.di.component.ActivityComponent;
import com.mission.chaze.chaze.models.EcomerceCategory;
import com.mission.chaze.chaze.models.EcomerceShop;
import com.mission.chaze.chaze.models.HomeGrid;
import com.mission.chaze.chaze.models.PostItems;
import com.mission.chaze.chaze.models.RecyclerItems;
import com.mission.chaze.chaze.screens.Cart.CartActivity;
import com.mission.chaze.chaze.screens.Homepage.Ecommerce.EcommerceCategoryAdapter;
import com.mission.chaze.chaze.screens.Homepage.Ecommerce.ShopByShops.ShopsAdapter;
import com.mission.chaze.chaze.screens.Homepage.HomeActivity;
import com.mission.chaze.chaze.screens.base.BaseFragment;
import com.mission.chaze.chaze.screens.search.SearchActivity;

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
    /*@BindView(R.id.homeImageRecycler)
    RecyclerView cardsRecycler;*/

    @Inject
    @LinLayoutVert
    LinearLayoutManager mLayoutManager;

    @Inject
    ShopsAdapter paginationAdapter;

    @Inject
    HomeGridAdapter adapter;

    HomeCardAdapter cardAdapter;
    LinearLayoutManager linearLayoutManager;

    @Inject
    HomeFragmentContract.Presentor<HomeFragmentContract.View> mPresenter;

    ArrayList<RecyclerItems> cardItems;

    @BindView(R.id.toolbar)
    RelativeLayout toolbar;

    @BindView(R.id.searchbar)
    SearchView searchView;

    @BindView(R.id.nestedScroll)
    NestedScrollView nestedScrollView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        onAttach(getContext());
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this, view));
        mPresenter.onAttach(this);
        setupToolBar();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Timber.d("HomeFragment");
        adapter.addItems();
        //loadCards();
        grid.setAdapter(adapter);
        cardItems=new ArrayList<>();
        cardAdapter=new HomeCardAdapter(loadCards(),getContext());
        //cardsRecycler.setAdapter(cardAdapter);
        linearLayoutManager=new LinearLayoutManager(getActivity().getApplication(),LinearLayoutManager.VERTICAL,false);
        //cardsRecycler.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(cardAdapter);
        recyclerView.setLayoutManager(mLayoutManager);
        //setUpLoadMoreListener();

        mPresenter.subscribeForData();
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


    /**
     * setting listener to get callback for load more
     */
    private void setUpLoadMoreListener() {


        nestedScrollView.setOnScrollChangeListener((NestedScrollView.OnScrollChangeListener) (v, scrollX, scrollY, oldScrollX, oldScrollY) -> {
            if (v.getChildAt(v.getChildCount() - 1) != null) {
                if ((scrollY >= (v.getChildAt(v.getChildCount() - 1).getMeasuredHeight() - v.getMeasuredHeight())) &&
                        scrollY > oldScrollY) {

                    totalItemCount = mLayoutManager.getItemCount();
                    lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
                    if (!loading
                            && totalItemCount <= (lastVisibleItem + VISIBLE_THRESHOLD)) {
                        mPresenter.next();
                    }
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
    public ArrayList<RecyclerItems> loadCards() {
        ArrayList<PostItems> postItems= new ArrayList<>();
        /*postItems.add(new PostItems("https://www.flaticon.com/free-icon/trophy_1152912","1",0));
        postItems.add(new PostItems("https://www.flaticon.com/free-icon/trophy_1152912","2",1));
        postItems.add(new PostItems("https://www.flaticon.com/free-icon/trophy_1152912","3",2));
        postItems.add(new PostItems("https://www.flaticon.com/free-icon/trophy_1152912","4",3));
        cardItems.add(new RecyclerItems(2,"cat",postItems));
        postItems.add(new PostItems("https://www.flaticon.com/free-icon/trophy_1152912","1",0));
        postItems.add(new PostItems("https://www.flaticon.com/free-icon/trophy_1152912","2",1));
        postItems.add(new PostItems("https://www.flaticon.com/free-icon/trophy_1152912","3",2));
        cardItems.add(new RecyclerItems(1,"cat",postItems));*/
        postItems.add(new PostItems("https://www.flaticon.com/free-icon/trophy_1152912","1",0));
        postItems.add(new PostItems("https://www.flaticon.com/free-icon/trophy_1152912","2",1));
        postItems.add(new PostItems("https://www.flaticon.com/free-icon/trophy_1152912","3",2));
        cardItems.add(new RecyclerItems(3,"cat",postItems));
        /*postItems.add(new PostItems("https://www.flaticon.com/free-icon/trophy_1152912","1",0));
        cardItems.add(new RecyclerItems(4,"cat",postItems));*/
        return cardItems;

    }

    @Override
    public void onDestroyView() {
        adapter.clear();
        super.onDestroyView();
    }


}