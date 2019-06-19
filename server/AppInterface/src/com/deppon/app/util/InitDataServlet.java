package com.deppon.app.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class InitDataServlet
 */
public class InitDataServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(InitDataServlet.class);

	public static Properties prop;

	public InitDataServlet() {
		super();
	}

	@Override
	public void init() throws ServletException {

		prop = new Properties();
		InputStream is = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("prop.properties");

		try {
			prop.load(is);
		} catch (IOException e) {
			logger.error("读取配置文件出错:" + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * 获取key对应的�?
	 * 
	 * @param key
	 * @return
	 */
	public static String getValue(String key) {
		if (null != prop) {
			return prop.getProperty(key);
		}
		return null;
	}

}
