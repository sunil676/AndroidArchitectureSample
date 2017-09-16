package com.sunil.androidarchitecturesample.api;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by sunil on 16-09-2017.
 */

public interface ApiServices {

    @GET("movie/popular")
    Call<MoviesResponse> loadMovies();
}
