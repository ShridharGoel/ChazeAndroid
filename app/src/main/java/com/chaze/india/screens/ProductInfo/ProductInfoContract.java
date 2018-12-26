package com.chaze.india.screens.ProductInfo;

import android.widget.TextView;

import com.chaze.india.models.Ecommerce.CartItem;
import com.chaze.india.models.Ecommerce.Product;
import com.chaze.india.screens.base.MvpContract;


/**
 * Created by Shubham Vishwakarma on 12/10/18.
 */

public class ProductInfoContract {

    public interface View extends MvpContract.View {

        void showData(CartItem ci);


    }


    public interface Presenter<V extends View> extends MvpContract.Presenter<V> {


        void loadData(Product product);

        int getItemsCount();

        void addItems(Product id, Long quantity, String description, TextView cartCountBadge);
    }
}
