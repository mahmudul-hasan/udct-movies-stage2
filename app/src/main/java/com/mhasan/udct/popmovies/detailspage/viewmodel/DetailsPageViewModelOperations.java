package com.mhasan.udct.popmovies.detailspage.viewmodel;

import com.mhasan.udct.popmovies.mainpage.repository.model.MovieResponse.ResultsBean;

import androidx.annotation.NonNull;

public interface DetailsPageViewModelOperations {

	void cacheCurrentlySelectedMovie(@NonNull ResultsBean movie);

	ResultsBean getCurrentlySelectedMovie();

}
