package com.example.dogimages.Network;

import retrofit2.converter.gson.GsonConverterFactory;

public class DogRetrofit {

    public retrofit2.Retrofit retrofit= new retrofit2.Retrofit.Builder()
            .baseUrl(Credentials.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    public API api= retrofit.create(API.class);
}
