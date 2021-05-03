package com.example.fitnessappproject475.model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.List;
import java.util.stream.Collectors;

public class SearchDTO {
    public final int id;
    public final String brandname;
    public final String name;
    public final Double kilocal;

    public SearchDTO(int id, String brandname, String name, Double kilocal){
        this.id = id;
        this.brandname = brandname;
        this.name = name;
        this.kilocal = kilocal;
    }

    public static SearchDTO parseFood(SearchPojo.FDCFood food){
       /* return new SearchDTO(
                food.getFdcID(),
                food.getBrandOwner(),
                food.getDescription(),
                food.getFoodNutrients()
                        .stream()
                        .filter( v -> v.getNutrientsID() == SearchPojo.NUTRIENTS.KiloCal.code)
                        .map(v -> v.getValue())
                        .findFirst()
                        .orElse(null)

        );

        */
        return null;
    }
   /* @RequiresApi(api = Build.VERSION_CODES.N)
    public static List<SearchDTO> parsePojo(SearchPojo pojo){
        return pojo.getFoods()
                .stream()
                .map(SearchDTO::parseFood)
                .collect(Collectors.toList());
    }

    */


}
