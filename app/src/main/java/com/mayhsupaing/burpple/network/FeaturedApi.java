package com.mayhsupaing.burpple.network;

import com.mayhsupaing.burpple.network.response.GetFeaturedResponse;
import com.mayhsupaing.burpple.network.response.GetLogInResponse;
import com.mayhsupaing.burpple.network.response.GetRegisterResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Lenovo on 1/12/2018.
 */

public interface FeaturedApi {

    @FormUrlEncoded
    @POST("getFeatured.php")
    Call<GetFeaturedResponse> getFeatured(@Field("page") int page,
                                                   @Field("access_token") String accessToken);

    @FormUrlEncoded
    @POST("login.php")
    Call<GetLogInResponse> loginUser(@Field("phoneNo") String phoneNo,
                                     @Field("password") String password);

    @FormUrlEncoded
    @POST("register.php")
    Call<GetRegisterResponse> registerUser(@Field("phoneNo") String phoneNo,
                                          @Field("password") String password,
                                          @Field("name") String name);
}
