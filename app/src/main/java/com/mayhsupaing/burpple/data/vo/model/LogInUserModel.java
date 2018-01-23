package com.mayhsupaing.burpple.data.vo.model;

import com.mayhsupaing.burpple.data.vo.LogInUserVO;
import com.mayhsupaing.burpple.events.SuccessLoginEvent;
import com.mayhsupaing.burpple.events.UserLogOutEvent;
import com.mayhsupaing.burpple.network.FeaturedDataAgent;
import com.mayhsupaing.burpple.network.FeaturedRetrofitDataAgent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by Lenovo on 1/23/2018.
 */

public class LogInUserModel {

    private static LogInUserModel sObjInstance;

    private FeaturedDataAgent sDataAgent;

    private LogInUserVO mlogInUser;


    private LogInUserModel(){
        sDataAgent= FeaturedRetrofitDataAgent.getsObjInstance();
        EventBus.getDefault().register(this);
    }

    public static  LogInUserModel getsObjInstance(){
        if(sObjInstance==null){
            sObjInstance=new LogInUserModel();
        }
        return sObjInstance;
    }
    public void logInUser(String phoneNo, String password) {
        sDataAgent.loginUser(phoneNo,password);
    }

    //check whether user is login or not.
    public boolean isUserLogIn() {

        return mlogInUser != null;

        /*if(mLogInUser==null){
            return  false;
        }
        else
            return true;*/
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onLoginUserSuccess(SuccessLoginEvent event) {
        mlogInUser = event.getLoginUserList(); //success login
    }

    public void logOut(){
        mlogInUser=null;
        UserLogOutEvent event=new UserLogOutEvent();
        EventBus.getDefault().post(event);
    }
}
