package com.chaze.india.screens.PostOrderStatus.ActiveOrders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.chaze.india.R;
import com.chaze.india.models.ActiveOrder;
import com.chaze.india.models.EcomerceCategory;
import com.chaze.india.screens.Homepage.Ecommerce.EcommerceCategoryAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.subjects.PublishSubject;
import timber.log.Timber;

public class ActiveOrdersAdapter extends RecyclerView.Adapter<ActiveOrdersAdapter.ViewHolder> {
    Context context;
    ArrayList<ActiveOrder> list;
    PublishSubject<String> subject;


    public ActiveOrdersAdapter(Context context, ArrayList<ActiveOrder> list) {
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
        ActiveOrder item=list.get(i);
        viewHolder.shopName.setText(item.getRestaurantName());
        Picasso.get().load(item.getImage())
                .error(R.drawable.buttonshape)
                .into(viewHolder.shopImage);
        viewHolder.button.setOnClickListener(view ->
                        subject.onNext(""+i  ));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void addItems() {

        for (int i = 0; i < 20; i++)
            list.add(new ActiveOrder("https://drive.google.com/file/d/15b68H448F4jszurUpAAQV6lFPHdY1dv2/view?usp=sharing","people"  ));
    }

    public void setSubject(PublishSubject<String> subject) {
        this.subject=subject;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView shopName;
        ImageView shopImage;
        Button button;
        CardView card;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            shopName=itemView.findViewById(R.id.activeOrderShopName);
            shopImage=itemView.findViewById(R.id.activeOrderImage);
            button=itemView.findViewById(R.id.checkStatusButton);
            card=itemView.findViewById(R.id.activeCard);
            itemView.setOnClickListener(v->subject.onNext(""+getPosition()  ));
        }
    }
}
