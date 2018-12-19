package com.chaze.india.screens.Shop;

import com.chaze.india.models.CategorySearchResults;
import com.chaze.india.models.Ecommerce.EcomerceCategory;
import com.chaze.india.models.Ecommerce.Post;
import com.chaze.india.models.Ecommerce.SubCategory;
import com.chaze.india.screens.base.MvpContract;

import java.util.List;


/**
 * Created by Shubham Vishwakarma on 12/10/18.
 */

public class ShopContract {


    public interface View extends MvpContract.View {
        void showData(CategorySearchResults results);

        void addItems(List<Post> items);

        String getShop();

        String getCategory();

        void showCategories(List<SubCategory> results);
    }


    public interface Presenter<V extends ShopContract.View> extends MvpContract.Presenter<V> {

        void subscribeForData(int page);

        void next();

        void getSubCategories();

        void getProducts();
    }
}
