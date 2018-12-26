package com.chaze.india.screens.Category;

import com.chaze.india.models.Ecommerce.ShopForCategory;
import com.chaze.india.screens.base.MvpContract;
import com.chaze.india.models.CategorySearchResults;

import java.util.List;


/**
 * Created by Shubham Vishwakarma on 12/10/18.
 */

public class CategoryContract {

    public interface View extends MvpContract.View {

        Long getCategory();

        void addShops(List<ShopForCategory> shopForCategories);
    }


    public interface Presenter<V extends View> extends MvpContract.Presenter<V> {

        void getShops();
    }
}
