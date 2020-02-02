package com.mhasan.udct.popmovies.detailspage.repository;

import java.util.List;

import com.mhasan.udct.popmovies.database.FavoriteMovieEntity;
import com.mhasan.udct.popmovies.detailspage.repository.model.ReviewsResponse;
import com.mhasan.udct.popmovies.detailspage.repository.model.VideoTrailerResponse;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public interface DetailsPageUseCases {

//	void addFavoriteMovieIntoDb(FavoriteMovieEntity favoriteMovieEntity);
//
//	void deleteFavoriteMovieFromDb(FavoriteMovieEntity favoriteMovieEntity);
//
//	LiveData<List<FavoriteMovieEntity>> getFavoriteMovies();

	void loadReviews(@NonNull String movieId, MutableLiveData<ReviewsResponse> reviewsResponseLiveData);

	void loadVideoTrailers(@NonNull String movieId, MutableLiveData<VideoTrailerResponse> videoTrailerResponseLiveData);

}
