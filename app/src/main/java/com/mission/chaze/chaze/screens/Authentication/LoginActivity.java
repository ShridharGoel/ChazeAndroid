package com.mission.chaze.chaze.screens.Authentication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.mission.chaze.chaze.R;
import com.mission.chaze.chaze.screens.Homepage.HomeActivity;
import com.mission.chaze.chaze.screens.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

import static com.mission.chaze.chaze.repository.session.SessionManager.PREF_NAME;

public class LoginActivity extends BaseActivity implements LoginContract.View {

    private static final int RC_SIGN_IN = 10;

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

    @BindView(R.id.google_login)
    ImageView googleLogin;

    @BindView(R.id.fb_login)
    ImageView fbLogin;

    GoogleSignInClient mGoogleSignInClient;

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
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Timber.w("signInResult:failed code=%s", e.getStatusCode());
            Toast.makeText(this, "Sign In failed. Error: " + e.getStatusCode(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showloginResult() {
    }
}
