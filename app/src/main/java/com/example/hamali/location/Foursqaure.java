package com.example.hamali.location;

import android.util.Log;

import com.example.hamali.location.Model.Explore.Explore;
import com.example.hamali.location.Model.Explore.Item_;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;



/**
 * Created by hamali on 15/08/2017.
 */

public class Foursqaure implements Interface.venue_foursquare {

    private Interface.venue_presentor presentor;
    String Client_ID = "Client_ID provided";
    String Client_Secret = "Client_Secret Provided";
    String apiVersion = "20161010";
    List<Item_> item_list = new ArrayList<Item_>();

    public Foursqaure(Interface.venue_presentor presentor) {
        this.presentor = presentor;
    }
    @Override
    public void searchvenue(String userinput, String cloc) {

        Interface_four interface_four = Interface_four.retrofit.create(Interface_four.class);
        final Call<Explore> call = interface_four.requestexplore(Client_ID, Client_Secret, apiVersion, cloc, userinput);
        call.enqueue(new Callback<Explore>() {
            @Override
            public void onResponse(Call<Explore> call, Response<Explore> response) {
                item_list = response.body().getResponse().getGroups().get(0).getItems();

                presentor.result(item_list);
            }

            @Override
            public void onFailure(Call<Explore> call, Throwable t) {

            }
        });


    }

}
