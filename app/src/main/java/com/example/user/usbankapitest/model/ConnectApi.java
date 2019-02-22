package com.example.user.usbankapitest.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ConnectApi {

    final String BASE_URL = "https://api.myjson.com/";
    static private ConnectApi instance;
    private Retrofit retrofit;

    private ConnectApi() {
    }

    public static ConnectApi getInstance(){
        if(instance == null)
            instance = new ConnectApi();
        return instance;
    }

    public Retrofit getRetrofitData(){
        Gson gson = new GsonBuilder().
                setLenient()
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
            return retrofit;
    }

}
