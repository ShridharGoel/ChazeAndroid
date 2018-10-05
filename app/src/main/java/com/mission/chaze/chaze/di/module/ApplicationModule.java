

package com.mission.chaze.chaze.di.module;

import android.app.Application;
import android.content.Context;


import com.mission.chaze.chaze.di.ApplicationContext;
import com.mission.chaze.chaze.di.ApplicationScope;
import com.mission.chaze.chaze.repository.CartManager;
import com.mission.chaze.chaze.repository.session.SessionManager;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Shubham Vishwakarma on 4/10/18.
 */

@Module
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
    SessionManager provideSessionManager(@ApplicationContext Context c){
        return new SessionManager(c);
    }

    @Provides
    @ApplicationScope
    CartManager cartManager(@ApplicationContext Context c){
        return new CartManager(c);
    }
}
