package com.mission.chaze.chaze.screens.Authentication;

import com.mission.chaze.chaze.screens.base.MvpContract;


/**
 * Created by Shubham Vishwakarma on 12/10/18.
 */

public class LoginContract {

    public interface View extends MvpContract.View {

        void showloginResult();

    }


    public interface Presenter<V extends View> extends MvpContract.Presenter<V> {
        void doLogin(String mobile, String pass);
    }
}
