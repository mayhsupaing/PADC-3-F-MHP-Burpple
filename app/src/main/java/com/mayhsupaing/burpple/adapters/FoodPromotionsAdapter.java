package com.mayhsupaing.burpple.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mayhsupaing.burpple.R;
import com.mayhsupaing.burpple.viewholders.ItemsFoodPromotion;

/**
 * Created by Lenovo on 1/4/2018.
 */

public class FoodPromotionsAdapter extends RecyclerView.Adapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View foodItemsView=inflater.inflate(R.layout.item_food_promotion,parent,false);
        ItemsFoodPromotion itemsFoodPromotion=new ItemsFoodPromotion(foodItemsView);
        return itemsFoodPromotion;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 7;
    }
}
