package com.mhasan.udct.popmovies.mainpage.repository;

import java.util.List;

import android.app.Application;

import com.mhasan.udct.popmovies.database.DatabaseOperationsRepository;
import com.mhasan.udct.popmovies.database.FavoriteMovieEntity;
import com.mhasan.udct.popmovies.mainpage.repository.helpers.FavoriteMovieEntitiesToMovieResponseTransformer;
import com.mhasan.udct.popmovies.mainpage.repository.model.MovieResponse;
import com.mhasan.udct.popmovies.utils.MovieServiceInterface;
import com.mhasan.udct.popmovies.utils.UrlUtils;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainPageRepository extends DatabaseOperationsRepository implements MainPageUseCases {

	public static MainPageRepository getInstance(Application application) {
		return new MainPageRepository(application);
	}

	public MainPageRepository(Application application) {
		super(application);
	}

	public void considerLoadingFavorites(@NonNull List<FavoriteMovieEntity> favoriteMovieEntities, final MutableLiveData<MovieResponse> movieResponseLiveData) {
		movieResponseLiveData.setValue(new FavoriteMovieEntitiesToMovieResponseTransformer().transform(favoriteMovieEntities));
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
				movieResponseLiveData.setValue(response.body());
			}
		});
	}
}
