package com.careydevelopment.youtubedemo.model;

import javax.validation.constraints.Size;

public class YoutubeSearchCriteria {
	
	@Size(min=5, max=64, message="Search term must be between 5 and 64 characters")
	private String queryTerm;

	public String getQueryTerm() {
		return queryTerm;
	}

	public void setQueryTerm(String queryTerm) {
		this.queryTerm = queryTerm;
	}

}
