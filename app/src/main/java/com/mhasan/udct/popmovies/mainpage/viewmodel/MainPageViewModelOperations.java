package com.mhasan.udct.popmovies.mainpage.viewmodel;

import java.util.List;

import com.mhasan.udct.popmovies.database.FavoriteMovieEntity;
import com.mhasan.udct.popmovies.mainpage.repository.model.MovieResponse;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

public interface MainPageViewModelOperations {

	LiveData<List<FavoriteMovieEntity>> getFavoriteMovies();

	String getInitialCategory();

	LiveData<MovieResponse> getMovieResponseLiveData();

	void loadAndCacheMovies(@NonNull String sortCategory);

	void loadFavorites(@NonNull List<FavoriteMovieEntity> favoriteMovieEntities, @NonNull String sortCategory);

	void sortMoviesBy(@NonNull String sortCategory);

}
