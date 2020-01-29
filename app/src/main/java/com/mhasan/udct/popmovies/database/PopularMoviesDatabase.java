package com.mhasan.udct.popmovies.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {FavoriteMovieEntity.class}, version = 1, exportSchema = false)
public abstract class PopularMoviesDatabase extends RoomDatabase {

	private static final String DATABASE_NAME = "popmovies_db";
	private static PopularMoviesDatabase dbInstance;

	public static synchronized PopularMoviesDatabase getInstance(Context context) {
		if (dbInstance == null) {
			dbInstance = Room.databaseBuilder(context.getApplicationContext(),
					PopularMoviesDatabase.class, DATABASE_NAME).fallbackToDestructiveMigration().build();
		}
		return dbInstance;
	}

	public abstract FavoriteMovieDao getFavoriteMovieDao();

}
