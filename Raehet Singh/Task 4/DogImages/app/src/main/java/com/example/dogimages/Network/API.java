package com.example.dogimages.Network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface API {

    @GET("api/breeds/list/all")
    Call<Root> getRoot();

    @GET("api/breed/{breed_name}/images/random")
    Call<ImgUrl> getUrl(@Path("breed_name") String breed_name);
}
