package com.mhasan.udct.popmovies.detailspage.viewmodel;

import android.app.Application;

import com.mhasan.udct.popmovies.mainpage.repository.model.MovieResponse.ResultsBean;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class DetailsPageViewModel extends AndroidViewModel implements DetailsPageViewModelOperations {

	private ResultsBean currentlySelectedMovie;

	public DetailsPageViewModel(@NonNull Application application) {
		super(application);
	}

	@Override
	public void cacheCurrentlySelectedMovie(@NonNull ResultsBean movie) {
		if (currentlySelectedMovie == null) currentlySelectedMovie = movie;
	}

	@Override
	public ResultsBean getCurrentlySelectedMovie() {
		return currentlySelectedMovie;
	}
}
