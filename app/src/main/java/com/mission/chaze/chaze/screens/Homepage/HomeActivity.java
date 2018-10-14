package com.mission.chaze.chaze.screens.Homepage;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.mission.chaze.chaze.R;
import com.mission.chaze.chaze.models.EcomerceCategory;
import com.mission.chaze.chaze.screens.Cart.CartActivity;
import com.mission.chaze.chaze.screens.Homepage.Ecommerce.EcommerceFragment;
import com.mission.chaze.chaze.screens.Homepage.Food.FoodFragment;
import com.mission.chaze.chaze.screens.Homepage.Home.HomeFragment;
import com.mission.chaze.chaze.screens.Homepage.LocalSearch.LocalSearchFragment;
import com.mission.chaze.chaze.screens.Homepage.More.MoreFragment;
import com.mission.chaze.chaze.repository.CartManager;
import com.mission.chaze.chaze.screens.base.BaseActivity;
import com.mission.chaze.chaze.screens.search.SearchActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class HomeActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, HomeContract.View {


    MenuItem prevMenuItem;

    TextView txtViewCount;

    @Inject
    CartManager cartManager;

    @Inject
    HomeContract.Presenter<HomeContract.View> mPresenter;

    @BindView(R.id.navigation)
    BottomNavigationView bottomNavigationView;
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @Inject
    HomeBottomNavPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setUnBinder(ButterKnife.bind(this));
        getActivityComponent().inject(this);

        mPresenter.onAttach(this);
        setSupportActionBar(toolbar);
        setupBottomNavigation();
        setupViewPager(viewPager);
    }


    private void setupViewPager(ViewPager viewPager) {

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                Timber.d("page" + "onPageSelected: " + position);
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        viewPager.setAdapter(adapter);
    }

    private void goToSearch() {

        Intent intent = new Intent(HomeActivity.this, SearchActivity.class);
        intent.putExtra("SearchType", viewPager.getCurrentItem());
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this, (View) toolbar, "search");
        startActivity(intent, options.toBundle());
    }

    private void setupBottomNavigation() {
        BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
                = (item) -> {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_dashboard:
                    return true;
                case R.id.navigation_3:
                    return true;
                case R.id.navigation_4:
                    return true;
                case R.id.navigation_5:
                    return true;
            }
            return false;
        };
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        navigationView.setNavigationItemSelectedListener(this);


        bottomNavigationView.setOnNavigationItemSelectedListener(
                item -> {
                    switch (item.getItemId()) {
                        case R.id.navigation_home:
                            viewPager.setCurrentItem(0);
                            break;
                        case R.id.navigation_dashboard:
                            viewPager.setCurrentItem(1);
                            break;
                        case R.id.navigation_3:
                            viewPager.setCurrentItem(2);
                            break;
                        case R.id.navigation_4:
                            viewPager.setCurrentItem(3);
                            break;
                        case R.id.navigation_5:
                            viewPager.setCurrentItem(4);
                            break;
                    }
                    return false;
                });

    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) drawer.closeDrawer(GravityCompat.START);
        else super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.menu_just_cart, menu);
        final View cart = menu.findItem(R.id.cart_icon_badge_action).getActionView();
        final View search = menu.findItem(R.id.serchview).getActionView();
        txtViewCount = (TextView) cart.findViewById(R.id.cart_count_badge);
        txtViewCount.setText(String.valueOf(0));
        search.setOnClickListener(v -> goToSearch());
        cart.setOnClickListener(v -> {
            startActivity(new Intent(HomeActivity.this, CartActivity.class));
        });
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void addItems(List<EcomerceCategory> items) {

    }
}
