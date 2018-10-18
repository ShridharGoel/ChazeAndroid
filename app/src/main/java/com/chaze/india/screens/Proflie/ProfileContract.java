package com.chaze.india.screens.Proflie;

import com.chaze.india.screens.base.MvpContract;
import com.chaze.india.screens.base.MvpContract;


/**
 * Created by Shubham Vishwakarma on 12/10/18.
 */

public class ProfileContract {

    public interface View extends MvpContract.View {


    }


    public interface Presentor<V extends View> extends MvpContract.Presenter<V> {

    }
}
