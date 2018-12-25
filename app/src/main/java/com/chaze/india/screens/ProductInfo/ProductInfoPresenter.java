

package com.chaze.india.screens.ProductInfo;

import android.widget.TextView;

import com.chaze.india.models.Ecommerce.CartItem;
import com.chaze.india.models.Ecommerce.Product;
import com.chaze.india.repository.CartManager;
import com.chaze.india.repository.network.ICommonAPIManager;
import com.chaze.india.repository.session.SessionManager;
import com.chaze.india.screens.base.BasePresenter;
import com.chaze.india.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;


/**
 * Created by Shubham Vishwakarma on 12/10/18.
 */

public class ProductInfoPresenter<V extends ProductInfoContract.View> extends BasePresenter<V>
        implements ProductInfoContract.Presenter<V> {

    Product product;

    @Inject
    public ProductInfoPresenter(ICommonAPIManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, SessionManager sessionManager, CartManager cartManager) {
        super(dataManager, schedulerProvider, compositeDisposable, sessionManager, cartManager);
    }

    @Override
    public void loadData(Product product) {
        this.product = product;
        CartItem ci = getCartManager().checkIfThisProductPresent(this.product.getId(), this.product.getSellerId());

        getMvpView().showData(ci);

    }

    @Override
    public int getItemsCount(){
        return getCartManager().getItemsCount();
    }

    @Override
    public void addItems(Product product, Long quantity, String description, TextView cartCountBadge) {
        getCartManager().addItemToCart(product, quantity, description, cartCountBadge);
    }
}
