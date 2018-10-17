package com.chaze.india.screens.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Shubham Vishwakarma on 4/10/18.
 */

public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    private int mCurrentPosition;

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    protected abstract void clear();

    public void onBind(int position) {

    }

    public int getCurrentPosition() {
        return mCurrentPosition;
    }
}
