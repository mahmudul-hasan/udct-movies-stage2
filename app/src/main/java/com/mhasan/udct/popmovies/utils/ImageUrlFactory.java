package com.mhasan.udct.popmovies.utils;

import android.net.Uri;

import androidx.annotation.NonNull;

/**
 * This factory class creates an image url based on the endpoint, size and image uri value.
 *
 * @author Mahmudul Hasan.
 */
public class ImageUrlFactory implements UtilsFactory<String> {

	public static final String BASE_IMAGE_URL = "http://image.tmdb.org/t/p/";
	public static final String IMAGE_SIZE = "w185";
	private String imageUri;

	public ImageUrlFactory(@NonNull String imageUri) {
		this.imageUri = imageUri.replaceAll("^/+", "");
	}

	@Override
	public String create() {
		return getUriText();
	}

	private String getUriText() {
		Uri uri = Uri.parse(BASE_IMAGE_URL).buildUpon()
				.appendPath(IMAGE_SIZE)
				.appendPath(imageUri)
				.build();
		return uri.toString();
	}

}
