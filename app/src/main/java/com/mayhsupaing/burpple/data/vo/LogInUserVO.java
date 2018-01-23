package com.mayhsupaing.burpple.data.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Lenovo on 1/23/2018.
 */

public class LogInUserVO {
    private int userId;
    private String name;
    private String email;
    private String phoneNo;
    private String profileUrl;
    private String coverUrl;

    @SerializedName("fav_food_places")
    private List<FavouriteFoodPlacesVO> favouriteFoodPlace;

    @SerializedName("fav_foods")
    private List<FavouriteFoodVO> favouriteFood;

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public List<FavouriteFoodPlacesVO> getFavouriteFoodPlace() {
        return favouriteFoodPlace;
    }

    public List<FavouriteFoodVO> getFavouriteFood() {
        return favouriteFood;
    }
}
