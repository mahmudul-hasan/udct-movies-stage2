package com.mhasan.udct.popmovies.detailspage.viewmodel;

import java.util.List;

import android.app.Application;

import com.mhasan.udct.popmovies.database.FavoriteMovieEntity;
import com.mhasan.udct.popmovies.detailspage.repository.DetailsPageRepository;
import com.mhasan.udct.popmovies.detailspage.repository.model.ReviewsResponse;
import com.mhasan.udct.popmovies.detailspage.repository.model.VideoTrailerResponse;
import com.mhasan.udct.popmovies.mainpage.repository.model.MovieResponse.ResultsBean;
import com.mhasan.udct.popmovies.utils.Transformer;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class DetailsPageViewModel extends AndroidViewModel implements DetailsPageViewModelOperations {

	private ResultsBean currentlySelectedMovie;
	private final DetailsPageRepository detailsPageRepository;
	private MutableLiveData<ReviewsResponse> reviewsResponseLiveData;
	private MutableLiveData<VideoTrailerResponse> videoTrailerLiveData;

	public DetailsPageViewModel(@NonNull Application application) {
		super(application);
		detailsPageRepository = DetailsPageRepository.getInstance(application);
		reviewsResponseLiveData = new MutableLiveData<>();
		videoTrailerLiveData = new MutableLiveData<>();
	}

	public LiveData<List<FavoriteMovieEntity>> getFavoriteMoviesLiveData() {
		return detailsPageRepository.getFavoriteMovies();
	}

	@Override
	public void cacheCurrentlySelectedMovie(@NonNull ResultsBean movie) {
		if (currentlySelectedMovie == null) currentlySelectedMovie = movie;
	}

	@Override
	public ResultsBean getCurrentlySelectedMovie() {
		return currentlySelectedMovie;
	}

	public MutableLiveData<ReviewsResponse> getReviewsResponseLiveData() {
		return reviewsResponseLiveData;
	}

	public MutableLiveData<VideoTrailerResponse> getVideoTrailerLiveData() {
		return videoTrailerLiveData;
	}

	@Override
	public void loadReviews(@NonNull String movieId) {
		detailsPageRepository.loadReviews(movieId, reviewsResponseLiveData);
	}

	@Override
	public void loadTrailers(@NonNull String movieId) {
		detailsPageRepository.loadVideoTrailers(movieId, videoTrailerLiveData);
	}

	public void addFavoriteMovieIntoDb(ResultsBean favoriteMovie) {
		FavoriteMovieEntity favoriteMovieEntity = new FavoriteMovieTransformer().transform(favoriteMovie);
		detailsPageRepository.addFavoriteMovieIntoDb(favoriteMovieEntity);
	}

	public void deleteFavoriteMovieFromDb(ResultsBean favoriteMovie) {
		FavoriteMovieEntity favoriteMovieEntity = new FavoriteMovieTransformer().transform(favoriteMovie);
		detailsPageRepository.deleteFavoriteMovieFromDb(favoriteMovieEntity);
	}

	public class FavoriteMovieTransformer implements Transformer<ResultsBean, FavoriteMovieEntity> {

		@Override
		public FavoriteMovieEntity transform(ResultsBean original) {
			int movieId = original.getId();
			String posterPath = original.getPoster_path();
			String backdropPath = original.getBackdrop_path();
			double averageVote = original.getVote_average();
			String releaseDate = original.getRelease_date();
			String overview = original.getOverview();
			return new FavoriteMovieEntity(movieId, posterPath, backdropPath, averageVote, releaseDate, overview);
		}
	}
}
