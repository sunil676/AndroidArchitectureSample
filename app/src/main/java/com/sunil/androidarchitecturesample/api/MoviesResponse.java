package com.sunil.androidarchitecturesample.api;

import com.sunil.androidarchitecturesample.db.entity.MovieEntity;

import java.util.List;

/**
 * Created by sunil on 16-09-2017.
 */

public class MoviesResponse {
    private List<MovieEntity> results;

    public List<MovieEntity> getResults() {
        return results;
    }

    public void setResults(List<MovieEntity> results) {
        this.results = results;
    }
}