package isw.proyecto.jdbc.util;

import java.util.MissingResourceException;
import java.util.Properties;

public class DbPropertiesReader {
	
	private static final String BUNDLE_NAME = "connection.properties";

	private static final Properties RESOURCE_BUNDLE = PropertyLoader.loadProperties(BUNDLE_NAME);

	private DbPropertiesReader() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getProperty(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
