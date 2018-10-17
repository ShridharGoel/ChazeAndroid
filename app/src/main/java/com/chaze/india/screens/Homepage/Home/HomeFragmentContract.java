package com.chaze.india.screens.Homepage.Home;

<<<<<<< HEAD:app/src/main/java/com/mission/chaze/chaze/screens/Homepage/Home/HomeFragmentContract.java
import com.mission.chaze.chaze.models.EcomerceCategory;
import com.mission.chaze.chaze.models.EcomerceShop;
import com.mission.chaze.chaze.models.RecyclerItems;
import com.mission.chaze.chaze.screens.base.MvpContract;
=======
import com.chaze.india.screens.base.MvpContract;
import com.chaze.india.models.EcomerceCategory;
import com.chaze.india.models.EcomerceShop;
import com.chaze.india.screens.base.MvpContract;
>>>>>>> b37de7518fd978e79ba696064a9e43d13a376659:app/src/main/java/com/chaze/india/screens/Homepage/Home/HomeFragmentContract.java

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
