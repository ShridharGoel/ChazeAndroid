package com.chaze.india.screens.ProductInfo;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chaze.india.R;
import com.github.chrisbanes.photoview.PhotoView;
import com.squareup.picasso.Picasso;

public class ProductImageSliderAdapter extends PagerAdapter {
    private LayoutInflater layoutInflater;
    Context context;

    String[] urls;

    public ProductImageSliderAdapter(Context context, String[] urls) {
        this.context = context;
        this.urls = urls;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.product_info_slide, container, false);
        PhotoView imageView = ((PhotoView) view.findViewById(R.id.image));

        Picasso.get().load("https://www.dhresource.com/webp/m/0x0s/f2-albu-g7-M00-FF-E9-rBVaSVpnDAiAVjpLAAKFeXiLUr4605.jpg/men-039-s-pu-leather-jackets-winter-fashion.jpg")
                .error(R.drawable.ic_menu_manage)
                .into(imageView);

        container.addView(view);

        return view;
    }

    @Override
    public int getCount() {
        return urls.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}