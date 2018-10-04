package com.mission.chaze.chaze;

import android.app.Application;

import com.mission.chaze.chaze.di.component.ApplicationComponent;
import com.mission.chaze.chaze.di.component.DaggerApplicationComponent;
import com.mission.chaze.chaze.di.module.ApplicationModule;

public class AppController extends Application {

    ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }
}
