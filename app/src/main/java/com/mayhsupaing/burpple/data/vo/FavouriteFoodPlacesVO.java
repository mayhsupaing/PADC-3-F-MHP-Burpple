package com.mayhsupaing.burpple.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lenovo on 1/23/2018.
 */

public class FavouriteFoodPlacesVO {

    @SerializedName("favorite_food_place_id")
    private int favPlaceId;

    @SerializedName("title")
    private String favPlaceTitle;

    @SerializedName("address")
    private String favPlaceAddress;

    @SerializedName("photoUrl")
    private String favPlacePhotoUrl;

    public int getFavPlaceId() {
        return favPlaceId;
    }

    public String getFavPlaceTitle() {
        return favPlaceTitle;
    }

    public String getFavPlaceAddress() {
        return favPlaceAddress;
    }

    public String getFavPlacePhotoUrl() {
        return favPlacePhotoUrl;
    }
}
