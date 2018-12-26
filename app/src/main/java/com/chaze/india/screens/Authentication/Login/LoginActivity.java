package com.chaze.india.screens.Authentication.Login;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chaze.india.R;
import com.chaze.india.screens.Authentication.OTPConfirmation.OTPConfirmation;
import com.chaze.india.screens.Authentication.Signup.SignUpActivity;
import com.chaze.india.screens.Homepage.HomeActivity;
import com.chaze.india.screens.ProductInfo.ProductInfoActivity;
import com.chaze.india.screens.base.BaseActivity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import java.util.Random;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

/**
 post request on /login
 param: email or mobile
 password:

 return: {
    success:false/true
    error:
    token:secret key
    user:
 }

**/

/**
 * Created by Shridhar Goel on 14/10/18.
 */

public class LoginActivity extends BaseActivity implements LoginContract.View {

    private static final int RC_SIGN_IN = 10;
    private String forgotPassMobile;
    private int MAX_LENGTH = 12;

    @BindView(R.id.login_btn)
    TextView loginBtn;

    @BindView(R.id.signup_btn)
    TextView signupBtn;

    @BindView(R.id.skip_btn)
    Button skipBtn;

    @BindView(R.id.signup_enter_mobile)
    EditText loginMobile;

    @BindView(R.id.signup_enter_pass)
    EditText loginPass;

    @BindView(R.id.login_submit_btn)
    TextView loginSubmitBtn;

    @BindView(R.id.google_login)
    ImageView googleLogin;

    @BindView(R.id.fb_login)
    ImageView fbLogin;

    @BindView(R.id.forgot_pass)
    TextView forgotPass;

    GoogleSignInClient mGoogleSignInClient;

    @Inject
    LoginContract.Presenter<LoginContract.View> mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        getActivityComponent().inject(this);

        mPresenter.onAttach(this);

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
            if(!TextUtils.isEmpty(loginMobile.getText().toString()) && !TextUtils.isEmpty(loginPass.getText().toString())) {

                if(TextUtils.isDigitsOnly(loginMobile.getText().toString()))
                    mPresenter.doLogin(loginMobile.getText().toString(), loginPass.getText().toString());

                else
                    mPresenter.doLoginWithEmail(loginMobile.getText().toString(), loginPass.getText().toString());
            }

            else if(TextUtils.isEmpty(loginMobile.getText().toString()))
                Toast.makeText(this, "Please enter your mobile number.", Toast.LENGTH_SHORT).show();

            else if(TextUtils.isEmpty(loginPass.getText().toString()))
                Toast.makeText(this, "Please enter your password.", Toast.LENGTH_SHORT).show();
        });

        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                builder.setTitle("Enter your mobile number or email");

                // Set up the input
                final EditText input = new EditText(LoginActivity.this);

                // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS | InputType.TYPE_TEXT_VARIATION_PHONETIC);
                builder.setView(input);

                // Set up the buttons
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        forgotPassMobile = input.getText().toString();

                        if(TextUtils.isDigitsOnly(forgotPassMobile)) {
                            mPresenter.hasForgottenPassword(forgotPassMobile);
                        }
                        else {
                            mPresenter.hasForgottenPasswordWithEmail(forgotPassMobile);
                        }
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
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
        // Shop returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
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

            GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
            if (acct != null) {
                String personName = acct.getDisplayName();
                String personEmail = acct.getEmail();
                String personId = acct.getId();
                String pass = generateRandomString();
                final int[] gender = new int[1];

                AlertDialog.Builder b = new AlertDialog.Builder(this);
                b.setTitle("Select Gender");
                String[] types = {"Male", "Female"};
                b.setItems(types, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                        switch(which){
                            case 0:
                                gender[0] = 1;
                                break;
                            case 1:
                                gender[0] = 0;
                                break;
                        }
                        mPresenter.doGoogleLogin(personName, personEmail, gender[0], pass, personId);
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }

                });

                b.show();

            }
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Timber.w("signInResult:failed code=%s", e.getStatusCode());
            Toast.makeText(this, "Sign In failed. Error: " + e.getStatusCode(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void startHomeActivity() {
        Intent homeIntent = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(homeIntent);
        finish();
    }

    @Override
    public void startOTPConfirmationActivity() {
        Intent otpConfirmationIntent = new Intent(LoginActivity.this, OTPConfirmation.class);
        otpConfirmationIntent.putExtra("ForgotPass", true);
        otpConfirmationIntent.putExtra("Mobile", forgotPassMobile);
        startActivity(otpConfirmationIntent);
        finish();
    }

    public String generateRandomString() {
        Random generator = new Random();
        StringBuilder randomStringBuilder = new StringBuilder();
        int randomLength = generator.nextInt(MAX_LENGTH);
        char tempChar;
        for (int i = 0; i < randomLength; i++){
            tempChar = (char) (generator.nextInt(96) + 32);
            randomStringBuilder.append(tempChar);
        }
        return randomStringBuilder.toString();
    }
}
