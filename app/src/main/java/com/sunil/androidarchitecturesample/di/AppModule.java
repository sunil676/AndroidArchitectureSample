package com.sunil.androidarchitecturesample.di;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.sunil.androidarchitecturesample.api.ApiServices;
import com.sunil.androidarchitecturesample.api.RequestInterceptor;
import com.sunil.androidarchitecturesample.db.dao.MovieDao;
import com.sunil.androidarchitecturesample.db.database.MovieDatabase;
import com.sunil.androidarchitecturesample.util.Constant;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mertsimsek on 20/05/2017.
 */
@Module(includes = ViewModelModule.class)
public class AppModule {

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.connectTimeout(Constant.TIMEOUT_IN_SEC, TimeUnit.SECONDS);
        okHttpClient.readTimeout(Constant.TIMEOUT_IN_SEC, TimeUnit.SECONDS);
        okHttpClient.addInterceptor(new RequestInterceptor());
        return okHttpClient.build();
    }

    @Provides
    @Singleton
    ApiServices provideRetrofit(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit.create(ApiServices.class);
    }

    @Provides
    @Singleton
    MovieDatabase provideMovieDatabase(Application application) {
        return Room.databaseBuilder(application, MovieDatabase.class, "aa.db").build();
    }

    @Provides
    @Singleton
    MovieDao provideMovieDao(MovieDatabase movieDatabase) {
        return movieDatabase.movieDao();
    }

}
