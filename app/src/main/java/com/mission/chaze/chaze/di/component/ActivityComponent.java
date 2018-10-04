

package com.mission.chaze.chaze.di.component;

import com.mission.chaze.chaze.di.PerActivity;
import com.mission.chaze.chaze.di.module.ActivityModule;
import com.mission.chaze.chaze.screens.Homepage.HomeActivity;
import com.mission.chaze.chaze.screens.Splash.SplashActivity;

import dagger.Component;

/**
 * Created by Shubham Vishwakarma on 4/10/18.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(HomeActivity activity);

    void inject(SplashActivity activity);

}
