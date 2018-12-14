package com.chaze.india.screens.Authentication.ForgotPassword;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.chaze.india.R;
import com.chaze.india.screens.Homepage.HomeActivity;
import com.chaze.india.screens.base.BaseActivity;
import com.google.gson.Gson;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;


/**
 post request on /login
 param: req: OTP code( 6digit) + token


 return: {
 success:true/false
 error:msg to show if success is false
 token:secret key
 user:
 }

 **/

public class ForgotPasswordActivity extends BaseActivity implements ForgotPasswordContract.View {

    @BindView(R.id.new_pass)
    EditText newPass;

    @BindView(R.id.confirm_new_pass)
    EditText confirmNewPass;

    @BindView(R.id.submit_new_pass_btn)
    Button submitBtn;

    @Inject
    ForgotPasswordContract.Presenter<ForgotPasswordContract.View> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        ButterKnife.bind(this);

        getActivityComponent().inject(this);

        mPresenter.onAttach(this);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (newPass.getText().toString().equals(confirmNewPass.getText().toString())) {

                    Timber.e("Check "+getIntent().getStringExtra("Mobile"));
                    mPresenter.doChangePass(getIntent().getStringExtra("Mobile"), Integer.parseInt(getIntent().getStringExtra("OTP")), newPass.getText().toString());

                }
            }
        });
    }

                @Override
                public void startHomeActivity () {
                    Intent homeIntent = new Intent(ForgotPasswordActivity.this, HomeActivity.class);
                    startActivity(homeIntent);
                }
            }


