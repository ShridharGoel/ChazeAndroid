package com.mission.chaze.chaze.screens.Proflie;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

import com.mission.chaze.chaze.R;
import com.mission.chaze.chaze.repository.session.ISessionManager;
import com.mission.chaze.chaze.repository.session.SessionManager;
import com.mission.chaze.chaze.screens.base.BaseActivity;

import javax.annotation.Nullable;
import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

import static com.mission.chaze.chaze.R.*;

public class ProfileActivity extends BaseActivity {

    @BindView(R.id.profile_name)
    EditText name;
    @BindView(R.id.profile_phone)
    EditText phone;
    @BindView(R.id.profile_email)
    EditText email;
    @BindView(R.id.profile_gender)
    EditText gender;
    @BindView(R.id.profile_address)
    EditText address;
    @BindView(id.editName)
    ImageView editName;
    @BindView(id.editPhone)
    ImageView editPhone;
    @BindView(id.editEmail)
    ImageView editEmail;
    @BindView(id.editGender)
    ImageView editGender;
    @BindView(id.editAddress)
    ImageView editAddress;

    //   @Inject

    SessionManager sharedPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_profile);

        ButterKnife.bind(this);
        // getActivityComponent().inject(this);

        sharedPreference = new SessionManager(getApplicationContext());

        displayDetails();


        editName.setOnClickListener(view -> {
            name.setEnabled(true);
            name.setFocusable(true);
            name.setCursorVisible(true);
            editName.setImageResource(drawable.common_google_signin_btn_icon_dark);
            editName.setOnClickListener(view1 -> {
                name.setEnabled(false);
                name.setFocusable(false);
                name.setCursorVisible(false);
                sharedPreference.setUserName(name.getText().toString());
                name.setText(name.getText().toString());
                editName.setImageResource(drawable.ic_edit_black_24dp);
            });
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
        });

        editPhone.setOnClickListener(view -> {
            phone.setEnabled(true);
            phone.setFocusable(true);
            phone.setCursorVisible(true);
            editPhone.setImageResource(drawable.common_google_signin_btn_icon_dark);
            editPhone.setOnClickListener(view12 -> {
                phone.setEnabled(false);
                phone.setFocusable(false);
                phone.setCursorVisible(false);
                sharedPreference.setUserName(phone.getText().toString());
                phone.setText(phone.getText().toString());
                editPhone.setImageResource(drawable.ic_edit_black_24dp);
            });
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
        });

        editEmail.setOnClickListener(view -> {
            email.setEnabled(true);
            email.setFocusable(true);
            email.setCursorVisible(true);
            editEmail.setImageResource(drawable.common_google_signin_btn_icon_dark);
            name.setFocusable(false);
            name.setCursorVisible(false);
            sharedPreference.setUserName(name.getText().toString());
            name.setText(name.getText().toString());
            editName.setImageResource(drawable.ic_edit_black_24dp);
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
        });

        editGender.setOnClickListener(view -> {
            gender.setEnabled(true);
            gender.setFocusable(true);
            gender.setCursorVisible(true);
            editGender.setImageResource(drawable.common_google_signin_btn_icon_dark);
            gender.setFocusable(false);
            gender.setCursorVisible(false);
            sharedPreference.setUserName(gender.getText().toString());
            gender.setText(gender.getText().toString());
            editGender.setImageResource(drawable.ic_edit_black_24dp);
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
        });

        editAddress.setOnClickListener(view -> {
            address.setEnabled(true);
            address.setFocusable(true);
            address.setCursorVisible(true);
            editAddress.setImageResource(drawable.common_google_signin_btn_icon_dark);
            address.setFocusable(false);
            address.setCursorVisible(false);
            sharedPreference.setUserName(address.getText().toString());
            address.setText(address.getText().toString());
            editAddress.setImageResource(drawable.ic_edit_black_24dp);
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
        });


    }

    private void displayDetails() {

        //sharedPreference.setUserName("asdfsd");

        name.setText(sharedPreference.getUserName());
        phone.setText(sharedPreference.getPhoneNo());
        email.setText(sharedPreference.getUserEmail());
        gender.setText(sharedPreference.getGender());
        address.setText(sharedPreference.getAddress());
    }
}
