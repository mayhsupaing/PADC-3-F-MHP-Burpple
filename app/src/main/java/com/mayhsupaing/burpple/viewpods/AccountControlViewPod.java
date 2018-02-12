package com.mayhsupaing.burpple.viewpods;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.mayhsupaing.burpple.R;
import com.mayhsupaing.burpple.data.vo.model.LogInUserModel;
import com.mayhsupaing.burpple.data.vo.model.RegisterUserModel;
import com.mayhsupaing.burpple.delegates.BeforeLoginDelegate;
import com.mayhsupaing.burpple.delegates.LogInUserDelegate;
import com.mayhsupaing.burpple.delegates.RegisterUserDelegate;
import com.mayhsupaing.burpple.events.SuccessLoginEvent;
import com.mayhsupaing.burpple.events.SuccessRegisterEvent;
import com.mayhsupaing.burpple.events.UserLogOutEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lenovo on 1/23/2018.
 */

public class AccountControlViewPod extends FrameLayout {

    @BindView(R.id.vp_login_user)
    LogInUserViewPod vpLoginUser;

    @BindView(R.id.vp_before_login)
    BeforeLogInUserViewPod vpBeforeLogin;

    @BindView(R.id.vp_register_user)
    RegisterUserViewPod vpRegisterUser;


    public AccountControlViewPod(@NonNull Context context) {
        super(context);
    }

    public AccountControlViewPod(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AccountControlViewPod(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this,this);

        refreshUserSession();


        EventBus.getDefault().register(this);
    }

    public void setDelegate(LogInUserDelegate logInUserDelegate) {
        vpLoginUser.setDelegate(logInUserDelegate);
    }

    public void setDelegate(BeforeLoginDelegate beforeLogInDelegate) {
        vpBeforeLogin.setDelegate(beforeLogInDelegate);
    }

    public void setDelegate(RegisterUserDelegate registerUserDelegate) {
        vpRegisterUser.setDelegate(registerUserDelegate);
    }

    /**
     * Log in
     * @param
     */

    public void refreshUserSession() {
        if (LogInUserModel.getsObjInstance().isUserLogIn()) {
            vpBeforeLogin.setVisibility(View.GONE);
            vpLoginUser.setVisibility(View.VISIBLE);
            vpRegisterUser.setVisibility(View.GONE);
        } else if(RegisterUserModel.getsObjInstance().isUserRegister()){
            vpBeforeLogin.setVisibility(View.GONE);
            vpLoginUser.setVisibility(View.GONE);
            vpRegisterUser.setVisibility(View.VISIBLE);
        }
        else {
            vpBeforeLogin.setVisibility(View.VISIBLE);
            vpLoginUser.setVisibility(View.GONE);
            vpRegisterUser.setVisibility(View.GONE);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoginUserSuccess(SuccessLoginEvent event) {
        vpBeforeLogin.setVisibility(View.GONE);
        vpLoginUser.setVisibility(View.VISIBLE);

        vpLoginUser.bindData(event.getLoginUserList()); //bind data
    }

    @Subscribe(threadMode = ThreadMode.MAIN) //UI comp changes
    public void onLogOutUser(UserLogOutEvent event) {
        vpBeforeLogin.setVisibility(View.VISIBLE);
        vpLoginUser.setVisibility(View.GONE);
    }

    /**
     * Register
     */


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onRegisterUserSuccess(SuccessRegisterEvent event) {
        vpBeforeLogin.setVisibility(View.GONE);
        vpRegisterUser.setVisibility(View.VISIBLE);

        vpRegisterUser.bindData(event.getRegisterUserList()); //bind data
    }

    @Subscribe(threadMode = ThreadMode.MAIN) //UI comp changes
    public void onLogOutRegisterUser(UserLogOutEvent event) {
        vpBeforeLogin.setVisibility(View.VISIBLE);
        vpRegisterUser.setVisibility(View.GONE);
    }

}
