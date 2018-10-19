package com.chaze.india.screens.PostOrderStatus.ActiveOrders;

import android.os.Bundle;

import com.chaze.india.screens.base.MvpContract;

import io.reactivex.subjects.PublishSubject;

public class ActiveOrdersContract {
    public interface View extends MvpContract.View{
        void onCreate(Bundle savedInstanceState);
        void setSubjectToAdapter(PublishSubject<String> subject);
        void showOnActivity();
        void showFull(String str);
    }
    public interface Presentor<V extends View> extends MvpContract.Presenter<V>{
        void show();
    }
}
