package com.chaze.india.screens.Cart.EcommerceCart;

import com.chaze.india.screens.base.MvpContract;

import io.reactivex.subjects.PublishSubject;


/**
 * Created by Shubham Vishwakarma on 12/10/18.
 */

public class CartContract {

    public interface View extends MvpContract.View {

        void setSubjectToAdapter(PublishSubject<String> subject);

        void showFull(String str);

        void showOnActivity();
    }


    public interface Presenter<V extends View> extends MvpContract.Presenter<V> {

        void show();
    }
}
