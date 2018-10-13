package com.mission.chaze.chaze.screens.Authentication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.mission.chaze.chaze.R;
import com.mission.chaze.chaze.screens.Homepage.HomeActivity;
import com.mission.chaze.chaze.screens.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity implements LoginContract.View {

    @BindView(R.id.login_btn)
    Button loginBtn;

    @BindView(R.id.signup_btn)
    Button signupBtn;

    @BindView(R.id.skip_btn)
    Button skipBtn;

    @BindView(R.id.login_enter_mobile)
    EditText loginMobile;

    @BindView(R.id.login_enter_pass)
    EditText loginPass;


    @Inject
    LoginContract.Presenter<LoginContract.View> mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        getActivityComponent().inject(this);

        getSupportActionBar().hide();

        signupBtn.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            finish();
            overridePendingTransition(0, 0);
        });

        skipBtn.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        });

        loginBtn.setOnClickListener(v -> mPresenter.doLogin(loginMobile.getText().toString(), loginPass.getText().toString()));
    }

    @Override
    public void showloginResult() {

    }
}
