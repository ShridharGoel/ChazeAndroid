

package com.chaze.india.screens.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.chaze.india.AppController;
import com.chaze.india.di.component.ActivityComponent;
import com.chaze.india.di.module.ActivityModule;
import com.chaze.india.AppController;
import com.chaze.india.di.component.ActivityComponent;
import com.chaze.india.di.component.DaggerActivityComponent;
import com.chaze.india.di.module.ActivityModule;

import butterknife.Unbinder;


/**
 * Created by Shubham Vishwakarma on 4/10/18.
 */

public abstract class BaseActivity extends AppCompatActivity
        implements MvpContract.View {


    ActivityComponent mActivityComponent;
    private Unbinder mUnBinder;
    ProgressDialog progressDialog;


    @Override
    protected void onPause() {
        super.onPause();
        progressDialog.hide();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((AppController) getApplication()).getComponent())
                .build();

        progressDialog = new ProgressDialog(getApplicationContext());

    }

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }


    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    @Override
    protected void onDestroy() {

        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }

    @Override
    public void showLoading() {
        progressDialog.setMessage("Loading....");
        progressDialog.show();
    }

    @Override
    public void hideLoading() {
        progressDialog.hide();
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
