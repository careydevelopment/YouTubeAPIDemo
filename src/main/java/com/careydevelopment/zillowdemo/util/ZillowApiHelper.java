package com.careydevelopment.zillowdemo.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import com.careydevelopment.zillowdemo.model.Address;
import com.careydevelopment.zillowdemo.model.ZillowSearchResults;

public class ZillowApiHelper {

	/**
	 * Given an address object, this method will return valuation
	 * data obtained from Zillow's API
	 */
	public static ZillowSearchResults getSearchResults(Address address) {
		ZillowSearchResults results = null;
				
		//first get the url
		String url = constructUrl(address);
		
		//use try with resources for automatic closure
		try (InputStream is = UrlHelper.readUrlContents(url)) {
			//parse that input stream data to create a search results object
			results = ZillowParser.parseSearchResults(is);				
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		
		return results;
	}
	
	
	/**
	 * Constructs the URL to get search results from Zillow's API
	 */
	private static final String constructUrl(Address address) {
		StringBuilder builder = new StringBuilder();
		
		builder.append("https://www.zillow.com/webservice/GetSearchResults.htm?zws-id=");
		
		//replace this with your Zillow ZWS-ID
		builder.append("[YOUR ZILLOW ZWS-ID]");
		builder.append("&address=");
		
		//we need to encode the street address because it has spaces in it
		builder.append(encode(address.getStreetAddress()));
		builder.append("&citystatezip=");
		builder.append(address.getZip());
		
		return builder.toString();
	}
	
	
	/**
	 * Encodes a string for inclusion in a URL
	 */
	private static String encode(String param)  {
		String encodedParam = "";
		
		try {
			encodedParam = URLEncoder.encode(param, StandardCharsets.UTF_8.toString());
		} catch (UnsupportedEncodingException e) {
			//VERY unlikely we'll get here
			e.printStackTrace();
		}

		return encodedParam;
	}
}
