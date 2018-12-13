package com.chaze.india.screens.Homepage.Ecommerce.ShopByShops;

import com.chaze.india.models.Ecommerce.Shop;
import com.chaze.india.models.Ecommerce.ShopListResponse;
import com.chaze.india.screens.base.MvpContract;

import java.util.List;


/**
 * Created by Shubham Vishwakarma on 12/10/18.
 */

public class ShopByShopsContract {

    public interface View extends MvpContract.View {
        void addItems(List<Shop> items);

        void showShops(ShopListResponse shplstrspns);

        void showError();
    }


    public interface Presenter<V extends View> extends MvpContract.Presenter<V> {
        void subscribeForData();

        void next();
    }
}
