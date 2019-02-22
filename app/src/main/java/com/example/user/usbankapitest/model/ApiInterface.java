package com.example.user.usbankapitest.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("bins/n8jxy/")
    Call<ContactDetailsPojo> loadDetails();

}
