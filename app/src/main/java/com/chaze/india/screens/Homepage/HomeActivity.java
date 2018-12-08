package com.chaze.india.screens.Homepage;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.Window;
import android.widget.FrameLayout;

import com.chaze.india.models.RecyclerItems;
import com.chaze.india.screens.Checkout.CheckoutActivity;
import com.chaze.india.screens.Homepage.Ecommerce.EcommerceFragment;
import com.chaze.india.screens.Homepage.Food.FoodFragment;
import com.chaze.india.screens.Homepage.More.MoreFragment;
import com.chaze.india.screens.PostOrderStatus.PostOrderStatusActivity;
import com.chaze.india.R;
import com.chaze.india.models.EcomerceCategory;
import com.chaze.india.repository.CartManager;
import com.chaze.india.screens.Checkout.CheckoutActivity;
import com.chaze.india.screens.Checkout.CheckoutContract;
import com.chaze.india.screens.Profile.ProfileActivity;
import com.chaze.india.screens.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class HomeActivity extends BaseActivity
        implements HomeContract.View {


    ProgressDialog progressDialog;
    @Inject
    CartManager cartManager;

    @Inject
    HomeContract.Presenter<HomeContract.View> mPresenter;


    @BindView(R.id.fragment)
    FrameLayout fragmentContainer;


    @BindView(R.id.ecommerce)
    ConstraintLayout ecommerce;


    @BindView(R.id.eat)
    ConstraintLayout eat;


    @BindView(R.id.wishlist)
    ConstraintLayout wishlist;


    @BindView(R.id.purchases)
    ConstraintLayout purchases;


    @BindView(R.id.more)
    ConstraintLayout more;

    @BindView(R.id.bottom_bar)
    ConstraintLayout bottomBar;

    int cid = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setUnBinder(ButterKnife.bind(this));
        getActivityComponent().inject(this);
        progressDialog = new ProgressDialog(this);
        mPresenter.onAttach(this);
        addFragment(0);

        setListeners();

    }

    private void setListeners() {

        ecommerce.setOnClickListener(v -> addFragment(0));
        eat.setOnClickListener((v -> addFragment(1)));
        wishlist.setOnClickListener(v -> addFragment(2));
        purchases.setOnClickListener(v -> addFragment(3));
        more.setOnClickListener(v -> addFragment(4));
    }

    private void addFragment(int id) {


        if (cid == id) return;

        FragmentManager fragmentManager = getSupportFragmentManager();

        Fragment ecommerceFragment = new EcommerceFragment(), foodFragment = new FoodFragment(), moreFragment = new MoreFragment();


        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment);
        FragmentTransaction fragmentTransaction;
        if (fragment != null) {
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(fragment);
            fragmentTransaction.commit();
        }

        fragmentTransaction = fragmentManager.beginTransaction();

        switch (id) {
            case 0: {
                fragmentTransaction.add(R.id.fragment, ecommerceFragment).commit();
                Window window = getWindow();
                window.setStatusBarColor(getResources().getColor(R.color.colorPurple));
                bottomBar.setBackgroundColor(getResources().getColor(R.color.colorPurpleLight));
                break;
            }
            case 1: {
                fragmentTransaction.add(R.id.fragment, foodFragment).commit();
                Window window = getWindow();
                window.setStatusBarColor(getResources().getColor(R.color.colorPumpkinDark));
                bottomBar.setBackgroundColor(getResources().getColor(R.color.colorPumpkin));
                break;
            }
            case 2: {

            }
            case 3: {
                this.startActivityForResult(new Intent(this, PostOrderStatusActivity.class), cid);
                this.overridePendingTransition(0, 0);
            }
            case 4: {
                fragmentTransaction.add(R.id.fragment, moreFragment).commit();
                break;
            }
        }

        cid = id;


    }


    public void addItems(List<EcomerceCategory> items) {

    }

    public ArrayList<RecyclerItems> loadCards() {
        return null;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Timber.e("" + requestCode +" "+ resultCode);

        if (resultCode!=-1) {
            addFragment(resultCode);
        } else {
            addFragment(requestCode);
        }


    }

}
