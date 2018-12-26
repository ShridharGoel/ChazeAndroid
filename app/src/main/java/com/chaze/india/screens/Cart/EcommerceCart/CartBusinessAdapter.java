package com.chaze.india.screens.Cart.EcommerceCart;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chaze.india.R;
import com.chaze.india.models.Ecommerce.CartBusiness;
import com.chaze.india.models.Ecommerce.CartItem;
import com.chaze.india.models.Ecommerce.CartResponse;
import com.chaze.india.models.Ecommerce.CartShop;
import com.chaze.india.models.Ecommerce.Category;
import com.chaze.india.repository.CartManager;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.subjects.PublishSubject;

public class CartBusinessAdapter extends RecyclerView.Adapter<CartBusinessAdapter.ViewHolder> {
    private Context context;
    private List<CartShop> cartBusinesses;
    private CartManager cartManager;
    private PublishSubject<CartShop> subject;
    private CartActivity.UpdateGrandTotal updateGrandTotal;


    public CartBusinessAdapter(Context context, List<CartShop> cartBusinesses) {
        this.context = context;
        this.cartBusinesses = cartBusinesses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cart_bottom_sheet, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        CartShop shop = cartBusinesses.get(i);
        viewHolder.name.setText(cartBusinesses.get(i).getName());
        viewHolder.billTotalView.setText("" + shop.getTotalBillBeforDiscount());
        if (shop.getDiscountApplied() != 0) {
            viewHolder.discountApplied.setText("" + shop.getDiscountApplied());
        } else {
            viewHolder.discountContainer.setVisibility(View.GONE);
        }
        viewHolder.deliveryCharge.setText("" + shop.getDeliveryCharge());

        viewHolder.amountToPay.setText("" + shop.getTotalToPay());
        viewHolder.amountToPayFront.setText("" + shop.getTotalToPay());
        viewHolder.total.setText("" + shop.getTotalAfterDiscount());
        viewHolder.cartItemsAdapter.addItems(shop);
    }

    public void setCartManager(CartManager cartManager, CartActivity.UpdateGrandTotal updateGrandTotal) {
        this.cartManager = cartManager;
        this.updateGrandTotal = updateGrandTotal;
        if (cartManager.getCart() != null && cartManager.getCart().getCartShops() != null)
            cartBusinesses.addAll(cartManager.getCart().getCartShops());
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return cartBusinesses.size();
    }


    public interface Recalculate {
        void recalculate();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.shop_image_view)
        ImageView imageView;

        @BindView(R.id.shop_name_view)
        TextView name;

        @BindView(R.id.bill_total_view)
        TextView billTotalView;


        @BindView(R.id.discount_container)
        ConstraintLayout discountContainer;

        @BindView(R.id.discount_applied)
        TextView discountApplied;

        @BindView(R.id.taxContainer)
        ConstraintLayout taxContainer;

        @BindView(R.id.tax_applied)
        TextView taxApplied;


        @BindView(R.id.amount_total)
        TextView total;

        @BindView(R.id.delivery_charge)
        TextView deliveryCharge;

        @BindView(R.id.amount_to_pay)
        TextView amountToPay;

        @BindView(R.id.amount_to_pay_front)
        TextView amountToPayFront;

        @BindView(R.id.cart_items_recycler)
        RecyclerView cartItemRecyclerView;

        CartItemsAdapter cartItemsAdapter;

        @SuppressLint("SetTextI18n")
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(v -> subject.onNext(cartBusinesses.get(getPosition())));

            cartItemsAdapter = new CartItemsAdapter(new ArrayList<>(), cartManager, () -> {
                int i = getPosition();
                CartShop shop = cartBusinesses.get(i);
                billTotalView.setText("" + shop.getTotalBillBeforDiscount());
                if (shop.getDiscountApplied() != 0) {
                    discountApplied.setText("" + shop.getDiscountApplied());
                } else {
                    discountContainer.setVisibility(View.GONE);
                }
                deliveryCharge.setText("" + shop.getDeliveryCharge());
                amountToPay.setText("" + shop.getTotalToPay());
                amountToPayFront.setText("" + shop.getTotalToPay());
                total.setText("" + shop.getTotalAfterDiscount());
                updateGrandTotal.updateGrandTotal();
            });
            cartItemRecyclerView.setAdapter(cartItemsAdapter);
            LinearLayoutManager layoutManagerCart = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
            cartItemRecyclerView.setLayoutManager(layoutManagerCart);
        }

    }
}
