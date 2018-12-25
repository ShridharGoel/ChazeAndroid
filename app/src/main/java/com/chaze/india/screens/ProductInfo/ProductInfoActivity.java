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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.chaze.india.R;
import com.chaze.india.models.Ecommerce.CartBusiness;
import com.chaze.india.models.Ecommerce.CartItem;
import com.chaze.india.models.Ecommerce.Detail;
import com.chaze.india.models.Ecommerce.Product;
import com.chaze.india.models.Ecommerce.Variety;
import com.chaze.india.screens.base.BaseActivity;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    @BindView(R.id.sheet_image)
    ImageView sheetImage;

    @BindView(R.id.sheet_name)
    TextView sheetName;

    @BindView(R.id.sheet_price)
    TextView sheetPriceView;

    @BindView(R.id.cart_decrease_quantity)
    TextView decreaseQuantity;

    @BindView(R.id.cart_increase_quantity)
    TextView increaseQuantity;

    @BindView(R.id.cart_item_quantity)
    TextView quantityCount;

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

    @BindView(R.id.confirm)
    TextView confirm;

    @BindView(R.id.cart_count_badge)
    TextView cartCountBadge;

    @Inject
    ProductInfoContract.Presenter<ProductInfoContract.View> presenter;

    ArrayList<View> viewList = new ArrayList<>();

    HashMap<String, ArrayList<View>> map = new HashMap<>();

    ProductImageSliderAdapter myViewPagerAdapter;

    BottomSheetBehavior sheetBehavior;

    Detail[] selectedVariety;
    String selectedVarietyString;

    Long quantity = Long.valueOf(0);

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
        presenter.loadData(product);
        cartCountBadge.setText(presenter.getItemsCount());
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

    private void setupSheet(CartItem ci) {

        if (ci != null) {
            quantity = ci.getQuantity();
            selectedVarietyString = ci.getDescription();
            if (selectedVarietyString != null) {
                selectedVariety = (new Gson()).fromJson(selectedVarietyString, Detail[].class);
            }
        }
        Picasso.get().load(product.getImageFirst()).placeholder(R.drawable.shop_place_holder).into(sheetImage);
        quantityCount.setText(String.valueOf(quantity));
        decreaseQuantity.setOnClickListener(v -> {
            if (quantity == 0) {
                Toast.makeText(this, "Count is already Zero", Toast.LENGTH_SHORT).show();
            } else {
                quantity--;
                quantityCount.setText(String.valueOf(quantity));
            }
        });

        increaseQuantity.setOnClickListener(v -> {
            quantity++;
            quantityCount.setText(String.valueOf(quantity));
        });

        confirm.setOnClickListener(v -> {
            if (ci == null || !ci.getQuantity().equals(quantity)) {

                boolean isDone = true;
                for (int i = 0; i < selectedVariety.length; i++) {
                    if (selectedVariety[i].getValue() == null) {
                        Toast.makeText(this, "" + selectedVariety[i].getType() + " not selected", Toast.LENGTH_SHORT).show();
                        isDone = false;
                        break;
                    }
                }


                if (isDone) {
                    presenter.addItems(product, quantity, selectedVarietyString, cartCountBadge);
                    Timber.e(selectedVarietyString);
                }
            }
            showProgress();
        });

        sheetName.setText(product.getName());
        sheetPriceView.setText("Rs. " + product.getPrice());

    }

    private void showProgress() {
    }

    public void hideSheet() {

        isSheetClosed = true;

        sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        Timber.e("Close sheet");
    }

    public void showSheet() {
        isSheetClosed = false;
//        Timber.e("Show sheet");
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
    public void showData(CartItem ci) {

        setupSheet(ci);
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
        desription.setText(product.getDescription());
    }

    private void showDetails() {
        Detail[] details = (new Gson()).fromJson(product.getDetails(), Detail[].class);

        for (int i = 0; i < details.length; i++) {
            TableRow row = new TableRow(this);
            View v = View.inflate(ProductInfoActivity.this, R.layout.horizontol_view, null);
//            Timber.e(details[i].getType());
            ((TextView) v.findViewById(R.id.key)).setText(details[i].getType());
            ((TextView) v.findViewById(R.id.value)).setText(details[i].getValue());
            row.addView(v);
            detailsTableLayout.addView(row);
        }
    }

    private void showVarieties(TableLayout varietiesTableLayout, boolean isCartSheet) {

        Variety[] varieties = (new Gson()).fromJson(product.getVarieties(), Variety[].class);

        if (isCartSheet && selectedVariety == null) {
            selectedVariety = new Detail[varieties.length];
            for (int i = 0; i < selectedVariety.length; i++) {
                selectedVariety[i] = new Detail();
            }
        }


        int l = varieties.length;
        TableRow row;
        View v;
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

//            Timber.e(varieties[i].getKey());


            key = varieties[i].getKey();

            ((TextView) v.findViewById(R.id.key)).setText(key);
            valuesTable = v.findViewById(R.id.innerVarietiesTable);
            rowrow = new TableRow(this);
            currx = 0;
            View txtView;
            TextView txt;

            if (isCartSheet) {
                selectedVariety[i].setType(key);
                map.put(key, new ArrayList<View>());
            }


            for (int j = 0; j < varieties[i].getValues().size(); j++) {

                txtView = View.inflate(ProductInfoActivity.this, R.layout.text_view_for_values, null);
                txt = txtView.findViewById(R.id.values);
                txt.setText(varieties[i].getValues().get(j));
                txt.setBackground(getDrawable(R.drawable.white_rectangle_border_gray));
                txt.setTextColor(getResources().getColor(R.color.textDarkPrimary));

                if (isCartSheet) {
                    map.get(key).add(txt);
                    txt.setOnClickListener(vi -> {
                        Timber.e((((TextView) (vi.findViewById(R.id.values))).getText().toString()));
                        broadcast(vi);
                    });
                }

                txt.setLayoutParams(lp);
                int width = dpsToPixels(varieties[i].getValues().get(j).length() * 30 + 8);

                rowrow.addView(txtView);


                currx += width + dpsToPixels(16);


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


        if (isCartSheet && selectedVarietyString != null) {
            highlightSelectedChoicesInSheet();
        }
    }

    private void highlightSelectedChoicesInSheet() {
        for (Map.Entry<String, ArrayList<View>> views : map.entrySet()) {
            viewList = views.getValue();
            String key = views.getKey();
            for (int i = 0; i < selectedVariety.length; i++) {
                if (key.equals(selectedVariety[i].getType()) && selectedVariety[i].getValue() != null) {
                    for (int j = 0; j < viewList.size(); j++) {
                        if (((TextView) viewList.get(j)).getText().toString().equals(selectedVariety[i].getValue())) {
                            viewList.get(j).setBackground(getDrawable(R.drawable.yellow_rectangle_border_purple));
                        }
                    }
                }
            }
        }


    }

    private void broadcast(View vi) {
        for (Map.Entry<String, ArrayList<View>> views : map.entrySet()) {
            viewList = views.getValue();
            String key = views.getKey();
            boolean isFound = false;
            for (View v : viewList) {
                if (v == vi) {
                    v.setBackground(getDrawable(R.drawable.yellow_rectangle_border_purple));

                    for (int i = 0; i < selectedVariety.length; i++) {
                        if (key.equals(selectedVariety[i].getType())) {
                            selectedVariety[i].setValue(((TextView) v).getText().toString());
                            break;
                        }
                    }
                    selectedVarietyString = (new Gson()).toJson(selectedVariety);
                    /*Timber.e("Befor: " + selectedVarietyString);
                    selectedVariety = (new Gson()).fromJson(selectedVarietyString, Detail[].class);
                    selectedVarietyString = (new Gson()).toJson(selectedVariety);
                    Timber.e("After: " + selectedVarietyString);*/

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


