package com.mission.chaze.chaze.screens.Homepage.Ecommerce.ShopByProducts;

import android.support.v7.widget.RecyclerView;

import com.mission.chaze.chaze.models.EcomerceCategory;
import com.mission.chaze.chaze.screens.base.MvpContract;

import java.util.List;


/**
 * Created by Shubham Vishwakarma on 12/10/18.
 */

public class ShopByProductsContract {

    public interface View extends MvpContract.View {



        void addItems(List<EcomerceCategory> items);
    }


    public interface Presentor<V extends View> extends MvpContract.Presenter<V> {
        void subscribeForData();
        void next();
    }
}
