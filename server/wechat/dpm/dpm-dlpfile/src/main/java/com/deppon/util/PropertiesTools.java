/*
 * Created on Apr 8, 2010
 * PropertiesTools.java
 * 
 * Copyright 2004 Hintsoft, LTD. All rights reserved.
 * HINTSOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * 
 * $Id: PropertiesTools.java,v 1.1 2012/08/23 06:54:39 weijf Exp $
 * $Author: weijf $ ( mailto:huangcc@hintsoft.com.cn )
 * $Revision: 1.1 $
 * 
 */
package com.deppon.util;

/**
 * @author huangcc
 *
 */
public class PropertiesTools {
	public static BundleConfig config = null;
	public static BundleConfig db = null;
	static {
		try {
			config = new BundleConfig("config");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getConfigProperties(String key, String def) {
		String val = config.getString(key, def);
		return val;
	}

	public static int getConfigProperties(String key, int def) {
		int val = config.getInt(key, def);
		return val;
	}

	public static String getConfigProperties(String key) {
		String val = config.getString(key);
		return val;
	}

	public static String[] getConfigPropertiesByArr(String key, String regex) {
		String val = config.getString(key);
		if (StringUtils.isEmpty(val)) {
			return null;
		}
		return val.split(regex);
	}

	public static int getConfigPropertiesIntValue(String key) {
		int val = config.getInt(key);
		return val;
	}

	public static String getPathTypeByConfigProperties(String key) {
		String val = config.getString(key);
		String systemType = System.getProperty("os.name");
		if (systemType.startsWith("Windows")) {
			val = "D:" + val;
		}
		System.out.println("属性文件里面：得到的路径："+val);
		return val;
	}

}
