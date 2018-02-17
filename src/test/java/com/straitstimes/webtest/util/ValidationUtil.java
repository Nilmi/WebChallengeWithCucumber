package com.straitstimes.webtest.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ValidationUtil {
	/**
	 * This method can be used to check whether the image is present check the src
	 * attribute value of the image tag and check whether it gives 200 HTTP response
	 * using HTTP GET
	 * 
	 * @param imageUrl
	 * @return
	 * @throws IOException
	 */
	public static boolean checkImageValidity(String imageUrl) {
		HttpURLConnection connection = null;
		try {
			URL url = new URL(imageUrl);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			return connection.getResponseCode() == 200;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
		return false;
	}
}
