package com.chaze.india.screens.Purchases;

import android.os.Bundle;

import com.chaze.india.screens.base.MvpContract;


/**
 * Created by Shubham Vishwakarma on 12/10/18.
 */

public class PurchasesContract {

    public interface View extends MvpContract.View {


        void onCreate(Bundle savedInstanceState);
    }


    public interface Presenter<V extends View> extends MvpContract.Presenter<V> {


    }
}
