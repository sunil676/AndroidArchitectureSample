package com.sunil.androidarchitecturesample.api;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.sunil.androidarchitecturesample.db.dao.MovieDao;
import com.sunil.androidarchitecturesample.db.entity.MovieEntity;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;

/**
 * Created by sunil on 16-09-2017.
 */

public class APIClient {

    private final MovieDao movieDao;
    private final ApiServices apiServices;

    @Inject
    public APIClient(MovieDao movieDao, ApiServices apiServices) {
        this.movieDao = movieDao;
        this.apiServices = apiServices;
    }

    public LiveData<Resource<List<MovieEntity>>> loadPopularMovies() {
        return new NetworkBoundResource<List<MovieEntity>, MoviesResponse>() {

            @Override
            protected void saveCallResult(@NonNull MoviesResponse item) {
                movieDao.saveMovies(item.getResults());
            }

            @NonNull
            @Override
            protected LiveData<List<MovieEntity>> loadFromDb() {
                return movieDao.loadMovies();
            }

            @NonNull
            @Override
            protected Call<MoviesResponse> createCall() {
                return apiServices.loadMovies();
            }
        }.getAsLiveData();
    }

    public LiveData<MovieEntity> getMovie(int id){
        return movieDao.getMovie(id);
    }
}
