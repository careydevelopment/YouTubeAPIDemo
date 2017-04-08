package com.careydevelopment.youtubedemo.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.careydevelopment.youtubedemo.model.YouTubeVideo;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;

@Service
public class YouTubeService {
	
	private static final long MAX_SEARCH_RESULTS = 5;
	
	/**
	 * Returns the first 5 YouTube videos that match the query term
	 */
	public List<YouTubeVideo> fetchVideosByQuery(String queryTerm) {
		List<YouTubeVideo> videos = new ArrayList<YouTubeVideo>();

		try {
			//instantiate youtube object
        	YouTube youtube = getYouTube();

        	//define what info we want to get
            YouTube.Search.List search = youtube.search().list("id,snippet");
            
            //set our credentials
            String apiKey = "";
            search.setKey(apiKey);
            
            //set the search term
            search.setQ(queryTerm);

            //we only want video results
            search.setType("video");

            //set the fields that we're going to use
            search.setFields("items(id/kind,id/videoId,snippet/title,snippet/thumbnails/default/url)");
            
            //set the max results
            search.setMaxResults(MAX_SEARCH_RESULTS);

            //perform the search and parse the results
            SearchListResponse searchResponse = search.execute();
            List<SearchResult> searchResultList = searchResponse.getItems();
            if (searchResultList != null) {
               for (SearchResult result : searchResultList) {
            	   YouTubeVideo video = new YouTubeVideo();
            	   video.setTitle(result.getSnippet().getTitle());
            	   video.setUrl(buildVideoUrl(result.getId().getVideoId()));
            	   video.setDescription(result.getSnippet().getDescription());
            	   video.setThumbnailUrl(result.getSnippet().getThumbnails().getDefault().getUrl());

            	   videos.add(video);
               }
            }
        } catch (Exception e) {
        	e.printStackTrace();
        } 
        
        return videos;
	}

	
	/**
	 * Constructs the URL to play the YouTube video
	 */
	private String buildVideoUrl(String videoId) {
		StringBuilder builder = new StringBuilder();
		builder.append("https://www.youtube.com/watch?v=");
		builder.append(videoId);
		
		return builder.toString();
	}

	
	/**
	 * Instantiates the YouTube object
	 */
	private YouTube getYouTube() {
		 YouTube youtube = new YouTube.Builder(new NetHttpTransport(), new JacksonFactory(), 
				 (reqeust) -> {}).setApplicationName("youtube-spring-boot-demo").build();
		 
		 return youtube;
	}
	
	
	public static void main(String[] args) {
		new YouTubeService().fetchVideosByQuery("bill maher");
	}
}
