

package com.mission.chaze.chaze.screens.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.mission.chaze.chaze.AppController;
import com.mission.chaze.chaze.di.component.ActivityComponent;
import com.mission.chaze.chaze.di.component.DaggerActivityComponent;
import com.mission.chaze.chaze.di.module.ActivityModule;


/**
 * Created by Shubham Vishwakarma on 4/10/18.
 */

public abstract class BaseActivity extends AppCompatActivity
        implements MvpContract.View {

    ActivityComponent mActivityComponent;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((AppController) getApplication()).getComponent())
                .build();

    }

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

}
