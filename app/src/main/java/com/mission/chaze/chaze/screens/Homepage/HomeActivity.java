package com.mission.chaze.chaze.screens.Homepage;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mission.chaze.chaze.R;
import com.mission.chaze.chaze.ViewPagerAdapter;
import com.mission.chaze.chaze.fragments.Ecomerce;
import com.mission.chaze.chaze.fragments.Food;
import com.mission.chaze.chaze.fragments.Home;
import com.mission.chaze.chaze.fragments.Localsearch;
import com.mission.chaze.chaze.fragments.more;
import com.mission.chaze.chaze.screens.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class HomeActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    public HomeActivity() {
    }

    /*@BindView(R.id.message)
    TextView mTextMessage;


    @BindView(R.id.toolbar)
    Toolbar toolbar;
*/
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;


    /*@Inject
    SessionManager sessionManager;

    @Inject
    CartManager mCartManager;
*/

    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.navigation)
    BottomNavigationView navigation;

    //This is our viewPager
    @BindView(R.id.viewpager)
    ViewPager viewPager;

    TabLayout tabLayout;
    MenuItem prevMenuItem;
    Ecomerce ecomerce;
    Food food;
    Home home;
    Localsearch localsearch;
    more more_object;
    BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                   // mTextMessage.setText(R.string.title_home);

                    return true;
                case R.id.navigation_dashboard:
                   // mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_3:
                 //   mTextMessage.setText(R.string.title_notifications);
                    return true;
                case R.id.navigation_4:
                   // mTextMessage.setText(R.string.title_notifications);
                    return true;
                case R.id.navigation_5:
                  //  mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        setUnBinder(ButterKnife.bind(this));

       // setSupportActionBar(toolbar);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

      /*  ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();*/

        navigationView.setNavigationItemSelectedListener(this);


        //Initializing the bottomNavigationView
        navigation.setOnNavigationItemSelectedListener(item-> {



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

        setupViewPager(viewPager);
    }



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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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


    private void setupViewPager(ViewPager viewPager) {

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                Toast.makeText(HomeActivity.this,""+ position, Toast.LENGTH_SHORT).show();

                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    navigation.getMenu().getItem(0).setChecked(false);
                }
                Timber.d("onPageSelected: " + position);
                navigation.getMenu().getItem(position).setChecked(true);
                prevMenuItem = navigation.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        ecomerce = new Ecomerce();
        food = new Food();
        home = new Home();
        more_object = new more();
        adapter.addFragment(ecomerce);
        adapter.addFragment(food);
        adapter.addFragment(home);
        adapter.addFragment(more_object);
        viewPager.setAdapter(adapter);
    }
}
