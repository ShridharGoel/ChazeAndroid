package com.chaze.india.screens.RestaurantMenu;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.chaze.india.R;
import com.chaze.india.screens.Homepage.Food.Restaurants.RestaurantsContract;
import com.chaze.india.screens.base.BaseActivity;

public class RestaurantMenuActivity extends BaseActivity implements RestaurantMenuContract.View {


    private TabLayout mainActivitySlider;
    private ViewPager RestaurantMenuViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant__menu);
    }
}
