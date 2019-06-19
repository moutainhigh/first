package com.deppon.montal.util.redis.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;

import com.deppon.montal.model.OaRollNews;
import com.deppon.montal.util.redis.service.INewsRedis;
import com.deppon.montal.util.redis.util.JedisConstant;
import com.deppon.montal.util.redis.util.JedisUtil;



public class NewsRedisService implements INewsRedis{

	private static Logger logger = null;
	
	static{
		logger = Logger.getLogger(NewsRedisService.class);
	}
	/**
	 * 获取前n条最新新闻
	 */
	@Override
	public List<OaRollNews> getTopNews(String userId) {
		Jedis jedis = JedisUtil.createJedis();
		List<OaRollNews> newsList = new ArrayList<OaRollNews>();
		try{
			
			jedis.zrevrange(JedisConstant.DPMONTAL_NEWS + userId, 0, 10);
		}catch(Exception ex){
			JedisUtil.returnBrokenResource(jedis);
			logger.info("[NewsRedisService getTopNews]" + ex.getMessage());
			ex.printStackTrace();
		}finally{
			//return the Jedis instance to the pool
			JedisUtil.releaseJedis(jedis);
		}
		return newsList;
	}
}
