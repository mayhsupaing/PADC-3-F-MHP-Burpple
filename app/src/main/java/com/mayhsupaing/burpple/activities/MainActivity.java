package com.mayhsupaing.burpple.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
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
import com.mayhsupaing.burpple.data.vo.model.LogInUserModel;
import com.mayhsupaing.burpple.data.vo.model.PromotionModel;
import com.mayhsupaing.burpple.data.vo.model.RegisterUserModel;
import com.mayhsupaing.burpple.delegates.BeforeLoginDelegate;
import com.mayhsupaing.burpple.delegates.LogInUserDelegate;
import com.mayhsupaing.burpple.delegates.RegisterUserDelegate;
import com.mayhsupaing.burpple.events.LoadFeaturedEvent;
import com.mayhsupaing.burpple.events.LoadGuideEvent;
import com.mayhsupaing.burpple.events.LoadPromotionEvent;
import com.mayhsupaing.burpple.viewpods.AccountControlViewPod;
import com.mayhsupaing.burpple.viewpods.LogInUserViewPod;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements BeforeLoginDelegate,LogInUserDelegate,RegisterUserDelegate {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

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

    @BindView(R.id.navigation_view)
    NavigationView navigationView;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    private ImagesInFoodAdapter mImagesInFoodAdapter;
    private FoodPromotionsAdapter mFoodPromotionsAdapter;
    private FoodGuidesAdapter mFoodGuidesAdapter;
    private NewlyOpenedAdapter mNewlyOpenedAdapter;
    private TrendingVenuesAdapter mTrendingVenuesAdapter;

    /*private BeforeLogInUserViewPod vpBeforeLoginUser;*/
   /* private LogInUserViewPod vpLogInUser;*/

    private AccountControlViewPod vpAccountControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);

        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.title_toolbar);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


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

        /*vpBeforeLoginUser= (BeforeLogInUserViewPod) navigationView.getHeaderView(0);
        vpBeforeLoginUser.setDelegate(this);
*/

       /* vpLogInUser= (LogInUserViewPod) navigationView.getHeaderView(0);
        vpLogInUser.setDelegate(this);*/
       vpAccountControl= (AccountControlViewPod) navigationView.getHeaderView(0);
       vpAccountControl.setDelegate((BeforeLoginDelegate) this);
       vpAccountControl.setDelegate((LogInUserDelegate) this);
       vpAccountControl.setDelegate((RegisterUserDelegate) this);
     /*  vpAccountControl.setDelegate((BeforeLoginDelegate) this);
       vpAccountControl.setDelegate((LogInUserDelegate) this);
       vpAccountControl.setDelegate((RegisterUserDelegate) this);*/

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

        if(id==android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START);
        }

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

    @Override
    public void onTapToLogin() {
        Intent intent=AccountControlActivity.newIntentLogIn(getApplicationContext());
        startActivity(intent);
    }

    @Override
    public void onTapToRegister() {
        Intent intent=AccountControlActivity.newIntentRegister(getApplicationContext());
        startActivity(intent);
    }

    @Override
    public void onTapLogOut()
    {
        LogInUserModel.getsObjInstance().logOut();
    }

    @Override
    public void onTapRegisterLogOut() {
        RegisterUserModel.getsObjInstance().logOut();
    }
}
