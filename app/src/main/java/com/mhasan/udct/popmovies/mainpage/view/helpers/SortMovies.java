package com.mhasan.udct.popmovies.mainpage.view.helpers;

import android.view.MenuItem;

import com.mhasan.udct.popmovies.R;
import com.mhasan.udct.popmovies.mainpage.viewmodel.MainPageViewModel;
import com.mhasan.udct.popmovies.utils.Executer;
import com.mhasan.udct.popmovies.utils.UrlUtils;

import androidx.annotation.NonNull;

/**
 * This class sorts the movies based on the sort category.
 *
 * @author Mahmudul Hasan.
 */
public class SortMovies implements Executer<MenuItem> {

	private MainPageViewModel mainPageViewModel;

	public SortMovies(@NonNull MainPageViewModel mainPageViewModel) {
		this.mainPageViewModel = mainPageViewModel;
	}

	@Override
	public void execute(@NonNull MenuItem item) {
		switch (item.getItemId()) {
			case R.id.sortByPopularity:
				mainPageViewModel.sortMoviesBy(UrlUtils.CATEGORY_POPULAR);
				break;
			case R.id.sortByTopRatings:
				mainPageViewModel.sortMoviesBy(UrlUtils.CATEGORY_TOP_RATED);
				break;
		}
	}
}
