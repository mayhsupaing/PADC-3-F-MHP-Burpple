package com.mayhsupaing.burpple.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mayhsupaing.burpple.R;
import com.mayhsupaing.burpple.data.vo.PromotionVO;
import com.mayhsupaing.burpple.viewholders.ItemsFoodGuides;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 1/4/2018.
 */

public class FoodGuidesAdapter extends RecyclerView.Adapter<ItemsFoodGuides>{

    private List<PromotionVO> mGuideList;

    public FoodGuidesAdapter() {
        mGuideList= new ArrayList<>();
    }

    @Override
    public ItemsFoodGuides onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View foodGuideItemsView = inflater.inflate(R.layout.item_food_guides, parent, false);
        ItemsFoodGuides itemsFoodGuides = new ItemsFoodGuides(foodGuideItemsView);
        return itemsFoodGuides;
    }

    @Override
    public void onBindViewHolder(ItemsFoodGuides holder, int position) {
        holder.setGuide(mGuideList.get(position));
    }


    @Override
    public int getItemCount() {
        return mGuideList.size();
    }

    public void setGuide(List<PromotionVO> guideList) {
        mGuideList = guideList;
        notifyDataSetChanged();
    }
}
