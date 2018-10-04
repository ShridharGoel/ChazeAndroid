package com.mission.chaze.chaze.di.component;

import android.app.Application;
import android.content.Context;

import com.mission.chaze.chaze.AppController;
import com.mission.chaze.chaze.di.ApplicationContext;
import com.mission.chaze.chaze.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Shubham Vishwakarma on 4/10/18.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(AppController app);


    @ApplicationContext
    Context context();

    Application application();

}