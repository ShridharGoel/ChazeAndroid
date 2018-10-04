package com.mission.chaze.chaze.screens.base;



/**
 * Created by Shubham Vishwakarma on 4/10/18.
 */

public class MvpContract {


    public interface View {


    }

    public interface Presenter<V extends View> {

        void onAttach(V mvpView);

        void onDetach();

        void handleApiError(Exception error);

    }

}
