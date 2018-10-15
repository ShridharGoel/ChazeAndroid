package com.mission.chaze.chaze.screens.Authentication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mission.chaze.chaze.R;
import com.mission.chaze.chaze.screens.Homepage.HomeActivity;
import com.mission.chaze.chaze.screens.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.mission.chaze.chaze.repository.session.SessionManager.PREF_NAME;

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

    @BindView(R.id.login_submit_btn)
    Button loginSubmitBtn;


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

        loginSubmitBtn.setOnClickListener(v ->
        {
            if(!TextUtils.isEmpty(loginMobile.getText().toString()) && !TextUtils.isEmpty(loginPass.getText().toString()))

            mPresenter.doLogin(loginMobile.getText().toString(), loginPass.getText().toString());

            else if(TextUtils.isEmpty(loginMobile.getText().toString()))
                Toast.makeText(this, "Please enter your mobile number.", Toast.LENGTH_SHORT).show();

            else if(TextUtils.isEmpty(loginPass.getText().toString()))
                Toast.makeText(this, "Please enter your password.", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public void showloginResult() {

    }
}
