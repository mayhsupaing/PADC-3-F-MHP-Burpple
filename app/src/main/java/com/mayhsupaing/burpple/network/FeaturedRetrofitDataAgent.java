package com.mayhsupaing.burpple.network;

import com.google.gson.Gson;
import com.mayhsupaing.burpple.events.LoadFeaturedEvent;

import com.mayhsupaing.burpple.events.SuccessLoginEvent;
import com.mayhsupaing.burpple.events.SuccessRegisterEvent;
import com.mayhsupaing.burpple.network.response.GetFeaturedResponse;
import com.mayhsupaing.burpple.network.response.GetLogInResponse;
import com.mayhsupaing.burpple.network.response.GetRegisterResponse;


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

public class FeaturedRetrofitDataAgent implements FeaturedDataAgent {

    private static FeaturedRetrofitDataAgent sObjInstance;

    private FeaturedApi featuredApi;

    private FeaturedRetrofitDataAgent(){

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

       featuredApi=retrofit.create(FeaturedApi.class);
    }

    public static FeaturedRetrofitDataAgent getsObjInstance(){
        if(sObjInstance==null){
            sObjInstance=new FeaturedRetrofitDataAgent();
        }
        return sObjInstance;
    }
    @Override
    public void loadFeatured() {

        final Call<GetFeaturedResponse> getFeaturedResponseCall=featuredApi.getFeatured(1,"b002c7e1a528b7cb460933fc2875e916");

        getFeaturedResponseCall.enqueue(new Callback<GetFeaturedResponse>() {
            @Override
            public void onResponse(Call<GetFeaturedResponse> call, Response<GetFeaturedResponse> response) {
                GetFeaturedResponse getFeaturedResponse=response.body();
                if(getFeaturedResponse!=null) {
                    LoadFeaturedEvent event = new LoadFeaturedEvent(getFeaturedResponse.getFeatured());
                    EventBus.getDefault().post(event);
                }
            }

            @Override
            public void onFailure(Call<GetFeaturedResponse> call, Throwable t) {

            }

        });
    }

    @Override
    public void loginUser(String phoneNo, String password) {
        Call<GetLogInResponse> getLogInResponseCall=featuredApi.loginUser(phoneNo,password);
        getLogInResponseCall.enqueue(new Callback<GetLogInResponse>() {
            @Override
            public void onResponse(Call<GetLogInResponse> call, Response<GetLogInResponse> response) {
                GetLogInResponse getLogInResponse=response.body();
                if(getLogInResponse!=null) {
                    SuccessLoginEvent event = new SuccessLoginEvent(getLogInResponse.getLoginUser());
                    EventBus.getDefault().post(event);
                }
            }

            @Override
            public void onFailure(Call<GetLogInResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void registerUser(String name, String password, String phoneNo) {
        Call<GetRegisterResponse> getRegisterResponseCall = featuredApi.registerUser(name, password, phoneNo);
        getRegisterResponseCall.enqueue(new Callback<GetRegisterResponse>() {
            @Override
            public void onResponse(Call<GetRegisterResponse> call, Response<GetRegisterResponse> response) {
                GetRegisterResponse getRegisterResponse=response.body();
                if(getRegisterResponse!=null) {
                    SuccessRegisterEvent event = new SuccessRegisterEvent(getRegisterResponse.getRegisterUser());
                    EventBus.getDefault().post(event);
                }
            }

            @Override
            public void onFailure(Call<GetRegisterResponse> call, Throwable t) {

            }
        });
    }
}
