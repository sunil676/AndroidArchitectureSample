package com.sunil.androidarchitecturesample.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.sunil.androidarchitecturesample.db.entity.MovieEntity;

import java.util.List;

/**
 * Created by sunil on 16-09-2017.
 */

@Dao
public interface MovieDao {

    @Query("SELECT * FROM movies")
    LiveData<List<MovieEntity>> loadMovies();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveMovies(List<MovieEntity> movieEntities);

    @Query("SELECT * FROM movies WHERE id=:id")
    LiveData<MovieEntity> getMovie(int id);

}