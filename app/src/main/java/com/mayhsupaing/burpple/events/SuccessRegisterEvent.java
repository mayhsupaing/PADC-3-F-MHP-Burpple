package com.mayhsupaing.burpple.events;

import com.mayhsupaing.burpple.data.vo.LogInUserVO;
import com.mayhsupaing.burpple.data.vo.RegisterVO;

/**
 * Created by Lenovo on 1/23/2018.
 */

public class SuccessRegisterEvent {

    private RegisterVO registerUserList;

    public SuccessRegisterEvent(RegisterVO registerUserList) {
        this.registerUserList = registerUserList;
    }

    public RegisterVO getRegisterUserList() {
        return registerUserList;
    }
}
