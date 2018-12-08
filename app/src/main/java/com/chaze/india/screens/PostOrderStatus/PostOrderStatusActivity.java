package com.chaze.india.screens.PostOrderStatus;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.chaze.india.screens.base.BaseActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.chaze.india.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class PostOrderStatusActivity extends BaseActivity implements PostOrderStatusContract.View {

    MenuItem prevMenuItem;

    @Inject
    PostOrderStatusContract.Presenter<PostOrderStatusContract.View> mPresenter;
    ProgressDialog progressDialog;
    @BindView(R.id.postorder_slider)
    TabLayout tabLayout;
    @BindView(R.id.postorder_view_pager)
    ViewPager viewPager;
    @Inject
    PostOrderPagerAdapter postOrderPagerAdapter;


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

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_order_status);
        setUnBinder(ButterKnife.bind(this));
        getActivityComponent().inject(this);
        progressDialog = new ProgressDialog(this);
        mPresenter.onAttach(this);
        viewPager.setAdapter(postOrderPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        setListeners();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setResult(-1);
        finish();
    }

    private void setListeners() {

        ecommerce.setOnClickListener((v) -> {
            setResult(0);
            finish();
        });
        eat.setOnClickListener((v) -> {
            setResult(1);
            finish();
        });
        wishlist.setOnClickListener((v) -> {
            setResult(2);
            finish();
        });
        purchases.setOnClickListener((v) -> {
            setResult(3);
            finish();
        });
        more.setOnClickListener((v) -> {
            setResult(4);
            finish();
        });
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }

    @Override
    public void hideKeyboard() {

    }
}
