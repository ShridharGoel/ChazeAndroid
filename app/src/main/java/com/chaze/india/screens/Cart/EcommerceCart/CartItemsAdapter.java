package com.chaze.india.screens.Cart.EcommerceCart;

import android.content.Context;
import android.support.annotation.NonNull;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chaze.india.R;
import com.chaze.india.models.Ecommerce.CartItem;
import com.chaze.india.models.Ecommerce.CartShop;
import com.chaze.india.repository.CartManager;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CartItemsAdapter extends RecyclerView.Adapter<CartItemsAdapter.ViewHolder> {
    List<CartItem> cartItems;
    CartManager cartManager;
    Context context;
    CartBusinessAdapter.Recalculate recalculate;

    public CartItemsAdapter(List<CartItem> cartItems, CartManager cartManager, CartBusinessAdapter.Recalculate recalculate) {
        this.cartItems = cartItems;
        this.cartManager = cartManager;
        this.recalculate = recalculate;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cart_item, viewGroup, false);
        context = viewGroup.getContext();
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
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cartItemName = itemView.findViewById(R.id.cart_item_name);
            cartItemDecreaseQuantity = itemView.findViewById(R.id.cart_decrease_quantity);
            cartItemIncreaseQuantity = itemView.findViewById(R.id.cart_increase_quantity);
            cartItemQuantity = itemView.findViewById(R.id.cart_item_quantity);
            cartItemPrice = itemView.findViewById(R.id.cart_item_price);
            imageView = itemView.findViewById(R.id.cart_item_image);

        }

        public void bind(int i) {
            final CartItem cartItem = cartItems.get(i);
            cartItemName.setText(cartItems.get(i).getName());
            cartItemQuantity.setText(String.valueOf(cartItems.get(i).getQuantity()));
            cartItemPrice.setText(String.valueOf(cartItems.get(i).getPrice()));
            cartItemIncreaseQuantity.setOnClickListener(v -> {
                cartManager.addItemToCart(cartItem.getId(), cartItem.getQuantity() + 1, cartItem.getDescription(), new CartManager.AddItemsCallBack() {
                    @Override
                    public void onItemAdded() {
                        cartItem.setQuantity(cartItem.getQuantity() + 1);
                        cartItemQuantity.setText("" + cartItem.getQuantity());
                        recalculate.recalculate();
                    }
                    @Override
                    public void onError() {
                        Toast.makeText(context, "Some error occured..", Toast.LENGTH_SHORT).show();
                    }
                });
            });
            cartItemDecreaseQuantity.setOnClickListener(v -> {
                cartManager.addItemToCart(cartItem.getId(), cartItem.getQuantity() - 1, cartItem.getDescription(), new CartManager.AddItemsCallBack() {
                    @Override
                    public void onItemAdded() {
                        cartItem.setQuantity(cartItem.getQuantity() - 1);
                        cartItemQuantity.setText("" + cartItem.getQuantity());
                        recalculate.recalculate();
                    }

                    @Override
                    public void onError() {
                        Toast.makeText(context, "Some error occured..", Toast.LENGTH_SHORT).show();
                    }
                });
            });
            Picasso.get().load(cartItem.getImage()).into(imageView);
        }
    }
}
