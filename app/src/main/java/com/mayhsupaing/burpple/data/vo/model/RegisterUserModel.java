package com.mayhsupaing.burpple.data.vo.model;

import com.mayhsupaing.burpple.data.vo.LogInUserVO;
import com.mayhsupaing.burpple.data.vo.RegisterVO;
import com.mayhsupaing.burpple.events.SuccessRegisterEvent;
import com.mayhsupaing.burpple.events.UserLogOutEvent;
import com.mayhsupaing.burpple.network.FeaturedDataAgent;
import com.mayhsupaing.burpple.network.FeaturedRetrofitDataAgent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by Lenovo on 1/23/2018.
 */

public class RegisterUserModel {

    private static RegisterUserModel sObjInstance;

    private FeaturedDataAgent sDataAgent;

    private RegisterVO mRegisterUser;

    private RegisterUserModel(){
        sDataAgent= FeaturedRetrofitDataAgent.getsObjInstance();

        EventBus.getDefault().register(this);
    }

    public static RegisterUserModel getsObjInstance(){
        if(sObjInstance==null){
            sObjInstance=new RegisterUserModel();
        }
        return sObjInstance;
    }

    public void registerUser(String name,String password,String phoneNo){
        sDataAgent.registerUser(name, password, phoneNo);
    }

    public boolean isUserRegister() {

        return mRegisterUser != null;

    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onRegisterUserSuccess(SuccessRegisterEvent event) {
        mRegisterUser= event.getRegisterUserList(); //success register
    }

    public void logOut(){
        mRegisterUser=null;
        UserLogOutEvent event=new UserLogOutEvent();
        EventBus.getDefault().post(event);
    }
}
