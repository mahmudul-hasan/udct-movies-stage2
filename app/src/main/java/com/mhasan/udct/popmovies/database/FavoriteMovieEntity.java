package com.mhasan.udct.popmovies.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="favorite_movie_table")
public class FavoriteMovieEntity {

	@PrimaryKey
	private int movieId;
	private String posterPath;
	private String backdropPath;
	private double averageVote;
	private String releaseDate;
	private String overview;

	public FavoriteMovieEntity(int movieId, String posterPath, String backdropPath, double averageVote, String releaseDate, String overview) {
		this.movieId = movieId;
		this.posterPath = posterPath;
		this.backdropPath = backdropPath;
		this.averageVote = averageVote;
		this.releaseDate = releaseDate;
		this.overview = overview;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getPosterPath() {
		return posterPath;
	}

	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}

	public String getBackdropPath() {
		return backdropPath;
	}

	public void setBackdropPath(String backdropPath) {
		this.backdropPath = backdropPath;
	}

	public double getAverageVote() {
		return averageVote;
	}

	public void setAverageVote(double averageVote) {
		this.averageVote = averageVote;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}
}
