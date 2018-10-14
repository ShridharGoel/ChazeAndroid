package com.mission.chaze.chaze.screens.Homepage.Food;

import com.mission.chaze.chaze.models.EcomerceCategory;
import com.mission.chaze.chaze.models.Restaurant;
import com.mission.chaze.chaze.screens.base.MvpContract;

import java.util.List;


/**
 * Created by Shubham Vishwakarma on 12/10/18.
 */

public class FoodContract {

    public interface View extends MvpContract.View {

    }


    public interface Presenter<V extends View> extends MvpContract.Presenter<V> {

    }
}
