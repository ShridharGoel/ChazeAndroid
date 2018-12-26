package com.chaze.india.screens.Profile;

import com.chaze.india.models.Authentication.User;
import com.chaze.india.screens.base.MvpContract;
import com.chaze.india.screens.base.MvpContract;

import java.util.List;


/**
 * Created by Shubham Vishwakarma on 12/10/18.
 */

public class ProfileContract {

    public interface View extends MvpContract.View {
        void saveDetails(User user);
    }


    public interface Presenter<V extends View> extends MvpContract.Presenter<V> {
        void fetchDetails();
    }
}