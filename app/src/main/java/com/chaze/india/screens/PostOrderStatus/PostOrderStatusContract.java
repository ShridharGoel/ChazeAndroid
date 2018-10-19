package com.chaze.india.screens.PostOrderStatus;

import android.os.Bundle;

import com.chaze.india.screens.PostOrderStatus.ActiveOrders.ActiveOrdersFragment;
import com.chaze.india.screens.base.MvpContract;
import com.chaze.india.screens.base.MvpContract;


/**
 * Created by Shubham Vishwakarma on 12/10/18.
 */

public class PostOrderStatusContract {

    public interface View extends MvpContract.View {


        void onCreate(Bundle savedInstanceState);
    }


    public interface Presentor<V extends View> extends MvpContract.Presenter<V> {


    }
}
