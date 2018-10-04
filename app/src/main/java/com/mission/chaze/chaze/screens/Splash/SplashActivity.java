/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.mission.chaze.chaze.screens.Splash;


import android.os.Bundle;
import android.support.annotation.Nullable;

import com.mission.chaze.chaze.R;
import com.mission.chaze.chaze.screens.base.BaseActivity;

/**
 * Created by Shubham Vishwakarma on 4/10/18.
 */

public class SplashActivity extends BaseActivity implements SplashContract.View {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void openLoginActivity() {

    }

    @Override
    public void openHomeActivity() {

    }

}
