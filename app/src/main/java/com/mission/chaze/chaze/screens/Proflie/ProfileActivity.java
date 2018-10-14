package com.mission.chaze.chaze.screens.Proflie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.mission.chaze.chaze.R;

import butterknife.BindView;

public class ProfileActivity extends AppCompatActivity {

    @BindView(R.id.profile_name)
     EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


    }
}
