package com.mission.chaze.chaze.screens.Homepage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.mission.chaze.chaze.R;
import com.mission.chaze.chaze.ViewPagerAdapter;
import com.mission.chaze.chaze.fragments.Ecomerce;
import com.mission.chaze.chaze.fragments.Food;
import com.mission.chaze.chaze.fragments.Home;
import com.mission.chaze.chaze.fragments.Localsearch;
import com.mission.chaze.chaze.fragments.more;
import com.mission.chaze.chaze.repository.CartManager;
import com.mission.chaze.chaze.screens.search.SearchActivity;

import javax.inject.Inject;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView mTextMessage;
    private TabLayout tabLayout;
    BottomNavigationView bottomNavigationView;

    //This is our viewPager
    private ViewPager viewPager;
    MenuItem prevMenuItem;
    Ecomerce ecomerce;
    Food food;
    Home home;
    Localsearch localsearch;
    private more more_object;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);

                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_3:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
                case R.id.navigation_4:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
                case R.id.navigation_5:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };
    private TextView txtViewCount;
    CartManager cartManager;

    public HomeActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        viewPager = (ViewPager) findViewById(R.id.viewpager);

        //Initializing the bottomNavigationView
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
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
                    }
                });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                }
                else
                {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page", "onPageSelected: "+position);
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        setupViewPager(viewPager);
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        ecomerce=new Ecomerce();
        food=new Food();
        home=new Home();
        localsearch=new Localsearch();
        more_object=new more();
        adapter.addFragment(ecomerce);
        adapter.addFragment(food);
        adapter.addFragment(home);
        adapter.addFragment(localsearch);
        adapter.addFragment(more_object);
        viewPager.setAdapter(adapter);
    }

    TextView search;
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        cartManager = new CartManager(HomeActivity.this);
        getMenuInflater().inflate(R.menu.menu_just_cart, menu);
        final View cart = menu.findItem(R.id.cart_icon_badge_action).getActionView();
        final View search = menu.findItem(R.id.serchview).getActionView();
        txtViewCount = (TextView) cart.findViewById(R.id.cart_count_badge);
        txtViewCount.setText(String.valueOf(0));
        search.setOnClickListener(v->goToSearch());
        cart.setOnClickListener(v->
                {}

        );
        return super.onCreateOptionsMenu(menu);
    }

    private void goToSearch() {

        Intent intent = new Intent(HomeActivity.this, SearchActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
