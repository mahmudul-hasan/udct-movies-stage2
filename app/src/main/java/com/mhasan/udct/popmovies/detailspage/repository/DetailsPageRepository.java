package com.mhasan.udct.popmovies.detailspage.repository;

import com.mhasan.udct.popmovies.detailspage.repository.model.ReviewsResponse;
import com.mhasan.udct.popmovies.detailspage.repository.model.VideoTrailerResponse;
import com.mhasan.udct.popmovies.utils.MovieServiceInterface;
import com.mhasan.udct.popmovies.utils.UrlUtils;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailsPageRepository implements DetailsPageUseCases {

	public static DetailsPageRepository getInstance() {
		return new DetailsPageRepository();
	}

	private MovieServiceInterface getMovieServiceInterface() {
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(UrlUtils.BASE_URL)
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		return retrofit.create(MovieServiceInterface.class);
	}

	@Override
	public void loadReviews(@NonNull String movieId, final MutableLiveData<ReviewsResponse> reviewsResponseLiveData) {
		Call<ReviewsResponse> serviceCall = getMovieServiceInterface().fetchReviewsResponse(movieId, UrlUtils.getApiKey());
		serviceCall.enqueue(new Callback<ReviewsResponse>() {
			@Override
			public void onFailure(Call<ReviewsResponse> call, Throwable t) {
				//todo
			}

			@Override
			public void onResponse(Call<ReviewsResponse> call, Response<ReviewsResponse> response) {
				reviewsResponseLiveData.setValue(response.body());
			}
		});
	}

	@Override
	public void loadVideoTrailers(@NonNull String movieId, final MutableLiveData<VideoTrailerResponse> videoTrailerResponseLiveData) {
		Call<VideoTrailerResponse> serviceCall = getMovieServiceInterface().fetchVideoTrailerResponse(movieId, UrlUtils.getApiKey());
		serviceCall.enqueue(new Callback<VideoTrailerResponse>() {
			@Override
			public void onFailure(Call<VideoTrailerResponse> call, Throwable t) {
				//todo
			}

			@Override
			public void onResponse(Call<VideoTrailerResponse> call, Response<VideoTrailerResponse> response) {
				videoTrailerResponseLiveData.setValue(response.body());
			}
		});
	}
}
