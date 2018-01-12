package com.mayhsupaing.burpple.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mayhsupaing.burpple.R;
import com.mayhsupaing.burpple.data.vo.PromotionVO;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lenovo on 1/4/2018.
 */

public class ItemsFoodGuides extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_food_guide)
    ImageView ivFoodGuide;

    @BindView(R.id.tv_guide_promotion_title)
    TextView tvGuidePromotionTitle;

    @BindView(R.id.tv_guide_shop_name)
    TextView tvGuideShopName;

    @BindView(R.id.tv_guide_shop_area)
    TextView tvGuideShopArea;

    public ItemsFoodGuides(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void setGuide(PromotionVO guide)
    {
        tvGuidePromotionTitle.setText(guide.getPromotionTitle());
        tvGuideShopName.setText(guide.getPromotionShop().getPromotionShopName());
        tvGuideShopArea.setText(guide.getPromotionShop().getPromotionShopArea());

        Glide.with(ivFoodGuide.getContext())
                .load(guide.getPromotionImage())
                .into(ivFoodGuide);
    }
}
