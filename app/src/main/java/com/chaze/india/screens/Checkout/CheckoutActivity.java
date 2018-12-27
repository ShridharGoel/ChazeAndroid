package com.chaze.india.screens.Checkout;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.chaze.india.R;
import com.chaze.india.models.Authentication.User;
import com.chaze.india.screens.base.BaseActivity;
import com.google.android.gms.auth.GoogleAuthException;

import java.text.DecimalFormat;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;

public class CheckoutActivity extends BaseActivity implements CheckoutContract.View {

    @BindView(R.id.checkoutAltPhone)
    EditText checkoutAltPhone;
    @BindView(R.id.checkoutEmail)
    EditText checkoutEmail;
    @BindView(R.id.checkoutName)
    EditText checkoutName;
    @BindView(R.id.checkoutPhone)
    EditText checkoutPhone;
    @BindView(R.id.checkoutAddress)
    EditText checkoutAddress;

    @BindView(R.id.cod_pay_button)
    Button button;
    @Inject
    CheckoutContract.Presenter<CheckoutContract.View> presenter;

    @BindView(R.id.editCheckoutPhone)
    ImageView phoneImage;

    @BindView(R.id.editCheckoutEmail)
    ImageView emailImage;

    @BindView(R.id.editCheckoutAddress)
    ImageView addressImage;

    @BindView(R.id.editCheckoutName)
    ImageView nameImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        presenter.onAttach(this);
        presenter.getDetails();


    }

    @Override
    public void showDetails(User user) {
        if (user.getName() != null)
            checkoutName.setText(user.getName());
        else {
            nameImage.setVisibility(View.GONE);
            makeViewTrue(checkoutName);
        }
        if (user.getAddress() != null)
            checkoutAddress.setText(user.getAddress());
        else {
            makeViewTrue(checkoutAddress);
            addressImage.setVisibility(View.GONE);
        }
        if (user.getLastVerifiedPhone() != null) {
            String phone = Long.toString(user.getLastVerifiedPhone(), 10);
            checkoutPhone.setText("" + phone);
        } else {
            makeViewTrue(checkoutPhone);
            phoneImage.setVisibility(View.GONE);
        }
        if (user.getEmail() != null)
            checkoutEmail.setText(user.getEmail());
        else {
            makeViewTrue(checkoutEmail);
            emailImage.setVisibility(View.GONE);
        }
        button.setOnClickListener(v -> {
            if (checkDetails()) {
                processOrder();
            }
        });
    }

    private void processOrder() {
        String userName = checkoutName.getText().toString().trim();
        String userEmail = checkoutEmail.getText().toString().trim();
        Long userMobile = Long.valueOf(checkoutPhone.getText().toString().trim());
        String userAdress = checkoutAddress.getText().toString().trim();
        String userSecondPhone = checkoutAltPhone.getText().toString().trim();
        Timber.e("Yipeee");
        Toast.makeText(this, "Yip[eee", Toast.LENGTH_SHORT).show();

        presenter.placeOrder(userMobile, userAdress);
    }

    private boolean checkDetails() {
        String userName = checkoutName.getText().toString().trim();
        String userEmail = checkoutEmail.getText().toString().trim();
        String userMobile = checkoutPhone.getText().toString().trim();
        String userAdress = checkoutAddress.getText().toString().trim();
        String userSecondPhone = checkoutAltPhone.getText().toString().trim();

        if (userName.equals(null) || userName.isEmpty()) {
            checkoutName.setError("Enter Your Name");
            if (nameImage.getVisibility() != View.GONE) addressImage.setVisibility(View.GONE);
            requestFocus(checkoutName);
            makeViewTrue(checkoutName);
            return false;
        } else if (userMobile.length() < 10 || userMobile.length() > 10) {
            checkoutPhone.setError("Invalid Mobile Number");
            Toast.makeText(this, "Invalid Mobile Number", Toast.LENGTH_SHORT).show();
            checkoutPhone.setText("");
            if (phoneImage.getVisibility() != View.GONE) addressImage.setVisibility(View.GONE);
            requestFocus(checkoutPhone);
            makeViewTrue(checkoutPhone);
            return false;
        } else if (userEmail.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()) {
            checkoutEmail.setError("Invalid Email Address");
            Toast.makeText(this, "Invalid Email Address", Toast.LENGTH_SHORT).show();
            if (emailImage.getVisibility() != View.GONE) addressImage.setVisibility(View.GONE);
            makeViewTrue(checkoutEmail);
            requestFocus(checkoutEmail);
            return false;
        } else if (userAdress.equals(null) || userAdress.isEmpty()) {
            checkoutAddress.setError("Enter Your Address");
            makeViewTrue(checkoutAddress);
            if (addressImage.getVisibility() != View.GONE) addressImage.setVisibility(View.GONE);
            Toast.makeText(this, "Enter Your Address", Toast.LENGTH_SHORT).show();
            requestFocus(checkoutAddress);
            return false;
        }
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

 /*   public void makeViewFalse(EditText editText) {
        editText.setEnabled(false);
        editText.setFocusable(false);
        editText.setCursorVisible(false);
        editText.setText(editText.getText().toString());
    }*/

    public void makeViewTrue(EditText editText) {
        editText.setEnabled(true);
        editText.setFocusable(true);
        editText.setCursorVisible(true);
    }

    @OnClick({R.id.editCheckoutName, R.id.editCheckoutEmail, R.id.editCheckoutPhone, R.id.editCheckoutAddress})
    public void OnClick(ImageView imageView) {
        imageView.setVisibility(View.GONE);
        switch (imageView.getId()) {
            case R.id.editCheckoutName:
                makeViewTrue(checkoutName);
                break;
            case R.id.editCheckoutEmail:
                makeViewTrue(checkoutEmail);
                break;
            case R.id.editCheckoutPhone:
                makeViewTrue(checkoutPhone);
                break;
            case R.id.editCheckoutAddress:
                makeViewTrue(checkoutAddress);
                break;
        }
    }


}
