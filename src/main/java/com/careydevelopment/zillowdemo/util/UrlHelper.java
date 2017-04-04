package com.careydevelopment.zillowdemo.util;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import com.careydevelopment.zillowdemo.model.ZillowSearchResults;

public class UrlHelper {

	/**
	 * Given a URL string, returns the contents of that URL
	 */
	public static InputStream readUrlContents(String urlAddress) {
		InputStream is = null;
		
		try {
			URL urlObject = new URL(urlAddress);
		    URLConnection urlConnection = urlObject.openConnection();
		    is = urlConnection.getInputStream();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return is;
	}
		
	
	public static void main(String[] args) {
		InputStream is = readUrlContents("https://www.zillow.com/webservice/GetSearchResults.htm?address=1300%20Teacup%20Spring%20Court&citystatezip=27587");
		ZillowSearchResults results = ZillowParser.parseSearchResults(is);
		System.err.println(results.getZpid() + " " + results.getLastUpdated() + " " + results.getLowValue() + " " + results.getValue());
	}
}
