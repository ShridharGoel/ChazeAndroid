package com.chaze.india.di.module;

import android.support.v7.app.AppCompatActivity;

import com.chaze.india.models.Ecommerce.CartItem;
import com.chaze.india.models.Ecommerce.Post;
import com.chaze.india.screens.Cart.EcommerceCart.CartBusinessAdapter;
import com.chaze.india.screens.Cart.EcommerceCart.CartItemsAdapter;
import com.chaze.india.screens.Category.ShopCategoryAdapter;
import com.chaze.india.screens.Homepage.Ecommerce.EcommerceCategoryAdapter;
import com.chaze.india.screens.Homepage.Ecommerce.EcommerceFragment;
import com.chaze.india.screens.Homepage.Ecommerce.EcommercePagerAdapter;
import com.chaze.india.screens.Homepage.Food.CuisinesAdapter;
import com.chaze.india.screens.Homepage.Food.FoodFragment;
import com.chaze.india.screens.Homepage.Food.FoodPagerAdapter;
import com.chaze.india.screens.Homepage.Food.Restaurants.RestaurantListAdapter;
import com.chaze.india.screens.Homepage.HomeBottomNavPagerAdapter;
import com.chaze.india.screens.Homepage.More.MoreFragment;
import com.chaze.india.screens.Homepage.Purchases.ActiveOrders.ActiveOrdersAdapter;
import com.chaze.india.screens.Homepage.Purchases.ActiveOrders.ActiveOrdersContract;
import com.chaze.india.screens.Homepage.Purchases.ActiveOrders.ActiveOrdersPresenter;
import com.chaze.india.screens.Homepage.Purchases.ActiveOrders.TimeLineAdapter;
import com.chaze.india.screens.Homepage.Purchases.PurchasesPagerAdapter;
import com.chaze.india.screens.ProductsPostAdapter;
import com.chaze.india.screens.Shop.ProductsListAdapter;
import com.chaze.india.screens.Shop.ShopItemListAdapter;
import com.chaze.india.screens.Shop.SubCategoryAdapter;
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
        MoreFragment moreFragment_object = new MoreFragment();


        HomeBottomNavPagerAdapter adapter = new HomeBottomNavPagerAdapter(mActivity.getSupportFragmentManager());
        adapter.addFragment(ecommerce);
        adapter.addFragment(foodFragment);
        adapter.addFragment(moreFragment_object);
        return adapter;

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
    PurchasesPagerAdapter providesPostOrderPagerAdapter() {
        return new PurchasesPagerAdapter(mActivity.getSupportFragmentManager());
    }

    @Provides
    ActiveOrdersAdapter providesActiveOrdersAdapter() {
        return new ActiveOrdersAdapter(mActivity, new ArrayList<>());
    }


    @Provides
    FoodPagerAdapter providesFoodPagerAdapter() {
        return new FoodPagerAdapter(mActivity.getSupportFragmentManager());
    }

    @Provides
    ProductsPostAdapter providesProductsPostAdapter() {
        return new ProductsPostAdapter(new ArrayList<Post>(), mActivity);
    }

    @Provides
    SubCategoryAdapter providesSubCategoryAdapter() {
        return new SubCategoryAdapter(mActivity, new ArrayList<>());
    }

    @Provides
    RestaurantListAdapter providesRestaurantListAdapter() {
        return new RestaurantListAdapter(mActivity, new ArrayList<>());
    }


    @Provides
    ShopItemListAdapter providesShopItemList() {
        return new ShopItemListAdapter(new ArrayList<>(), mActivity);
    }

    @Provides
    ShopCategoryAdapter providesShopCategoryAdapter() {
        return new ShopCategoryAdapter(new ArrayList<>(), mActivity);
    }

    @Provides
    ProductsListAdapter providesProductListList() {
        return new ProductsListAdapter(mActivity, new ArrayList<>());
    }

    @Provides
    CartBusinessAdapter providesCartBusinessAdapter() {
        return new CartBusinessAdapter(mActivity, new ArrayList<>());
    }

    @Provides
    CartItemsAdapter providesCartItemsAdapter() {
        return new CartItemsAdapter(new LinkedList<>(), null, () -> {

        });
    }


    @Provides
    ActiveOrdersContract.Presenter<ActiveOrdersContract.View> providesActiveOrdersFragmentPresenter(ActiveOrdersPresenter<ActiveOrdersContract.View> presenter) {
        return presenter;
    }

}
