package com.mhasan.udct.popmovies.mainpage.repository;

import com.mhasan.udct.popmovies.mainpage.repository.model.MovieResponse;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public interface MainPageUseCases {

	void loadMovies(@NonNull String sortCategory, MutableLiveData<MovieResponse> movieResponseLiveData);

}
