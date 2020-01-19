package com.mhasan.udct.popmovies.mainpage.viewmodel;

import com.mhasan.udct.popmovies.mainpage.repository.model.MovieResponse;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

public interface MainPageViewModelOperations {

	String getInitialCategory();

	LiveData<MovieResponse> getMovieResponseLiveData();

	void loadAndCacheMovies(@NonNull String sortCategory);

	void sortMoviesBy(@NonNull String sortCategory);

}
