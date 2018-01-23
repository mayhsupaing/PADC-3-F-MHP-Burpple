package com.mayhsupaing.burpple.network.response;

import com.google.gson.annotations.SerializedName;
import com.mayhsupaing.burpple.data.vo.RegisterVO;

/**
 * Created by Lenovo on 1/23/2018.
 */

public class GetRegisterResponse {

    private int code;
    private String message;

    @SerializedName("register_user")
    private RegisterVO registerUser;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public RegisterVO getRegisterUser() {
        return registerUser;
    }
}
