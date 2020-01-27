package com.mhasan.udct.popmovies.detailspage.repository;

import com.mhasan.udct.popmovies.detailspage.repository.model.ReviewsResponse;
import com.mhasan.udct.popmovies.detailspage.repository.model.VideoTrailerResponse;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

public interface DetailsPageUseCases {

	void loadReviews(@NonNull String movieId, MutableLiveData<ReviewsResponse> reviewsResponseLiveData);

	void loadVideoTrailers(@NonNull String movieId, MutableLiveData<VideoTrailerResponse> videoTrailerResponseLiveData);

}
