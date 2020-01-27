package com.mhasan.udct.popmovies.detailspage.viewmodel;

import android.app.Application;

import com.mhasan.udct.popmovies.detailspage.repository.DetailsPageRepository;
import com.mhasan.udct.popmovies.detailspage.repository.model.ReviewsResponse;
import com.mhasan.udct.popmovies.detailspage.repository.model.VideoTrailerResponse;
import com.mhasan.udct.popmovies.mainpage.repository.model.MovieResponse.ResultsBean;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class DetailsPageViewModel extends AndroidViewModel implements DetailsPageViewModelOperations {

	private ResultsBean currentlySelectedMovie;
	private final DetailsPageRepository detailsPageRepository;
	private MutableLiveData<ReviewsResponse> reviewsResponseLiveData;
	private MutableLiveData<VideoTrailerResponse> videoTrailerLiveData;

	public DetailsPageViewModel(@NonNull Application application) {
		super(application);
		detailsPageRepository = DetailsPageRepository.getInstance();
		reviewsResponseLiveData = new MutableLiveData<>();
		videoTrailerLiveData = new MutableLiveData<>();
	}

	@Override
	public void cacheCurrentlySelectedMovie(@NonNull ResultsBean movie) {
		if (currentlySelectedMovie == null) currentlySelectedMovie = movie;
	}

	@Override
	public ResultsBean getCurrentlySelectedMovie() {
		return currentlySelectedMovie;
	}

	public MutableLiveData<ReviewsResponse> getReviewsResponseLiveData() {
		return reviewsResponseLiveData;
	}

	public MutableLiveData<VideoTrailerResponse> getVideoTrailerLiveData() {
		return videoTrailerLiveData;
	}

	@Override
	public void loadReviews(@NonNull String movieId) {
		detailsPageRepository.loadReviews(movieId, reviewsResponseLiveData);
	}

	@Override
	public void loadTrailers(@NonNull String movieId) {
		detailsPageRepository.loadVideoTrailers(movieId, videoTrailerLiveData);
	}
}
