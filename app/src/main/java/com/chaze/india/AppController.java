package com.chaze.india;

import android.app.Application;

import com.chaze.india.di.component.ApplicationComponent;
import com.chaze.india.di.component.DaggerApplicationComponent;
import com.chaze.india.di.module.ApplicationModule;
import com.chaze.india.repository.CartManager;
import com.chaze.india.repository.CartManager;import com.chaze.india.repository.network.ICommonAPIManager;
import com.chaze.india.repository.session.SessionManager;
import com.chaze.india.utils.TimberLogger;
import com.squareup.leakcanary.LeakCanary;

import javax.inject.Inject;

import timber.log.Timber;

public class AppController extends Application {

    private static ApplicationComponent mApplicationComponent;

    @Inject
    CartManager cartManager;

    @Inject
    SessionManager mSessionManager;

    @Inject
    ICommonAPIManager iCommonAPIManager;




    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);


        init();


    }

    private void init() {
        if (BuildConfig.DEBUG) Timber.plant(new TimberLogger());

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
