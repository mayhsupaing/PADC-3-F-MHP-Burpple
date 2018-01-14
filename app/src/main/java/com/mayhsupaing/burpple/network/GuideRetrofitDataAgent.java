package com.mayhsupaing.burpple.network;

import com.google.gson.Gson;
import com.mayhsupaing.burpple.events.LoadGuideEvent;
import com.mayhsupaing.burpple.events.LoadPromotionEvent;
import com.mayhsupaing.burpple.network.response.GetGuideResponse;
import com.mayhsupaing.burpple.network.response.GetPromotionResponse;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Lenovo on 1/12/2018.
 */

public class GuideRetrofitDataAgent implements GuideDataAgent {

    private static GuideRetrofitDataAgent sObjInstance;

    private GuideApi guideApi;

    private GuideRetrofitDataAgent(){

        OkHttpClient httpClient = new OkHttpClient.Builder() //1
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit=new Retrofit.Builder() //2
                .baseUrl("http://padcmyanmar.com/padc-3/burpple-food-places/apis/v1/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(httpClient)
                .build();

        guideApi=retrofit.create(GuideApi.class);
    }

    public static GuideRetrofitDataAgent getsObjInstance(){
        if(sObjInstance==null)
        {
            sObjInstance=new GuideRetrofitDataAgent();
        }
        return sObjInstance;
    }
    @Override
    public void loadGuide() {

        Call<GetGuideResponse> getGuideResponseCall=guideApi.getGuide(1,"b002c7e1a528b7cb460933fc2875e916");

        getGuideResponseCall.enqueue(new Callback<GetGuideResponse>() {
            @Override
            public void onResponse(Call<GetGuideResponse> call, Response<GetGuideResponse> response) {
                GetGuideResponse getGuideResponse=response.body();
                if(getGuideResponse!=null) {
                    LoadGuideEvent event = new LoadGuideEvent(getGuideResponse.getFeatured());
                    EventBus.getDefault().post(event);
                }
            }

            @Override
            public void onFailure(Call<GetGuideResponse> call, Throwable t) {

            }


        });
    }

}
