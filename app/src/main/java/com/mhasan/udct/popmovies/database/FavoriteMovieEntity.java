package com.mhasan.udct.popmovies.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * This is the entity class for the favorite movie database that represents the favorite movie table
 * on the database.
 *
 * @author Mahmudul Hasan.
 */
@Entity(tableName="favorite_movie_table")
public class FavoriteMovieEntity {

	@PrimaryKey
	private int movieId;
	private String movieTitle;
	private String posterPath;
	private String backdropPath;
	private double averageVote;
	private String releaseDate;
	private String overview;

	public FavoriteMovieEntity(int movieId, String movieTitle, String posterPath, String backdropPath, double averageVote, String releaseDate, String overview) {
		this.movieId = movieId;
		this.movieTitle = movieTitle;
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

	public String getMovieTitle() {
		return this.movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
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
