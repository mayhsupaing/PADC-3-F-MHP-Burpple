package com.mayhsupaing.burpple.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mayhsupaing.burpple.R;
import com.mayhsupaing.burpple.viewholders.ItemsNewAndTrending;

import java.util.zip.Inflater;

/**
 * Created by Lenovo on 1/4/2018.
 */

public class NewAndTrendingAdapter extends RecyclerView.Adapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View newAndTrending=inflater.inflate(R.layout.item_new_and_trending,parent,false);
        ItemsNewAndTrending itemsNewAndTrending=new ItemsNewAndTrending(newAndTrending);
        return itemsNewAndTrending;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
