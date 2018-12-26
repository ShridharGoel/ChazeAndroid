package com.chaze.india.screens.Cart.EcommerceCart;

import android.content.Context;
import android.support.annotation.NonNull;

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
import com.chaze.india.models.Ecommerce.CartResponse;
import com.chaze.india.models.Ecommerce.CartShop;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.subjects.PublishSubject;

public class CartBusinessAdapter extends RecyclerView.Adapter<CartBusinessAdapter.ViewHolder> {
    Context context;
    List<CartShop> cartBusinesses;
    PublishSubject<CartShop> subject;

    public void setSubject(PublishSubject<CartShop> subject) {
        this.subject = subject;
    }

    public CartBusinessAdapter(Context context, List<CartShop> cartBusinesses) {
        this.context = context;
        this.cartBusinesses = cartBusinesses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cart_business_item, viewGroup, false);

        return new ViewHolder(itemView);
    }

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
        viewHolder.total.setText("" + shop.getTotalAfterDiscount());
    }

    @Override
    public int getItemCount() {
        return cartBusinesses.size();
    }

    public void addItems(CartResponse cart) {

        if (cart != null && cart.getCartShops() != null)
            cartBusinesses.addAll(cart.getCartShops());
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cart_business_image_view)
        ImageView imageView;

        @BindView(R.id.cart_business_name_view)
        TextView name;

        @BindView(R.id.bill_total_view)
        TextView billTotalView;


        @BindView(R.id.discount_container)
        RelativeLayout discountContainer;

        @BindView(R.id.discount_applied)
        TextView discountApplied;

        @BindView(R.id.taxContainer)
        LinearLayout taxContainer;

        @BindView(R.id.tax_applied)
        TextView taxApplied;


        @BindView(R.id.amount_total)
        TextView total;

        @BindView(R.id.delivery_charge)
        TextView deliveryCharge;


        @BindView(R.id.amount_to_pay)
        TextView amountToPay;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(v -> subject.onNext(cartBusinesses.get(getPosition())));
        }

    }
}
