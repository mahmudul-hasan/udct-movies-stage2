package com.mhasan.udct.popmovies.mainpage.view.adapters;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.mhasan.udct.popmovies.R;
import com.mhasan.udct.popmovies.detailspage.view.DetailsPageActivity;
import com.mhasan.udct.popmovies.mainpage.repository.model.MovieResponse;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;

/**
 * This is the adapter that sets the movies into the Grid view way on the main page.
 *
 * @author Mahmudul Hasan.
 */
public class MovieGridViewAdapter extends Adapter<MovieGridViewHolder> {

	public static final String DATA_RETRIEVAL_KEY = "dataRetrievalKey";
	private Context context;
	private List<String> imageList;
	private MovieResponse movieResponse;

	public MovieGridViewAdapter(Context context, List<String> imageList, MovieResponse movieResponse) {
		this.context = context;
		this.imageList = imageList;
		this.movieResponse = movieResponse;
	}

	@Override
	public int getItemCount() {
		return imageList.size();
	}

	@Override
	public void onBindViewHolder(@NonNull MovieGridViewHolder holder, final int position) {
		String imagePath = imageList.get(position);
		Picasso.get().load(imagePath).into(holder.getImageView());
		holder.getImageView().setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, DetailsPageActivity.class);
				Bundle bundle = new Bundle();
				bundle.putParcelable(DATA_RETRIEVAL_KEY, movieResponse.getResults().get(position));
				intent.putExtras(bundle);
				context.startActivity(intent);
			}
		});
	}

	@NonNull
	@Override
	public MovieGridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_grid_cell, parent, false);
		return new MovieGridViewHolder(view);
	}
}
