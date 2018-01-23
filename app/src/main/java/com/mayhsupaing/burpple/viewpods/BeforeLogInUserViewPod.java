package com.mayhsupaing.burpple.viewpods;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.mayhsupaing.burpple.R;
import com.mayhsupaing.burpple.delegates.BeforeLoginDelegate;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Lenovo on 1/23/2018.
 */

public class BeforeLogInUserViewPod extends RelativeLayout {

    private BeforeLoginDelegate mDelegate;

    public BeforeLogInUserViewPod(Context context) {
        super(context);
    }

    public BeforeLogInUserViewPod(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BeforeLogInUserViewPod(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this,this);
    }

    //click btn on navigation view

    public void setDelegate(BeforeLoginDelegate beforeLoginDelegate){
        mDelegate=beforeLoginDelegate;
    }
    @OnClick(R.id.btn_to_login)
    public void onTapToLogIn(View view){
        mDelegate.onTapToLogin();
    }

    @OnClick(R.id.btn_to_register)
    public void onTapToRegister(View view){
        mDelegate.onTapToRegister();
    }
}
