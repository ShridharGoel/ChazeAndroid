package com.chaze.india.screens.RestaurantMenu;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.chaze.india.R;
import com.chaze.india.screens.Homepage.Food.Restaurants.RestaurantsContract;
import com.chaze.india.screens.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestaurantMenuActivity extends BaseActivity implements RestaurantMenuContract.View {


    @BindView(R.id.restaurant_menu_activity_slider)
    TabLayout mainActivitySlider;

    @BindView(R.id.restaurant_menu_activity_view_pager)
    ViewPager RestaurantMenuViewPager;

   /* @Inject*/
    RestaurantPagerAdapter restaurantPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant__menu);

        setUnBinder(ButterKnife.bind(this));
        getActivityComponent().inject(this);

    }
}
