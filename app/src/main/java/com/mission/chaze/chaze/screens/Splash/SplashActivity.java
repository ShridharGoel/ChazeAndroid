package com.mission.chaze.chaze.screens.Splash;


import android.os.Bundle;
import android.support.annotation.Nullable;

import com.mission.chaze.chaze.R;
import com.mission.chaze.chaze.repository.session.SessionManager;
import com.mission.chaze.chaze.screens.base.BaseActivity;

import javax.inject.Inject;

/**
 * Created by Shubham Vishwakarma on 4/10/18.
 */

public class SplashActivity extends BaseActivity implements SplashContract.View {

    @Inject
    SessionManager sessionManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getActivityComponent().inject(this);
    }

    @Override
    public void openLoginActivity() {

    }

    @Override
    public void openHomeActivity() {

    }

}
