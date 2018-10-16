

package com.mission.chaze.chaze.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.mission.chaze.chaze.di.ActivityContext;
import com.mission.chaze.chaze.di.LinLayoutHori;
import com.mission.chaze.chaze.di.LinLayoutVert;
import com.mission.chaze.chaze.screens.Authentication.LoginContract;
import com.mission.chaze.chaze.screens.Authentication.LoginPresenter;

import com.mission.chaze.chaze.screens.Cart.CartBusinessAdapter;
import com.mission.chaze.chaze.screens.Cart.CartContract;
import com.mission.chaze.chaze.screens.Cart.CartItemsAdapter;
import com.mission.chaze.chaze.screens.Cart.CartPresenter;

import com.mission.chaze.chaze.screens.Authentication.SignUpContract;
import com.mission.chaze.chaze.screens.Authentication.SignUpPresenter;

import com.mission.chaze.chaze.screens.Category.CategoryContract;
import com.mission.chaze.chaze.screens.Category.CategoryPresenter;
import com.mission.chaze.chaze.screens.Category.ShopCategoryAdapter;
import com.mission.chaze.chaze.screens.Homepage.Ecommerce.EcommerceCategoryAdapter;
import com.mission.chaze.chaze.screens.Homepage.Ecommerce.EcommerceContract;
import com.mission.chaze.chaze.screens.Homepage.Ecommerce.EcommerceFragment;
import com.mission.chaze.chaze.screens.Homepage.Ecommerce.EcommercePagerAdapter;
import com.mission.chaze.chaze.screens.Homepage.Ecommerce.EcommercePresenter;
import com.mission.chaze.chaze.screens.Homepage.Ecommerce.ShopByProducts.ProductsPostAdapter;
import com.mission.chaze.chaze.screens.Homepage.Ecommerce.ShopByProducts.ShopByProductsContract;
import com.mission.chaze.chaze.screens.Homepage.Ecommerce.ShopByProducts.ShopByProductsPresenter;
import com.mission.chaze.chaze.screens.Homepage.Ecommerce.ShopByShops.ShopByShopsContract;
import com.mission.chaze.chaze.screens.Homepage.Ecommerce.ShopByShops.ShopByShopsPresenter;
import com.mission.chaze.chaze.screens.Homepage.Ecommerce.ShopByShops.ShopsAdapter;
import com.mission.chaze.chaze.screens.Homepage.Food.FoodContract;
import com.mission.chaze.chaze.screens.Homepage.Food.FoodFragment;
import com.mission.chaze.chaze.screens.Homepage.Food.FoodPresenter;
import com.mission.chaze.chaze.screens.Homepage.Food.RestaurantListAdapter;
import com.mission.chaze.chaze.screens.Homepage.Home.HomeFragment;
import com.mission.chaze.chaze.screens.Homepage.Home.HomeFragmentContract;
import com.mission.chaze.chaze.screens.Homepage.Home.HomeFragmentPresenter;
import com.mission.chaze.chaze.screens.Homepage.Home.HomeGridAdapter;
import com.mission.chaze.chaze.screens.Homepage.HomePresenter;
import com.mission.chaze.chaze.screens.Homepage.HomeBottomNavPagerAdapter;
import com.mission.chaze.chaze.screens.Homepage.HomeContract;
import com.mission.chaze.chaze.screens.Homepage.LocalSearch.LocalSearchFragment;
import com.mission.chaze.chaze.screens.Homepage.More.MoreFragment;
import com.mission.chaze.chaze.screens.search.SearchContract;
import com.mission.chaze.chaze.screens.search.SearchPresenter;
import com.mission.chaze.chaze.screens.search.SearchSuggestionsAdapter;

import java.util.ArrayList;
import java.util.LinkedList;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Shubham Vishwakarma on 4/10/18.
 */

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SearchContract.Presentor<SearchContract.View> providesSearchPresentor(
            SearchPresenter<SearchContract.View> presenter) {
        return presenter;
    }

    @Provides
    HomeContract.Presenter<HomeContract.View> providesHomePresenter(
            HomePresenter<HomeContract.View> presenter) {
        return presenter;
    }

    @Provides
    @LinLayoutVert
    LinearLayoutManager providesLayoutManagerVert() {
        return new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false);
    }

    @Provides
    SearchSuggestionsAdapter getSearchSuggestionsAdapter() {
        return new SearchSuggestionsAdapter(mActivity, new ArrayList<>());
    }

    @Provides
    HomeBottomNavPagerAdapter getBottomNavAdapter() {
        EcommerceFragment ecomerce = new EcommerceFragment();
        FoodFragment foodFragment = new FoodFragment();
        HomeFragment homeFragment = new HomeFragment();
        LocalSearchFragment localsearch = new LocalSearchFragment();
        MoreFragment moreFragment_object = new MoreFragment();

        HomeBottomNavPagerAdapter adapter = new HomeBottomNavPagerAdapter(mActivity.getSupportFragmentManager());
        adapter.addFragment(homeFragment);
        adapter.addFragment(ecomerce);
        adapter.addFragment(foodFragment);
        adapter.addFragment(localsearch);
        adapter.addFragment(moreFragment_object);
        return adapter;

    }


    @Provides
    HomeGridAdapter providesHomeGridAdapter() {
        return new HomeGridAdapter(mActivity, new ArrayList<>());
    }


    @Provides
    HomeFragmentContract.Presentor<HomeFragmentContract.View> providesHomeFragmentPresentor(
            HomeFragmentPresenter<HomeFragmentContract.View> presenter) {
        return presenter;
    }

    @Provides
    @LinLayoutHori
    LinearLayoutManager providesLayoutManagerHori() {
        return new LinearLayoutManager(mActivity, LinearLayoutManager.HORIZONTAL, false);
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
    EcommerceContract.Presentor<EcommerceContract.View> providesEcommercePresenter(
            EcommercePresenter<EcommerceContract.View> presenter) {
        return presenter;
    }


    @Provides
    ProductsPostAdapter providesProductsPostAdapter() {
        return new ProductsPostAdapter(mActivity, new ArrayList<>());
    }

    @Provides
    ShopByProductsContract.Presentor<ShopByProductsContract.View> providesShopByProductsPresenter(
            ShopByProductsPresenter<ShopByProductsContract.View> presenter) {
        return presenter;
    }

    @Provides
    ShopsAdapter providesShopsAdapter() {
        return new ShopsAdapter(mActivity, new ArrayList<>());
    }

    @Provides
    ShopByShopsContract.Presentor<ShopByShopsContract.View> providesShopByShopsPresenter(
            ShopByShopsPresenter<ShopByShopsContract.View> presenter) {
        return presenter;
    }


    @Provides
    FoodContract.Presenter<FoodContract.View> providesFoodPresenter(FoodPresenter<FoodContract.View> presenter) {
        return presenter;
    }

    @Provides
    RestaurantListAdapter providesRestaurantListAdapter() {
        return new RestaurantListAdapter(mActivity, new ArrayList<>());
    }


    @Provides
    LoginContract.Presenter<LoginContract.View> providesLoginPresenter(LoginPresenter<LoginContract.View> presenter) {
        return presenter;
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
    CartContract.Presentor<CartContract.View> providesCartPresenter(CartPresenter<CartContract.View> presenter) {
        return presenter;
    }


    @Provides
    SignUpContract.Presenter<SignUpContract.View> providesSignUpPresenter(SignUpPresenter<SignUpContract.View> presenter) {
        return presenter;
    }

    @Provides
    CategoryContract.Presenter<CategoryContract.View> providesCategoryPresenter(CategoryPresenter<CategoryContract.View> presenter) {
        return presenter;
    }

    @Provides
    ShopCategoryAdapter providesShopCategoryAdapter() {
        return new ShopCategoryAdapter();
    }


}
