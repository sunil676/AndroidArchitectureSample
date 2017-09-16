package com.sunil.androidarchitecturesample.ui.list;

import android.view.View;

import com.sunil.androidarchitecturesample.db.entity.MovieEntity;

/**
 * Created by sunil on 16-09-2017.
 */

public interface MovieListCallback {
    void onMovieClicked(MovieEntity movieEntity, View sharedView);
}
