package com.mission.chaze.chaze.screens.Homepage;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.widget.TextView;

import com.mission.chaze.chaze.R;
import com.mission.chaze.chaze.models.EcomerceCategory;
import com.mission.chaze.chaze.models.RecyclerItems;
import com.mission.chaze.chaze.repository.CartManager;
import com.mission.chaze.chaze.screens.Checkout.CheckoutActivity;
import com.mission.chaze.chaze.screens.Checkout.CheckoutContract;
import com.mission.chaze.chaze.screens.Proflie.ProfileActivity;
import com.mission.chaze.chaze.screens.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class HomeActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, HomeContract.View {


    MenuItem prevMenuItem;

    ProgressDialog progressDialog;
    @Inject
    CartManager cartManager;

    @Inject
    HomeContract.Presenter<HomeContract.View> mPresenter;

    @BindView(R.id.navigation)
    BottomNavigationView bottomNavigationView;
    @BindView(R.id.viewpager)
    ViewPager viewPager;
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
        progressDialog = new ProgressDialog(this);
        mPresenter.onAttach(this);
        setupBottomNavigation();
        setupViewPager(viewPager);


    }

    public void openDrawer() {
        drawer.openDrawer(Gravity.LEFT);
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


        navigationView.setNavigationItemSelectedListener(this);


        bottomNavigationView.setOnNavigationItemSelectedListener(
                item -> {
                    switch (item.getItemId()) {
                        case R.id.navigation_home:

                            viewPager.setCurrentItem(0);
                            break;
                        case R.id.navigation_dashboard:
                            //showLoading();
                          viewPager.setCurrentItem(1);

                            break;
                        case R.id.navigation_3:
                            //showLoading();
                           // progressDialog.show();
                            viewPager.setCurrentItem(2);
                            break;
                        case R.id.navigation_4:
                           // showLoading();

                           viewPager.setCurrentItem(3);
                            break;
                        case R.id.navigation_5:
                        //    showLoading();
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
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_profile:
                Intent intent1 = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(intent1);
                break;
            case R.id.nav_checkout:
                Intent intent2=new Intent(HomeActivity.this, CheckoutActivity.class);
                startActivity(intent2);
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void addItems(List<EcomerceCategory> items) {

    }

    @Override
    public ArrayList<RecyclerItems> loadCards() {
        return null;
    }
}
