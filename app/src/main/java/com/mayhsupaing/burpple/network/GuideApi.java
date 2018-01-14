package com.mayhsupaing.burpple.network;

import com.mayhsupaing.burpple.network.response.GetGuideResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Lenovo on 1/13/2018.
 */

public interface GuideApi {

    @FormUrlEncoded
    @POST("getGuides.php")
    Call<GetGuideResponse> getGuide(@Field("page") int page,
                                       @Field("access_token") String accessToken);
}
