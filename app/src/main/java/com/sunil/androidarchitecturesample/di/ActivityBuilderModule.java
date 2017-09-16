package com.sunil.androidarchitecturesample.di;

import com.sunil.androidarchitecturesample.MainActivity;
import com.sunil.androidarchitecturesample.ui.detail.MovieDetailActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by mertsimsek on 30/05/2017.
 */
@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = FragmentBuilderModule.class)
    abstract MainActivity mainActivity();

    @ContributesAndroidInjector
    abstract MovieDetailActivity movieDetailActivity();
}
