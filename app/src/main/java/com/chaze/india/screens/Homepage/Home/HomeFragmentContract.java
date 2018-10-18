package com.chaze.india.screens.Homepage.Home;

import com.chaze.india.models.EcomerceCategory;
import com.chaze.india.models.RecyclerItems;
import com.chaze.india.screens.base.MvpContract;

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
