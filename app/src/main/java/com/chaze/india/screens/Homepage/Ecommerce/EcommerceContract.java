package com.chaze.india.screens.Homepage.Ecommerce;

import com.chaze.india.models.Ecommerce.Category;
import com.chaze.india.screens.base.MvpContract;

import java.util.ArrayList;


/**
 * Created by Shubham Vishwakarma on 12/10/18.
 */

public class EcommerceContract {

    public interface View extends MvpContract.View {

        public void showCategories(ArrayList<Category> categories);

        public void setCartCountBadge(int countBadge);
    }


    public interface Presenter<V extends View> extends MvpContract.Presenter<V> {

        public void getCartCount();

        public void loadCategories();
    }
}
