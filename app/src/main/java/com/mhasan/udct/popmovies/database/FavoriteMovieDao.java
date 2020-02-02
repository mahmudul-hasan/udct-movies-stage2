package com.mhasan.udct.popmovies.database;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

/**
 * This is the data accessor class for the database.
 *
 * @author Mahmudul Hasan.
 */
@Dao
public interface FavoriteMovieDao {

	@Delete
	void deleteFavoriteMovie(FavoriteMovieEntity favoriteMovie);

	@Insert
	void insertFavoriteMovie(FavoriteMovieEntity favoriteMovie);

	@Query("SELECT * FROM favorite_movie_table ORDER BY movieId")
	LiveData<List<FavoriteMovieEntity>> loadFavoriteMovies();

	@Update(onConflict = OnConflictStrategy.REPLACE)
	void updateFavoriteMovie(FavoriteMovieEntity favoriteMovie);
}
