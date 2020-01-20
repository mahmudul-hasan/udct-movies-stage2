package com.mhasan.udct.popmovies.detailspage.view;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.mhasan.udct.popmovies.R;
import com.mhasan.udct.popmovies.detailspage.viewmodel.DetailsPageViewModel;
import com.mhasan.udct.popmovies.mainpage.repository.model.MovieResponse.ResultsBean;
import com.mhasan.udct.popmovies.utils.ImageUrlFactory;
import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import static com.mhasan.udct.popmovies.mainpage.view.adapters.MovieGridViewAdapter.DATA_RETRIEVAL_KEY;

public class DetailsPageActivity extends AppCompatActivity {

	private DetailsPageViewModel detailsPageViewModel;

	private ResultsBean getCurrentlySelectedMovie() {
		return detailsPageViewModel.getCurrentlySelectedMovie();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details_page);
		detailsPageViewModel = ViewModelProviders.of(this).get(DetailsPageViewModel.class);
		detailsPageViewModel.cacheCurrentlySelectedMovie(retrieveSelectedMovieFromIntent());
		setupActionBar();
		populateView();
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

	private void populateView() {
		ResultsBean selectedMovie = getCurrentlySelectedMovie();
		ImageView imageView = findViewById(R.id.movieDetailsImageIv);
		TextView ratings = findViewById(R.id.movieDetailsAverageTv);
		TextView releaseDate = findViewById(R.id.movieDetailsReleaseDateTv);
		TextView synopsis = findViewById(R.id.movieDetailsSynopsisTv);
		String imagePath = new ImageUrlFactory(selectedMovie.getPoster_path()).create();
		Picasso.get().load(imagePath).resize(185, 277).centerCrop().into(imageView);
		ratings.setText(String.valueOf(selectedMovie.getVote_average()));
		releaseDate.setText(selectedMovie.getRelease_date());
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
