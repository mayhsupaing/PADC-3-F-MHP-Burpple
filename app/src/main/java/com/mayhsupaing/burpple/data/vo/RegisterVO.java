package com.mayhsupaing.burpple.data.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Lenovo on 1/23/2018.
 */

public class RegisterVO {

    private int userId;
    private String name;
    private String email;
    private String phoneNo;
    private String profileUrl;
    private String coverUrl;

    @SerializedName("fav_foods")
    private List<String> favouriteFood;

    @SerializedName("fav_food_places")
    private List<String> favouritePlace;

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

    public List<String> getFavouriteFood() {
        return favouriteFood;
    }

    public List<String> getFavouritePlace() {
        return favouritePlace;
    }
}
