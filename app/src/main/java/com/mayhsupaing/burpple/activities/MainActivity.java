package com.mayhsupaing.burpple.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.mayhsupaing.burpple.MBurppleApp;
import com.mayhsupaing.burpple.R;
import com.mayhsupaing.burpple.adapters.FoodGuidesAdapter;
import com.mayhsupaing.burpple.adapters.FoodPromotionsAdapter;
import com.mayhsupaing.burpple.adapters.ImagesInFoodAdapter;
import com.mayhsupaing.burpple.adapters.NewlyOpenedAdapter;
import com.mayhsupaing.burpple.adapters.TrendingVenuesAdapter;
import com.mayhsupaing.burpple.data.vo.model.FeaturedModel;
import com.mayhsupaing.burpple.data.vo.model.GuideModel;
import com.mayhsupaing.burpple.data.vo.model.PromotionModel;
import com.mayhsupaing.burpple.events.LoadFeaturedEvent;
import com.mayhsupaing.burpple.events.LoadGuideEvent;
import com.mayhsupaing.burpple.events.LoadPromotionEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.vp_backdrop_image)
    ViewPager vpBackDropImage;

    @BindView(R.id.rv_food_promotions)
    RecyclerView rvFoodPromotions;

    @BindView(R.id.rv_food_guides)
    RecyclerView rvFoodGuides;

    @BindView(R.id.rv_newly_opened)
    RecyclerView rvNewlyOpened;

    @BindView(R.id.rv_trending_venues)
    RecyclerView rvTrendingVenues;

    private ImagesInFoodAdapter mImagesInFoodAdapter;
    private FoodPromotionsAdapter mFoodPromotionsAdapter;
    private FoodGuidesAdapter mFoodGuidesAdapter;
    private NewlyOpenedAdapter mNewlyOpenedAdapter;
    private TrendingVenuesAdapter mTrendingVenuesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);


        mImagesInFoodAdapter = new ImagesInFoodAdapter();
        vpBackDropImage.setAdapter(mImagesInFoodAdapter);

        mFoodPromotionsAdapter = new FoodPromotionsAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext()
                , LinearLayoutManager.HORIZONTAL, false);
        rvFoodPromotions.setLayoutManager(linearLayoutManager);
        rvFoodPromotions.setAdapter(mFoodPromotionsAdapter);

        mFoodGuidesAdapter = new FoodGuidesAdapter();
        LinearLayoutManager foodGuidelinearLayoutManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.HORIZONTAL, false);
        rvFoodGuides.setLayoutManager(foodGuidelinearLayoutManager);
        rvFoodGuides.setAdapter(mFoodGuidesAdapter);

        mNewlyOpenedAdapter = new NewlyOpenedAdapter();
        LinearLayoutManager newlyOpenedLinearLayoutManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false);
        rvNewlyOpened.setLayoutManager(newlyOpenedLinearLayoutManager);
        rvNewlyOpened.setAdapter(mNewlyOpenedAdapter);

        mTrendingVenuesAdapter = new TrendingVenuesAdapter();
        LinearLayoutManager trendingVenuesLinearLayoutManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false);
        rvTrendingVenues.setLayoutManager(trendingVenuesLinearLayoutManager);
        rvTrendingVenues.setAdapter(mTrendingVenuesAdapter);

        FeaturedModel.getsObjInstance().loadFeatured();
        PromotionModel.getsObjInstance().LoadPromotion();
        GuideModel.getsObjInstance().LoadGuide();


    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onFeaturedLoaded(LoadFeaturedEvent event){
        Log.d(MBurppleApp.LOG_TAG,"FeaturedLoaded"+event.getFeaturedList().size());
        mImagesInFoodAdapter.setFeatured(event.getFeaturedList());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPromotionLoaded(LoadPromotionEvent event){
        Log.d(MBurppleApp.LOG_TAG,"mmPromotionLoaded"+event.getPromotionList().size());
        mFoodPromotionsAdapter.setPromotion(event.getPromotionList());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGuideLoaded(LoadGuideEvent event){
        Log.d(MBurppleApp.LOG_TAG,"mmGuideLoaded"+event.getGuideList().size());
        mFoodGuidesAdapter.setGuide(event.getGuideList());
    }
}
