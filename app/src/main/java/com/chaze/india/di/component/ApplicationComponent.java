package com.chaze.india.di.component;

import com.chaze.india.AppController;
import com.chaze.india.di.Qualifiers.ApplicationScope;
import com.chaze.india.di.module.ApplicationModule;
import com.chaze.india.di.module.NetworkModule;
import com.chaze.india.repository.CartManager;
import com.chaze.india.repository.network.ICommonAPIManager;
import com.chaze.india.repository.session.SessionManager;
import com.chaze.india.utils.rx.SchedulerProvider;

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