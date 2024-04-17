package kk.projects.imageview.rest;


import java.util.List;

import kk.projects.imageview.model.image_model;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {


    @GET("photos")
    Call<List<image_model.ResponseItem>> imageload(@Query("client_id") String mobile);

}
