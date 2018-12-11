package com.chaze.india.screens.Homepage.Purchases.ActiveOrders;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.widget.LinearLayoutManager;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.chaze.india.R;
import com.chaze.india.di.Qualifiers.LinLayoutVert;
import com.chaze.india.screens.base.BaseFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.subjects.PublishSubject;
import timber.log.Timber;

public class ActiveOrdersFragment extends BaseFragment implements ActiveOrdersContract.View {


    private static final String TAG = ActiveOrdersFragment.class.getSimpleName();
    @Inject
    ActiveOrdersContract.Presenter<ActiveOrdersContract.View> mPresenter;
    @BindView(R.id.activeOrderRecycler)
    RecyclerView recyclerView;
    @Inject
    ActiveOrdersAdapter adapter;
    @Inject
    TimeLineAdapter timeLineAdapter;
    @BindView(R.id.timelineRecyclerView)
    RecyclerView timelineRecyclerView;
    @Inject
    @LinLayoutVert
    LinearLayoutManager mLayoutManager, linearLayoutManager;
    BottomSheetBehavior sheetBehavior;

    @BindView(R.id.activeOrdersBottomSheet)
    LinearLayout layoutBottomSheet;

    int isPrevious = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Timber.d(TAG);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            isPrevious = bundle.getInt("key", 0);
        }

        View view = inflater.inflate(R.layout.fragment_active_orders, container, false);

        onAttach(getContext());
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this, view));
        mPresenter.onAttach(this);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter.addItems();
        timeLineAdapter.addItems();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(mLayoutManager);
        timelineRecyclerView.setAdapter(timeLineAdapter);
        timelineRecyclerView.setLayoutManager(linearLayoutManager);
        sheetBehavior = BottomSheetBehavior.from(layoutBottomSheet);
        sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

        mPresenter.show();
    }

    @Override
    public void setSubjectToAdapter(PublishSubject<String> subject) {
        adapter.setSubject(subject);
    }

    @Override
    public void showOnActivity() {

    }

    @Override
    public void showFull(String str) {
        sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    @OnClick(R.id.close_button_container)
    public void toggleBottomSheet() {

        sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

    }
}
