

package com.chaze.india.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.chaze.india.di.Qualifiers.ActivityContext;
import com.chaze.india.di.Qualifiers.LinLayoutHori;
import com.chaze.india.di.Qualifiers.LinLayoutVert;
import com.chaze.india.screens.Authentication.Login.LoginContract;
import com.chaze.india.screens.Authentication.Login.LoginPresenter;
import com.chaze.india.screens.Authentication.Signup.SignUpContract;
import com.chaze.india.screens.Authentication.Signup.SignUpPresenter;
import com.chaze.india.screens.Category.CategoryContract;
import com.chaze.india.screens.Category.CategoryPresenter;
import com.chaze.india.screens.Category.ShopCategoryAdapter;
import com.chaze.india.screens.Homepage.Ecommerce.EcommerceCategoryAdapter;
import com.chaze.india.screens.Homepage.Ecommerce.EcommerceContract;
import com.chaze.india.screens.Homepage.Ecommerce.EcommerceFragment;
import com.chaze.india.screens.Homepage.Ecommerce.EcommercePagerAdapter;
import com.chaze.india.screens.Homepage.Ecommerce.EcommercePresenter;
import com.chaze.india.screens.Homepage.Ecommerce.ShopByProducts.ProductsPostAdapter;
import com.chaze.india.screens.Homepage.Ecommerce.ShopByProducts.ShopByProductsPresenter;
import com.chaze.india.screens.Homepage.Ecommerce.ShopByShops.ShopByShopsContract;
import com.chaze.india.screens.Homepage.Ecommerce.ShopByShops.ShopByShopsPresenter;
import com.chaze.india.screens.Homepage.Ecommerce.ShopByShops.ShopsAdapter;
import com.chaze.india.screens.Homepage.Food.FoodContract;
import com.chaze.india.screens.Homepage.Food.FoodFragment;
import com.chaze.india.screens.Homepage.Food.FoodPresenter;
import com.chaze.india.screens.Homepage.Food.RestaurantListAdapter;
import com.chaze.india.screens.Homepage.Home.HomeFragment;
import com.chaze.india.screens.Homepage.Home.HomeFragmentContract;
import com.chaze.india.screens.Homepage.Home.HomeFragmentPresenter;
import com.chaze.india.screens.Homepage.Home.HomeGridAdapter;
import com.chaze.india.screens.Homepage.HomeBottomNavPagerAdapter;
import com.chaze.india.screens.Homepage.HomeContract;
import com.chaze.india.screens.Homepage.HomePresenter;
import com.chaze.india.screens.Homepage.More.MoreFragment;
import com.chaze.india.screens.PostOrderStatus.ActiveOrders.ActiveOrdersAdapter;
import com.chaze.india.screens.PostOrderStatus.ActiveOrders.ActiveOrdersContract;
import com.chaze.india.screens.PostOrderStatus.ActiveOrders.ActiveOrdersPresenter;
import com.chaze.india.screens.PostOrderStatus.ActiveOrders.TimeLineAdapter;
import com.chaze.india.screens.PostOrderStatus.PostOrderPagerAdapter;
import com.chaze.india.screens.PostOrderStatus.PostOrderStatusContract;
import com.chaze.india.screens.PostOrderStatus.PostOrderStatusPresenter;
import com.chaze.india.screens.SubCategory.SubCategoryContract;
import com.chaze.india.screens.SubCategory.SubCategoryPresenter;
import com.chaze.india.screens.search.SearchContract;
import com.chaze.india.screens.search.SearchPresenter;
import com.chaze.india.screens.search.SearchSuggestionsAdapter;
import com.chaze.india.screens.Cart.CartBusinessAdapter;
import com.chaze.india.screens.Cart.CartContract;
import com.chaze.india.screens.Cart.CartItemsAdapter;
import com.chaze.india.screens.Cart.CartPresenter;

import com.chaze.india.screens.Homepage.Ecommerce.ShopByProducts.ShopByProductsContract;
import com.chaze.india.screens.Homepage.LocalSearch.LocalSearchFragment;
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
    SearchContract.Presenter<SearchContract.View> providesSearchPresenter(
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
    @LinLayoutHori
    LinearLayoutManager providesLayoutManagerHori() {
        return new LinearLayoutManager(mActivity, LinearLayoutManager.HORIZONTAL, false);
    }



    @Provides
    EcommerceContract.Presenter<EcommerceContract.View> providesEcommercePresenter(
            EcommercePresenter<EcommerceContract.View> presenter) {
        return presenter;
    }


    @Provides
    ShopByProductsContract.Presenter<ShopByProductsContract.View> providesShopByProductsPresenter(
            ShopByProductsPresenter<ShopByProductsContract.View> presenter) {
        return presenter;
    }

    @Provides
    ShopsAdapter providesShopsAdapter() {
        return new ShopsAdapter(mActivity, new ArrayList<>());
    }

    @Provides
    ShopByShopsContract.Presenter<ShopByShopsContract.View> providesShopByShopsPresenter(
            ShopByShopsPresenter<ShopByShopsContract.View> presenter) {
        return presenter;
    }


    @Provides
    FoodContract.Presenter<FoodContract.View> providesFoodPresenter(FoodPresenter<FoodContract.View> presenter) {
        return presenter;
    }



    @Provides
    LoginContract.Presenter<LoginContract.View> providesLoginPresenter(LoginPresenter<LoginContract.View> presenter) {
        return presenter;
    }

    @Provides
    CartContract.Presenter<CartContract.View> providesCartPresenter(CartPresenter<CartContract.View> presenter) {
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
    SubCategoryContract.Presenter<SubCategoryContract.View> providesSubCategoryContract(SubCategoryPresenter<SubCategoryContract.View> presenter) {

        return presenter;
    }
    @Provides
    PostOrderStatusContract.Presenter<PostOrderStatusContract.View> providesPostOrderPresenter(PostOrderStatusPresenter<PostOrderStatusContract.View> presenter){
        return presenter;
    }


}
