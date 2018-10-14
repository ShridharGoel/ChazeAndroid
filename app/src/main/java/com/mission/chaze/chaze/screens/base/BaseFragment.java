package com.mission.chaze.chaze.screens.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.mission.chaze.chaze.di.component.ActivityComponent;

import butterknife.Unbinder;

/**
 * Created by Shubham Vishwakarma on 4/10/18.
 */

public abstract class BaseFragment extends Fragment implements MvpContract.View {


    private BaseActivity mActivity;
    private ProgressDialog progressDialog;
    private Unbinder mUnBinder;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            BaseActivity activity = (BaseActivity) context;
            this.mActivity = activity;
            progressDialog = new ProgressDialog(mActivity);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
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


    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    public ActivityComponent getActivityComponent() {
        if (mActivity != null) {
            return mActivity.getActivityComponent();
        }
        return null;
    }

}
