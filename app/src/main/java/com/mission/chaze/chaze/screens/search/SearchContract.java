package com.mission.chaze.chaze.screens.search;

import android.widget.SearchView;

import com.mission.chaze.chaze.screens.base.MvpContract;

import io.reactivex.functions.Consumer;


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
