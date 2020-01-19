package com.mhasan.udct.popmovies.mainpage.repository;

import java.util.ArrayList;

import android.app.Application;

import com.mhasan.udct.popmovies.mainpage.repository.model.MovieResponse;
import com.mhasan.udct.popmovies.mainpage.repository.model.MovieResponse.ResultsBean;
import com.mhasan.udct.popmovies.utils.MovieServiceInterface;
import com.mhasan.udct.popmovies.utils.UrlUtils;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainPageRepository implements MainPageUseCases {

	private MovieResponse movieResponse;

//	private String sortCategory;

	public MainPageRepository() {
		movieResponse = createEmptyMovieResponse();
	}

	public static MainPageRepository getInstance() {
		return new MainPageRepository();
	}

	@Override
	public void loadMovies(@NonNull String sortCategory, final MutableLiveData<MovieResponse> movieResponseLiveData) {
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(UrlUtils.BASE_URL)
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		MovieServiceInterface movieServiceInterface = retrofit.create(MovieServiceInterface.class);
		Call<MovieResponse> serviceCall
				= movieServiceInterface.fetchMovieResponse(sortCategory, UrlUtils.getApiKey());
		serviceCall.enqueue(new Callback<MovieResponse>() {
			@Override
			public void onFailure(Call<MovieResponse> call, Throwable t) {
				t.getStackTrace();
			}

			@Override
			public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
//				movieres = response.body();
//				movieResponseLiveData.setValue(response.body());
				movieResponseLiveData.setValue(response.body());
				setMovieResponse(response.body());
//				imageUrlList = new MovieResponseIntoImageUrlListTransformer().transform(movieResponse);
//				initializeView();
			}
		});
	}

	private MovieResponse createEmptyMovieResponse() {
		MovieResponse movieResponse = new MovieResponse();
		movieResponse.setResults(new ArrayList<ResultsBean>());
		return movieResponse;
	}

	public void setMovieResponse(@NonNull MovieResponse movieResponse) {
		this.movieResponse = movieResponse;
	}

	public MovieResponse getMovieResponse() {
		return movieResponse;
	}
}
