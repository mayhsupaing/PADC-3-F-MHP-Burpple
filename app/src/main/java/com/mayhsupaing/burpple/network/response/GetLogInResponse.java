package com.mayhsupaing.burpple.network.response;

import com.google.gson.annotations.SerializedName;
import com.mayhsupaing.burpple.data.vo.LogInUserVO;

/**
 * Created by Lenovo on 1/23/2018.
 */

public class GetLogInResponse {
    private int code;
    private String message;

    @SerializedName("login_user")
    private LogInUserVO loginUser;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public LogInUserVO getLoginUser() {
        return loginUser;
    }
}
