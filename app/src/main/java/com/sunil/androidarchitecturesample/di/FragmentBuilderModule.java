package com.sunil.androidarchitecturesample.di;

import com.sunil.androidarchitecturesample.ui.list.MovieListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by mertsimsek on 30/05/2017.
 */
@Module
public abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract MovieListFragment contributeMovieListFragment();
}
