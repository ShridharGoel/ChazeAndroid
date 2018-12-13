package com.chaze.india.screens.ProductInfo;

import com.chaze.india.screens.base.MvpContract;
import com.chaze.india.screens.base.MvpContract;


/**
 * Created by Shubham Vishwakarma on 12/10/18.
 */

public class ProductInfoContract {

    public interface View extends MvpContract.View {

        void showData();


    }


    public interface Presenter<V extends View> extends MvpContract.Presenter<V> {

        void loadData();
    }
}
