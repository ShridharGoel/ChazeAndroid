package com.chaze.india.screens.PostOrderStatus;

import android.app.ProgressDialog;
import android.os.Bundle;
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

public class PostOrderStatusActivity extends BaseActivity implements PostOrderStatusContract.View{

    MenuItem prevMenuItem;

    @Inject
    PostOrderStatusContract.Presentor<PostOrderStatusContract.View> mPresenter;
    ProgressDialog progressDialog;
    @BindView(R.id.postorder_slider)
    TabLayout tabLayout;
    @BindView(R.id.postorder_view_pager)
    ViewPager viewPager;
    @Inject
    PostOrderPagerAdapter postOrderPagerAdapter;

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
        //setupViewPager(viewPager);
    }



    private void addDataToFirebase() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference dRef = database.getReference("orders");

        dRef.child("transactionId").child("orderid").setValue("transactionId");
        dRef.child("transactionId").child("name").setValue("dummy_name");
        dRef.child("transactionId").child("email").setValue("dummy_email");
        dRef.child("transactionId").child("mobile").setValue("dummy_phoneno.");
        dRef.child("transactionId").child("address").setValue("dummy_address");
        dRef.child("transactionId").child("restaurant").setValue("dummy_restaurant");
        dRef.child("transactionId").child("summary").setValue("dummmy_summary");
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