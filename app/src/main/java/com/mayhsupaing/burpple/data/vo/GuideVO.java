package com.mayhsupaing.burpple.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lenovo on 1/13/2018.
 */

public class GuideVO {
    @SerializedName("burpple-guide-id")
    private String guideId;

    @SerializedName("burpple-guide-image")
    private String guideImage;

    @SerializedName("burpple-guide-title")
    private String guideTitle;

    @SerializedName("burpple-guide-desc")
    private String guidedescripition;

    public String getGuideId() {
        return guideId;
    }

    public String getGuideImage() {
        return guideImage;
    }

    public String getGuideTitle() {
        return guideTitle;
    }

    public String getGuidedescripition() {
        return guidedescripition;
    }
}
