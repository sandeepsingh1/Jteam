package com.hannover.helper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

public class ResourceToolkit {

	/**
	 * Returns the file represented by a resource on the classpath.
	 * 
	 * @param resource The name of the resource to locate
	 * @return Returns the <code>File</code> referred to by the resource or <code>null</code> if the resource could not be found
	 */
	public static File locateResource(String resource) {
		URL url = Thread.currentThread().getContextClassLoader().getResource(resource);
		if (url == null) {
			return null;
		}

		try {
			return new File(url.toURI());
		} catch (URISyntaxException e) {
			// This should never happen!
			return null;
		}
	}

	/**
	 * Loads properties from a resource on the classpath.
	 * 
	 * @param resource The name of the resource containing properties
	 * @return Returns a <code>Properties</code> containing the values loaded from the resource or <code>null</code> if the resource was not found
	 */
	public static Properties loadProperties(String resource) throws IOException {
		URL url = Thread.currentThread().getContextClassLoader().getResource(resource);
		if (url == null) {
			return null;
		}

		Properties properties = new Properties();
		InputStream is = url.openStream();
		try {
			properties.load(is);
		} finally {
			// If we have finished with URL then close the stream
			if (is != null) {
				is.close();
			}
		}
		
		return properties;
	}

}
