package com.mission.chaze.chaze.screens.Homepage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mission.chaze.chaze.R;
import com.mission.chaze.chaze.repository.CartManager;
import com.mission.chaze.chaze.repository.session.SessionManager;
import com.mission.chaze.chaze.screens.base.BaseActivity;

import javax.inject.Inject;

import io.reactivex.Observable;

public class HomeActivity extends BaseActivity {

    @Inject
    SessionManager sessionManager;

    @Inject
    CartManager mCartManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);

    }
}
