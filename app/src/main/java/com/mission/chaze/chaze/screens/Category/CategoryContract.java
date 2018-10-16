package com.mission.chaze.chaze.screens.Category;

import com.mission.chaze.chaze.models.CategorySearchResults;
import com.mission.chaze.chaze.screens.base.MvpContract;


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
