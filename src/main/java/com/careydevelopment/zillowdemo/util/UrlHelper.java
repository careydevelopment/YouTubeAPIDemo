package com.careydevelopment.zillowdemo.util;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

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
}
