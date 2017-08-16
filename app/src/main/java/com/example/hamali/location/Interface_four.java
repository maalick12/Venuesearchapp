package com.example.hamali.location;

import com.example.hamali.location.Model.Explore.Explore;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by hamali on 15/08/2017.
 */

public interface Interface_four {
    @GET("venues/explore/")
    Call<Explore>requestexplore(
            @Query("client_id") String client_id,
            @Query("client_secret") String client_secret,
            @Query("v") String v,
            @Query("ll") String ll,
            @Query("query") String query);
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.foursquare.com/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
