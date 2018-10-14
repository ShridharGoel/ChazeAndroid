package com.mission.chaze.chaze.screens.Cart;

import com.mission.chaze.chaze.screens.base.MvpContract;

import io.reactivex.subjects.PublishSubject;


/**
 * Created by Shubham Vishwakarma on 12/10/18.
 */

public class CartContract {

    public interface View extends MvpContract.View {

        void setSubjectToAdapter(PublishSubject<String> subject);

        void showFull(String str);
    }


    public interface Presentor<V extends View> extends MvpContract.Presenter<V> {

    }
}
