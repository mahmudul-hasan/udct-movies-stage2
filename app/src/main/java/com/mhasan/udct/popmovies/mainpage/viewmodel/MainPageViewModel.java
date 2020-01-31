package com.mhasan.udct.popmovies.mainpage.viewmodel;

import java.util.List;

import android.app.Application;

import com.mhasan.udct.popmovies.database.FavoriteMovieEntity;
import com.mhasan.udct.popmovies.mainpage.repository.MainPageRepository;
import com.mhasan.udct.popmovies.mainpage.repository.model.MovieResponse;
import com.mhasan.udct.popmovies.utils.UrlUtils;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class MainPageViewModel extends AndroidViewModel implements MainPageViewModelOperations {

	private String initialCategory = UrlUtils.CATEGORY_POPULAR;
	private MainPageRepository mainPageRepository;
	private MutableLiveData<MovieResponse> movieResponseLiveData;

	public MainPageViewModel(@NonNull Application application) {
		super(application);
		movieResponseLiveData = new MutableLiveData<>();
		mainPageRepository = getRepository(application);
	}

	public LiveData<List<FavoriteMovieEntity>> getFavoriteMovies() {
		return mainPageRepository.getFavoriteMovies();
	}

	public String getInitialCategory() {
		return initialCategory;
	}

	public MutableLiveData<MovieResponse> getMovieResponseLiveData() {
		return movieResponseLiveData;
	}

	private MainPageRepository getRepository(Application application) {
		return MainPageRepository.getInstance(application);
	}

	public void loadAndCacheMovies(@NonNull String sortCategory) {
		mainPageRepository.loadMovies(sortCategory, movieResponseLiveData);
	}

	public void loadFavorites(@NonNull List<FavoriteMovieEntity> favoriteMovieEntities, @NonNull String sortCategory) {
		setInitialCategory(sortCategory);
		mainPageRepository.considerLoadingFavorites(favoriteMovieEntities, movieResponseLiveData);
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
