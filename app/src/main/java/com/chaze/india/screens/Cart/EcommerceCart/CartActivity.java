package com.chaze.india.screens.Cart.EcommerceCart;

import android.annotation.SuppressLint;
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
import android.widget.TextView;

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
    CartContract.Presenter<CartContract.View> mPresenter;

    @BindView(R.id.checkout_button)
    Button button;

    @BindView(R.id.total_bill)
    TextView totalBill;

    public interface UpdateGrandTotal {
        void updateGrandTotal();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        setUnBinder(ButterKnife.bind(this));
        getActivityComponent().inject(this);
        mPresenter.onAttach(this);
        setup();
    }

    @SuppressLint("SetTextI18n")
    private void setup() {
        totalBill.setText("Rs. " + cartManager.getTotalBill());
        cartBusinessAdapter.setCartManager(cartManager, () -> totalBill.setText("Rs. " + cartManager.getTotalBill()));
        recyclerView.setAdapter(cartBusinessAdapter);
        recyclerView.setLayoutManager(layoutManager);

        button.setOnClickListener(v -> this.startActivity(new Intent(this, CheckoutActivity.class)));
    }


}
