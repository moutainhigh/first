package com.deppon.dpm.tongxunlu.server.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

public class DbPoolConnection {
	/**
	 * 数据库连接池
	 */
	private static DbPoolConnection databasePool = null;
	/**
	 * 用于创建数据库连接
	 */
	private static DruidDataSource dds = null;
	/**
	 * 静态代码块
	 */
	static {
		// 获取
		Resource resource = new ClassPathResource("config.properties");
		try {
			// 获取配置信息
			Properties properties = PropertiesLoaderUtils.loadProperties(resource);
			// 开启数据库连接
			dds = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			// 打印错误信息
			e.printStackTrace();
		}
	}
	/**
	 * Constructor
	 */
	private DbPoolConnection() {}
	/**
	 * 实例化
	 * 
	 * @return
	 */
	public static synchronized DbPoolConnection getInstance() {
		// 为空
		if (null == databasePool) {
			// 实例化一个连接池
			databasePool = new DbPoolConnection();
		}
		// 返回连接池
		return databasePool;
	}
	/**
	 * 获取连接
	 * 
	 * @return
	 * @throws SQLException
	 */
	public DruidPooledConnection getConnection() throws SQLException {
		// 返回连接
		return dds.getConnection();
	}
	/**
	 * 加载配置文件
	 * 
	 * @param fullFile
	 * @return
	 */
	public static Properties loadPropertyFile(String fullFile) {
		// 配置文件路径
		String webRootPath = null;
		// 如果配置文件路径为空
		if (null == fullFile || fullFile.equals("")){
			// 抛出异常
			throw new IllegalArgumentException("Properties file path can not be null : " + fullFile);
		}
		// 获取路径
		webRootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		// 获取父路径
		webRootPath = new File(webRootPath).getParent();
		// 输入流
		InputStream inputStream = null;
		// 配置信息
		Properties p = null;
		try { 
			// 文件获取
			File f = new File(fullFile);
			// 读取文件
			inputStream = new FileInputStream(f);
			// 实例化
			p = new Properties();
			// 加载文件嘻嘻
			p.load(inputStream);
		} catch (FileNotFoundException e) {
			// 排除异常
			throw new IllegalArgumentException("Properties file not found: " + fullFile);
		} catch (IOException e) {
			// 排除异常
			throw new IllegalArgumentException("Properties file can not be loading: " + fullFile);
		} finally {
			try {
				// 输入流不为空
				if (inputStream != null)
					// 关闭
					inputStream.close();
			} catch (IOException e) {
				// 打印错误
				e.printStackTrace();
			}
		}
		// 返回信息
		return p;
	}
}