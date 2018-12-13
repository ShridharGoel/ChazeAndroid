package com.chaze.india.screens.ProductInfo.ProductInfoPopupActivity;

import android.os.Bundle;
import android.support.constraint.Group;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.chaze.india.R;
import com.chaze.india.screens.ProductInfo.ProductImageSliderAdapter;
import com.chaze.india.screens.ProductInfo.ProductInfoContract;
import com.chaze.india.screens.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class ProductInfoPopupActivity extends BaseActivity implements ProductInfoContract.View {

    private TextView[] dots;


    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.layoutDots)
    LinearLayout dotsLayout;

    @BindView(R.id.details_table_layout)
    TableLayout detailsTableLayout;

    @BindView(R.id.verieties_table_layout)
    TableLayout varietiesTableLayout;

    @BindView(R.id.reviews_table_layout)
    TableLayout reviewsTableLayout;

    @BindView(R.id.description)
    TextView desription;

    @BindView(R.id.tablerow)
    TableRow detailsRow;

    @BindView(R.id.groupForVariety)
    Group groupForVarieties;

    @Inject
    ProductInfoContract.Presenter<ProductInfoContract.View> presenter;

    ProductImageSliderAdapter myViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_popup_info);

        ButterKnife.bind(this);
        getActivityComponent().inject(this);
        setup();
        presenter.onAttach(this);
        presenter.loadData();


    }

    private void setup() {

        String[] s = new String[4];
        myViewPagerAdapter = new ProductImageSliderAdapter(this, s);
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);


    }

    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

    private void addBottomDots(int currentPage) {
        dots = new TextView[4];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        dotsLayout.removeAllViews();

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(colorsActive[currentPage]);
    }

    @Override
    public void showData() {


        showDetails();

        showAvailabilityIn();

        desription.setText("asdfsdfasdf f asdfsdf asdf asdf sdf sdf sdf sdf sdf sdf sdf sdf asdfsdfasdf f asdfsdf asdf asdf sdf sdf sdf sdf sdf sdf sdf sdf asdfsdfasdf f asdfsdf asdf asdf sdf sdf sdf sdf sdf sdf sdf sdf ");
    }

    private void showDetails() {

        String keys = "Name,sexy;baby,you;are,hot;sizzline,aaah";
        String keyValues[] = keys.split(";");


        for (int i = 0; i < keyValues.length; i++) {
            TableRow row = new TableRow(this);


            View v = View.inflate(ProductInfoPopupActivity.this, R.layout.horizontol_view, null);


            Timber.e(keyValues[i].split(",")[0]);
            ((TextView) v.findViewById(R.id.key)).setText(keyValues[i].split(",")[0]);
            ((TextView) v.findViewById(R.id.value)).setText(keyValues[i].split(",")[1]);

            row.addView(v);


            detailsTableLayout.addView(row);

        }
    }


    private void showAvailabilityIn() {

        String keys = "Size,L,M,Q:color,red,blue,green:type,1,2,3";

        String[] keyValues = keys.split(":");


        for (int i = 0; i < keyValues.length; i++) {

            TableRow row = new TableRow(this);


            View v = View.inflate(ProductInfoPopupActivity.this, R.layout.varieties_view, null);


            String values[] = keyValues[i].split(",");

            Timber.e(values[0]);


            ((TextView) v.findViewById(R.id.key)).setText(values[0]);

            TableLayout valuesTable = v.findViewById(R.id.innerVarietiesTable);

            for (int j = 1; j < values.length; j++) {

                TableRow rowrow = new TableRow(this);


                View txtView = View.inflate(ProductInfoPopupActivity.this, R.layout.text_view_for_values, null);
                TextView txt = txtView.findViewById(R.id.values);
                txt.setText(values[j]);
                //txt.setBackground(getDrawable(R.drawable.white_rectangle_border_purple));
                txt.setTextColor(getResources().getColor(R.color.textDarkPrimary));
                rowrow.addView(txtView);
                valuesTable.addView(rowrow);

            }


            row.addView(v);


            varietiesTableLayout.addView(row);


        }
        groupForVarieties.setVisibility(View.GONE);


    }


    private int dpsToPixels(int dps) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dps * scale + 0.5f);
    }

}