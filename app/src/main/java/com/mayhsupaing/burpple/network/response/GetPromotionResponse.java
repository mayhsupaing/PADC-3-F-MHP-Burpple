package com.mayhsupaing.burpple.network.response;

import com.mayhsupaing.burpple.data.vo.PromotionVO;

import java.util.List;

/**
 * Created by Lenovo on 1/12/2018.
 */

public class GetPromotionResponse {

    private int code;
    private String message;
    private String apiVersion;
    private String page;
    private List<PromotionVO> promotions;

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

    public List<PromotionVO> getPromotions() {
        return promotions;
    }
}
