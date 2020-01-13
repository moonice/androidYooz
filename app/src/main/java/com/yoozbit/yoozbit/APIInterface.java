package com.yoozbit.yoozbit;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIInterface {

    @Headers({"Authorization: a4c3cb06-7bdb-4514-be17-80b2412e4c29"})
    @GET("v1/index.php/test")
    Call<Model> getData();

//    @POST("v1/index.php/login")
//    @FormUrlEncoded
//    Call<LoginModel> getLoginData(@Field("email") String email,
//                                  @Field("password") String password);
}