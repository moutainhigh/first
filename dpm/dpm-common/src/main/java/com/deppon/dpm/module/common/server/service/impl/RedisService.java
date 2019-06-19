package com.deppon.dpm.module.common.server.service.impl;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.cachecloud.JedisSentinelNodeInfo;
import com.deppon.dpm.module.common.server.service.Function;
import com.deppon.dpm.module.common.server.util.HttpUtil;
import com.deppon.dpm.module.common.shared.domain.EmpFurloughInfoEntity;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

public class RedisService {
	
	// 登录校验信息的key
	public static final String DPM_LOGIN_LOGININFO_KEY = "DPM_LOGIN_LOGININFO_";
	
	public static final String DPM_TONGXUNLU_FURLOUGH_KEY = "DPM_TONGXUNLU_FURLOUGH_INFO_";
	
	public static final String DPM_SMS_VALID_KEY = "DPM_SMS_VALID_KEY_INFO_";
	public static final String DPM_SMS_DIDI_DOC_KEY = "DPM_SMS_DIDI_DOC_KEY_INFO_";
	public static final String DPM_DOC_LEADER_CODE_KEY = "DPM_DOC_LEADER_CODE_KEY_INFO_";
	public static final String DPM_DOC_LEADER_LEVEL_KEY = "DPM_DOC_LEADER_LEVEL_KEY_INFO_";
	//组织人数
	public static final String DPM_SMS_ORG_NUM_KEY = "DPM_SMS_ORG_NUM_KEY_INFO_";
	//智能门店key
	public static final String DPM_STORE_ISDM_KEY = "DPM_STORE_ISDM_KEY_";
	//内部发货key
	public static final String DPM_INNER_SEND_KEY = "DPM_INNER_SEND_KEY_";
	//内部带货key
	public static final String DPM_INNER_RECIEVE_KEY = "DPM_INNER_RECIEVE_KEY_";
	//年度总结权限
	public static final String DPM_JURISDICTION_KEY = "DPM_JURISDICTION_KEY";
	//年度总结权限
	public static final String DPM_JURISDICTION_URL = "DPM_JURISDICTION_URL";
	
	//redis config start
	@Value("${redis.pool.maxActive}")
	private int maxActive ;
	
	@Value("${redis.pool.maxIdle}")
	private int maxIdle ;
	
	@Value("${redis.pool.maxWait}")
	private int maxWait;
	
	@Value("${redis.pool.testOnBorrow}")
	private boolean Borrow;
	
	@Value("${redis.pool.testOnReturn}")
	private boolean Return;
	
	@Value("${cache_cloud_domain_url}")
	private String cache_cloud_domain_url;
	//redis config end
	
	// Jedis连接池
	private volatile JedisSentinelPool redisSentinelJedisPool;
	
	/**
	 * 构建redis连接池
	 * 
	 * @param ip
	 * @param port
	 * @return JedisPool
	 */
	public Jedis getPool() {
		
		if(redisSentinelJedisPool!=null){
			return redisSentinelJedisPool.getResource();
		}
		GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
		// 最大连接数
		poolConfig.setMaxTotal(maxActive);
		// 对象最大空闲连接数
		poolConfig.setMaxIdle(maxIdle);
		// 连接的最大等待毫秒数
		poolConfig.setMaxWaitMillis(maxWait);
		// 连接测试可用
		poolConfig.setTestOnBorrow(Borrow);
		// 返回连接池测试可用
		poolConfig.setTestOnReturn(Return);
		// 获取主从模式，缓存连接信息
		// 哨兵模式
		JedisSentinelNodeInfo nodeInfo = this.getJedisSentinelNodeInfo();
		if(nodeInfo !=null){
			redisSentinelJedisPool = new JedisSentinelPool(nodeInfo.getMasterName(), nodeInfo.getSentinels(), poolConfig);
			return redisSentinelJedisPool.getResource();
		}
		return null;
	}
	
	/**
	  * 获取缓存连接信息
	  * @return
	  */
	 protected JedisSentinelNodeInfo getJedisSentinelNodeInfo(){
		 //主备节点信息
		String[] sentinelArray;
		Set<String> sentinels = new HashSet<String>();
		JedisSentinelNodeInfo jedisSentinelNodeInfo=new JedisSentinelNodeInfo();
	  //连接信息
	  String httpGet = HttpUtil.getHttp(cache_cloud_domain_url, null, null);
	 
	  if(StringUtils.isNotEmpty(httpGet)){
		  JSONObject jsonObject=JSONObject.parseObject(httpGet);
		  sentinelArray=jsonObject.getString("sentinels").split(" ");
		  jedisSentinelNodeInfo.setMasterName(jsonObject.getString("masterName"));
		  for (String string : sentinelArray) {
			   sentinels.add(string);
			  }
		  jedisSentinelNodeInfo.setSentinels(sentinels);
	  }
	  return jedisSentinelNodeInfo;
	 }
	 
	 /**
		 * 抽取的公共代码
		 * @param fun
		 * @return
		 */
		private <T> T excute(Function<Jedis, T> fun){
			Jedis shardedJedis = null;
			try {
				// 从连接池获取连接
				shardedJedis = getPool();
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
			Jedis shardedJedis = null;
			try {
				shardedJedis = getPool();
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
			return this.excute(new Function<Jedis, String>() {
				// 实现callback
				@Override
				public String callback(Jedis shardedJedis) {
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
			return this.excute(new Function<Jedis, String>() {
				// 实现callback
				@Override
				public String callback(Jedis shardedJedis) {
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
			return this.excute(new Function<Jedis, Long>() {
				// 复写callback
				@Override
				public Long callback(Jedis shardedJedis) {
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
			return this.excute(new Function<Jedis, String>() {
				// 实现callback
				@Override
				public String callback(Jedis shardedJedis) {
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
			return this.excute(new Function<Jedis, Long>() {
				// 实现callback
				@Override
				public Long callback(Jedis shardedJedis) {
					// 从redis删除一个键
					return shardedJedis.del(key);
				}
			});
		}

	/**
	 * setter
	 */
	
	  public void setJedisPool(JedisSentinelPool jedisPool) { 
		  this.redisSentinelJedisPool =jedisPool; 
      }
	 
}