
package com.mission.chaze.chaze.screens.base;

/**
 * Created by Shubham Vishwakarma on 4/10/18.
 */


/**
 * Base class that implements the Presenter interface and provides a base implementation for
 * onAttach() and onDetach(). It also handles keeping a reference to the mvpView that
 * can be accessed from the children classes by calling getMvpView().
 */

public class BasePresenter<V extends MvpContract.View> implements MvpContract.Presenter<V> {


    @Override
    public void onAttach(V mvpView) {

    }

    @Override
    public void onDetach() {

    }

    @Override
    public void handleApiError(Exception error) {

    }

}
