package com.mayhsupaing.burpple.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mayhsupaing.burpple.R;
import com.mayhsupaing.burpple.data.vo.FeaturedVO;
import com.mayhsupaing.burpple.viewitems.ImageInFoodViewItems;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lenovo on 1/4/2018.
 */

public class ImagesInFoodAdapter extends PagerAdapter{

    @BindView(R.id.iv_food_backdrop)
    ImageView ivFoodBackdrop;

    @BindView(R.id.tv_highlight_features)
    TextView tvHighlightFeatures;

    @BindView(R.id.tv_highlight_title)
    TextView tvHighlightTitle;

    @BindView(R.id.tv_highlight_sub_title)
    TextView tvHighlightSubDescription;

    private List<FeaturedVO> mFeaturedList;

    public ImagesInFoodAdapter(){
        mFeaturedList=new ArrayList<>();
    }

    @Override
    public int getCount() {
        return mFeaturedList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Context context = container.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        ImageInFoodViewItems view = (ImageInFoodViewItems) layoutInflater.inflate(R.layout.item_backdrop_image, container, false);
        ButterKnife.bind(this,view);

        tvHighlightFeatures.setText(mFeaturedList.get(position).getFeatureTag());
        tvHighlightSubDescription.setText(mFeaturedList.get(position).getFeatureDescription());
        tvHighlightTitle.setText(mFeaturedList.get(position).getFeatureTitle());

        Glide.with(ivFoodBackdrop.getContext())
                .load(mFeaturedList.get(position).getFeatureImage())
                .into(ivFoodBackdrop);
        container.addView(view);
        return view;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    public void setFeatured(List<FeaturedVO> featuredList) {
        mFeaturedList = featuredList;
        notifyDataSetChanged();
    }
    /**
     * Created by Lenovo on 1/4/2018.
     */

}
