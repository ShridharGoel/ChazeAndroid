

package com.mission.chaze.chaze.screens.Splash;

import com.mission.chaze.chaze.screens.base.BasePresenter;


/**
 * Created by Shubham Vishwakarma on 4/10/18.
 */

public class SplashPresenter<V extends SplashContract.View> extends BasePresenter<V>
        implements SplashContract.Presentor<V> {
    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void handleApiError(Exception error) {
        super.handleApiError(error);
    }
}
