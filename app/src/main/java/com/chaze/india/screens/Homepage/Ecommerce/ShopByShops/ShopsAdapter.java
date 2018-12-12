package com.chaze.india.screens.Homepage.Ecommerce.ShopByShops;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.cooltechworks.views.shimmer.ShimmerRecyclerView;

import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chaze.india.R;
import com.chaze.india.models.EcomerceCategory;
import com.chaze.india.models.EcomerceShop;
import com.chaze.india.models.Shop;
import com.chaze.india.screens.Shop.ShopActivity;
import com.iarcuschin.simpleratingbar.SimpleRatingBar;
import com.squareup.picasso.Picasso;

import android.support.v4.util.Pair;

import java.util.List;

public class ShopsAdapter extends RecyclerView.Adapter<ShopsAdapter.ViewHolder> {
    Context context;
    List<Shop> shops;

    public ShopsAdapter(Context context, List<Shop> shops) {
        this.context = context;
        this.shops = shops;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.shop_view, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Shop item = shops.get(i);
        // viewHolder.categoryText.setText(item.getName());
        /*Picasso.get()
                .load(item.getImageResourceId())
                .placeholder(R.drawable.ic_menu_camera)
                .error(R.drawable.ic_menu_gallery)
                .into(viewHolder.imageView);*/
        //viewHolder.imageView.setImageResource(R.drawable.cart_badge);
        //viewHolder.imageView.setImageDrawable(item.getImage());

    }

    @Override
    public int getItemCount() {
        return shops.size();
    }

    public void addItems(List<Shop> lst) {

        for (int i = 0; i < 20; i++) shops.add(new Shop());

        //shops.addAll(lst);


        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name;
        TextView address;

        TextView speciality, delivery, minOrderAmount;
        TextView specialityView, deliveryView, minOrderView;
        TextView status;
        SimpleRatingBar ratingBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.shop_image_view);
            name = itemView.findViewById(R.id.shop_name_view);
            address = itemView.findViewById(R.id.shop_address_view);

            speciality = itemView.findViewById(R.id.speacieality_view);
            delivery = itemView.findViewById(R.id.textView17);
            minOrderAmount = itemView.findViewById(R.id.textView13);
            specialityView = itemView.findViewById(R.id.speaciality_text);
            deliveryView = itemView.findViewById(R.id.delivery_charge_view);
            minOrderView = itemView.findViewById(R.id.min_order_view);
            status = itemView.findViewById(R.id.status);
            ratingBar = itemView.findViewById(R.id.shop_rating_view);
            itemView.setOnClickListener(v -> {

                Intent intent = new Intent(context, ShopActivity.class);


                Pair<View, String> p1 = Pair.create((View) imageView, "shop_image_view");
                Pair<View, String> p2 = Pair.create((View) name, "shop_name_view");
                Pair<View, String> p3 = Pair.create((View) address, "shop_address_view");

                Pair<View, String> p4 = Pair.create((View) speciality, "speacieality_view");
                Pair<View, String> p5 = Pair.create((View) delivery, "textView17");
                Pair<View, String> p6 = Pair.create((View) minOrderAmount, "textView13");

                Pair<View, String> p7 = Pair.create((View) specialityView, "speaciality_text");
                Pair<View, String> p8 = Pair.create((View) deliveryView, "delivery_charge_view");
                Pair<View, String> p9 = Pair.create((View) minOrderView, "min_order_view");
                Pair<View, String> p10 = Pair.create((View) status, "status");
                Pair<View, String> p11 = Pair.create((View) ratingBar, "shop_rating_view");

                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation((Activity) context, p1, p2, p3, p4, p5, p6, p7, p8, p9,p10,p11);


                context.startActivity(new Intent(context, ShopActivity.class), options.toBundle());
            });
        }
    }
}
