package com.mission.chaze.chaze.screens.base;

/**
 * Created by Shubham Vishwakarma on 4/10/18.
 */

/**
 * Base interface that any class that wants to act as a View in the MVP (Model View Presenter)
 * pattern must implement. Generally this interface will be extended by a more specific interface
 * that then usually will be implemented by an Activity or Fragment.
 */
public interface SubMvpView extends MvpContract.View {

    void onCreate();

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

    void attachParentMvpView(MvpContract.View mvpView);
}
