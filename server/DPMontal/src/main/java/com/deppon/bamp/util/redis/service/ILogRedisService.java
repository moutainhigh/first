package com.deppon.bamp.util.redis.service;

/**
 * @title: ILogRedisService 
 * @description: 日志接口缓存Redis服务
 * @author: wuyaqing
 * @date:  2014-4-18 下午6:58:44
 */
public interface ILogRedisService {

	/**
	 * @MethodName: getReqNumFromRedis 
	 * @description: 从Redis里面获取请求访问次数
	 * @author: wuyaqing 
	 * @date: 2014-4-19 上午8:11:35
	 * @return int
	 */
	int getReqNumFromRedis();
	
	/**
	 * @MethodName: saveReqInfo 
	 * @description: 保存请求信息到Redis服务器
	 * @author: wuyaqing 
	 * @date: 2014-4-19 上午8:13:10
	 * @param o void
	 */
	void saveReqInfo(Object o);
	
	/**
	 * @MethodName: getReqInfoFromRedis 
	 * @description: 从redis获取到请求信息
	 * @author: wuyaqing 
	 * @date: 2014-4-19 上午8:35:37
	 * @return Object
	 */
	Object getReqInfoFromRedis();
}
