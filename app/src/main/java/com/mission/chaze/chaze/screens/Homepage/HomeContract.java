package com.mission.chaze.chaze.screens.Homepage;

import com.mission.chaze.chaze.screens.base.MvpContract;


/**
 * Created by Shubham Vishwakarma on 4/10/18.
 */

public class HomeContract {

    public interface View extends MvpContract.View {

        void openLoginActivity();

        void openMainActivity();

    }


    public interface Presentor<V extends View> extends MvpContract.Presenter<V> {

    }
}
