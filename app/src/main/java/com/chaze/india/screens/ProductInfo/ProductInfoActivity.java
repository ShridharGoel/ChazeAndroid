package com.chaze.india.screens.ProductInfo;

import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Group;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.Display;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.chaze.india.R;
import com.chaze.india.models.Ecommerce.Product;
import com.chaze.india.screens.base.BaseActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class ProductInfoActivity extends BaseActivity implements ProductInfoContract.View {

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


    @BindView(R.id.button)
    Button addToCart;

    @BindView(R.id.bottom_sheet_add_to_cart)
    ConstraintLayout layoutBottomSheet;

    @BindView(R.id.verieties_table_layout_sheet)
    TableLayout varitiesSheet;

    @BindView(R.id.image_button)
    TextView sheetCloseButton;

    ArrayList<View> viewList = new ArrayList<>();

    HashMap<String, ArrayList<View>> map = new HashMap<>();

    @Inject
    ProductInfoContract.Presenter<ProductInfoContract.View> presenter;

    ProductImageSliderAdapter myViewPagerAdapter;

    BottomSheetBehavior sheetBehavior;


    @BindView(R.id.offer_view)
    TextView discount;


    @BindView(R.id.rating_view)
    TextView rating;


    @BindView(R.id.ratingUsers)
    TextView ratingUsers;


    @BindView(R.id.price_view)
    TextView price;

    @BindView(R.id.stockItems_view)
    TextView stock;

    @BindView(R.id.discount_view)
    TextView discountedPrice;

    @BindView(R.id.name_view)
    TextView name;

    boolean isSheetClosed = false;

    Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_popup_info);

        ButterKnife.bind(this);
        getActivityComponent().inject(this);


        product = (Product) getIntent().getExtras().getSerializable("Product");
        setup();


        presenter.onAttach(this);
        presenter.loadData();
    }

    private void setup() {

        String[] s = new String[3];
        s[0] = product.getImageFirst();
        s[1] = product.getImageSecond();
        s[2] = product.getImageThird();
        myViewPagerAdapter = new ProductImageSliderAdapter(this, s);
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

        sheetBehavior = BottomSheetBehavior.from(layoutBottomSheet);
        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_HIDDEN:
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED: {
                        //  btnBottomSheet.setText("Close Sheet");
                    }
                    break;
                    case BottomSheetBehavior.STATE_COLLAPSED: {
                        //btnBottomSheet.setText("Expand Sheet");
                        break;
                    }
                    case BottomSheetBehavior.STATE_DRAGGING: {

                        if (!isSheetClosed)
                            sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                        break;
                    }

                    case BottomSheetBehavior.STATE_SETTLING: {
                        if (!isSheetClosed)
                            sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                        break;
                    }

                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });

        addToCart.setOnClickListener(v -> showSheet());
        sheetCloseButton.setOnClickListener(v -> hideSheet());

        addBottomDots(0);
    }

    public void hideSheet() {

        isSheetClosed = true;

        sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        Timber.e("Close sheet");
    }

    public void showSheet() {
        isSheetClosed = false;
        Timber.e("Show sheet");
        sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
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

        dotsLayout.removeAllViews();

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.colorPurple));
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(getResources().getColor(R.color.yellow));
    }

    @Override
    public void showData() {
        name.setText(product.getName());
        rating.setText(String.valueOf(product.getRating()));
        if (product.getDiscount() != null && product.getDiscount() != 0)
            discountedPrice.setText(String.valueOf(product.getPrice() * (1 - (product.getDiscount() / 100))));
        else discountedPrice.setVisibility(View.GONE);

        discount.setText(String.valueOf(product.getDiscount()));
        price.setText(String.valueOf(product.getPrice()));
        stock.setText(String.valueOf(product.getStock()));


        showDetails();
        showVarieties(varitiesSheet, true);
        showVarieties(varietiesTableLayout, false);

        desription.setText("asdfsdfasdf f asdfsdf asdf asdf sdf sdf sdf sdf sdf sdf sdf sdf asdfsdfasdf f asdfsdf asdf asdf sdf sdf sdf sdf sdf sdf sdf sdf asdfsdfasdf f asdfsdf asdf asdf sdf sdf sdf sdf sdf sdf sdf sdf ");
    }

    private void showDetails() {

        String keys = "Range,5 metres;Brand,Fun;are,blueish;cloth,coton";
        String keyValues[] = keys.split(";");


        for (int i = 0; i < keyValues.length; i++) {
            TableRow row = new TableRow(this);


            View v = View.inflate(ProductInfoActivity.this, R.layout.horizontol_view, null);


            Timber.e(keyValues[i].split(",")[0]);
            ((TextView) v.findViewById(R.id.key)).setText(keyValues[i].split(",")[0]);
            ((TextView) v.findViewById(R.id.value)).setText(keyValues[i].split(",")[1]);

            row.addView(v);


            detailsTableLayout.addView(row);

        }
    }


    private void showVarieties(TableLayout varietiesTableLayout, boolean isCartSheet) {

        String keys = "Size,L,M,Q,asdfsadf,fsdfsfgds,sdf:color,red,blue,green:type,1,2,3";

        String[] keyValues = keys.split(":");

        int l = keyValues.length;
        TableRow row;
        View v;
        String values[];
        TableLayout valuesTable;
        TableRow rowrow;
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        int sizex = size.x;
        int currx;
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        lp.rightMargin = dpsToPixels(8);
        lp.bottomMargin = dpsToPixels(8);


        String key;
        for (int i = 0; i < l; i++) {

            row = new TableRow(this);
            v = View.inflate(ProductInfoActivity.this, R.layout.varieties_view, null);


            values = keyValues[i].split(",");

            Timber.e(values[0]);

            key = values[0];
            ((TextView) v.findViewById(R.id.key)).setText(key);

            valuesTable = v.findViewById(R.id.innerVarietiesTable);

            rowrow = new TableRow(this);
            currx = 0;


            View txtView;

            TextView txt;

            if (isCartSheet)
                map.put(key, new ArrayList<View>());

            for (int j = 1; j < values.length; j++) {


                txtView = View.inflate(ProductInfoActivity.this, R.layout.text_view_for_values, null);
                txt = txtView.findViewById(R.id.values);
                txt.setText(values[j]);
                txt.setBackground(getDrawable(R.drawable.white_rectangle_border_gray));
                txt.setTextColor(getResources().getColor(R.color.textDarkPrimary));

                if (isCartSheet)
                    map.get(key).add(txt);

                if (isCartSheet)
                    txt.setOnClickListener(vi -> {
                        Timber.e((((TextView) (vi.findViewById(R.id.values))).getText().toString()));
                        broadcast(vi);
                    });

                // viewList.add(txtView);


                txt.setLayoutParams(lp);
                int width = dpsToPixels(values[j].length() * 30 + 8);

                rowrow.addView(txtView);


                currx += width + dpsToPixels(16);

                Timber.e("Sizex=" + sizex + ", currx = " + currx);

                if (1.2 * currx > sizex) {
                    currx = 0;
                    valuesTable.addView(rowrow);
                    rowrow = new TableRow(this);
                }
            }
            valuesTable.addView(rowrow);

            row.addView(v);


            varietiesTableLayout.addView(row);


        }
    }

    private void broadcast(View vi) {


        for (Map.Entry<String, ArrayList<View>> views : map.entrySet()) {

            viewList = views.getValue();
            boolean isFound = false;
            for (View v : viewList) {
                if (v == vi) {
                    v.setBackground(getDrawable(R.drawable.yellow_rectangle_border_purple));
                    isFound = true;
                    break;
                }
            }

            if (isFound) {
                for (View v : viewList) {
                    if (v != vi) {
                        v.setBackground(getDrawable(R.drawable.white_rectangle_border_gray));
                    }
                }

                break;
            }

        }

    }


    private int dpsToPixels(int dps) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dps * scale + 0.5f);
    }

}


