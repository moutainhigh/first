package com.deppon.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

public class BundleConfig {

	public static final String CONFIG_FILENAME = "config";

	private Logger logger = Logger
			.getLogger("com.individual.common.utils.BundleConfig");

	private ResourceBundle resourceBundle;

	public BundleConfig() throws Exception {
		this(CONFIG_FILENAME);
	}

	public BundleConfig(String configFileName) throws Exception {

		logger.debug(configFileName);
		try {
			if (configFileName != null) {
				resourceBundle = ResourceBundle.getBundle(configFileName);

			} else {
				resourceBundle = ResourceBundle.getBundle(CONFIG_FILENAME);

			}
		} catch (MissingResourceException ex) {
			logger.error(ex);
			throw new Exception(ex.getMessage());
		}
	}

	public boolean getBoolean(String key) {
		return getBoolean(key, false);
	}

	public boolean getBoolean(String key, boolean defaultValue) {
		String stringValue = getString(key);
		if (stringValue != null) {
			return "TRUE".equalsIgnoreCase(stringValue);
		} else {
			return defaultValue;
		}
	}

	public int getInt(String key) {
		return getInt(key, 10);
	}

	public int getInt(String key, int defaultValue) {
		int intValue = -1;
		String stringValue = getString(key);
		if (stringValue != null) {
			try {
				intValue = Integer.parseInt(stringValue);
			} catch (NumberFormatException ex) {
				intValue = defaultValue;
			}
		} else {
			intValue = defaultValue;
		}
		return intValue;
	}

	public long getLong(String key) {
		return getLong(key, -1l);
	}

	public long getLong(String key, long defaultValue) {
		long longValue = -1l;
		String stringValue = getString(key);
		if (stringValue != null) {
			try {
				longValue = Long.parseLong(stringValue);
			} catch (NumberFormatException ex) {
				longValue = defaultValue;
			}
		} else {
			longValue = defaultValue;
		}
		return longValue;
	}

	public String getString(String key) {
		logger.debug("key" + key);
		return getString(key, null);
	}

	public String getString(String key, String defaultValue) {
		String stringValue = null;
		try {
			stringValue = resourceBundle.getString(key);
		} catch (Exception ex) {
			stringValue = defaultValue;
		}
		return stringValue;
	}
}