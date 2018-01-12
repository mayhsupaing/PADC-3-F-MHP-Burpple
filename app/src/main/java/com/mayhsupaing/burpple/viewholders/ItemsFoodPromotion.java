package com.mayhsupaing.burpple.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mayhsupaing.burpple.R;
import com.mayhsupaing.burpple.data.vo.PromotionVO;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lenovo on 1/4/2018.
 */

public class ItemsFoodPromotion extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_food_promotions)
    ImageView ivFoodPromotion;

    @BindView(R.id.tv_promotion_title)
    TextView tvPromotionTitle;

    @BindView(R.id.tv_promotion_end_date)
    TextView tvPromotionEndDate;

    @BindView(R.id.tv_promotion_shop_name)
    TextView tvPromotionShopName;

    @BindView(R.id.tv_promotion_shop_area)
    TextView tvPromotionShopArea;
    public ItemsFoodPromotion(View itemView) {

        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void setPromotion(PromotionVO promotion){
        tvPromotionTitle.setText(promotion.getPromotionTitle());
        tvPromotionEndDate.setText(promotion.getPromotionUntil());
        tvPromotionShopName.setText(promotion.getPromotionShop().getPromotionShopName());
        tvPromotionShopArea.setText(promotion.getPromotionShop().getPromotionShopArea());

        Glide.with(ivFoodPromotion.getContext())
                .load(promotion.getPromotionImage())
                .into(ivFoodPromotion);

    }
}
