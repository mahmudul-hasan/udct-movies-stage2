package com.mhasan.udct.popmovies.mainpage.view.helpers;

import java.util.List;

import android.view.MenuItem;

import com.mhasan.udct.popmovies.R;
import com.mhasan.udct.popmovies.database.FavoriteMovieEntity;
import com.mhasan.udct.popmovies.mainpage.viewmodel.MainPageViewModel;
import com.mhasan.udct.popmovies.utils.Executer;
import com.mhasan.udct.popmovies.utils.UrlUtils;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

/**
 * This class sorts the movies based on the sort category.
 *
 * @author Mahmudul Hasan.
 */
public class SortMovies implements Executer<MenuItem> {

	private LifecycleOwner lifecycleOwner;
	private MainPageViewModel mainPageViewModel;

	public SortMovies(@NonNull MainPageViewModel mainPageViewModel, LifecycleOwner lifecycleOwner) {
		this.mainPageViewModel = mainPageViewModel;
		this.lifecycleOwner = lifecycleOwner;
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
			case R.id.showFavorites:
				mainPageViewModel.getFavoriteMovies().observe(lifecycleOwner, new Observer<List<FavoriteMovieEntity>>() {
					@Override
					public void onChanged(List<FavoriteMovieEntity> favoriteMovieEntities) {
						mainPageViewModel.loadFavorites(favoriteMovieEntities, UrlUtils.CATEGORY_FAVORITES);
					}
				});
				break;
		}
	}
}
