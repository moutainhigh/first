package com.deppon.dpm.module.common.server.service.impl;

import java.util.Map;
import java.util.Map.Entry;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import com.alibaba.fastjson.JSON;
import com.deppon.dpm.module.common.server.service.Function;
import com.deppon.dpm.module.common.shared.domain.EmpFurloughInfoEntity;

public class RedisService {
	
	// 登录校验信息的key
	public static final String DPM_LOGIN_LOGININFO_KEY = "DPM_LOGIN_LOGININFO_";
	
	public static final String DPM_TONGXUNLU_FURLOUGH_KEY = "DPM_TONGXUNLU_FURLOUGH_INFO_";
	
	// Jedis连接池
	private ShardedJedisPool jedisPool;
	
	/**
	 * 抽取的公共代码
	 * @param fun
	 * @return
	 */
	private <T> T excute(Function<ShardedJedis, T> fun){
		ShardedJedis shardedJedis = null;
		try {
			// 从连接池获取连接
			shardedJedis = jedisPool.getResource();
			// 执行方法
			return fun.callback(shardedJedis);
		} finally {
			if(null != shardedJedis){
				// 将有效的连接返回到连接池
				shardedJedis.close();
			}
		}
	}
	
	
	/**
	 * 批量SET，并设置生存时间
	 * @param data
	 * @param seconds
	 */
	public void batchSet(Map<String,EmpFurloughInfoEntity> data, int seconds) {
		ShardedJedis shardedJedis = null;
		try {
			shardedJedis = jedisPool.getResource();
			for(Entry<String,EmpFurloughInfoEntity> entry : data.entrySet()) {
				String key = DPM_TONGXUNLU_FURLOUGH_KEY + entry.getKey();
				shardedJedis.set(key, JSON.toJSONString(entry.getValue()));
				shardedJedis.expire(key, seconds);
			}
		} finally {
			if(null != shardedJedis) {
				shardedJedis.close();
			}
		}
		
	}
	
	/**
	 * 执行SET操作
	 * @param key
	 * @param value
	 * @return
	 */
	public String set(final String key,final String value){
		// 设置进缓存
		return this.excute(new Function<ShardedJedis, String>() {
			// 实现callback
			@Override
			public String callback(ShardedJedis shardedJedis) {
				// 存入redis
				return shardedJedis.set(key, value);
			}
		});
	}
	
	/**
	 * 执行SET，并设置存活时间（单位为秒）
	 * @param key
	 * @param value
	 * @param seconds
	 * @return
	 */
	public String set(final String key,final String value,final Integer seconds){
		// 设置进缓存，设置存活时间
		return this.excute(new Function<ShardedJedis, String>() {
			// 实现callback
			@Override
			public String callback(ShardedJedis shardedJedis) {
				// 存入redis
				String str = shardedJedis.set(key, value);
				// 设置生存时间
				shardedJedis.expire(key, seconds);
				return str;
			}
		});
	}
	
	/**
	 * 设置key的存活时间（单位秒）
	 * @param key
	 * @param seconds
	 * @return
	 */
	public Long expire(final String key,final int seconds){
		// 设置存活时间
		return this.excute(new Function<ShardedJedis, Long>() {
			// 复写callback
			@Override
			public Long callback(ShardedJedis shardedJedis) {
				// 设置生存时间
				return shardedJedis.expire(key, seconds);
			}
		});
	}
	
	/**
	 * 执行GET操作
	 * @param key
	 * @return
	 */
	public String get(final String key){
		// 获取缓存数据
		return this.excute(new Function<ShardedJedis, String>() {
			// 实现callback
			@Override
			public String callback(ShardedJedis shardedJedis) {
				// 从redis获取值
				return shardedJedis.get(key);
			}
		});
	}
	
	/**
	 * 删除一个键
	 * @param key
	 * @return
	 */
	public Long del(final String key){
		// 删除一个键
		return this.excute(new Function<ShardedJedis, Long>() {
			// 实现callback
			@Override
			public Long callback(ShardedJedis shardedJedis) {
				// 从redis删除一个键
				return shardedJedis.del(key);
			}
		});
	}

	/**
	 * setter
	 */
	public void setJedisPool(ShardedJedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}
	
}
