package com.mayhsupaing.burpple.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mayhsupaing.burpple.R;
import com.mayhsupaing.burpple.data.vo.PromotionVO;
import com.mayhsupaing.burpple.viewholders.ItemsFoodPromotion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 1/4/2018.
 */

public class FoodPromotionsAdapter extends RecyclerView.Adapter<ItemsFoodPromotion> {

    private List<PromotionVO> mPromotionList;

    public FoodPromotionsAdapter() {
        mPromotionList = new ArrayList<>();
    }

    @Override
    public ItemsFoodPromotion onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View foodItemsView = inflater.inflate(R.layout.item_food_promotion, parent, false);
        ItemsFoodPromotion itemsFoodPromotion = new ItemsFoodPromotion(foodItemsView);
        return itemsFoodPromotion;
    }

    @Override
    public void onBindViewHolder(ItemsFoodPromotion holder, int position) {
        holder.setPromotion(mPromotionList.get(position));
    }


    @Override
    public int getItemCount() {
        return mPromotionList.size();
    }

    public void setPromotion(List<PromotionVO> promotionList) {
        mPromotionList = promotionList;
        notifyDataSetChanged();
    }
}
