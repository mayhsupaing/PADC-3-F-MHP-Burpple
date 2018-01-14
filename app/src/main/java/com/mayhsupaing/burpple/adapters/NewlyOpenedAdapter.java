package com.mayhsupaing.burpple.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mayhsupaing.burpple.R;
import com.mayhsupaing.burpple.viewholders.ItemsNewlyOpened;

/**
 * Created by Lenovo on 1/4/2018.
 */

public class NewlyOpenedAdapter extends RecyclerView.Adapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View newlyOpened = inflater.inflate(R.layout.item_newly_opened, parent, false);
        ItemsNewlyOpened itemsNewlyOpened = new ItemsNewlyOpened(newlyOpened);
        return itemsNewlyOpened;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

}
