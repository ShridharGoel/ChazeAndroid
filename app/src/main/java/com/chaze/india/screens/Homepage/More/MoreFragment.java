package com.chaze.india.screens.Homepage.More;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.chaze.india.screens.Profile.ProfileActivity;
import com.chaze.india.screens.base.BaseFragment;
import com.chaze.india.R;
import com.chaze.india.screens.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoreFragment extends BaseFragment {

    @BindView(R.id.goToProfile)
    Button goToProfile;

    public MoreFragment() {
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_more,container,false);

        setUnBinder(ButterKnife.bind(this, view));

        goToProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ProfileActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }


}
