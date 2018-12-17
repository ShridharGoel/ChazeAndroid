package com.chaze.india.screens;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.chaze.india.R;
import com.chaze.india.models.Ecommerce.Post;
import com.chaze.india.screens.Shop.ShopActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.supercharge.shimmerlayout.ShimmerLayout;
import timber.log.Timber;

public class ProductsPostAdapter extends RecyclerView.Adapter {
    ArrayList<Post> cardList;
    Context context;
    Boolean isByShop;
    String shopId;

    @Inject
    public ProductsPostAdapter(ArrayList<Post> cardList, Context context) {
        this.cardList = cardList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;

        Timber.e("" + i);
        switch (i) {
            case 1:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ecomerce_card_1, viewGroup, false);
                return new Card1ViewHolder(view);
            case 2:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ecomerce_card_2, viewGroup, false);
                return new Card2ViewHolder(view);
            case 3:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ecomerce_card_3, viewGroup, false);
                return new Card3ViewHolder(view);
            case 4:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ecomerce_card_4, viewGroup, false);
                return new Card4ViewHolder(view);
            case 5:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ecomerce_card_4, viewGroup, false);
                return new Card4ViewHolder(view);
        }

        return null;
    }

    @Override
    public int getItemViewType(int position) {

        Timber.e("products " + cardList.get(position).getProducts().size());
        switch (cardList.get(position).getProducts().size()) {
            case 1:
                return 4;
            case 2:
                return 3;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
                return 5;
        }
        return 4;
        //return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Post object = cardList.get(i);

        Timber.e(object.toString());

        switch (getItemViewType(i)) {
            case 1:


                ((Card1ViewHolder) viewHolder).topic.setText(""+object.getKey());

                Picasso.get().load(object.getProducts().get(0).getImageFirst())
                        .error(R.drawable.ic_menu_manage)
                        .into(((Card1ViewHolder) viewHolder).image1);

                ((Card1ViewHolder) viewHolder).textName1.setText(object.getProducts().get(0).getName());


                Picasso.get().load(object.getProducts().get(1).getImageFirst())
                        .error(R.drawable.ic_menu_manage)
                        .into(((Card1ViewHolder) viewHolder).image2);

                ((Card1ViewHolder) viewHolder).textName1.setText(object.getProducts().get(1).getName());

                Picasso.get().load(object.getProducts().get(2).getImageFirst())
                        .error(R.drawable.ic_menu_manage)
                        .into(((Card1ViewHolder) viewHolder).image3);

                ((Card1ViewHolder) viewHolder).textName1.setText(object.getProducts().get(2).getName());
                ((Card1ViewHolder) viewHolder).shimmerLayout.setShimmerColor(context.getResources().getColor(R.color.white));
                ((Card1ViewHolder) viewHolder).shimmerLayout.startShimmerAnimation();
                break;
            case 2:

                ((Card2ViewHolder) viewHolder).topic.setText(""+object.getKey());
                Picasso.get().load(object.getProducts().get(0).getImageFirst())
                        .error(R.drawable.ic_menu_manage)
                        .into(((Card2ViewHolder) viewHolder).image1);
                ((Card2ViewHolder) viewHolder).textName1.setText(object.getProducts().get(0).getName());
                ((Card2ViewHolder) viewHolder).description1.setText("Rs. " + object.getProducts().get(0).getPrice());

                Picasso.get().load(object.getProducts().get(1).getImageFirst())
                        .error(R.drawable.ic_menu_manage)
                        .into(((Card2ViewHolder) viewHolder).image2);

                ((Card2ViewHolder) viewHolder).textName2.setText(object.getProducts().get(1).getName());
                ((Card2ViewHolder) viewHolder).description2.setText("Rs. " + object.getProducts().get(1).getPrice());


                Picasso.get().load(object.getProducts().get(2).getImageFirst())
                        .error(R.drawable.ic_menu_manage)
                        .into(((Card2ViewHolder) viewHolder).image3);
                ((Card2ViewHolder) viewHolder).textName3.setText(object.getProducts().get(2).getName());
                ((Card2ViewHolder) viewHolder).description3.setText("Rs. " + object.getProducts().get(2).getPrice());

                Picasso.get().load(object.getProducts().get(3).getImageFirst())
                        .error(R.drawable.ic_menu_manage)
                        .into(((Card2ViewHolder) viewHolder).image4);

                ((Card2ViewHolder) viewHolder).textName4.setText(object.getProducts().get(3).getName());
                ((Card2ViewHolder) viewHolder).description4.setText("Rs. " + object.getProducts().get(3).getPrice());
                ((Card2ViewHolder) viewHolder).shimmerLayout.setShimmerColor(context.getResources().getColor(R.color.white));
                ((Card2ViewHolder) viewHolder).shimmerLayout.startShimmerAnimation();
                break;
            case 3: {

                ((Card3ViewHolder) viewHolder).topic.setText(""+object.getKey());

                Picasso.get().load(object.getProducts().get(0).getImageFirst())
                        .error(R.drawable.ic_menu_manage)
                        .into(((Card3ViewHolder) viewHolder).image1);

                ((Card3ViewHolder) viewHolder).text1.setText(object.getProducts().get(0).getName());

                Picasso.get().load(object.getProducts().get(1).getImageFirst())
                        .error(R.drawable.ic_menu_manage)
                        .into(((Card3ViewHolder) viewHolder).image2);

                ((Card3ViewHolder) viewHolder).text2.setText(object.getProducts().get(1).getName());
                ((Card3ViewHolder) viewHolder).shimmerLayout.setShimmerColor(context.getResources().getColor(R.color.white));
                ((Card3ViewHolder) viewHolder).shimmerLayout.startShimmerAnimation();
                break;

            }
            case 4: {

                ((Card4ViewHolder) viewHolder).topic.setText(""+object.getKey());
                ((Card4ViewHolder) viewHolder).name.setText(object.getProducts().get(0).getName());

                ((Card4ViewHolder) viewHolder).price.setText("Rs. " + object.getProducts().get(0).getPrice().intValue());
                Picasso.get().load(object.getProducts().get(0).getImageFirst())
                        .error(R.drawable.ic_menu_manage)
                        .into(((Card4ViewHolder) viewHolder).image1);

                ((Card4ViewHolder) viewHolder).shimmerLayout.setShimmerColor(context.getResources().getColor(R.color.white));
                ((Card4ViewHolder) viewHolder).shimmerLayout.startShimmerAnimation();
                break;
            }
            case 5:
                Picasso.get().load(object.getProducts().get(0).getImageFirst())
                        .error(R.drawable.ic_menu_manage)
                        .into(((Card4ViewHolder) viewHolder).image1);
                break;
        }

    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }

    public void setIsByShop(boolean isByShop, String shopID) {
        this.isByShop = isByShop;
        this.shopId = shopID;
    }

    public void addItems(List<Post> items) {
        for (Post i : items) {
            Timber.e("Fuck " + i.getProducts().get(0).getName());
            cardList.addAll(items);
            notifyDataSetChanged();
        }

    }


    public void doOnClick(String id) {
        if (isByShop) {
            Intent intent = new Intent(context, ShopActivity.class);
            intent.putExtra("Shop", id);
            intent.putExtra("Category", "-1");
            context.startActivity(intent);
        } else {
            Intent intent = new Intent(context, ShopActivity.class);
            intent.putExtra("Shop", shopId);
            intent.putExtra("Category", id);
            context.startActivity(intent);
        }
    }

    public class Card1ViewHolder extends RecyclerView.ViewHolder {
        ImageView image1, image2, image3;
        TextView textName1, textName2, textName3, topic;
        Button viewall;
        ShimmerLayout shimmerLayout;
        public Card1ViewHolder(@NonNull View itemView) {
            super(itemView);
            image1 = itemView.findViewById(R.id.card1_image1);
            image2 = itemView.findViewById(R.id.card1_image2);
            image3 = itemView.findViewById(R.id.card1_image3);

            textName1 = itemView.findViewById(R.id.card1_text1);
            textName2 = itemView.findViewById(R.id.card1_text2);
            textName3 = itemView.findViewById(R.id.card1_text3);

            topic = itemView.findViewById(R.id.topic_name);
            shimmerLayout = itemView.findViewById(R.id.shimmer_view);

            viewall = itemView.findViewById(R.id.viewall);
            viewall.setOnClickListener(view -> {
                doOnClick(cardList.get(getPosition()).getKey().toString());
            });
        }
    }

    public class Card2ViewHolder extends RecyclerView.ViewHolder {
        ImageView image1, image2, image3, image4;
        TextView textName1, textName2, textName3, textName4;
        TextView description1, description2, description3, description4;

        TextView topic;
        Button viewAll;
        ShimmerLayout shimmerLayout;
        public Card2ViewHolder(@NonNull View itemView) {
            super(itemView);
            image1 = itemView.findViewById(R.id.card2_image1);
            image2 = itemView.findViewById(R.id.card2_image2);
            image3 = itemView.findViewById(R.id.card2_image3);
            image4 = itemView.findViewById(R.id.card2_image4);

            textName1 = itemView.findViewById(R.id.card2_item_name_1);
            textName2 = itemView.findViewById(R.id.card2_item_name_2);
            textName3 = itemView.findViewById(R.id.card2_item_name_3);
            textName4 = itemView.findViewById(R.id.card2_item_name_4);


            description1 = itemView.findViewById(R.id.card2_item_description1);
            description2 = itemView.findViewById(R.id.card2_item_description2);
            description3 = itemView.findViewById(R.id.card2_item_description3);
            description4 = itemView.findViewById(R.id.card2_item_description4);
            shimmerLayout = itemView.findViewById(R.id.shimmer_view);
            shimmerLayout.startShimmerAnimation();
            topic = itemView.findViewById(R.id.topic_name);
            viewAll = itemView.findViewById(R.id.viewall);

            viewAll.setOnClickListener(view -> {
                doOnClick(cardList.get(getPosition()).getKey().toString());
            });

        }
    }




    public class Card3ViewHolder extends RecyclerView.ViewHolder {
        ImageView image1, image2;
        TextView text1, text2;
        TextView topic;
        Button viewall;
        ShimmerLayout shimmerLayout;
        public Card3ViewHolder(@NonNull View itemView) {
            super(itemView);

            image1 = itemView.findViewById(R.id.card3_image1);
            image2 = itemView.findViewById(R.id.card3_image2);
            text1 = itemView.findViewById(R.id.card3_text1);
            text2 = itemView.findViewById(R.id.card3_text2);
            shimmerLayout = itemView.findViewById(R.id.shimmer_view);
            shimmerLayout.startShimmerAnimation();
            viewall = itemView.findViewById(R.id.viewall);
            topic = itemView.findViewById(R.id.topic_name);
            viewall.setOnClickListener(view -> {
                doOnClick(cardList.get(getPosition()).getKey().toString());
            });
        }
    }

    public class Card4ViewHolder extends RecyclerView.ViewHolder {

        ImageView image1;
        TextView name, topic, price;
        Button viewall;

        ShimmerLayout shimmerLayout;

        public Card4ViewHolder(@NonNull View itemView) {
            super(itemView);
            image1 = itemView.findViewById(R.id.card4_image);
            name = itemView.findViewById(R.id.name);

            price = itemView.findViewById(R.id.price);
            viewall = itemView.findViewById(R.id.viewall);
            topic = itemView.findViewById(R.id.topic_name);
            shimmerLayout = itemView.findViewById(R.id.shimmer_view);
            shimmerLayout.startShimmerAnimation();
            viewall.setOnClickListener(view -> {
                doOnClick(cardList.get(getPosition()).getKey().toString());
            });
        }
    }
}
