package com.example.fitnessappproject475.services;

import com.example.fitnessappproject475.model.SearchPojo;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class FDCService {
    public static final String baseURL = "https://api.nal.usda.gov/fdc/";
    private static final String Key = "";
    private static volatile IFDCService INSTANCE;

    private static IFDCService getFDCService() {
        if (INSTANCE == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            synchronized (FDCService.class) {
                if (INSTANCE == null) {
                    INSTANCE = retrofit.create(IFDCService.class);
                }
            }
        }
        return INSTANCE;
    }

    public static Call<SearchPojo> searchFood(String foodname) {
        return getFDCService().searchFood(Key, foodname);
    }
}
