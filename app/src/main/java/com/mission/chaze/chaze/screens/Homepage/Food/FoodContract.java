package com.mission.chaze.chaze.screens.Homepage.Food;

import com.mission.chaze.chaze.screens.base.MvpContract;


/**
 * Created by Shubham Vishwakarma on 12/10/18.
 */

public class FoodContract {

    public interface View extends MvpContract.View {


    }


    public interface Presentor<V extends View> extends MvpContract.Presenter<V> {

    }
}
