package com.chaze.india.screens.Authentication.Signup;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.chaze.india.R;
import com.chaze.india.repository.session.SessionManager;
import com.chaze.india.screens.Authentication.Login.LoginActivity;
import com.chaze.india.screens.Homepage.HomeActivity;
import com.chaze.india.screens.PostOrderStatus.PostOrderStatusActivity;
import com.chaze.india.screens.base.BaseActivity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;


/**
 post request on /login
 param: req: password(min 8 length), gender(M/F) , name(String greater than 5), email or phone


 return: {
 success:true/false
 error:msg to show if success is false
 token:secret key
 user:
 }

 **/

/**
 * Created by Shridhar Goel on 14/10/18.
 */

public class SignUpActivity extends BaseActivity implements SignUpContract.View {

    private static final int RC_SIGN_IN = 10;

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
    Button signUpSubmitBtn;

    @BindView(R.id.google_login)
    ImageView googleLogin;

    @BindView(R.id.fb_login)
    ImageView fbLogin;

    GoogleSignInClient mGoogleSignInClient;

    @Inject
    SignUpContract.Presenter<SignUpContract.View> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);

        getActivityComponent().inject(this);

        getSupportActionBar().hide();
        loginBtn.setOnClickListener(view -> {
            Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            finish();
            overridePendingTransition(0, 0);
        });

        skipBtn.setOnClickListener(v -> {
            Intent intent = new Intent(SignUpActivity.this, PostOrderStatusActivity.class);
            startActivity(intent);
            finish();
        });

        signUpSubmitBtn.setOnClickListener(v -> {
            if (!TextUtils.isEmpty(signUpName.getText().toString())
                    && !TextUtils.isEmpty(signUpMobile.getText().toString())
                    && !TextUtils.isEmpty(signUpPass.getText().toString())
                    && !TextUtils.isEmpty(signUpConfirmPass.getText().toString())
                    && signUpPass.getText().toString().equals(signUpConfirmPass.getText().toString()))
            {
                /*mPresenter.doSignUp(signUpName.getText().toString(),
                                    signUpMobile.getText().toString(),
                                    signUpPass.getText().toString());
            */
                /*SharedPreferences.Editor editor=getSharedPreferences(PREF_NAME,MODE_PRIVATE).edit();
                editor.putString("phone",signUpMobile.getText().toString());
                editor.putString("name",signUpName.getText().toString());
                editor.apply();*/
                SessionManager sharedPreference=new SessionManager(getBaseContext());
                sharedPreference.setPhoneNo(signUpMobile.getText().toString());
                sharedPreference.setUserName(signUpName.getText().toString());
            }

            else if(TextUtils.isEmpty(signUpName.getText().toString())) {
                Toast.makeText(this, "Name cannot be blank", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(signUpMobile.getText().toString())) {
                Toast.makeText(this, "Mobile number cannot be blank", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(signUpPass.getText().toString())) {
                Toast.makeText(this, "Password cannot be blank", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(signUpConfirmPass.getText().toString())) {
                Toast.makeText(this, "Confirm password field cannot be blank", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Passwords do not match.", Toast.LENGTH_SHORT).show();
            }
        });

        googleLogin.setOnClickListener(v -> {
            // Configure sign-in to request the user's ID, email address, and basic
            // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
            GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestEmail()
                    .build();
            // Build a GoogleSignInClient with the options specified by gso.
            mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
            signIn();
        });
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            // Signed in successfully, show authenticated UI.
            Intent intent = new Intent(SignUpActivity.this, HomeActivity.class);
            startActivity(intent);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Timber.w("signInResult:failed code=%s", e.getStatusCode());
            Toast.makeText(this, "Sign In failed. Error: " + e.getStatusCode(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showSignUpResult() {
    }

}

