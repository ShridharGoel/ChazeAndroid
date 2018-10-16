package com.mission.chaze.chaze.screens.Checkout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import com.mission.chaze.chaze.R;
import com.mission.chaze.chaze.repository.session.SessionManager;
import com.mission.chaze.chaze.screens.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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

    SessionManager sharedPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        setUnBinder(ButterKnife.bind(this));

        sharedPreference = new SessionManager(getApplicationContext());
        setExistingData();

    }

    private void setExistingData() {
        checkoutName.setText(sharedPreference.getUserName());
        checkoutAddress.setText(sharedPreference.getAddress());
        checkoutPhone.setText(sharedPreference.getPhoneNo());
        checkoutEmail.setText(sharedPreference.getUserEmail());
    }

    @OnClick({R.id.editCheckoutName,R.id.editCheckoutEmail,R.id.editCheckoutPhone,R.id.editCheckoutAddress})
    public void OnClick(ImageView imageView){
        switch (imageView.getId()){
            case R.id.editCheckoutName:
                checkoutName.setEnabled(true);
                checkoutName.setFocusable(true);
                checkoutName.setCursorVisible(true);
                imageView.setImageResource(R.drawable.common_google_signin_btn_icon_dark);
                imageView.setOnClickListener(view1 -> {
                    checkoutName.setEnabled(false);
                    checkoutName.setFocusable(false);
                    checkoutName.setCursorVisible(false);
                    sharedPreference.setUserName(checkoutName.getText().toString());
                    checkoutName.setText(checkoutName.getText().toString());
                    imageView.setImageResource(R.drawable.ic_edit_black_24dp);
        });break;
            case R.id.editCheckoutEmail:
                checkoutEmail.setEnabled(true);
                checkoutEmail.setFocusable(true);
                checkoutEmail.setCursorVisible(true);
                imageView.setImageResource(R.drawable.common_google_signin_btn_icon_dark);
                imageView.setOnClickListener(view1 -> {
                    checkoutEmail.setEnabled(false);
                    checkoutEmail.setFocusable(false);
                    checkoutEmail.setCursorVisible(false);
                    sharedPreference.setUserEmail(checkoutEmail.getText().toString());
                    checkoutEmail.setText(checkoutEmail.getText().toString());
                    imageView.setImageResource(R.drawable.ic_edit_black_24dp);
                });break;
            case R.id.editCheckoutPhone:
                checkoutPhone.setEnabled(true);
                checkoutPhone.setFocusable(true);
                checkoutPhone.setCursorVisible(true);
                imageView.setImageResource(R.drawable.common_google_signin_btn_icon_dark);
                imageView.setOnClickListener(view1 -> {
                    checkoutPhone.setEnabled(false);
                    checkoutPhone.setFocusable(false);
                    checkoutPhone.setCursorVisible(false);
                    sharedPreference.setPhoneNo(checkoutPhone.getText().toString());
                    checkoutPhone.setText(checkoutPhone.getText().toString());
                    imageView.setImageResource(R.drawable.ic_edit_black_24dp);
                });break;
            case R.id.editCheckoutAddress:
                checkoutAddress.setEnabled(true);
                checkoutAddress.setFocusable(true);
                checkoutAddress.setCursorVisible(true);
                imageView.setImageResource(R.drawable.common_google_signin_btn_icon_dark);
                imageView.setOnClickListener(view1 -> {
                    checkoutAddress.setEnabled(false);
                    checkoutAddress.setFocusable(false);
                    checkoutAddress.setCursorVisible(false);
                    sharedPreference.setAddress(checkoutAddress.getText().toString());
                    checkoutAddress.setText(checkoutAddress.getText().toString());
                    imageView.setImageResource(R.drawable.ic_edit_black_24dp);
                });break;
    }
}
}
