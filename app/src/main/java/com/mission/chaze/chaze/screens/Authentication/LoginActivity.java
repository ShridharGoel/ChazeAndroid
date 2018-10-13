package com.mission.chaze.chaze.screens.Authentication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mission.chaze.chaze.AppController;
import com.mission.chaze.chaze.R;
import com.mission.chaze.chaze.models.LoginResponse;
import com.mission.chaze.chaze.repository.network.LoginAPIService;
import com.mission.chaze.chaze.screens.Homepage.HomeActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {

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

    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        ((AppController)getApplication()).getComponent().inject(this);

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

        loginBtn.setOnClickListener(v -> {

            LoginAPIService loginAPIService =  retrofit.create(LoginAPIService.class);

            Call<LoginResponse> call = loginAPIService.loginUser(loginMobile.getText().toString(),
                                                                    loginPass.getText().toString());

            call.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    LoginResponse loginResponse = response.body();

                    if(!loginResponse.getLoginError())
                    {
                        //Login
                    }
                    else
                    {
                        Toast.makeText(LoginActivity.this, "Error occurred. Please try again." , Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {

                }
            });

        });
    }
}
