package com.chaze.india.di.module;

import android.support.v7.app.AppCompatActivity;

import com.chaze.india.models.RecyclerItems;
import com.chaze.india.screens.Cart.CartBusinessAdapter;
import com.chaze.india.screens.Cart.CartItemsAdapter;
import com.chaze.india.screens.Category.ShopCategoryAdapter;
import com.chaze.india.screens.Homepage.Ecommerce.EcommerceCategoryAdapter;
import com.chaze.india.screens.Homepage.Ecommerce.EcommerceFragment;
import com.chaze.india.screens.Homepage.Ecommerce.EcommercePagerAdapter;
import com.chaze.india.screens.Homepage.Food.CuisinesAdapter;
import com.chaze.india.screens.Homepage.Food.FoodFragment;
import com.chaze.india.screens.Homepage.Food.RestaurantListAdapter;
import com.chaze.india.screens.Homepage.Home.HomeFragment;
import com.chaze.india.screens.Homepage.Home.HomeFragmentContract;
import com.chaze.india.screens.Homepage.Home.HomeFragmentPresenter;
import com.chaze.india.screens.Homepage.Home.HomeGridAdapter;
import com.chaze.india.screens.Homepage.HomeBottomNavPagerAdapter;
import com.chaze.india.screens.Homepage.LocalSearch.LocalSearchFragment;
import com.chaze.india.screens.Homepage.More.MoreFragment;
import com.chaze.india.screens.PostOrderStatus.ActiveOrders.ActiveOrdersAdapter;
import com.chaze.india.screens.PostOrderStatus.ActiveOrders.ActiveOrdersContract;
import com.chaze.india.screens.PostOrderStatus.ActiveOrders.ActiveOrdersPresenter;
import com.chaze.india.screens.PostOrderStatus.ActiveOrders.TimeLineAdapter;
import com.chaze.india.screens.PostOrderStatus.PostOrderPagerAdapter;
import com.chaze.india.screens.ProductsPostAdapter;
import com.chaze.india.screens.search.SearchSuggestionsAdapter;

import java.util.ArrayList;
import java.util.LinkedList;

import dagger.Module;
import dagger.Provides;


/**
 * Created by Shubham Vishwakarma on 29/11/18.
 */

@Module
public class AdapterModule {

    private AppCompatActivity mActivity;

    public AdapterModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }


    @Provides
    SearchSuggestionsAdapter getSearchSuggestionsAdapter() {
        return new SearchSuggestionsAdapter(mActivity, new ArrayList<>());
    }

    @Provides
    TimeLineAdapter getTimeLineAdapter() {
        return new TimeLineAdapter(new ArrayList<>(), mActivity);
    }

    @Provides
    HomeBottomNavPagerAdapter getBottomNavAdapter() {
        EcommerceFragment ecommerce = new EcommerceFragment();
        FoodFragment foodFragment = new FoodFragment();
        HomeFragment homeFragment = new HomeFragment();
        LocalSearchFragment localSearch = new LocalSearchFragment();
        MoreFragment moreFragment_object = new MoreFragment();

        HomeBottomNavPagerAdapter adapter = new HomeBottomNavPagerAdapter(mActivity.getSupportFragmentManager());
        adapter.addFragment(homeFragment);
        adapter.addFragment(ecommerce);
        adapter.addFragment(foodFragment);
        /*adapter.addFragment(localSearch);
        adapter.addFragment(moreFragment_object);*/
        return adapter;

    }


    @Provides
    HomeGridAdapter providesHomeGridAdapter() {
        return new HomeGridAdapter(mActivity, new ArrayList<>());
    }

    @Provides
    EcommerceCategoryAdapter providesEcommerceCategoryAdapter() {
        return new EcommerceCategoryAdapter(mActivity, new ArrayList<>());
    }

    @Provides
    EcommercePagerAdapter providesEcommercePagerAdapter() {
        return new EcommercePagerAdapter(mActivity.getSupportFragmentManager());
    }

    @Provides
    CuisinesAdapter providesCuisinesAdapter() {
        return new CuisinesAdapter(mActivity, new ArrayList<>());
    }

    @Provides
    PostOrderPagerAdapter providesPostOrderPagerAdapter() {
        return new PostOrderPagerAdapter(mActivity.getSupportFragmentManager());
    }

    @Provides
    ActiveOrdersAdapter providesActiveOrdersAdapter() {
        return new ActiveOrdersAdapter(mActivity, new ArrayList<>());
    }


    @Provides
    ProductsPostAdapter providesProductsPostAdapter() {
        return new ProductsPostAdapter(new ArrayList<RecyclerItems>(), mActivity);
    }

    @Provides
    RestaurantListAdapter providesRestaurantListAdapter() {
        return new RestaurantListAdapter(mActivity, new ArrayList<>());
    }

    @Provides
    CartBusinessAdapter providesCartBusinessAdapter() {
        return new CartBusinessAdapter(mActivity, new ArrayList<>());
    }

    @Provides
    CartItemsAdapter providesCartItemsAdapter() {
        return new CartItemsAdapter(new LinkedList<>());
    }


    @Provides
    ShopCategoryAdapter providesShopCategoryAdapter() {
        return new ShopCategoryAdapter();
    }


    @Provides
    HomeFragmentContract.Presenter<HomeFragmentContract.View> providesHomeFragmentPresenter(
            HomeFragmentPresenter<HomeFragmentContract.View> presenter) {
        return presenter;
    }

    @Provides
    ActiveOrdersContract.Presenter<ActiveOrdersContract.View> providesActiveOrdersFragmentPresenter(ActiveOrdersPresenter<ActiveOrdersContract.View> presenter) {
        return presenter;
    }

}
