

package com.chaze.india.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.chaze.india.di.Qualifiers.ActivityContext;
import com.chaze.india.di.Qualifiers.LinLayoutHori;
import com.chaze.india.di.Qualifiers.LinLayoutVert;
import com.chaze.india.screens.Authentication.ForgotPassword.ForgotPasswordContract;
import com.chaze.india.screens.Authentication.ForgotPassword.ForgotPasswordPresenter;
import com.chaze.india.screens.Authentication.Login.LoginContract;
import com.chaze.india.screens.Authentication.Login.LoginPresenter;
import com.chaze.india.screens.Authentication.OTPConfirmation.OTPConfirmationContract;
import com.chaze.india.screens.Authentication.OTPConfirmation.OTPConfirmationPresenter;
import com.chaze.india.screens.Authentication.Signup.SignUpContract;
import com.chaze.india.screens.Authentication.Signup.SignUpPresenter;
import com.chaze.india.screens.Cart.EcommerceCart.CartContract;
import com.chaze.india.screens.Cart.EcommerceCart.CartPresenter;
import com.chaze.india.screens.Cart.RestaurantCart.RestaurantCartContract;
import com.chaze.india.screens.Cart.RestaurantCart.RestaurantCartPresenter;
import com.chaze.india.screens.Category.CategoryContract;
import com.chaze.india.screens.Category.CategoryPresenter;
import com.chaze.india.screens.Checkout.CheckoutContract;
import com.chaze.india.screens.Checkout.CheckoutPresenter;
import com.chaze.india.screens.Homepage.Ecommerce.EcommerceContract;
import com.chaze.india.screens.Homepage.Ecommerce.EcommercePresenter;
import com.chaze.india.screens.Homepage.Ecommerce.ShopByProducts.ShopByProductsPresenter;
import com.chaze.india.screens.Homepage.Ecommerce.ShopByShops.ShopByShopsContract;
import com.chaze.india.screens.Homepage.Ecommerce.ShopByShops.ShopByShopsPresenter;
import com.chaze.india.screens.Homepage.Ecommerce.ShopByShops.ShopsAdapter;
import com.chaze.india.screens.Homepage.Food.FoodContract;
import com.chaze.india.screens.Homepage.Food.FoodPresenter;
import com.chaze.india.screens.Homepage.Food.Restaurants.RestaurantsContract;
import com.chaze.india.screens.Homepage.Food.Restaurants.RestaurantsPresenter;
import com.chaze.india.screens.Homepage.HomeContract;
import com.chaze.india.screens.Homepage.HomePresenter;
import com.chaze.india.screens.Homepage.Purchases.PurchasesContract;
import com.chaze.india.screens.Homepage.Purchases.PurchasesPresenter;
import com.chaze.india.screens.ProductInfo.ProductInfoContract;
import com.chaze.india.screens.ProductInfo.ProductInfoPresenter;
import com.chaze.india.screens.Profile.ProfileContract;
import com.chaze.india.screens.Profile.ProfilePresenter;
import com.chaze.india.screens.Shop.ShopContract;
import com.chaze.india.screens.Shop.ShopPresenter;
import com.chaze.india.screens.SubCategory.SubCategoryContract;
import com.chaze.india.screens.SubCategory.SubCategoryPresenter;
import com.chaze.india.screens.search.SearchContract;
import com.chaze.india.screens.search.SearchPresenter;

import com.chaze.india.screens.Homepage.Ecommerce.ShopByProducts.ShopByProductsContract;

import java.util.ArrayList;

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
    RestaurantCartContract.Presenter<RestaurantCartContract.View> providesRestaurantCartPresenter(RestaurantCartPresenter<RestaurantCartContract.View> presenter) {
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
    PurchasesContract.Presenter<PurchasesContract.View> providesPostOrderPresenter(PurchasesPresenter<PurchasesContract.View> presenter) {
        return presenter;
    }

    @Provides
    RestaurantsContract.Presenter<RestaurantsContract.View> providesRestaurantsPresenter(RestaurantsPresenter<RestaurantsContract.View> presenter) {
        return presenter;
    }

    @Provides
    ProductInfoContract.Presenter<ProductInfoContract.View> providesProductInfoPresenter(ProductInfoPresenter<ProductInfoContract.View> presenter) {
        return presenter;
    }

    @Provides
    ShopContract.Presenter<ShopContract.View> providesShopPresenter(ShopPresenter<ShopContract.View> presenter) {
        return presenter;
    }

    @Provides
    OTPConfirmationContract.Presenter<OTPConfirmationContract.View> providesOTPPresenter(OTPConfirmationPresenter<OTPConfirmationContract.View> presenter) {
        return presenter;
    }

    @Provides
    ForgotPasswordContract.Presenter<ForgotPasswordContract.View> providesForgotPasswordPresenter(ForgotPasswordPresenter<ForgotPasswordContract.View> presenter) {
        return presenter;
    }

    @Provides
    ProfileContract.Presenter<ProfileContract.View> providesProfilePresenter(ProfilePresenter<ProfileContract.View> presenter) {
        return presenter;
    }

    @Provides
    CheckoutContract.Presenter<CheckoutContract.View> providesCheckoutContract(CheckoutPresenter<CheckoutContract.View> presenter) {
        return presenter;
    }
}

