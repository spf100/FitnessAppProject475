package com.example.fitnessappproject475.services;

import com.example.fitnessappproject475.model.SearchPojo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IFDCService {
    @GET("/fdc/v1/foods/search")
    Call<SearchPojo> searchFood(@Query("api_key") String key, @Query("query") String foodname);
}
