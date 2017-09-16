package com.sunil.androidarchitecturesample.ui.detail;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.sunil.androidarchitecturesample.api.APIClient;
import com.sunil.androidarchitecturesample.api.Resource;
import com.sunil.androidarchitecturesample.db.entity.MovieEntity;

import javax.inject.Inject;

/**
 * Created by sunil on 16-09-2017.
 */

public class MovieDetailViewModel extends ViewModel {
    private final LiveData<Resource<MovieEntity>> movieDetail = new MutableLiveData<>();
    private final APIClient movieRepository;

    @Inject
    public MovieDetailViewModel(APIClient movieRepository) {
        this.movieRepository = movieRepository;
    }

    public LiveData<MovieEntity> getMovie(int id){
        return movieRepository.getMovie(id);
    }
}