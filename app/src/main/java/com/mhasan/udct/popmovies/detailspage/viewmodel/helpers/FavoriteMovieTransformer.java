package com.mhasan.udct.popmovies.detailspage.viewmodel.helpers;

import com.mhasan.udct.popmovies.database.FavoriteMovieEntity;
import com.mhasan.udct.popmovies.mainpage.repository.model.MovieResponse.ResultsBean;
import com.mhasan.udct.popmovies.utils.Transformer;

/**
 * This class transforms a MovieResponse.ResultsBean into a FavoriteMovieEntity.
 *
 * @author Mahmudul Hasan.
 */
public class FavoriteMovieTransformer implements Transformer<ResultsBean, FavoriteMovieEntity> {

	@Override
	public FavoriteMovieEntity transform(ResultsBean original) {
		int movieId = original.getId();
		String movieTitle = original.getTitle();
		String posterPath = original.getPoster_path();
		String backdropPath = original.getBackdrop_path();
		double averageVote = original.getVote_average();
		String releaseDate = original.getRelease_date();
		String overview = original.getOverview();
		return new FavoriteMovieEntity(movieId, movieTitle, posterPath, backdropPath, averageVote, releaseDate, overview);
	}
}
