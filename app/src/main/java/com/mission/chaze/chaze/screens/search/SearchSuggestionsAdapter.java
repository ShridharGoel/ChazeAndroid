package com.mission.chaze.chaze.screens.search;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mission.chaze.chaze.R;
import com.mission.chaze.chaze.models.SearchResult;
import com.mission.chaze.chaze.models.ecomerceCategory;

import java.util.List;

public class SearchSuggestionsAdapter extends RecyclerView.Adapter<SearchSuggestionsAdapter.ViewHolder> {
    Context context;
    List<SearchResult> categoryList;

    public SearchSuggestionsAdapter(Context context, List<SearchResult> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.search_suggestion_item, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        SearchResult item = categoryList.get(i);
        viewHolder.searchText.setText(item.getText());
        //viewHolder.imageView.setImageDrawable(item.getImage());

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView searchText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            searchText = itemView.findViewById(R.id.suggestion);
        }
    }
}
