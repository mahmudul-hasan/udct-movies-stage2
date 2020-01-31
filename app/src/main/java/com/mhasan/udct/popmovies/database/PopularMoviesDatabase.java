package com.mhasan.udct.popmovies.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {FavoriteMovieEntity.class}, version = 2)
public abstract class PopularMoviesDatabase extends RoomDatabase {

	private static final String DATABASE_NAME = "popmovies_db";
	private static PopularMoviesDatabase dbInstance;

	public static synchronized PopularMoviesDatabase getInstance(Context context) {
		if (dbInstance == null) {
			dbInstance = Room.databaseBuilder(context.getApplicationContext(),
					PopularMoviesDatabase.class, DATABASE_NAME)
					.addMigrations(MIGRATION_1_2)
					.build();
		}
		return dbInstance;
	}

	static final Migration MIGRATION_1_2 = new Migration(1, 2) {
		@Override
		public void migrate(SupportSQLiteDatabase database) {
			database.execSQL("ALTER TABLE favorite_movie_table "
					+ " ADD COLUMN movieTitle TEXT");
		}
	};

	public abstract FavoriteMovieDao getFavoriteMovieDao();

}
