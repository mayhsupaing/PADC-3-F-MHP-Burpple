package com.mayhsupaing.burpple.network.response;

import com.mayhsupaing.burpple.data.vo.GuideVO;

import java.util.List;

/**
 * Created by Lenovo on 1/13/2018.
 */

public class GetGuideResponse {

    private int code;
    private String message;
    private String apiVersion;
    private String page;
    private List<GuideVO> featured;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPage() {
        return page;
    }

    public List<GuideVO> getFeatured() {
        return featured;
    }
}
