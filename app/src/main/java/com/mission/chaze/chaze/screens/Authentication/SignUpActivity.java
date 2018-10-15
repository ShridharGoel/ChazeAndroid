package com.mission.chaze.chaze.screens.Authentication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class SignUpActivity extends BaseActivity implements SignUpContract.View {

    @BindView(R.id.login_btn)
    Button loginBtn;

    @BindView(R.id.signup_btn)
    Button signupBtn;

    @BindView(R.id.skip_btn)
    Button skipBtn;

    @BindView(R.id.signup_enter_name)
    EditText signUpName;

    @BindView(R.id.signup_enter_mobile)
    EditText signUpMobile;

    @BindView(R.id.signup_enter_pass)
    EditText signUpPass;

    @BindView(R.id.signup_confirm_pass)
    EditText signUpConfirmPass;

    @BindView(R.id.signup_submit_btn)
    EditText signUpSubmitBtn;

    @Inject
    SignUpContract.Presenter<SignUpContract.View> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        ButterKnife.bind(this);

        getSupportActionBar().hide();

        loginBtn.setOnClickListener(view -> {
            Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            finish();
            overridePendingTransition(0, 0);
        });

        skipBtn.setOnClickListener(v -> {
            Intent intent = new Intent(SignUpActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        });

        signUpSubmitBtn.setOnClickListener(v -> {
            if(!TextUtils.isEmpty(signUpName.getText().toString())
                    && !TextUtils.isEmpty(signUpMobile.getText().toString())
                    && !TextUtils.isEmpty(signUpPass.getText().toString())
                    && !TextUtils.isEmpty(signUpConfirmPass.getText().toString())
                    && signUpPass.getText().toString().equals(signUpConfirmPass.getText().toString()))
            {
                mPresenter.doSignUp(signUpName.getText().toString(),
                                    signUpMobile.getText().toString(),
                                    signUpPass.getText().toString());
            }

            else if(TextUtils.isEmpty(signUpName.getText().toString()))
            {
                Toast.makeText(this, "Name cannot be blank", Toast.LENGTH_SHORT).show();
            }

            else if(TextUtils.isEmpty(signUpMobile.getText().toString()))
            {
                Toast.makeText(this, "Mobile number cannot be blank", Toast.LENGTH_SHORT).show();
            }

            else if(TextUtils.isEmpty(signUpPass.getText().toString()))
            {
                Toast.makeText(this, "Password cannot be blank", Toast.LENGTH_SHORT).show();
            }

            else if(TextUtils.isEmpty(signUpConfirmPass.getText().toString()))
            {
                Toast.makeText(this, "Confirm password field cannot be blank", Toast.LENGTH_SHORT).show();
            }

            else
            {
                Toast.makeText(this, "Passwords do not match.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void showSignUpResult()
    {

    }
}
