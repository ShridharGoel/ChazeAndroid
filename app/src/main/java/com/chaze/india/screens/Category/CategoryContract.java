package com.chaze.india.screens.Category;

import com.chaze.india.screens.base.MvpContract;
import com.chaze.india.models.CategorySearchResults;
import com.chaze.india.screens.base.MvpContract;


/**
 * Created by Shubham Vishwakarma on 12/10/18.
 */

public class CategoryContract {

    public interface View extends MvpContract.View {
        void showData(CategorySearchResults results);

    }


    public interface Presenter<V extends View> extends MvpContract.Presenter<V> {

    }
}
