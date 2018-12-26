

package com.chaze.india.di.module;

import android.app.Application;
import android.content.Context;


import com.chaze.india.di.Qualifiers.ApplicationContext;
import com.chaze.india.di.Qualifiers.ApplicationScope;
import com.chaze.india.repository.CartManager;
import com.chaze.india.repository.CartManager;import com.chaze.india.repository.network.ICommonAPIManager;
import com.chaze.india.repository.session.SessionManager;
import com.chaze.india.utils.rx.AppSchedulerProvider;
import com.chaze.india.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Shubham Vishwakarma on 4/10/18.
 */

@Module(includes = NetworkModule.class)
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    @ApplicationScope
    Context provideContext() {
        return mApplication;
    }


    @Provides
    @ApplicationScope
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationScope
    SessionManager provideSessionManager(@ApplicationContext Context c) {
        return new SessionManager(c);
    }

    @Provides
    @ApplicationScope
    CartManager cartManager(@ApplicationContext Context c, SessionManager sessionManager, ICommonAPIManager commonAPIManager) {
        return new CartManager(c, sessionManager, commonAPIManager);
    }

    @Provides
    @ApplicationScope
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

}
