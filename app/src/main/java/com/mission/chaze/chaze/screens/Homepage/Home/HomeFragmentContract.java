package com.mission.chaze.chaze.screens.Homepage.Home;

import com.mission.chaze.chaze.models.EcomerceCategory;
import com.mission.chaze.chaze.models.EcomerceShop;
import com.mission.chaze.chaze.models.RecyclerItems;
import com.mission.chaze.chaze.screens.base.MvpContract;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Shubham Vishwakarma on 12/10/18.
 */

public class HomeFragmentContract {

    public interface View extends MvpContract.View {
        void addItems(List<EcomerceCategory> items);
        ArrayList<RecyclerItems> loadCards();

    }


    public interface Presentor<V extends View> extends MvpContract.Presenter<V> {
        void subscribeForData();

        void next();
    }
}
