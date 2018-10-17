package com.chaze.india.screens.base;


/**
 * Created by Shubham Vishwakarma on 4/10/18.
 */

public class MvpContract {


    public interface View {
        void showLoading();

        void hideLoading();

        void onError(String message);

        void showMessage(String message);

        boolean isNetworkConnected();

        void hideKeyboard();

    }

    public interface Presenter<V extends View> {

        void onAttach(V mvpView);

        void onDetach();

        void handleApiError(Exception error);

    }

}
