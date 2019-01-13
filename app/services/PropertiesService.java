package services;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This service holds the application configuration
 */
public class PropertiesService {
	private static String propertiesFile = "application.properties";
	private static Properties properties;
	
	public static Properties getProperties() {
		if (properties == null) {
			String path = Thread.currentThread().getContextClassLoader().getResource("").getPath() + propertiesFile;
			properties = new Properties();
			
			try {
				properties.load(new FileInputStream(path));
			} catch (IOException e) {
				System.out.println(String.format("Error initializing properties from path: %s. Error: %s", path, e.getMessage()));
			}
		}
		
		return properties;
	}
}
