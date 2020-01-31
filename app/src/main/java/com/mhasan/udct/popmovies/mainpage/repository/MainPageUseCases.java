package com.mhasan.udct.popmovies.mainpage.repository;

import java.util.List;

import com.mhasan.udct.popmovies.database.FavoriteMovieEntity;
import com.mhasan.udct.popmovies.mainpage.repository.model.MovieResponse;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

public interface MainPageUseCases {

	void considerLoadingFavorites(@NonNull List<FavoriteMovieEntity> favoriteMovieEntities, final MutableLiveData<MovieResponse> movieResponseLiveData);

	void loadMovies(@NonNull String sortCategory, MutableLiveData<MovieResponse> movieResponseLiveData);

}
