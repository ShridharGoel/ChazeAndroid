package com.mission.chaze.chaze;

import android.app.Application;

import com.mission.chaze.chaze.di.component.ApplicationComponent;
import com.mission.chaze.chaze.di.component.DaggerApplicationComponent;
import com.mission.chaze.chaze.di.module.ApplicationModule;
import com.mission.chaze.chaze.utils.TimberLogger;
import com.squareup.leakcanary.LeakCanary;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import timber.log.Timber;

public class AppController extends Application {

    ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        init();

    }

    private void init() {
        if (!BuildConfig.DEBUG) Timber.plant(new TimberLogger());

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }
}
