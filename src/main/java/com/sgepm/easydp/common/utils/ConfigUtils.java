package com.sgepm.easydp.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.Logger;

public class ConfigUtils {
	
	private static final Logger logger = Logger.getLogger(ConfigUtils.class);
	
	private static ConfigUtils configuration =  null;
	private static Properties prop = null;
	private static String CONFIG_FILE_LOCATION = "easydp.properties";
	
	public synchronized static ConfigUtils getInstance() {
		if (configuration == null) {
			configuration = new ConfigUtils();
		}
		return configuration;
	}
	
	private ConfigUtils() {
		InputStream is = this.getClass().getClassLoader().getResourceAsStream(CONFIG_FILE_LOCATION);
		prop = new Properties();
		try {
			prop.load(is);
			is.close();
		} catch (IOException ex) {
			logger.error("Can't find file：easydp.properties");
		}
	}
	
	public String getProperty(String property) {
		if (prop == null) {
			throw new RuntimeException("Error Properties is null");
		}
		
		return prop.getProperty(property);
	}
	
}
