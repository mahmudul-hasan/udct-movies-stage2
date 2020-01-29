package com.mhasan.udct.popmovies.database;

import java.util.List;

import android.app.Application;

import com.mhasan.udct.popmovies.utils.AppExecutors;

import androidx.lifecycle.LiveData;

public class DatabaseOperationsRepository {

	private final AppExecutors appExecutors;
	private LiveData<List<FavoriteMovieEntity>> favoriteMovies;
	private final PopularMoviesDatabase popularMoviesDatabase;

	public DatabaseOperationsRepository(Application application) {
		popularMoviesDatabase = PopularMoviesDatabase.getInstance(application);
		appExecutors = AppExecutors.getInstance();
		favoriteMovies = getFavoriteMovieDao().loadFavoriteMovies();
//		readFavoriteMoviesFromDb();
	}

	//Create
	public void addFavoriteMovieIntoDb(final FavoriteMovieEntity favoriteMovieEntity) {
		executeDbOperation(new Runnable() {
			@Override
			public void run() {
				getFavoriteMovieDao().insertFavoriteMovie(favoriteMovieEntity);
			}
		});
	}

	//Delete
	public void deleteFavoriteMovieFromDb(final FavoriteMovieEntity favoriteMovieEntity) {
		executeDbOperation(new Runnable() {
			@Override
			public void run() {
				getFavoriteMovieDao().deleteFavoriteMovie(favoriteMovieEntity);
			}
		});
	}

	private void executeDbOperation(Runnable operation) {
		appExecutors.diskIO().execute(operation);
	}

	private FavoriteMovieDao getFavoriteMovieDao() {
		return popularMoviesDatabase.getFavoriteMovieDao();
	}

	public LiveData<List<FavoriteMovieEntity>> getFavoriteMovies() {
		return favoriteMovies;
	}

	//Read
	public void readFavoriteMoviesFromDb() {
		executeDbOperation(new Runnable() {
			@Override
			public void run() {
				favoriteMovies = getFavoriteMovieDao().loadFavoriteMovies();
			}
		});
	}

	//Update
	public void updateFavoriteMovieInDb(final FavoriteMovieEntity favoriteMovieEntity) {
		executeDbOperation(new Runnable() {
			@Override
			public void run() {
				getFavoriteMovieDao().updateFavoriteMovie(favoriteMovieEntity);
			}
		});
	}
}
