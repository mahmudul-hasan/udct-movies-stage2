package com.mhasan.udct.popmovies.utils;

import com.mhasan.udct.popmovies.detailspage.repository.model.ReviewsResponse;
import com.mhasan.udct.popmovies.detailspage.repository.model.VideoTrailerResponse;
import com.mhasan.udct.popmovies.mainpage.repository.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * This is the servicecall interface to fetch the movies using Retrofit.
 *
 * @author Mahmudul Hasan.
 */
public interface MovieServiceInterface {

	@GET("/3/movie/{sortByCategory}")
	Call<MovieResponse> fetchMovieResponse(@Path("sortByCategory") String sortByCategory, @Query("api_key") String apiKey);

	@GET("/3/movie/{movie_id}/reviews")
	Call<ReviewsResponse> fetchReviewsResponse(@Path("movie_id") String movieId, @Query("api_key") String apiKey);

	@GET("/3/movie/{movie_id}/videos")
	Call<VideoTrailerResponse> fetchVideoTrailerResponse(@Path("movie_id") String movieId, @Query("api_key") String apiKey);

}
