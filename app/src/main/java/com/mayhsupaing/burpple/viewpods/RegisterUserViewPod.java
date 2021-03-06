package com.mayhsupaing.burpple.viewpods;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mayhsupaing.burpple.R;
import com.mayhsupaing.burpple.data.vo.RegisterVO;
import com.mayhsupaing.burpple.delegates.RegisterUserDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Lenovo on 1/23/2018.
 */

public class RegisterUserViewPod extends RelativeLayout {

    @BindView(R.id.iv_register_bg)
    ImageView ivRegisterBackground;

    @BindView(R.id.iv_register_user_profile)
    ImageView ivRegisterUserProfile;

    @BindView(R.id.tv_register_name)
    TextView tvRegisterName;

    @BindView(R.id.tv_register_user_phone)
    TextView tvRegisterUserPhone;

    @BindView(R.id.tv_register_user_email)
    TextView tvRegisterUserEmail;

    private RegisterUserDelegate mDelegate;

    public RegisterUserViewPod(Context context) {
        super(context);
    }

    public RegisterUserViewPod(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RegisterUserViewPod(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this,this);
    }

    public void bindData(RegisterVO registerUser){
        Glide.with(ivRegisterBackground.getContext())
                .load(registerUser.getCoverUrl())
                .into(ivRegisterBackground);

        Glide.with(ivRegisterUserProfile.getContext())
                .load(registerUser.getProfileUrl())
                .into(ivRegisterUserProfile);

        tvRegisterName.setText(registerUser.getName());
        tvRegisterUserEmail.setText(registerUser.getEmail());
        tvRegisterUserPhone.setText(registerUser.getPhoneNo());
    }

    //setter method
    public void setDelegate(RegisterUserDelegate registerUserDelegate){
        mDelegate=registerUserDelegate;
    }

    @OnClick(R.id.btn_register_log_out)
    public void onTapRegisterLogOut(View view){
        mDelegate.onTapRegisterLogOut();
    }
}
