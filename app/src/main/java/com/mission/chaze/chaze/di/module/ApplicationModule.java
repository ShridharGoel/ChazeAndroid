

package com.mission.chaze.chaze.di.module;

import android.app.Application;
import android.content.Context;


import com.mission.chaze.chaze.di.ApplicationContext;

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
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }


}
