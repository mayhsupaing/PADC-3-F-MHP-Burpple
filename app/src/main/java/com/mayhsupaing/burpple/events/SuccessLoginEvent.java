package com.mayhsupaing.burpple.events;


import com.mayhsupaing.burpple.data.vo.LogInUserVO;
import com.mayhsupaing.burpple.data.vo.model.LogInUserModel;

/**
 * Created by Lenovo on 1/21/2018.
 */

public class SuccessLoginEvent {

    private LogInUserVO loginUserList;

    public LogInUserVO getLoginUserList() {
        return loginUserList;
    }

    public SuccessLoginEvent(LogInUserVO loginUserList) {
        this.loginUserList = loginUserList;
    }
}
