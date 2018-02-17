package com.straitstimes.webtest.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {
	private static Properties properties = new Properties();
	
	static {
		readProperties();
	}

	/**
	 * Read test  condition values from config.properties file
	 * 
	 * @return
	 * @throws IOException
	 */
	public static void readProperties() {
		properties = new Properties();
		try (InputStream ip = PropertyUtil.class.getResourceAsStream("config.properties")) {
			properties.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String property) {
		return properties.getProperty(property);
	}
}
