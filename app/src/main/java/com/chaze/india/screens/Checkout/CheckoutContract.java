package com.chaze.india.screens.Checkout;

import com.chaze.india.models.Authentication.User;
import com.chaze.india.screens.base.MvpContract;


/**
 * Created by Shubham Vishwakarma on 12/10/18.
 */

public class CheckoutContract {

    public interface View extends MvpContract.View {
        void showDetails(User user);
    }


    public interface Presenter<V extends View> extends MvpContract.Presenter<V> {
        void getDetails();

        void placeOrder(Long userMobile, String userAdress);
    }
}
