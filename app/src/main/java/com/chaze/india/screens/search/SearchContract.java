package com.chaze.india.screens.search;

import android.widget.SearchView;

import com.chaze.india.screens.base.MvpContract;
import com.chaze.india.screens.base.MvpContract;


/**
 * Created by Shubham Vishwakarma on 4/10/18.
 */

public class SearchContract {

    public interface View extends MvpContract.View {


        SearchView getSearchView();

        void recreateList(String result);
    }


    public interface Presentor<V extends View> extends MvpContract.Presenter<V> {
        void initSearchHome();

        void initSearchEcommerce();

        void initSearchEngineLocal();

        void initSearchEngineFood();
    }
}
