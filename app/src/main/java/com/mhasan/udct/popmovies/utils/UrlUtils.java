package com.mhasan.udct.popmovies.utils;

/**
 * This is the utility class for the Urls.
 *
 * @author Mahmudul Hasan.
 */
public class UrlUtils {

	private static final String API_KEY = "0d7c8800a4c55306acf3e3a63415882e";

	public static final String BASE_URL = "https://api.themoviedb.org";
	public static final String CATEGORY_POPULAR = "popular";
	public static final String CATEGORY_TOP_RATED = "top_rated";

	public static String getApiKey() {
		return API_KEY;
	}
}
