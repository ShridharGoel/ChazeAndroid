package com.chaze.india.screens.Homepage.Food;

import com.chaze.india.screens.base.MvpContract;
import com.chaze.india.models.EcomerceCategory;
import com.chaze.india.models.Restaurant;
import com.chaze.india.screens.base.MvpContract;


/**
 * Created by Shubham Vishwakarma on 12/10/18.
 */

public class FoodContract {

    public interface View extends MvpContract.View {

    }


    public interface Presenter<V extends View> extends MvpContract.Presenter<V> {

    }
}
