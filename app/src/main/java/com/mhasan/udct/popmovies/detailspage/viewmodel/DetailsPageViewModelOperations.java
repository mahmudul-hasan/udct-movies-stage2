package com.mhasan.udct.popmovies.detailspage.viewmodel;

import java.util.List;

import com.mhasan.udct.popmovies.database.FavoriteMovieEntity;
import com.mhasan.udct.popmovies.detailspage.repository.model.ReviewsResponse;
import com.mhasan.udct.popmovies.detailspage.repository.model.VideoTrailerResponse;
import com.mhasan.udct.popmovies.mainpage.repository.model.MovieResponse.ResultsBean;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public interface DetailsPageViewModelOperations {

	void addFavoriteMovieIntoDb(ResultsBean favoriteMovie);

	void deleteFavoriteMovieFromDb(ResultsBean favoriteMovie);

	void cacheCurrentlySelectedMovie(@NonNull ResultsBean movie);

	ResultsBean getCurrentlySelectedMovie();

	LiveData<List<FavoriteMovieEntity>> getFavoriteMoviesLiveData();

	MutableLiveData<ReviewsResponse> getReviewsResponseLiveData();

	MutableLiveData<VideoTrailerResponse> getVideoTrailerLiveData();

	void loadReviews(@NonNull String movieId);

	void loadTrailers(@NonNull String movieId);

}
