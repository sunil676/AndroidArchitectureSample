package com.sunil.androidarchitecturesample.db.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.sunil.androidarchitecturesample.db.dao.MovieDao;
import com.sunil.androidarchitecturesample.db.entity.MovieEntity;

/**
 * Created by sunil on 16-09-2017.
 */

@Database(entities = {MovieEntity.class}, version = 2)
public abstract class MovieDatabase extends RoomDatabase {

    public abstract MovieDao movieDao();
}
