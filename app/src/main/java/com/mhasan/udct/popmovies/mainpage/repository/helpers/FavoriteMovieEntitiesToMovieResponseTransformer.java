package com.mhasan.udct.popmovies.mainpage.repository.helpers;

import java.util.ArrayList;
import java.util.List;

import com.mhasan.udct.popmovies.database.FavoriteMovieEntity;
import com.mhasan.udct.popmovies.mainpage.repository.model.MovieResponse;
import com.mhasan.udct.popmovies.mainpage.repository.model.MovieResponse.ResultsBean;
import com.mhasan.udct.popmovies.utils.Transformer;

/**
 * This is a transformer class that transforms a FavoriteMovieEntitiy list into a MovieResponse objest.
 *
 * @author Mahmudul Hasan.
 */
public class FavoriteMovieEntitiesToMovieResponseTransformer implements Transformer<List<FavoriteMovieEntity>, MovieResponse> {

	@Override
	public MovieResponse transform(List<FavoriteMovieEntity> favoriteMovieEntities) {
		List<ResultsBean> results = new ArrayList<>();
		for (FavoriteMovieEntity entity : favoriteMovieEntities) {
			ResultsBean resultsBean = new ResultsBean();
			resultsBean.setId(entity.getMovieId());
			resultsBean.setTitle(entity.getMovieTitle());
			resultsBean.setPoster_path(entity.getPosterPath());
			resultsBean.setBackdrop_path(entity.getBackdropPath());
			resultsBean.setVote_average(entity.getAverageVote());
			resultsBean.setRelease_date(entity.getReleaseDate());
			resultsBean.setOverview(entity.getOverview());
			results.add(resultsBean);
		}
		MovieResponse movieResponse = new MovieResponse();
		movieResponse.setResults(results);
		return movieResponse;
	}
}
