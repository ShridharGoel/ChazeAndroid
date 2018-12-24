package com.chaze.india.screens.search;

import android.content.Context;
import android.support.annotation.NonNull;

import com.chaze.india.models.Suggestion;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.chaze.india.R;

import java.util.List;

public class SearchSuggestionsAdapter extends RecyclerView.Adapter<SearchSuggestionsAdapter.ViewHolder> {
    Context context;
    List<Suggestion> suggestions;
    SearchView searchView;

    public SearchSuggestionsAdapter(Context context, List<Suggestion> suggestions) {
        this.context = context;
        this.suggestions = suggestions;
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
        Suggestion item = suggestions.get(i);
        viewHolder.searchText.setText(item.getName());
        //viewHolder.imageView.setImageDrawable(item.getImage());

    }

    @Override
    public int getItemCount() {
        return suggestions.size();
    }


    public void recreateList(List<Suggestion> list, SearchView searchView) {
        suggestions.clear();
        this.searchView = searchView;
        suggestions.addAll(list);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView searchText;
        ImageView searchIconImageView;
        ImageView autoCompleteImageView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            searchText = itemView.findViewById(R.id.suggestion);
            searchIconImageView = itemView.findViewById(R.id.search_icon);
            autoCompleteImageView = itemView.findViewById(R.id.auto_complete);

            searchText.setOnClickListener(v -> goToSearch(searchText.getText()));
            searchIconImageView.setOnClickListener(v -> goToSearch(searchText.getText()));
            autoCompleteImageView.setOnClickListener(v -> fillSearchWithString(searchText.getText()));

        }
    }

    private void fillSearchWithString(CharSequence text) {
        searchView.setQuery(text, false);
    }

    private void goToSearch(CharSequence text) {
        Toast.makeText(context, "Go To search: " + text.toString(), Toast.LENGTH_SHORT).show();
    }
}
