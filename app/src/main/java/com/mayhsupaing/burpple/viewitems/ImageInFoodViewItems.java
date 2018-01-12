package com.mayhsupaing.burpple.viewitems;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mayhsupaing.burpple.R;
import com.mayhsupaing.burpple.data.vo.FeaturedVO;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lenovo on 1/4/2018.
 */

public class ImageInFoodViewItems extends FrameLayout {



    public ImageInFoodViewItems(@NonNull Context context) {
        super(context);
    }

    public ImageInFoodViewItems(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ImageInFoodViewItems(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


}
