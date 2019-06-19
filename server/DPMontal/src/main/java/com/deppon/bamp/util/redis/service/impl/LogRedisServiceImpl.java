package com.deppon.bamp.util.redis.service.impl;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;

import com.deppon.bamp.module.log.domain.ReqInfoEntity;
import com.deppon.bamp.module.log.util.LogClientUtil;
import com.deppon.bamp.util.redis.service.ILogRedisService;
import com.deppon.montal.util.redis.service.impl.UserRedisService;
import com.deppon.montal.util.redis.util.JedisUtil;

/**
 * @title: LogRedisServiceImpl 
 * @description: 日志接口缓存Redis服务实现类
 * @author: wuyaqing
 * @date:  2014-4-19 上午9:00:16
 */
public class LogRedisServiceImpl implements ILogRedisService {

	private static Logger logger = null;
	
	/**
	 * 初始化日志变量
	 */
	static{
		logger = Logger.getLogger(UserRedisService.class);
	}

	/**
	 * @MethodName: getReqNumFromRedis 
	 * @description: 获取请求累计次数
	 * @author: wuyaqing 
	 * @date: 2014-4-19 上午9:41:01
	 */
	@Override
	public int getReqNumFromRedis() {
		//初始化Jedis类型变量
		Jedis jedis = JedisUtil.createJedis();
		//声明请求次数变量并赋初始值
		int i = 0;
		try {
			/**
			 * 判断redis里面是否存在请求信息
			 */
			boolean b = jedis.exists(LogClientUtil.DPMONTAL_REQ_PARAS);
			//redis里面有请求信息
			if(b) {
				//取出请求次数
				Long count = jedis.llen(LogClientUtil.DPMONTAL_REQ_PARAS);
				i = count.intValue();
				logger.info("【LogRedisServiceImpl---->getReqNumFromRedis---> 从Redis中获取请求次数为：】" + i);
			}
		} catch(Exception e) {
			JedisUtil.returnBrokenResource(jedis);
			logger.info("[LogRedisServiceImpl getReqNumFromRedis]" + e.getMessage());
		} finally {
			//return the Jedis instance to the pool
			JedisUtil.releaseJedis(jedis);
		}
		//返回redis里面的请求累计次数
		return i;
	}

	/**
	 * @MethodName: saveReqInfo 
	 * @description: 添加请求信息到Redis服务器
	 * @author: wuyaqing 
	 * @date: 2014-4-19 上午9:03:26
	 */
	@Override
	public void saveReqInfo(Object o) {
		//初始化Jedis类型变量
		Jedis jedis = JedisUtil.createJedis();
		try {
			ReqInfoEntity entity = (ReqInfoEntity) o;
			//把请求实体转换为JSON格式
			JSONObject jo = JSONObject.fromObject(entity);
			logger.info("【LogRedisServiceImpl---->saveReqInfo---> 添加请求参数为： 】" + jo.toString());
			//把请求参数放到缓存中
			jedis.lpush(LogClientUtil.DPMONTAL_REQ_PARAS, jo.toString());
		} catch(Exception e) {
			JedisUtil.returnBrokenResource(jedis);
			logger.info("[LogRedisServiceImpl saveReqInfo]" + e.getMessage());
		} finally {
			//return the Jedis instance to the pool
			JedisUtil.releaseJedis(jedis);
		}
		
	}

	/**
	 * @MethodName: getReqInfoFromRedis 
	 * @description:从redis获取请求信息
	 * @author: wuyaqing 
	 * @date: 2014-4-19 上午9:04:05
	 */
	@Override
	public Object getReqInfoFromRedis() {
		Jedis jedis = JedisUtil.createJedis();
		Object entity = null;
		try {
			/**
			 * 判断redis里面是否存在请求信息
			 */
			boolean b = jedis.exists(LogClientUtil.DPMONTAL_REQ_PARAS);
			//redis里面有请求信息
			if(b) {
				String paras = jedis.lpop(LogClientUtil.DPMONTAL_REQ_PARAS);
				logger.info("【LogRedisServiceImpl---->getReqInfoFromRedis---> 从Redis中获取到的请求信息： 】" + paras);
				JSONObject jo = JSONObject.fromObject(paras);
				entity = JSONObject.toBean(jo, ReqInfoEntity.class);
			}
		} catch(Exception e) {
			JedisUtil.returnBrokenResource(jedis);
			logger.info("[LogRedisServiceImpl getParasFromRedis]" + e.getMessage());
		} finally {
			//return the Jedis instance to the pool
			JedisUtil.releaseJedis(jedis);
		}
		//返回从redis得到的请求信息
		return entity;
	}

}
