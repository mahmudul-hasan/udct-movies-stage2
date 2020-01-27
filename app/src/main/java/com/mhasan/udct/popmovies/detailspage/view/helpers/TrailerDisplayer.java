package com.mhasan.udct.popmovies.detailspage.view.helpers;

import java.util.ArrayList;
import java.util.List;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;

import com.mhasan.udct.popmovies.R;
import com.mhasan.udct.popmovies.detailspage.repository.model.VideoTrailerResponse;
import com.mhasan.udct.popmovies.utils.Executer;
import com.mhasan.udct.popmovies.utils.UrlUtils;

import androidx.appcompat.app.AlertDialog.Builder;

public class TrailerDisplayer implements Executer<VideoTrailerResponse> {

	private Context context;

	public TrailerDisplayer(Context context) {
		this.context = context;
	}

	@Override
	public void execute(VideoTrailerResponse videoTrailerResponse) {
		showTrailersDialog(videoTrailerResponse, context);
	}

	private List<String> getTrailerTitles(VideoTrailerResponse videoTrailerResponse) {
		List<String> trailerTitles = new ArrayList<>();
		if (videoTrailerResponse.getResults() != null && videoTrailerResponse.getResults().size() != 0) {
			for (VideoTrailerResponse.ResultsBean trailer : videoTrailerResponse.getResults()) {
				trailerTitles.add(trailer.getName());
			}
		}
		return trailerTitles;
	}

	private void showTrailersDialog(final VideoTrailerResponse videoTrailerResponse, final Context context) {
		String[] trailerTitles = new String[getTrailerTitles(videoTrailerResponse).size()];
		trailerTitles = getTrailerTitles(videoTrailerResponse).toArray(trailerTitles);
		Builder builder = new Builder(context);
		builder.setTitle(context.getString(R.string.trailers_and_videos));
		builder.setItems(trailerTitles, new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				watchVideo(context, videoTrailerResponse.getResults().get(which).getKey());
			}
		});
		builder.create().show();
	}

	/**
	 * https://stackoverflow.com/questions/574195/android-youtube-app-play-video-intent
	 * @param context
	 * @param id
	 */
	private void watchVideo(Context context, String id) {
		Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(UrlUtils.YOUTUBE_APP_URI + id));
		Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(UrlUtils.YOUTUBE_WEB_URL + id));
		try {
			context.startActivity(appIntent);
		} catch (ActivityNotFoundException exception) {
			context.startActivity(webIntent);
		}
	}
}
