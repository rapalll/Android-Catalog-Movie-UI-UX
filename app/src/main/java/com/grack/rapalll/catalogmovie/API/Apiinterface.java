package com.grack.rapalll.catalogmovie.API;

import com.grack.rapalll.catalogmovie.Data.Movie;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Apiinterface {

    String DB_API = "e22bfd4f80a9b2ef27addd85a68a3461";

    @GET("popular?api_key="+DB_API)
    Call<Movie> getPopular();

    @GET("top_rated?api_key="+DB_API)
    Call<Movie> getTopRated();


    @GET("now_playing?api_key=" + DB_API)
    Call<Movie> getNowPlaying();

    @GET("upcoming?api_key=" + DB_API)
    Call<Movie> getUpComing();

    @GET("movie?api_key=" + DB_API)
    Call<Movie> getSearchMovie(@retrofit2.http.Query("query") String queryCari);
}
