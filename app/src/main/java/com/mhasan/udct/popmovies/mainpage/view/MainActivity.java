package com.mhasan.udct.popmovies.mainpage.view;

import java.util.List;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;

import com.mhasan.udct.popmovies.R;
import com.mhasan.udct.popmovies.database.FavoriteMovieEntity;
import com.mhasan.udct.popmovies.mainpage.repository.helpers.FavoriteMovieEntitiesToMovieResponseTransformer;
import com.mhasan.udct.popmovies.mainpage.repository.model.MovieResponse;
import com.mhasan.udct.popmovies.mainpage.view.adapters.MovieGridViewAdapter;
import com.mhasan.udct.popmovies.mainpage.view.helpers.DeviceConfigurationIntoGridSpanTransformer;
import com.mhasan.udct.popmovies.mainpage.view.helpers.LoadingProgressController;
import com.mhasan.udct.popmovies.mainpage.view.helpers.MovieResponseIntoImageUrlListTransformer;
import com.mhasan.udct.popmovies.mainpage.view.helpers.SortMenuItemTitleModifier;
import com.mhasan.udct.popmovies.mainpage.view.helpers.SortMenuTitleDeterminerBasedOnCategory;
import com.mhasan.udct.popmovies.mainpage.view.helpers.SortMovies;
import com.mhasan.udct.popmovies.mainpage.viewmodel.MainPageViewModel;
import com.mhasan.udct.popmovies.utils.UrlUtils;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements LoadingProgressController {

	private MainPageViewModel mainPageViewModel;
	private String menuClicked = "";

	private void considerLoadingInitialMovies() {
		if (!mainPageViewModel.getInitialCategory().equals(UrlUtils.CATEGORY_FAVORITES)) {
			mainPageViewModel.loadAndCacheMovies(mainPageViewModel.getInitialCategory());
		}
	}

	private String getMenuClicked() {
		return menuClicked;
	}

	private int getSpanCount() {
		return new DeviceConfigurationIntoGridSpanTransformer().transform(getResources().getConfiguration());
	}

	private void initializeMovieGridViewsWith(MovieResponse movieResponse) {
		List<String> imageList = new MovieResponseIntoImageUrlListTransformer().transform(movieResponse);
		RecyclerView gridViewRv = findViewById(R.id.movieGridViewRv);
		MovieGridViewAdapter adapter = new MovieGridViewAdapter(this, imageList, movieResponse);
		gridViewRv.setLayoutManager(new GridLayoutManager(this, getSpanCount()));
		gridViewRv.setAdapter(adapter);
	}

	private void observeViewModel(final MainPageViewModel viewModel) {
		viewModel.getMovieResponseLiveData().observe(this, new Observer<MovieResponse>() {
			@Override
			public void onChanged(MovieResponse movieResponse) {
				initializeMovieGridViewsWith(movieResponse);
				shouldShowProgress(false);
			}
		});
		viewModel.getFavoriteMovies().observe(this, new Observer<List<FavoriteMovieEntity>>() {
			@Override
			public void onChanged(List<FavoriteMovieEntity> favoriteMovieEntities) {
				if (mainPageViewModel.getInitialCategory().equals(UrlUtils.CATEGORY_FAVORITES)) {
					MovieResponse movieResponse = new FavoriteMovieEntitiesToMovieResponseTransformer()
							.transform(favoriteMovieEntities);
					mainPageViewModel.getMovieResponseLiveData().setValue(movieResponse);
				}
			}
		});
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mainPageViewModel = ViewModelProviders.of(this).get(MainPageViewModel.class);
		observeViewModel(mainPageViewModel);
		shouldShowProgress(true);
		updateMenuTitle(getString(new SortMenuTitleDeterminerBasedOnCategory().transform(mainPageViewModel.getInitialCategory())));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.sortmenu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		new SortMovies(mainPageViewModel, this, this).execute(item);
		updateMenuTitle(String.valueOf(item.getTitle()));
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		new SortMenuItemTitleModifier(getString(R.string.sort_movies) + ": \n" + getMenuClicked()).modify(menu);
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	protected void onResume() {
		super.onResume();
		considerLoadingInitialMovies();
	}

	private void setMenuClicked(@NonNull String menuClicked) {
		this.menuClicked = menuClicked;
	}

	public void shouldShowProgress(boolean yes) {
		findViewById(R.id.loadingPb).setVisibility(yes ? ProgressBar.VISIBLE : ProgressBar.GONE);
	}

	private void updateMenuTitle(@NonNull String sortedByTitle) {
		setMenuClicked(sortedByTitle);
		invalidateOptionsMenu();
	}
}
