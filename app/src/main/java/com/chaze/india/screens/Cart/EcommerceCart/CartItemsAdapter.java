package com.chaze.india.screens.Cart.EcommerceCart;

import android.support.annotation.NonNull;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chaze.india.R;
import com.chaze.india.models.Ecommerce.CartItem;
import com.chaze.india.models.Ecommerce.CartShop;
import com.chaze.india.models.Ecommerce.ShopItem;
import com.chaze.india.models.Ecommerce.EcommerceCartItem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CartItemsAdapter extends RecyclerView.Adapter<CartItemsAdapter.ViewHolder> {
    List<CartItem> cartItems;


    public CartItemsAdapter(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cart_item, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(i);
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    public void addItems(CartShop cartShop) {
        cartItems = new ArrayList<>();
        cartItems.addAll(cartShop.getProducts());
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView cartItemName;
        TextView cartItemDecreaseQuantity;
        TextView cartItemQuantity;
        TextView cartItemIncreaseQuantity;
        TextView cartItemPrice;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            cartItemName = (TextView) itemView.findViewById(R.id.cart_item_name);
            cartItemDecreaseQuantity = (TextView) itemView.findViewById(R.id.cart_decrease_quantity);
            cartItemIncreaseQuantity = (TextView) itemView.findViewById(R.id.cart_increase_quantity);
            cartItemQuantity = (TextView) itemView.findViewById(R.id.cart_item_quantity);
            cartItemPrice = (TextView) itemView.findViewById(R.id.cart_item_price);


        }

        public void bind(int i) {
            final CartItem cartItem = cartItems.get(i);
            cartItemName.setText(cartItems.get(i).getName());
            cartItemQuantity.setText(String.valueOf(cartItems.get(i).getQuantity()));
            cartItemPrice.setText(String.valueOf(cartItems.get(i).getPrice()));
            cartItemIncreaseQuantity.setOnClickListener(v -> {

            });
            cartItemDecreaseQuantity.setOnClickListener(v -> {

            });
        }
    }
}
