package com.chaze.india.screens.Cart.EcommerceCart;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chaze.india.R;
import com.chaze.india.models.Business;
import com.chaze.india.models.CartItem;
import com.chaze.india.models.Item;

import java.util.LinkedList;

public class CartItemsAdapter extends RecyclerView.Adapter<CartItemsAdapter.ViewHolder>{
    LinkedList<CartItem> cartItems;


    public CartItemsAdapter( LinkedList<CartItem> cartItems) {
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

    public void addItems() {

        for (int i = 0; i < 4; i++)
            cartItems.add(new CartItem(new Item("asdf", "asdfsad", false, 43, false, "4", 3, 3, 0, false) {
                @Override
                public Business getBusiness() {
                    return null;
                }
            },4));

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

            cartItemName = (TextView)itemView.findViewById(R.id.cart_item_name);
            cartItemDecreaseQuantity = (TextView)itemView.findViewById(R.id.cart_decrease_quantity);
            cartItemIncreaseQuantity = (TextView)itemView.findViewById(R.id.cart_increase_quantity);
            cartItemQuantity = (TextView)itemView.findViewById(R.id.cart_item_quantity);
            cartItemPrice = (TextView)itemView.findViewById(R.id.cart_item_price);




        }

        public void bind(int i) {
            final CartItem cartItem = cartItems.get(i);
            final Item restaurantItem = cartItem.getItem();



            cartItemName.setText(cartItems.get(i).getItem().getName());
            cartItemQuantity.setText(String.valueOf(cartItems.get(i).getItemQuantity()));
            cartItemPrice.setText(String.valueOf(cartItems.get(i).getCartItemPrice()));

            cartItemIncreaseQuantity.setOnClickListener(v -> {


            });

            cartItemDecreaseQuantity.setOnClickListener(v -> {


            });
        }
    }
}
