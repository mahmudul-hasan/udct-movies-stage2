package com.mhasan.udct.popmovies.detailspage.viewmodel;

import com.mhasan.udct.popmovies.detailspage.repository.model.ReviewsResponse;
import com.mhasan.udct.popmovies.detailspage.repository.model.VideoTrailerResponse;
import com.mhasan.udct.popmovies.mainpage.repository.model.MovieResponse.ResultsBean;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

public interface DetailsPageViewModelOperations {

	void cacheCurrentlySelectedMovie(@NonNull ResultsBean movie);

	ResultsBean getCurrentlySelectedMovie();

	MutableLiveData<ReviewsResponse> getReviewsResponseLiveData();

	MutableLiveData<VideoTrailerResponse> getVideoTrailerLiveData();

	void loadReviews(@NonNull String movieId);

	void loadTrailers(@NonNull String movieId);

}
