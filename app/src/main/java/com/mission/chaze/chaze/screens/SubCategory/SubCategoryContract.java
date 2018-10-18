package com.mission.chaze.chaze.screens.SubCategory;

import com.mission.chaze.chaze.models.CategorySearchResults;
import com.mission.chaze.chaze.models.EcomerceCategory;
import com.mission.chaze.chaze.screens.base.MvpContract;

import java.util.List;


/**
 * Created by Shubham Vishwakarma on 16/10/18.
 */

public class SubCategoryContract {

    public interface View extends MvpContract.View {
        void showData(CategorySearchResults results);

        void addItems(List<EcomerceCategory> items);
    }


    public interface Presenter<V extends View> extends MvpContract.Presenter<V> {

        void subscribeForData();

        void next();
    }
}
