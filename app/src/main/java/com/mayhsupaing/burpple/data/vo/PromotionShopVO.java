package com.mayhsupaing.burpple.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lenovo on 1/12/2018.
 */

public class PromotionShopVO {
    @SerializedName("burpple-shop-id")
    private String promotionShopId;

    @SerializedName("burpple-shop-name")
    private String promotionShopName;

    @SerializedName("burpple-shop-area")
    private String promotionShopArea;

    public String getPromotionShopId() {
        return promotionShopId;
    }

    public String getPromotionShopName() {
        return promotionShopName;
    }

    public String getPromotionShopArea() {
        return promotionShopArea;
    }
}
