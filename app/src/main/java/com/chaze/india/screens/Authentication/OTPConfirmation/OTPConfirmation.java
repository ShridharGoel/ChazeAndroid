package com.chaze.india.screens.Authentication.OTPConfirmation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.chaze.india.R;
import com.chaze.india.screens.Authentication.ForgotPassword.ForgotPasswordActivity;
import com.chaze.india.screens.Homepage.HomeActivity;
import com.chaze.india.screens.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


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

public class OTPConfirmation extends BaseActivity implements OTPConfirmationContract.View {

    String mobileNum;

    @BindView(R.id.otp_edit_text)
    EditText enterOtp;

    @BindView(R.id.submit_otp_btn)
    Button submitOtpBtn;

    @BindView(R.id.resend_otp_btn)
    Button resendOtpBtn;

    @Inject
    OTPConfirmationContract.Presenter<OTPConfirmationContract.View> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_confirmation);

        ButterKnife.bind(this);

        getActivityComponent().inject(this);

        mPresenter.onAttach(this);

        mobileNum = getIntent().getStringExtra("Mobile");

        submitOtpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty(enterOtp.getText().toString())) {

                    if(getIntent().getBooleanExtra("ForgotPass", false)) {
                        startChangePassActivity();
                    }
                    else {
                        mPresenter.doOTPConfirmation(mobileNum, Integer.parseInt(enterOtp.getText().toString()));
                    }
                }
                else {
                    Toast.makeText(OTPConfirmation.this, "Enter OTP", Toast.LENGTH_SHORT).show();
                }
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                resendOtpBtn.setVisibility(View.VISIBLE);
            }
        }, 30000);

        resendOtpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.doResendOTP(mobileNum);
            }
        });
    }

    @Override
    public void startHomeActivity() {
        Intent homeIntent = new Intent(OTPConfirmation.this, HomeActivity.class);
        startActivity(homeIntent);
    }

    @Override
    public void startChangePassActivity() {
        Intent changePassIntent = new Intent(OTPConfirmation.this, ForgotPasswordActivity.class);
        changePassIntent.putExtra("Mobile", mobileNum);
        changePassIntent.putExtra("OTP", enterOtp.getText().toString());
        startActivity(changePassIntent);
    }
}

