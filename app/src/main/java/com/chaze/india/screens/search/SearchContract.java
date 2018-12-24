package com.chaze.india.screens.search;

import android.widget.SearchView;

import com.chaze.india.models.Suggestion;
import com.chaze.india.screens.base.MvpContract;

import java.util.List;


/**
 * Created by Shubham Vishwakarma on 4/10/18.
 */

public class SearchContract {

    public interface View extends MvpContract.View {


        SearchView getSearchView();

        void recreateList(List<Suggestion> suggestions);

        void showError(String message);
    }


    public interface Presenter<V extends View> extends MvpContract.Presenter<V> {
        void initByShopAndCategory();

        void initSearchEcommerce();

        void initCategory();

        void initSearchEngineFood();
    }
}
