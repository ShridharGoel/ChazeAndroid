package com.chaze.india.screens.RestaurantMenu;

import android.widget.SearchView;

import com.chaze.india.screens.base.MvpContract;


/**
 * Created by Shubham Vishwakarma on 4/10/18.
 */

public class RestaurantMenuContract {

    public interface View extends MvpContract.View {

    }


    public interface Presenter<V extends View> extends MvpContract.Presenter<V> {

    }
}
