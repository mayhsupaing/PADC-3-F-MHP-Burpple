package com.mayhsupaing.burpple.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lenovo on 1/23/2018.
 */

public class FavouriteFoodVO {
    @SerializedName("favorite_food_id")
    private int favFoodId;

    @SerializedName("title")
    private String favFoodTitle;

    @SerializedName("photoUrl")
    private String favFoodPhotoUrl;

    public int getFavFoodId() {
        return favFoodId;
    }

    public String getFavFoodTitle() {
        return favFoodTitle;
    }

    public String getFavFoodPhotoUrl() {
        return favFoodPhotoUrl;
    }
}
