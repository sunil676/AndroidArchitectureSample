package com.sunil.androidarchitecturesample.ui.list;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.sunil.androidarchitecturesample.api.APIClient;
import com.sunil.androidarchitecturesample.api.Resource;
import com.sunil.androidarchitecturesample.db.entity.MovieEntity;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by sunil on 16-09-2017.
 */

public class MovieListViewModel extends ViewModel{
    private final LiveData<Resource<List<MovieEntity>>> popularMovies;

    @Inject
    public MovieListViewModel(APIClient movieRepository) {
        popularMovies = movieRepository.loadPopularMovies();
    }

    LiveData<Resource<List<MovieEntity>>> getPopularMovies() {
        return popularMovies;
    }
}
