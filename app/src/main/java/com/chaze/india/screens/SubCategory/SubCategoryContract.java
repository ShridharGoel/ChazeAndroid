package com.chaze.india.screens.SubCategory;

import com.chaze.india.models.CategorySearchResults;
import com.chaze.india.models.Ecommerce.EcomerceCategory;
import com.chaze.india.models.Ecommerce.Post;
import com.chaze.india.screens.base.MvpContract;

import java.util.List;


/**
 * Created by Shubham Vishwakarma on 16/10/18.
 */

public class SubCategoryContract {

    public interface View extends MvpContract.View {
        void showData(CategorySearchResults results);

        void addItems(List<Post> items);
    }


    public interface Presenter<V extends View> extends MvpContract.Presenter<V> {

        void subscribeForData();

        void next();
    }
}
