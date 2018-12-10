package com.chaze.india.screens.Homepage.Purchases.ActiveOrders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.chaze.india.R;
import com.chaze.india.models.ActiveOrder;
import com.chaze.india.models.Business;
import com.chaze.india.models.CartBusiness;
import com.chaze.india.models.CategorySearchResults;
import com.chaze.india.models.Item;
import com.chaze.india.models.Order;
import com.chaze.india.models.ShopResults;
import com.chaze.india.screens.Category.CategoryItemsInAShopAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import io.reactivex.subjects.PublishSubject;

public class ActiveOrdersAdapter extends RecyclerView.Adapter<ActiveOrdersAdapter.ViewHolder> {
    Context context;
    ArrayList<Order> list;

    RecyclerView shopItemsView;
    PublishSubject<String> subject;

    public ActiveOrdersAdapter(Context context, ArrayList<Order> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_orders, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Order item = list.get(i);
        viewHolder.bind(i);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addItems() {

        list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {

            Order order = new Order();
            ArrayList<Item> items = new ArrayList<>();

            for (int j = 0; j < 7; j++) {
                order.addCartBusiness(new CartBusiness());
            }

            list.add(order);
        }
        notifyDataSetChanged();
    }

    public void setSubject(PublishSubject<String> subject) {
        this.subject=subject;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            shopItemsView = itemView.findViewById(R.id.recycler_view);
        }

        public void bind(int i) {
            ArrayList<CartBusiness> cartBusinesses = list.get(i).getCartBusinesses();

            ShopsInAOrderAdapter shopsInAOrderAdapter = new ShopsInAOrderAdapter(cartBusinesses);
            final LinearLayoutManager foundItemsInARestaurantLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
            shopItemsView.setAdapter(shopsInAOrderAdapter);
            shopItemsView.setLayoutManager(foundItemsInARestaurantLayoutManager);
            shopItemsView.setHasFixedSize(true);

        }
    }
}

