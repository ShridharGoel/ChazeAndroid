

package com.chaze.india.di.component;

import com.chaze.india.di.module.AdapterModule;
import com.chaze.india.screens.Authentication.ForgotPassword.ForgotPasswordActivity;
import com.chaze.india.screens.Authentication.Login.LoginActivity;
import com.chaze.india.screens.Authentication.OTPConfirmation.OTPConfirmation;
import com.chaze.india.screens.Authentication.Signup.SignUpActivity;
import com.chaze.india.screens.Cart.EcommerceCart.CartActivity;
import com.chaze.india.screens.Cart.RestaurantCart.RestaurantCartActivity;
import com.chaze.india.screens.Category.CategoryActivity;
import com.chaze.india.screens.Homepage.Ecommerce.EcommerceFragment;
import com.chaze.india.screens.Homepage.Ecommerce.ShopByProducts.ShopByProductsFragment;
import com.chaze.india.screens.Homepage.Ecommerce.ShopByShops.ShopByShopsFragment;
import com.chaze.india.screens.Homepage.Food.FoodFragment;
import com.chaze.india.screens.Homepage.Food.Restaurants.RestaurantsFragment;
import com.chaze.india.screens.Homepage.HomeActivity;
import com.chaze.india.screens.Homepage.Purchases.ActiveOrders.ActiveOrdersFragment;
import com.chaze.india.screens.Homepage.Purchases.PurchasesFragment;
import com.chaze.india.screens.ProductInfo.ProductInfoActivity;
import com.chaze.india.screens.ProductInfo.ProductInfoPopupActivity.ProductInfoPopupActivity;
import com.chaze.india.screens.Profile.ProfileActivity;
import com.chaze.india.screens.Shop.ShopActivity;
import com.chaze.india.screens.Splash.SplashActivity;
import com.chaze.india.screens.SubCategory.SubCategoryActivity;
import com.chaze.india.screens.search.SearchActivity;
import com.chaze.india.di.Qualifiers.PerActivity;
import com.chaze.india.di.module.ActivityModule;


import dagger.Component;


/**
 * Created by Shubham Vishwakarma on 4/10/18.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, AdapterModule.class})
public interface ActivityComponent {

    void inject(HomeActivity activity);

    void inject(SplashActivity activity);


    void inject(ProfileActivity profileActivity);


    void inject(SearchActivity searchActivity);
    void inject(EcommerceFragment ecommerceFragment);

    void inject(ShopByProductsFragment shopByProductsFragment);

    void inject(ShopByShopsFragment shopByShopsFragment);

    void inject(FoodFragment foodFragment);


    void inject(CartActivity cartActivity);


    void inject(CategoryActivity categoryActivity);

    void inject(SubCategoryActivity subCategoryActivity);



    void inject(ForgotPasswordActivity forgotPasswordActivity);

    void inject(LoginActivity loginActivity);

    void inject(OTPConfirmation otpConfirmation);

    void inject(SignUpActivity signUpActivity);

    void inject(ActiveOrdersFragment activeOrdersFragment);

    void inject(RestaurantsFragment restaurantsFragment);

    void inject(ProductInfoActivity productInfoActivity);


    void inject(ShopActivity shopActivity);

    void inject(RestaurantCartActivity restaurantCartActivity);

    void inject(ProductInfoPopupActivity productInfoPopupActivity);

    void inject(PurchasesFragment purchasesFragment);
}
