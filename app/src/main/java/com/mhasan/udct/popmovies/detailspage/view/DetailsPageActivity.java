package com.mhasan.udct.popmovies.detailspage.view;

import java.util.List;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mhasan.udct.popmovies.R;
import com.mhasan.udct.popmovies.database.FavoriteMovieEntity;
import com.mhasan.udct.popmovies.detailspage.repository.model.ReviewsResponse;
import com.mhasan.udct.popmovies.detailspage.repository.model.VideoTrailerResponse;
import com.mhasan.udct.popmovies.detailspage.view.adapters.ReviewsAdapter;
import com.mhasan.udct.popmovies.detailspage.view.helpers.ReviewsViewAdjuster;
import com.mhasan.udct.popmovies.detailspage.view.helpers.TrailerDisplayer;
import com.mhasan.udct.popmovies.detailspage.viewmodel.DetailsPageViewModel;
import com.mhasan.udct.popmovies.mainpage.repository.model.MovieResponse.ResultsBean;
import com.mhasan.udct.popmovies.utils.ImageUrlFactory;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import static com.mhasan.udct.popmovies.mainpage.view.adapters.MovieGridViewAdapter.DATA_RETRIEVAL_KEY;

public class DetailsPageActivity extends AppCompatActivity {

	private DetailsPageViewModel detailsPageViewModel;

	private void considerLoadingReviews() {
		if (detailsPageViewModel.getReviewsResponseLiveData().getValue() == null) {
			detailsPageViewModel.loadReviews(String.valueOf(getCurrentlySelectedMovie().getId()));
		}
	}

	private void considerLoadingTrailers() {
		if (detailsPageViewModel.getVideoTrailerLiveData().getValue() == null) {
			detailsPageViewModel.loadTrailers(String.valueOf(getCurrentlySelectedMovie().getId()));
		}
	}

	private ResultsBean getCurrentlySelectedMovie() {
		return detailsPageViewModel.getCurrentlySelectedMovie();
	}

	public void handleTrailerButtonClick(View view) {
		final VideoTrailerResponse videoTrailerResponse = detailsPageViewModel.getVideoTrailerLiveData().getValue();
		new TrailerDisplayer(this).execute(videoTrailerResponse);
	}

	public void handleFavoriteButtonClick(View view) {
		switch ((String) view.getTag()) {
			case "ic_favorite_border_24px":
				setFavoriteView((ImageView)view);
				detailsPageViewModel.addFavoriteMovieIntoDb(detailsPageViewModel.getCurrentlySelectedMovie());
				break;
			case "ic_favorited_24px":
				setUnFavoriteView((ImageView)view);
				detailsPageViewModel.deleteFavoriteMovieFromDb(detailsPageViewModel.getCurrentlySelectedMovie());
				break;
		}
	}

	private void setUnFavoriteView(ImageView view) {
		view.setImageDrawable(getDrawable(R.drawable.ic_favorite_border_24px));
		view.setTag("ic_favorite_border_24px");
	}

	private void setFavoriteView(ImageView view) {
		view.setImageDrawable(getDrawable(R.drawable.ic_favorited_24px));
		view.setTag("ic_favorited_24px");
	}

	private void observeViewModel(@NonNull DetailsPageViewModel viewModel) {
		viewModel.getReviewsResponseLiveData().observe(this, new Observer<ReviewsResponse>() {
			@Override
			public void onChanged(ReviewsResponse reviewsResponse) {
				//todo - save the new response
				ExpandableListView reviewsListView = findViewById(R.id.reviewListElv);
				reviewsListView.setAdapter(new ReviewsAdapter(DetailsPageActivity.this, reviewsResponse.getResults()));
				new ReviewsViewAdjuster().modify(reviewsListView);
			}
		});

		viewModel.getVideoTrailerLiveData().observe(this, new Observer<VideoTrailerResponse>() {
			@Override
			public void onChanged(VideoTrailerResponse videoTrailerResponse) {
				//todo - save the new response
			}
		});

		if (viewModel.getFavoriteMoviesLiveData() != null) {
			viewModel.getFavoriteMoviesLiveData().observe(this, new Observer<List<FavoriteMovieEntity>>() {
				@Override
				public void onChanged(List<FavoriteMovieEntity> favoriteMovies) {
					initializeFavoriteButton(favoriteMovies);
					Toast.makeText(DetailsPageActivity.this, favoriteMovies.toString(), Toast.LENGTH_LONG).show();
				}
			});
		}
	}

	//TODO - refactor
	private void initializeFavoriteButton(List<FavoriteMovieEntity> favoriteMovies) {
		ImageView favoriteView = findViewById(R.id.favoriteButtonIv);
		for (FavoriteMovieEntity favoriteMovie : favoriteMovies) {
			if (favoriteMovie.getMovieId() == getCurrentlySelectedMovie().getId()) {
				setFavoriteView(favoriteView);
				return;
			}
		}
		setUnFavoriteView(favoriteView);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details_page);
		detailsPageViewModel = ViewModelProviders.of(this).get(DetailsPageViewModel.class);
		detailsPageViewModel.cacheCurrentlySelectedMovie(retrieveSelectedMovieFromIntent());
		observeViewModel(detailsPageViewModel);
		setupActionBar();
		populateViews();
		considerLoadingTrailers();
		considerLoadingReviews();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:
				finish();
				return false;
		}
		return super.onOptionsItemSelected(item);
	}

	private void populateViews() {
		ResultsBean selectedMovie = getCurrentlySelectedMovie();
		ImageView imageView = findViewById(R.id.movieDetailsImageIv);
		TextView ratings = findViewById(R.id.movieDetailsAverageTv);
		TextView releaseDate = findViewById(R.id.movieDetailsReleaseDateTv);
		TextView synopsis = findViewById(R.id.movieDetailsSynopsisTv);
		String imagePath = new ImageUrlFactory(selectedMovie.getBackdrop_path(), "w300").create();
		Picasso.get().load(imagePath).into(imageView);
		ratings.setText(getString(R.string.ratings, String.valueOf(selectedMovie.getVote_average())));
		releaseDate.setText(getString(R.string.released_in, selectedMovie.getRelease_date()));
		synopsis.setText(selectedMovie.getOverview());
	}

	private ResultsBean retrieveSelectedMovieFromIntent() {
		Bundle bundle = getIntent().getExtras();
		return bundle.getParcelable(DATA_RETRIEVAL_KEY);
	}

	private void setupActionBar() {
		setTitle(getCurrentlySelectedMovie().getTitle());
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	}
}
