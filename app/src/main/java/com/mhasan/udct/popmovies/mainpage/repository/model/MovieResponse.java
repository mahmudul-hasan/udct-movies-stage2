package com.mhasan.udct.popmovies.mainpage.repository.model;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;

public class MovieResponse implements android.os.Parcelable {

	public static class ResultsBean implements android.os.Parcelable {

		public static final Creator<ResultsBean> CREATOR = new Creator<ResultsBean>() {
			@Override
			public ResultsBean createFromParcel(Parcel source) {
				return new ResultsBean(source);
			}

			@Override
			public ResultsBean[] newArray(int size) {
				return new ResultsBean[size];
			}
		};
		private boolean adult;
		private String backdrop_path;
		private List<Integer> genre_ids;
		private int id;
		private String original_language;
		private String original_title;
		private String overview;
		/**
		 * popularity : 541.169
		 * vote_count : 1569
		 * video : false
		 * poster_path : /xBHvZcjRiWyobQ9kxBhO6B2dtRI.jpg
		 * id : 419704
		 * adult : false
		 * backdrop_path : /p3TCqUDoVsrIm8fHK9KOTfWnDjZ.jpg
		 * original_language : en
		 * original_title : Ad Astra
		 * genre_ids : [12,18,9648,878,53]
		 * title : Ad Astra
		 * vote_average : 6
		 * overview : The near future, a time when both hope and hardships drive humanity to look to the stars and beyond. While a mysterious phenomenon menaces to destroy life on planet Earth, astronaut Roy McBride undertakes a mission across the immensity of space and its many perils to uncover the truth about a lost expedition that decades before boldly faced emptiness and silence in search of the unknown.
		 * release_date : 2019-09-17
		 */

		private double popularity;
		private String poster_path;
		private String release_date;
		private String title;
		private boolean video;
		private double vote_average;
		private int vote_count;

		public ResultsBean() {
		}

		protected ResultsBean(Parcel in) {
			this.adult = in.readByte() != 0;
			this.backdrop_path = in.readString();
			this.genre_ids = new ArrayList<Integer>();
			in.readList(this.genre_ids, Integer.class.getClassLoader());
			this.id = in.readInt();
			this.original_language = in.readString();
			this.original_title = in.readString();
			this.overview = in.readString();
			this.popularity = in.readDouble();
			this.poster_path = in.readString();
			this.release_date = in.readString();
			this.title = in.readString();
			this.video = in.readByte() != 0;
			this.vote_average = in.readDouble();
			this.vote_count = in.readInt();
		}

		@Override
		public int describeContents() {
			return 0;
		}

		public String getBackdrop_path() {
			return backdrop_path;
		}

		public List<Integer> getGenre_ids() {
			return genre_ids;
		}

		public int getId() {
			return id;
		}

		public String getOriginal_language() {
			return original_language;
		}

		public String getOriginal_title() {
			return original_title;
		}

		public String getOverview() {
			return overview;
		}

		public double getPopularity() {
			return popularity;
		}

		public String getPoster_path() {
			return poster_path;
		}

		public String getRelease_date() {
			return release_date;
		}

		public String getTitle() {
			return title;
		}

		public double getVote_average() {
			return vote_average;
		}

		public int getVote_count() {
			return vote_count;
		}

		public boolean isAdult() {
			return adult;
		}

		public boolean isVideo() {
			return video;
		}

		public void setAdult(boolean adult) {
			this.adult = adult;
		}

		public void setBackdrop_path(String backdrop_path) {
			this.backdrop_path = backdrop_path;
		}

		public void setGenre_ids(List<Integer> genre_ids) {
			this.genre_ids = genre_ids;
		}

		public void setId(int id) {
			this.id = id;
		}

		public void setOriginal_language(String original_language) {
			this.original_language = original_language;
		}

		public void setOriginal_title(String original_title) {
			this.original_title = original_title;
		}

		public void setOverview(String overview) {
			this.overview = overview;
		}

		public void setPopularity(double popularity) {
			this.popularity = popularity;
		}

		public void setPoster_path(String poster_path) {
			this.poster_path = poster_path;
		}

		public void setRelease_date(String release_date) {
			this.release_date = release_date;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public void setVideo(boolean video) {
			this.video = video;
		}

		public void setVote_average(double vote_average) {
			this.vote_average = vote_average;
		}

		public void setVote_count(int vote_count) {
			this.vote_count = vote_count;
		}

		@Override
		public void writeToParcel(Parcel dest, int flags) {
			dest.writeByte(this.adult ? (byte) 1 : (byte) 0);
			dest.writeString(this.backdrop_path);
			dest.writeList(this.genre_ids);
			dest.writeInt(this.id);
			dest.writeString(this.original_language);
			dest.writeString(this.original_title);
			dest.writeString(this.overview);
			dest.writeDouble(this.popularity);
			dest.writeString(this.poster_path);
			dest.writeString(this.release_date);
			dest.writeString(this.title);
			dest.writeByte(this.video ? (byte) 1 : (byte) 0);
			dest.writeDouble(this.vote_average);
			dest.writeInt(this.vote_count);
		}
	}
	public static final Creator<MovieResponse> CREATOR = new Creator<MovieResponse>() {
		@Override
		public MovieResponse createFromParcel(Parcel source) {
			return new MovieResponse(source);
		}

		@Override
		public MovieResponse[] newArray(int size) {
			return new MovieResponse[size];
		}
	};
	/**
	 * page : 1
	 * total_results : 10000
	 * total_pages : 500
	 * results : [{"popularity":541.169,"vote_count":1569,"video":false,"poster_path":"/xBHvZcjRiWyobQ9kxBhO6B2dtRI.jpg","id":419704,"adult":false,"backdrop_path":"/p3TCqUDoVsrIm8fHK9KOTfWnDjZ.jpg","original_language":"en","original_title":"Ad Astra","genre_ids":[12,18,9648,878,53],"title":"Ad Astra","vote_average":6,"overview":"The near future, a time when both hope and hardships drive humanity to look to the stars and beyond. While a mysterious phenomenon menaces to destroy life on planet Earth, astronaut Roy McBride undertakes a mission across the immensity of space and its many perils to uncover the truth about a lost expedition that decades before boldly faced emptiness and silence in search of the unknown.","release_date":"2019-09-17"},{"popularity":745.549,"vote_count":1640,"video":false,"poster_path":"/db32LaOibwEliAmSL2jjDF6oDdj.jpg","id":181812,"adult":false,"backdrop_path":"/jOzrELAzFxtMx2I4uDGHOotdfsS.jpg","original_language":"en","original_title":"Star Wars: The Rise of Skywalker","genre_ids":[28,12,878],"title":"Star Wars: The Rise of Skywalker","vote_average":6.7,"overview":"The surviving Resistance faces the First Order once again as the journey of Rey, Finn and Poe Dameron continues. With the power and knowledge of generations behind them, the final battle begins.","release_date":"2019-12-18"},{"popularity":499.471,"vote_count":696,"video":false,"poster_path":"/jyw8VKYEiM1UDzPB7NsisUgBeJ8.jpg","id":512200,"adult":false,"backdrop_path":"/zTxHf9iIOCqRbxvl8W5QYKrsMLq.jpg","original_language":"en","original_title":"Jumanji: The Next Level","genre_ids":[28,12,35,14],"title":"Jumanji: The Next Level","vote_average":6.7,"overview":"As the gang return to Jumanji to rescue one of their own, they discover that nothing is as they expect. The players will have to brave parts unknown and unexplored in order to escape the world\u2019s most dangerous game.","release_date":"2019-12-04"},{"popularity":322.465,"vote_count":75,"video":false,"poster_path":"/yJdeWaVXa2se9agI6B4mQunVYkB.jpg","id":449924,"adult":false,"backdrop_path":"/ekP6EVxL81lZ4ivcqPsoZ72rY0h.jpg","original_language":"cn","original_title":"葉問4","genre_ids":[28,18,36],"title":"Ip Man 4: The Finale","vote_average":6.2,"overview":"Following the death of his wife, Ip Man travels to San Francisco to ease tensions between the local kung fu masters and his star student, Bruce Lee, while searching for a better future for his son.","release_date":"2019-12-20"},{"popularity":276.587,"vote_count":7140,"video":false,"poster_path":"/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg","id":475557,"adult":false,"backdrop_path":"/n6bUvigpRFqSwmPp1m2YADdbRBc.jpg","original_language":"en","original_title":"Joker","genre_ids":[80,18,53],"title":"Joker","vote_average":8.3,"overview":"During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.","release_date":"2019-10-02"},{"popularity":226.665,"id":338967,"video":false,"vote_count":814,"vote_average":7.1,"title":"Zombieland: Double Tap","release_date":"2019-10-09","original_language":"en","original_title":"Zombieland: Double Tap","genre_ids":[27,28,35],"backdrop_path":"/3ghImmHdp4RnC3UkL6hpLayclnb.jpg","adult":false,"overview":"Columbus, Tallahassee, Wichita, and Little Rock move to the American heartland as they face off against evolved zombies, fellow survivors, and the growing pains of the snarky makeshift family.","poster_path":"/dtRbVsUb5O12WWO54SRpiMtHKC0.jpg"},{"popularity":171.034,"vote_count":1370,"video":false,"poster_path":"/pjeMs3yqRmFL3giJy4PMXWZTTPa.jpg","id":330457,"adult":false,"backdrop_path":"/xJWPZIYOEFIjZpBL7SVBGnzRYXp.jpg","original_language":"en","original_title":"Frozen II","genre_ids":[12,16,10402,10751],"title":"Frozen II","vote_average":7,"overview":"Elsa, Anna, Kristoff and Olaf head far into the forest to learn the truth about an ancient mystery of their kingdom.","release_date":"2019-11-20"},{"popularity":161.146,"vote_count":16182,"video":false,"poster_path":"/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg","id":299536,"adult":false,"backdrop_path":"/bOGkgRGdhrBYJSLpXaxhXVstddV.jpg","original_language":"en","original_title":"Avengers: Infinity War","genre_ids":[28,12,878],"title":"Avengers: Infinity War","vote_average":8.3,"overview":"As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.","release_date":"2018-04-25"},{"popularity":214.486,"vote_count":915,"video":false,"poster_path":"/lnWkyG3LLgbbrIEeyl5mK5VRFe4.jpg","id":509967,"adult":false,"backdrop_path":"/eFw5YSorHidsajLTayo1noueIxI.jpg","original_language":"en","original_title":"6 Underground","genre_ids":[28,35,53],"title":"6 Underground","vote_average":6.2,"overview":"After faking his death, a tech billionaire recruits a team of international operatives for a bold and bloody mission to take down a brutal dictator.","release_date":"2019-12-13"},{"popularity":163.261,"vote_count":34,"video":false,"poster_path":"/eU0orGizEpOli4wtN8HtfOOJDlA.jpg","id":516700,"adult":false,"backdrop_path":"/mlaX4c2M6usnhXHG5sYJcKVXflA.jpg","original_language":"id","original_title":"Gundala","genre_ids":[28,80,18],"title":"Gundala","vote_average":5.5,"overview":"Sancaka has lived on the streets since his parents left him. Living a hard life, Sancaka survives by thinking about his own safety. When the condition of the city gets worse and injustice rages throughout the country, Sancaka must decide whether he continues to live to look after himself or rise to become their oppressed hero.","release_date":"2019-08-29"},{"popularity":153.892,"vote_count":1050,"video":false,"poster_path":"/pThyQovXQrw2m0s9x82twj48Jq4.jpg","id":546554,"adult":false,"backdrop_path":"/AbRYlvwAKHs0YuyNO6NX9ofq4l6.jpg","original_language":"en","original_title":"Knives Out","genre_ids":[35,9648,53],"title":"Knives Out","vote_average":7.8,"overview":"When renowned crime novelist Harlan Thrombey is found dead at his estate just after his 85th birthday, the inquisitive and debonair Detective Benoit Blanc is mysteriously enlisted to investigate. From Harlan's dysfunctional family to his devoted staff, Blanc sifts through a web of red herrings and self-serving lies to uncover the truth behind Harlan's untimely death.","release_date":"2019-11-27"},{"popularity":101.55,"vote_count":927,"video":false,"poster_path":"/kTQ3J8oTTKofAVLYnds2cHUz9KO.jpg","id":522938,"adult":false,"backdrop_path":"/spYx9XQFODuqEVoPpvaJI1ksAVt.jpg","original_language":"en","original_title":"Rambo: Last Blood","genre_ids":[28,18,53],"title":"Rambo: Last Blood","vote_average":5.9,"overview":"After fighting his demons for decades, John Rambo now lives in peace on his family ranch in Arizona, but his rest is interrupted when Gabriela, the granddaughter of his housekeeper María, disappears after crossing the border into Mexico to meet her biological father. Rambo, who has become a true father figure for Gabriela over the years, undertakes a desperate and dangerous journey to find her.","release_date":"2019-09-19"},{"popularity":147.281,"vote_count":3564,"video":false,"poster_path":"/8j58iEBw9pOXFD2L0nt0ZXeHviB.jpg","id":466272,"adult":false,"backdrop_path":"/c6YyKddg8iVDYRRVZLDEd3m22RI.jpg","original_language":"en","original_title":"Once Upon a Time\u2026 in Hollywood","genre_ids":[35,18,53],"title":"Once Upon a Time\u2026 in Hollywood","vote_average":7.5,"overview":"Los Angeles, 1969. TV star Rick Dalton, a struggling actor specializing in westerns, and stuntman Cliff Booth, his best friend, try to survive in a constantly changing movie industry. Dalton is the neighbor of the young and promising actress and model Sharon Tate, who has just married the prestigious Polish director Roman Polanski\u2026","release_date":"2019-07-25"},{"popularity":116.676,"vote_count":67,"video":false,"poster_path":"/MBiKqTsouYqAACLYNDadsjhhC0.jpg","id":486589,"adult":false,"backdrop_path":"/bga3i5jcejBekr2FCGJga1fYCh.jpg","original_language":"en","original_title":"Red Shoes and the Seven Dwarfs","genre_ids":[16,10749],"title":"Red Shoes and the Seven Dwarfs","vote_average":6.4,"overview":"Princes who have been turned into Dwarfs seek the red shoes of a lady in order to break the spell, although it will not be easy.","release_date":"2019-07-25"},{"popularity":157.175,"vote_count":41,"video":false,"poster_path":"/30YacPAcxpNemhhwX0PVUl9pVA3.jpg","id":431693,"adult":false,"backdrop_path":"/qlYxtqVfu2LOdvYMMDPCSGX0Oz0.jpg","original_language":"en","original_title":"Spies in Disguise","genre_ids":[28,12,16,35],"title":"Spies in Disguise","vote_average":7.8,"overview":"When the world's best spy is turned into a pigeon, he must rely on his nerdy tech officer to save the world.","release_date":"2019-12-24"},{"popularity":92.129,"vote_count":120,"video":false,"poster_path":"/84Xz2Jh60tC3ICO1CY27wc0zwgC.jpg","id":461130,"adult":false,"backdrop_path":"/raspMdRYIj0cCF6SQH8NQ1lLLMB.jpg","original_language":"en","original_title":"Code 8","genre_ids":[28,80,18,878,53],"title":"Code 8","vote_average":6.3,"overview":"In Lincoln City, some inhabitants have extraordinary abilities. Most live below the poverty line, under the close surveillance of a heavily militarized police force. Connor, a construction worker with powers, involves with a criminal gang to help his ailing mother. (Based on the short film \u201cCode 8,\u201d 2016.)","release_date":"2019-12-06"},{"popularity":104.886,"vote_count":10797,"video":false,"poster_path":"/sM33SANp9z6rXW8Itn7NnG1GOEs.jpg","id":269149,"adult":false,"backdrop_path":"/mhdeE1yShHTaDbJVdWyTlzFvNkr.jpg","original_language":"en","original_title":"Zootopia","genre_ids":[12,16,35,10751],"title":"Zootopia","vote_average":7.7,"overview":"Determined to prove herself, Officer Judy Hopps, the first bunny on Zootopia's police force, jumps at the chance to crack her first case - even if it means partnering with scam-artist fox Nick Wilde to solve the mystery.","release_date":"2016-02-11"},{"popularity":104.432,"vote_count":911,"video":false,"poster_path":"/fapXd3v9qTcNBTm39ZC4KUVQDNf.jpg","id":423204,"adult":false,"backdrop_path":"/k2WyDw2NTUIWnuEs5gT7wgrCQg6.jpg","original_language":"en","original_title":"Angel Has Fallen","genre_ids":[28,53],"title":"Angel Has Fallen","vote_average":5.9,"overview":"After a treacherous attack, Secret Service agent Mike Banning is charged with attempting to assassinate President Trumbull. Chased by his own colleagues and the FBI, Banning begins a race against the clock to clear his name.","release_date":"2019-08-21"},{"popularity":110.904,"vote_count":2022,"video":false,"poster_path":"/7IiTTgloJzvGI1TAYymCfbfl3vT.jpg","id":496243,"adult":false,"backdrop_path":"/TU9NIjwzjoKPwQHoHshkFcQUCG.jpg","original_language":"ko","original_title":"기생충","genre_ids":[35,53],"title":"Parasite","vote_average":8.5,"overview":"All unemployed, Ki-taek's family takes peculiar interest in the wealthy and glamorous Parks for their livelihood until they get entangled in an unexpected incident.","release_date":"2019-05-30"},{"popularity":108.786,"vote_count":12556,"video":false,"poster_path":"/btTdmkgIvOi0FFip1sPuZI2oQG6.jpg","id":11,"adult":false,"backdrop_path":"/4iJfYYoQzZcONB9hNzg0J0wWyPH.jpg","original_language":"en","original_title":"Star Wars","genre_ids":[28,12,878],"title":"Star Wars","vote_average":8.2,"overview":"Princess Leia is captured and held hostage by the evil Imperial forces in their effort to take over the galactic Empire. Venturesome Luke Skywalker and dashing captain Han Solo team together with the loveable robot duo R2-D2 and C-3PO to rescue the beautiful princess and restore peace and justice in the Empire.","release_date":"1977-05-25"}]
	 */

	private int page;
	private List<ResultsBean> results;
	private int total_pages;
	private int total_results;

	public MovieResponse() {
	}

	protected MovieResponse(Parcel in) {
		this.page = in.readInt();
		this.results = new ArrayList<ResultsBean>();
		in.readList(this.results, ResultsBean.class.getClassLoader());
		this.total_pages = in.readInt();
		this.total_results = in.readInt();
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public int getPage() {
		return page;
	}

	public List<ResultsBean> getResults() {
		return results;
	}

	public int getTotal_pages() {
		return total_pages;
	}

	public int getTotal_results() {
		return total_results;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setResults(List<ResultsBean> results) {
		this.results = results;
	}

	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}

	public void setTotal_results(int total_results) {
		this.total_results = total_results;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(this.page);
		dest.writeList(this.results);
		dest.writeInt(this.total_pages);
		dest.writeInt(this.total_results);
	}
}
