package com.chaze.india.screens.Cart.EcommerceCart;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.widget.LinearLayoutManager;

import com.chaze.india.models.Ecommerce.CartShop;
import com.chaze.india.repository.CartManager;

import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.chaze.india.R;
import com.chaze.india.di.Qualifiers.LinLayoutVert;
import com.chaze.india.screens.Checkout.CheckoutActivity;
import com.chaze.india.screens.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.subjects.PublishSubject;

public class CartActivity extends BaseActivity implements CartContract.View {

    @BindView(R.id.recycler_view_cart)
    RecyclerView recyclerView;

    @Inject
    CartManager cartManager;

    @Inject
    CartBusinessAdapter cartBusinessAdapter;

    @Inject
    @LinLayoutVert
    LinearLayoutManager layoutManager;

    @Inject
    CartItemsAdapter cartItemsAdapter;

    @BindView(R.id.bottom_sheet)
    LinearLayout layoutBottomSheet;

    @BindView(R.id.cart_items_recycler)
    RecyclerView recyclerViewCartItems;

    @Inject
    CartContract.Presenter<CartContract.View> mPresenter;

    @BindView(R.id.close_button_container)
    RelativeLayout relativeLayout;

    BottomSheetBehavior sheetBehavior;

    @BindView(R.id.checkout_button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        setUnBinder(ButterKnife.bind(this));
        getActivityComponent().inject(this);
        mPresenter.onAttach(this);
        setup();
    }

    private void setup() {
        cartBusinessAdapter.addItems(cartManager.getCart());
        recyclerView.setAdapter(cartBusinessAdapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewCartItems.setAdapter(cartItemsAdapter);
        LinearLayoutManager layoutManagerCart = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewCartItems.setLayoutManager(layoutManagerCart);
        sheetBehavior = BottomSheetBehavior.from(layoutBottomSheet);
        sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        mPresenter.show();
        button.setOnClickListener(v -> this.startActivity(new Intent(this, CheckoutActivity.class)));
    }

    @Override
    public void setSubjectToAdapter(PublishSubject<CartShop> cartShopPublishSubject) {
        cartBusinessAdapter.setSubject(cartShopPublishSubject);
    }

    @Override
    public void showFull(CartShop cartShop) {
        cartItemsAdapter.addItems(cartShop);
        sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    @Override
    public void showOnActivity() {

    }

    @OnClick(R.id.close_button_container)
    public void toggleBottomSheet() {
        sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
    }


}
