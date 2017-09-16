package com.sunil.androidarchitecturesample.ui.detail;

import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.sunil.androidarchitecturesample.R;
import com.sunil.androidarchitecturesample.databinding.ActivityMovieDetailBinding;
import com.sunil.androidarchitecturesample.db.entity.MovieEntity;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.HasActivityInjector;

/**
 * Created by sunil on 16-09-2017.
 */

public class MovieDetailActivity extends AppCompatActivity implements LifecycleRegistryOwner {

    private static final String KEY_MOVIE_ID = "key_movie_id";

    LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);

    ActivityMovieDetailBinding binding;

    @Inject
    MovieDetailViewModel movieDetailViewModel;

    public static Intent newIntent(Context context, int movieId) {
        Intent intent = new Intent(context, MovieDetailActivity.class);
        intent.putExtra(KEY_MOVIE_ID, movieId);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_detail);

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int movieId = getIntent().getIntExtra(KEY_MOVIE_ID, 0);
        movieDetailViewModel.getMovie(movieId)
                .observe(this, new Observer<MovieEntity>() {
                    @Override
                    public void onChanged(@Nullable MovieEntity movieEntity) {
                        binding.setMovie(movieEntity);
                    }
                });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                ActivityCompat.finishAfterTransition(this);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public LifecycleRegistry getLifecycle() {
        return lifecycleRegistry;
    }

}
