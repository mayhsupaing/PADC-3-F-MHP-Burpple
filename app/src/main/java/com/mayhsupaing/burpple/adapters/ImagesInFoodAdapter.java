package com.mayhsupaing.burpple.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mayhsupaing.burpple.R;
import com.mayhsupaing.burpple.viewitems.ImageInFoodViewItems;

/**
 * Created by Lenovo on 1/4/2018.
 */

public class ImagesInFoodAdapter extends PagerAdapter {
    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Context context=container.getContext();
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        ImageInFoodViewItems view= (ImageInFoodViewItems) layoutInflater.inflate(R.layout.item_backdrop_image,container,false);
        container.addView(view);
        return view;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

    /**
     * Created by Lenovo on 1/4/2018.
     */

    public static class ImageInFoodGuidesViewItems extends RecyclerView.ViewHolder {
        public ImageInFoodGuidesViewItems(View itemView) {
            super(itemView);
        }
    }
}
