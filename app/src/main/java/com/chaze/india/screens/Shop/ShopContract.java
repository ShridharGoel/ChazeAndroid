package com.chaze.india.screens.Shop;

import com.chaze.india.models.CategorySearchResults;
import com.chaze.india.models.EcomerceCategory;
import com.chaze.india.screens.SubCategory.SubCategoryContract;
import com.chaze.india.screens.base.MvpContract;
import com.chaze.india.screens.base.MvpContract;

import java.util.List;


/**
 * Created by Shubham Vishwakarma on 12/10/18.
 */

public class ShopContract {


    public interface View extends MvpContract.View {
        void showData(CategorySearchResults results);

        void addItems(List<EcomerceCategory> items);
    }


    public interface Presenter<V extends ShopContract.View> extends MvpContract.Presenter<V> {

        void subscribeForData();

        void next();
    }
}
