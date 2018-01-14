package com.mayhsupaing.burpple.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mayhsupaing.burpple.R;
import com.mayhsupaing.burpple.data.vo.GuideVO;
import com.mayhsupaing.burpple.data.vo.PromotionVO;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lenovo on 1/4/2018.
 */

public class ItemsFoodGuides extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_food_guide)
    ImageView ivFoodGuide;

    @BindView(R.id.tv_guide_title)
    TextView tvGuideTitle;

    public ItemsFoodGuides(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void setGuide(GuideVO guide)
    {
        tvGuideTitle.setText(guide.getGuideTitle());

        Glide.with(ivFoodGuide.getContext())
                .load(guide.getGuideImage())
                .into(ivFoodGuide);
    }
}
