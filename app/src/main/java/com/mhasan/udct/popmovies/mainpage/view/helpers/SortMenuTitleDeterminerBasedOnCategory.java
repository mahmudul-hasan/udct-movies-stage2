package com.mhasan.udct.popmovies.mainpage.view.helpers;

import com.mhasan.udct.popmovies.R;
import com.mhasan.udct.popmovies.utils.Transformer;
import com.mhasan.udct.popmovies.utils.UrlUtils;

/**
 * This class determines the sort menu title to be appended with the "Sorted By" based on the selected sort
 * category.
 *
 * @author Mahmudul Hasan.
 */
public class SortMenuTitleDeterminerBasedOnCategory implements Transformer<String, Integer> {

	@Override
	public Integer transform(String sortCategory) {
		switch (sortCategory) {
			case UrlUtils.CATEGORY_POPULAR:
				return R.string.popularity;
			case UrlUtils.CATEGORY_TOP_RATED:
				return R.string.highest_rated;
			case UrlUtils.CATEGORY_FAVORITES:
				return R.string.favorites;
		}
		return -1;
	}
}
