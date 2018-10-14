package com.mission.chaze.chaze.screens.Authentication;

import com.mission.chaze.chaze.screens.base.MvpContract;

/**
 * Created by Shridhar Goel on 14/10/18.
 */
public class SignUpContract {

    public interface View extends MvpContract.View {

        void showSignUpResult();

    }


    public interface Presenter<V extends View> extends MvpContract.Presenter<V> {
        void doSignUp(String name, String mobile, String pass);
    }
}
