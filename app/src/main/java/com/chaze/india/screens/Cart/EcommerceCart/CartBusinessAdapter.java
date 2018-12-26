package com.chaze.india.screens.Cart.EcommerceCart;

import android.content.Context;
import android.support.annotation.NonNull;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chaze.india.R;
import com.chaze.india.models.Ecommerce.CartBusiness;

import java.util.List;

import io.reactivex.subjects.PublishSubject;

public class CartBusinessAdapter extends RecyclerView.Adapter<CartBusinessAdapter.ViewHolder>{
    Context context;
    List<CartBusiness> cartBusinesses;
    PublishSubject<String> subject;

    public void setSubject(PublishSubject<String> subject) {
        this.subject = subject;
    }

    public CartBusinessAdapter(Context context, List<CartBusiness> cartBusinesses) {
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
        CartBusiness item=cartBusinesses.get(i);
       // viewHolder.categoryText.setText("asdfsdfsdff");

    }

    @Override
    public int getItemCount() {
        return cartBusinesses.size();
    }

    public void addItems() {

        for (int i = 0; i < 4; i++)
            cartBusinesses.add(new CartBusiness());

        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView categoryText;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            itemView.setOnClickListener(v->subject.onNext(""+getPosition()));
          //  imageView=itemView.findViewById(R.id.categoryImage);
        }

    }
}
