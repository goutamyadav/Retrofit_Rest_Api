package com.example.retrofit;

import static com.example.retrofit.MainActivity.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitIncetence {
   public static RetrofitIncetence incetence;
    ApiInterface apiInterface;

    RetrofitIncetence(){
        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl(api)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiInterface= retrofit.create(ApiInterface.class);
    }
    public  static  RetrofitIncetence getIncetence() {
        if(incetence ==null){
            incetence =new RetrofitIncetence();
        }
        return incetence;
    }
}
