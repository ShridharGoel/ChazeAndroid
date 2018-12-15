package com.chaze.india.screens.Homepage;

import android.content.Context;
import android.support.annotation.NonNull;

import com.chaze.india.models.Ecommerce.Post;
import com.chaze.india.screens.ProductsPostAdapter;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chaze.india.R;
import com.chaze.india.models.RecyclerItems;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

public class HomeCardAdapter extends RecyclerView.Adapter{
    ArrayList<Post> cardList;
    Context context;

    public HomeCardAdapter(ArrayList<Post> cardList, Context context) {
        this.cardList = cardList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;

        switch (i) {
            case 1:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ecomerce_card_1, viewGroup, false);
                return new HomeCardAdapter.Card1ViewHolder(view);
            case 2:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ecomerce_card_2, viewGroup, false);
                return new HomeCardAdapter.Card2ViewHolder(view);
            case 3:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ecomerce_card_3, viewGroup, false);
                return new HomeCardAdapter.Card3ViewHolder(view);
            case 4:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ecomerce_card_4, viewGroup, false);
                return new HomeCardAdapter.Card4ViewHolder(view);
        }
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ecomerce_card_4, viewGroup, false);
        return new HomeCardAdapter.Card4ViewHolder(view);
    }

    @Override
    public int getItemViewType(int position) {
        switch (cardList.get(position).getType()) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
        }
        return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Post object = cardList.get(i);
        switch (object.getType()) {
            case 1:
                Picasso.get().load(object.getItems().get(0).getImageFirst())
                        .error(R.drawable.ic_menu_manage)
                        .into(((HomeCardAdapter.Card1ViewHolder) viewHolder).image1);
                Picasso.get().load(object.getItems().get(1).getImageFirst())
                        .error(R.drawable.ic_menu_manage)
                        .into(((HomeCardAdapter.Card1ViewHolder) viewHolder).image2);
                Picasso.get().load(object.getItems().get(2).getImageFirst())
                        .error(R.drawable.ic_menu_manage)
                        .into(((HomeCardAdapter.Card1ViewHolder) viewHolder).image3);
                break;
            case 2:
                Picasso.get().load(object.getItems().get(0).getImageFirst())
                        .error(R.drawable.ic_menu_manage)
                        .into(((HomeCardAdapter.Card2ViewHolder) viewHolder).image1);
                Picasso.get().load(object.getItems().get(1).getImageFirst())
                        .error(R.drawable.ic_menu_manage)
                        .into(((HomeCardAdapter.Card2ViewHolder) viewHolder).image2);
                Picasso.get().load(object.getItems().get(2).getImageFirst())
                        .error(R.drawable.ic_menu_manage)
                        .into(((HomeCardAdapter.Card2ViewHolder) viewHolder).image3);
                Picasso.get().load(object.getItems().get(3).getImageFirst())
                        .error(R.drawable.ic_menu_manage)
                        .into(((HomeCardAdapter.Card2ViewHolder) viewHolder).image4);
                break;
            case 3:/*Picasso.get().load(object.getRecyclerList().get(0).getImageUrl())
                .error(R.drawable.ic_menu_manage)
                .into(((Card3ViewHolder)viewHolder).image1);
            Picasso.get().load(object.getRecyclerList().get(1).getImageUrl())
                    .error(R.drawable.ic_menu_gallery)
                    .into(((Card3ViewHolder)viewHolder).image2);
            Picasso.get().load(object.getRecyclerList().get(2).getImageUrl())
                    .error(R.drawable.ic_menu_send)
                    .into(((Card3ViewHolder)viewHolder).image3);*/
                for (int j = 0; j < 3; j++) {

                    SliderView sliderView = new SliderView(context);

                    switch (i) {
                        case 0:
                            sliderView.setImageUrl(object.getItems().get(0).getImageFirst());
                            break;
                        case 1:
                            sliderView.setImageUrl(object.getItems().get(1).getImageFirst());
                            break;
                        case 2:
                            sliderView.setImageUrl(object.getItems().get(2).getImageFirst());
                            break;
                    }
                    ((HomeCardAdapter.Card3ViewHolder) viewHolder).sliderLayout.addSliderView(sliderView);
                }


                break;
            case 4:
                Picasso.get().load(object.getItems().get(0).getImageFirst())
                        .error(R.drawable.ic_menu_manage)
                        .into(((HomeCardAdapter.Card4ViewHolder) viewHolder).image1);

        }

    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }

    public void addItems(List<Post> items) {
        for (Post i : items) {
            Timber.e(i.getItems().get(0).getName());
            cardList.addAll(items);
        }
        notifyDataSetChanged();
    }

    public class Card1ViewHolder extends RecyclerView.ViewHolder {
        ImageView image1, image2, image3;

        public Card1ViewHolder(@NonNull View itemView) {
            super(itemView);
            image1 = itemView.findViewById(R.id.card1_image1);
            image2 = itemView.findViewById(R.id.card1_image2);
            image3 = itemView.findViewById(R.id.card1_image3);
        }
    }

    public class Card2ViewHolder extends RecyclerView.ViewHolder {
        ImageView image1, image2, image3, image4;

        public Card2ViewHolder(@NonNull View itemView) {
            super(itemView);
            image1 = itemView.findViewById(R.id.card2_image1);
            image2 = itemView.findViewById(R.id.card2_image2);
            image3 = itemView.findViewById(R.id.card2_image3);
            image4 = itemView.findViewById(R.id.card2_image4);
        }
    }

    public class Card3ViewHolder extends RecyclerView.ViewHolder {
        ImageView image1, image2, image3;
        SliderLayout sliderLayout;

        public Card3ViewHolder(@NonNull View itemView) {
            super(itemView);
            sliderLayout = itemView.findViewById(R.id.imageSlider);
            sliderLayout.setIndicatorAnimation(SliderLayout.Animations.FILL); //set indicator animation by using SliderLayout.Animations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
            sliderLayout.setScrollTimeInSec(1);
            image1 = itemView.findViewById(R.id.card3_image1);
            image2 = itemView.findViewById(R.id.card3_image2);
            image3 = itemView.findViewById(R.id.card3_image3);
        }
    }

    public class Card4ViewHolder extends RecyclerView.ViewHolder {

        ImageView image1;

        public Card4ViewHolder(@NonNull View itemView) {
            super(itemView);
            image1 = itemView.findViewById(R.id.card4_image);
        }
    }
}
