package com.mission.chaze.chaze.screens.search;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mission.chaze.chaze.R;
import com.mission.chaze.chaze.screens.base.BaseActivity;

public class SearchActivity extends BaseActivity implements SearchContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }
}
