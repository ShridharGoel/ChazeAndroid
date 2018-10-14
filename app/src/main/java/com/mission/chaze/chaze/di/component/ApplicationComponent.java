package com.mission.chaze.chaze.di.component;

import android.app.Application;
import android.content.Context;

import com.mission.chaze.chaze.AppController;
import com.mission.chaze.chaze.di.ApplicationContext;
import com.mission.chaze.chaze.di.ApplicationScope;
import com.mission.chaze.chaze.di.module.ApplicationModule;
import com.mission.chaze.chaze.di.module.NetworkModule;
import com.mission.chaze.chaze.repository.CartManager;
import com.mission.chaze.chaze.repository.network.ICommonAPIManager;
import com.mission.chaze.chaze.repository.session.SessionManager;
import com.mission.chaze.chaze.screens.Authentication.LoginActivity;
import com.mission.chaze.chaze.utils.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Shubham Vishwakarma on 4/10/18.
 */
@ApplicationScope
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {


    void inject(AppController appController);

    SessionManager getSessionManager();


    CartManager getCartManager();

    ICommonAPIManager getICommonAPIManager();

    SchedulerProvider getSchedulerProvider();

}