package com.mhasan.udct.popmovies.detailspage.repository.model;

import java.util.List;

public class VideoTrailerResponse {

	public static class ResultsBean {

		/**
		 * id : 5d76dcc739549a001095c028
		 * iso_639_1 : en
		 * iso_3166_1 : US
		 * key : jKCj3XuPG8M
		 * name : BAD BOYS FOR LIFE - Official Trailer
		 * site : YouTube
		 * size : 2160
		 * type : Trailer
		 */

		private String id;
		private String iso_3166_1;
		private String iso_639_1;
		private String key;
		private String name;
		private String site;
		private int size;
		private String type;

		public String getId() {
			return id;
		}

		public String getIso_3166_1() {
			return iso_3166_1;
		}

		public String getIso_639_1() {
			return iso_639_1;
		}

		public String getKey() {
			return key;
		}

		public String getName() {
			return name;
		}

		public String getSite() {
			return site;
		}

		public int getSize() {
			return size;
		}

		public String getType() {
			return type;
		}

		public void setId(String id) {
			this.id = id;
		}

		public void setIso_3166_1(String iso_3166_1) {
			this.iso_3166_1 = iso_3166_1;
		}

		public void setIso_639_1(String iso_639_1) {
			this.iso_639_1 = iso_639_1;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setSite(String site) {
			this.site = site;
		}

		public void setSize(int size) {
			this.size = size;
		}

		public void setType(String type) {
			this.type = type;
		}
	}

	/**
	 * id : 38700
	 * results : [{"id":"5d76dcc739549a001095c028","iso_639_1":"en","iso_3166_1":"US","key":"jKCj3XuPG8M","name":"BAD BOYS FOR LIFE - Official Trailer","site":"YouTube","size":2160,"type":"Trailer"}]
	 */

	private int id;
	private List<ResultsBean> results;

	public int getId() {
		return id;
	}

	public List<ResultsBean> getResults() {
		return results;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setResults(List<ResultsBean> results) {
		this.results = results;
	}
}
