

package com.chaze.india.di.component;

import com.chaze.india.screens.Authentication.LoginActivity;
import com.chaze.india.screens.Authentication.SignUpActivity;
import com.chaze.india.screens.Category.CategoryActivity;
import com.chaze.india.screens.Homepage.Ecommerce.EcommerceFragment;
import com.chaze.india.screens.Homepage.Ecommerce.ShopByProducts.ShopByProductsFragment;
import com.chaze.india.screens.Homepage.Ecommerce.ShopByShops.ShopByShopsFragment;
import com.chaze.india.screens.Homepage.Food.FoodFragment;
import com.chaze.india.screens.Homepage.Home.HomeFragment;
import com.chaze.india.screens.Homepage.HomeActivity;
import com.chaze.india.screens.Proflie.ProfileActivity;
import com.chaze.india.screens.Splash.SplashActivity;
import com.chaze.india.screens.search.SearchActivity;
import com.chaze.india.di.PerActivity;
import com.chaze.india.di.module.ActivityModule;
import com.chaze.india.screens.Authentication.LoginActivity;

import com.chaze.india.screens.Cart.CartActivity;

import com.chaze.india.screens.Authentication.SignUpActivity;

import com.chaze.india.screens.Category.CategoryActivity;
import com.chaze.india.screens.Homepage.Ecommerce.EcommerceFragment;
import com.chaze.india.screens.Homepage.Ecommerce.ShopByProducts.ShopByProductsFragment;
import com.chaze.india.screens.Homepage.Ecommerce.ShopByShops.ShopByShopsFragment;
import com.chaze.india.screens.Homepage.Food.FoodFragment;
import com.chaze.india.screens.Homepage.Home.HomeFragment;
import com.chaze.india.screens.Homepage.HomeActivity;
import com.chaze.india.screens.Proflie.ProfileActivity;
import com.chaze.india.screens.Splash.SplashActivity;
import com.chaze.india.screens.base.BaseActivity;
import com.chaze.india.screens.search.SearchActivity;

import dagger.Component;


/**
 * Created by Shubham Vishwakarma on 4/10/18.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(HomeActivity activity);

    void inject(SplashActivity activity);


    void inject(ProfileActivity profileActivity);


    void inject(SearchActivity searchActivity);

    void inject(HomeFragment homeFragment);

    void inject(EcommerceFragment ecommerceFragment);

    void inject(ShopByProductsFragment shopByProductsFragment);

    void inject(ShopByShopsFragment shopByShopsFragment);

    void inject(FoodFragment foodFragment);

    void inject(LoginActivity loginActivity);


    void inject(CartActivity cartActivity);

    void inject(SignUpActivity signUpActivity);

    void inject(CategoryActivity categoryActivity);
}
