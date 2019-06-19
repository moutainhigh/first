package com.deppon.montal.util.redis.util;

import java.util.ResourceBundle;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtil {

	private static JedisPool pool;
	
	private static ResourceBundle bundle = null;
	
	static{
		//初始化pool
		bundle = ResourceBundle.getBundle("prop");
		if(bundle == null){
			throw new IllegalArgumentException("[prop.properties] is not found!");
		}
		int maxActive = Integer.valueOf(bundle.getString("redis.pool.maxActive"));
		int maxIdle = Integer.valueOf(bundle.getString("redis.pool.maxIdle"));
		long maxWait = Long.valueOf(bundle.getString("redis.pool.maxWait"));
		boolean onBorrow = Boolean.valueOf(bundle.getString("redis.pool.testOnBorrow"));
		boolean onReturn = Boolean.valueOf(bundle.getString("redis.pool.testOnReturn"));
		String ipaddress = String.valueOf(bundle.getString("redis.ip"));
		int port = Integer.valueOf(bundle.getString("redis.port"));
		int timeout = Integer.valueOf(bundle.getString("redis.pool.timeout"));
		String auth = String.valueOf(bundle.getString("redis.pool.auth"));
		
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxActive(maxActive);
		config.setMaxIdle(maxIdle);
		config.setMaxWait(maxWait);
		config.setTestOnBorrow(onBorrow);
		config.setTestOnReturn(onReturn);
		pool = new JedisPool(config, ipaddress, port, timeout,auth);
	}
	
	
	/**
	 * 创建jedis对象
	 */
	public static Jedis createJedis(){
		
		return pool.getResource();
	}
	/**
	 * 销毁
	 */
	public static void returnBrokenResource(Jedis jedis){
		if(jedis != null){
			pool.returnBrokenResource(jedis);
		}
	}
	/**
	 * 关闭jedis
	 */
	public static void releaseJedis(Jedis jedis){
		if(jedis != null){
			pool.returnResource(jedis);
			pool.returnBrokenResource(jedis);
		}
	}
	/**
	 * 获取prop.properties配置文件中的值
	 */
	public static String getValue(String key){
		String val = null;
		if(key != null){
			val = bundle.getString(key);
		}
		return val;
	}
}
