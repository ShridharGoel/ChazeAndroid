package com.chaze.india.screens.Cart.RestaurantCart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.chaze.india.R;
import com.chaze.india.screens.Cart.EcommerceCart.CartItemsAdapter;
import com.chaze.india.screens.Checkout.CheckoutActivity;
import com.chaze.india.screens.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestaurantCartActivity extends BaseActivity implements RestaurantCartContract.View {


    @Inject
    CartItemsAdapter cartItemsAdapter;

    @BindView(R.id.cart_items_recycler)
    RecyclerView recyclerViewCartItems;

    @Inject
    RestaurantCartContract.Presenter<RestaurantCartContract.View> mPresenter;

    @BindView(R.id.checkout_button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_cart);

        setUnBinder(ButterKnife.bind(this));

        getActivityComponent().inject(this);


        mPresenter.onAttach(this);

        recyclerViewCartItems.setAdapter(cartItemsAdapter);

        LinearLayoutManager layoutManagerCart = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewCartItems.setLayoutManager(layoutManagerCart);


        button.setOnClickListener(v -> this.startActivity(new Intent(this, CheckoutActivity.class)));

    }


}
