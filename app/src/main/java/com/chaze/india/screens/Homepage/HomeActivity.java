package com.chaze.india.screens.Homepage;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.chaze.india.models.RecyclerItems;
import com.chaze.india.screens.Homepage.Ecommerce.EcommerceFragment;
import com.chaze.india.screens.Homepage.Food.FoodFragment;
import com.chaze.india.screens.Homepage.More.MoreFragment;
import com.chaze.india.R;
import com.chaze.india.models.EcomerceCategory;
import com.chaze.india.repository.CartManager;
import com.chaze.india.screens.Homepage.Purchases.PurchasesFragment;
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


    @BindView(R.id.asdf)
    ConstraintLayout wishlist;


    @BindView(R.id.purchases)
    ConstraintLayout purchases;


    @BindView(R.id.more)
    ConstraintLayout more;

    @BindView(R.id.bottom_bar)
    ConstraintLayout bottomBar;


    @BindView(R.id.morei)
    ImageView moreI;


    @BindView(R.id.malli)
    ImageView mallI;

    @BindView(R.id.foodi)
    ImageView foodI;

    @BindView(R.id.purchasesi)
    ImageView purchasesI;

    @BindView(R.id.wishlishti)
    ImageView wishlistI;



    @BindView(R.id.moret)
    TextView moreT;


    @BindView(R.id.mallt)
    TextView mallT;

    @BindView(R.id.foodt)
    TextView foodT;

    @BindView(R.id.purchasest)
    TextView purchasesT;

    @BindView(R.id.wishlistt)
    TextView wishlistT;



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

        mallI.setImageDrawable(getDrawable(R.drawable.ic_mallw));
        foodI.setImageDrawable(getDrawable(R.drawable.ic_foodw));
        purchasesI.setImageDrawable(getDrawable(R.drawable.ic_purchasesw));
        moreI.setImageDrawable(getDrawable(R.drawable.ic_morew));
        wishlistI.setImageDrawable(getDrawable(R.drawable.ic_favw));

        mallT.setTextColor(getResources().getColor(R.color.white));
        foodT.setTextColor(getResources().getColor(R.color.white));
        purchasesT.setTextColor(getResources().getColor(R.color.white));
        moreT.setTextColor(getResources().getColor(R.color.white));
        wishlistT.setTextColor(getResources().getColor(R.color.white));

        switch (id) {
            case 0: {
                fragmentTransaction.add(R.id.fragment, ecommerceFragment).commit();
                Window window = getWindow();
                window.setStatusBarColor(getResources().getColor(R.color.colorPurple));
                bottomBar.setBackgroundColor(getResources().getColor(R.color.colorPurpleLight));
                mallI.setImageDrawable(getDrawable(R.drawable.ic_mally));
                mallT.setTextColor(getResources().getColor(R.color.yellow));
                break;
            }
            case 1: {
                fragmentTransaction.add(R.id.fragment, foodFragment).commit();
                Window window = getWindow();
                window.setStatusBarColor(getResources().getColor(R.color.colorPumpkinDark));
                bottomBar.setBackgroundColor(getResources().getColor(R.color.colorPumpkin));
                foodI.setImageDrawable(getDrawable(R.drawable.ic_foodc));
                foodT.setTextColor(getResources().getColor(R.color.colorCyan));
                break;
            }
            case 2: {
                break;
            }
            case 3: {
                fragmentTransaction.add(R.id.fragment, new PurchasesFragment()).commit();
                Window window = getWindow();
                window.setStatusBarColor(getResources().getColor(R.color.colorPurple));
                bottomBar.setBackgroundColor(getResources().getColor(R.color.colorPurpleLight));
                purchasesI.setImageDrawable(getDrawable(R.drawable.ic_purchasesy));
                purchasesT.setTextColor(getResources().getColor(R.color.yellow));
                break;
            }
            case 4: {
                fragmentTransaction.add(R.id.fragment, moreFragment).commit();
                moreI.setImageDrawable(getDrawable(R.drawable.ic_morey));
                moreT.setTextColor(getResources().getColor(R.color.yellow));
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


}
