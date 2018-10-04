
package com.mission.chaze.chaze.screens.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by Shubham Vishwakarma on 4/10/18.
 */

public abstract class BaseFragment extends Fragment implements MvpContract.View {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
    }

}
