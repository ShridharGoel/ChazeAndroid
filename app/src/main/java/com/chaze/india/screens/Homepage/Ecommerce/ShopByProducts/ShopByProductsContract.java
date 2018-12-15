package com.chaze.india.screens.Homepage.Ecommerce.ShopByProducts;

import com.chaze.india.models.Ecommerce.Post;
import com.chaze.india.screens.base.MvpContract;
import com.chaze.india.models.Ecommerce.EcomerceCategory;

import java.util.List;


/**
 * Created by Shubham Vishwakarma on 12/10/18.
 */

public class ShopByProductsContract {

    public interface View extends MvpContract.View {



        void addItems(List<Post> items);
    }


    public interface Presenter<V extends View> extends MvpContract.Presenter<V> {
        void subscribeForData(int limit);
        void next();
    }
}
