package com.mhasan.udct.popmovies.utils;

import android.net.Uri;

import androidx.annotation.NonNull;

/**
 * This factory class creates an image url based on the endpoint, size and image uri value.
 *
 * @author Mahmudul Hasan.
 */
public class ImageUrlFactory implements UtilsFactory<String> {

	private static final String BASE_IMAGE_URL = "http://image.tmdb.org/t/p/";
	private static final String IMAGE_SIZE = "w185";
	private String imageUri;
	private final String providedImageSize;

	public ImageUrlFactory(@NonNull String imageUri, @NonNull String imageSize) {
		this.imageUri = imageUri.replaceAll("^/+", "");
		providedImageSize = imageSize;
	}

	@Override
	public String create() {
		return getUriText();
	}

	private String getUriText() {
		Uri uri = Uri.parse(BASE_IMAGE_URL).buildUpon()
				.appendPath(providedImageSize.isEmpty() ? IMAGE_SIZE : providedImageSize)
				.appendPath(imageUri)
				.build();
		return uri.toString();
	}

}
