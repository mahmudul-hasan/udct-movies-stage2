package com.mhasan.udct.popmovies.mainpage.view.helpers;

import java.util.ArrayList;
import java.util.List;

import com.mhasan.udct.popmovies.mainpage.repository.model.MovieResponse;
import com.mhasan.udct.popmovies.utils.ImageUrlFactory;
import com.mhasan.udct.popmovies.utils.Transformer;

import androidx.annotation.NonNull;

/**
 * This transformer class transforms a MovieResponse object into ImageUrlList ogject.
 *
 * @author Mahmudul Hasan.
 */
public class MovieResponseIntoImageUrlListTransformer implements Transformer<MovieResponse, List<String>> {

	@NonNull
	@Override
	public List<String> transform(MovieResponse movieResponse) {
		List<String> imageUrlList = new ArrayList<>();
		for (int i = 0; i < movieResponse.getResults().size(); i++) {
			String posterPath = movieResponse.getResults().get(i).getPoster_path();
			String imageUrl = new ImageUrlFactory(posterPath == null ? "" : posterPath, "").create();
			imageUrlList.add(imageUrl);
		}
		return imageUrlList;
	}
}
