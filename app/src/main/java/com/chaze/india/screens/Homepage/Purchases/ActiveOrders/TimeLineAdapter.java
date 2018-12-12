package com.chaze.india.screens.Homepage.Purchases.ActiveOrders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chaze.india.R;
import com.chaze.india.models.Ecommerce.TimeLine;
import com.github.vipulasri.timelineview.TimelineView;

import java.util.ArrayList;

public class TimeLineAdapter extends RecyclerView.Adapter<TimeLineAdapter.TimeLineViewHolder> {
    private ArrayList<TimeLine> trackStatusList;
    private Context context;

    public TimeLineAdapter(ArrayList<TimeLine> trackStatusList, Context context) {
        this.trackStatusList = trackStatusList;
        this.context = context;
    }

    @NonNull
    @Override
    public TimeLineViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_timeline, viewGroup, false);

        return new TimeLineViewHolder(itemView,i);
    }

    @Override
    public void onBindViewHolder(@NonNull TimeLineViewHolder timeLineViewHolder, int i) {
        TimeLine timeLineModel = trackStatusList.get(i);
        if(timeLineModel.getStatus() == "SUCCESSFUL") {
            timeLineViewHolder.mTimelineView.setMarker(ContextCompat.getDrawable(context, R.drawable.ic_marker), ContextCompat.getColor(context, R.color.dot_dark_screen4));
        } else
        if(i<3 && trackStatusList.get(i+1).getStatus() == "SUCCESSFUL") {
            timeLineViewHolder.mTimelineView.setMarker(ContextCompat.getDrawable(context, R.drawable.ic_marker_active), ContextCompat.getColor(context, R.color.dot_dark_screen4));
        }else
        if (timeLineModel.getStatus().equals("")){
            timeLineViewHolder.mTimelineView.setMarker(ContextCompat.getDrawable(context,R.drawable.ic_marker_inactive),ContextCompat.getColor(context,R.color.dot_dark_screen4));
        }

        timeLineViewHolder.title.setText(timeLineModel.getMessage());
    }
    public void addItems() {

        for (int i = 0; i < 4; i++)
            trackStatusList.add(new TimeLine("SUCCESSFUL","Order confirmed"  ));
    }
    @Override
    public int getItemCount() {
        return trackStatusList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return TimelineView.getTimeLineViewType(position,getItemCount());
    }

    public class TimeLineViewHolder extends RecyclerView.ViewHolder{
        public TimelineView mTimelineView;
        public TextView title;
        public TimeLineViewHolder(@NonNull View itemView,int viewType) {
            super(itemView);
            mTimelineView = (TimelineView) itemView.findViewById(R.id.time_marker);
            title=itemView.findViewById(R.id.text_timeline_title);
            //status=itemView.findViewById(R.id.status);
            mTimelineView.initLine(viewType);
        }
    }
}
