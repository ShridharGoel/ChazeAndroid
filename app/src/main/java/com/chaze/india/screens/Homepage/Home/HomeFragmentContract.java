package com.chaze.india.screens.Homepage.Home;

import com.chaze.india.screens.base.MvpContract;
import com.chaze.india.models.EcomerceCategory;
import com.chaze.india.models.EcomerceShop;
import com.chaze.india.screens.base.MvpContract;

import java.util.List;


/**
 * Created by Shubham Vishwakarma on 12/10/18.
 */

public class HomeFragmentContract {

    public interface View extends MvpContract.View {
        void addItems(List<EcomerceCategory> items);

    }


    public interface Presentor<V extends View> extends MvpContract.Presenter<V> {
        void subscribeForData();

        void next();
    }
}
