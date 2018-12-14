package com.chaze.india.utils;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

import static com.google.android.gms.internal.measurement.zzsl.init;

public class HackedViewPager extends ViewPager {

    public HackedViewPager(Context context) {
        super(context);
    }


    public HackedViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }




    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        try {
            return super.onInterceptTouchEvent(ev);
        } catch (IllegalArgumentException e) {
            //uncomment if you really want to see these errors
            //e.printStackTrace();
            return false;
        }
    }
}
