package com.mhasan.udct.popmovies.mainpage.viewmodel;

import android.app.Application;

import com.mhasan.udct.popmovies.mainpage.repository.MainPageRepository;
import com.mhasan.udct.popmovies.mainpage.repository.model.MovieResponse;
import com.mhasan.udct.popmovies.utils.UrlUtils;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class MainPageViewModel extends AndroidViewModel implements MainPageViewModelOperations {

	private String initialCategory = UrlUtils.CATEGORY_POPULAR;
	private MainPageRepository mainPageRepository;
	private MutableLiveData<MovieResponse> movieResponseLiveData;

	public MainPageViewModel(@NonNull Application application) {
		super(application);
		movieResponseLiveData = new MutableLiveData<>();
		mainPageRepository = getRepository();
	}

	public String getInitialCategory() {
		return initialCategory;
	}

	public MutableLiveData<MovieResponse> getMovieResponseLiveData() {
		return movieResponseLiveData;
	}

	private MainPageRepository getRepository() {
		return MainPageRepository.getInstance();
	}

	public void loadAndCacheMovies(@NonNull String sortCategory) {
		mainPageRepository.loadMovies(sortCategory, movieResponseLiveData);
	}

	private void setInitialCategory(@NonNull String initialCategory) {
		this.initialCategory = initialCategory;
	}

	@Override
	public void sortMoviesBy(@NonNull String sortCategory) {
		setInitialCategory(sortCategory);
		loadAndCacheMovies(sortCategory);
	}
}
