package com.deppon.montal.util.redis.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;

import com.deppon.montal.login.model.LoginUser;
import com.deppon.montal.util.redis.service.IRedis;
import com.deppon.montal.util.redis.util.JedisConstant;
import com.deppon.montal.util.redis.util.JedisUtil;

public class UserRedisService implements IRedis{

	private static Logger logger = null;
	
	static{
		logger = Logger.getLogger(UserRedisService.class);
	}
	/**
	 * 向redis缓存中添加用户信息
	 * @param user
	 */
	@Override
	public void add2Redis(String sessionId,String userId) {
		logger.info("----->开始向redis缓存中添加用户信息");
		Jedis jedis = JedisUtil.createJedis();
		try{
			if(userId != null && sessionId != null){
				logger.info("【UserRedisService---->add2Redis--->向redis缓存中添加用户信息】:" + JedisConstant.DPMONTAL_USER_SESSION + sessionId);
				//以hash的形式存放每个userId的信息
				jedis.set(JedisConstant.DPMONTAL_USER_SESSION + sessionId, userId);
			}
		}catch(Exception ex){
			JedisUtil.returnBrokenResource(jedis);
			logger.info("[UserRedisService add2Redis]" + ex.getMessage());
			ex.printStackTrace();
		}finally{
			//return the Jedis instance to the pool
			JedisUtil.releaseJedis(jedis);
		}
	}
	/**
	 * 注销或手动计时销毁用户实例
	 * @param userId <br>
	 */
	@Override
	public void removeFromRedis(String sessionId) {
		logger.info("----->开始注销或手动计时销毁用户实例");
		Jedis jedis = JedisUtil.createJedis();
		try{
			logger.info("【UserRedisService---->removeFromRedis--->注销或手动计时销毁用户实例】:" + JedisConstant.DPMONTAL_USER_SESSION+sessionId);
			jedis.del(JedisConstant.DPMONTAL_USER_SESSION+sessionId);
		}catch(Exception ex){
			JedisUtil.returnBrokenResource(jedis);
			logger.info("[UserRedisService removeFromRedis]" + ex.getMessage());
			ex.printStackTrace();
		}finally{
			//return the Jedis instance to the pool
			JedisUtil.releaseJedis(jedis);
		}
	}
	/**
	 * 判断键是否存在，即判断用户是否还在redis缓存中
	 * @param userId
	 * @return b(boolean)
	 */
	@Override
	public boolean checkExists(String sessionId) {
		logger.info("----->判断键是否存在，即判断用户是否还在redis缓存中");
		Jedis jedis = JedisUtil.createJedis();
		boolean b = false;
		try{
			logger.info("【UserRedisService---->checkExists--->判断键是否存在，即判断用户是否还在redis缓存中】:" + JedisConstant.DPMONTAL_USER_SESSION + sessionId);
			b = jedis.exists(JedisConstant.DPMONTAL_USER_SESSION + sessionId);
			logger.info("----->键是否存在b=true则存在，b=false则不存在：b = " + b);
		}catch(Exception ex){
			JedisUtil.returnBrokenResource(jedis);
			logger.info("[UserRedisService checkExists]" + ex.getMessage());
			ex.printStackTrace();
		}finally{
			//return the Jedis instance to the pool
			JedisUtil.releaseJedis(jedis);
		}
		return b;
	}
	/**
	 * 
	 * 根据userId来获取登录用户的信息
	 * @param userId
	 * @return LoginUser
	 */
	@Override
	public Object getFromRedisBySession(String sessionId) {
		Jedis jedis = JedisUtil.createJedis();
		LoginUser user = null;
		try{
			if(sessionId != null){
				boolean b = checkExists(sessionId);
				if(b == false){
					logger.info("【UserRedisService---->getFromRedisBySession--->根据userId来获取登录用户的信息】:"+sessionId+"：会话失效。");
					return null;
				}
				//根据sessionId从缓存中获取相应的userid
				String userId = jedis.get(JedisConstant.DPMONTAL_USER_SESSION+sessionId);
				
				if(userId != null){
					logger.info("【UserRedisService---->getFromRedisBySession--->根据userId来获取登录用户的信息】:" + JedisConstant.DPMONTAL_USER_SESSION+sessionId + ":" + userId);
					user = new LoginUser();
					String uid = jedis.hget(JedisConstant.DPMONTAL_USER + userId, "userId");
					String empid = jedis.hget(JedisConstant.DPMONTAL_USER+userId, "empId");
					String empName = jedis.hget(JedisConstant.DPMONTAL_USER+userId, "empName");
					String jobName = jedis.hget(JedisConstant.DPMONTAL_USER+userId, "jobName");
//					String syscodes = jedis.hget(JedisConstant.DPMONTAL_DPMON_EMPLOYEE + userId, "syscodes");
					logger.info("【UserRedisService---->getFromRedisBySession--->根据userId来获取登录用户的信息】:userId = " + uid + " ,empid = " + empid + " ,empName = "+ empName + " ,jobName = " + jobName);
					user.setUserId(uid);
					user.setEmpId(Long.valueOf(empid));
					user.setEmpName(empName);
					user.setJobName(jobName);
//					user.setSyscodes(syscodes);
				}
			}
		}catch(Exception ex){
			JedisUtil.returnBrokenResource(jedis);
			logger.info("[UserRedisService getFromRedisBySession]" + ex.getMessage());
			ex.printStackTrace();
		}finally{
			//return the Jedis instance to the pool
			JedisUtil.releaseJedis(jedis);
		}
		return user;
	}
	
	/**
	 *  //TODO 首先根据userid来查询用户池中是否存在该用户
	 */
	@Override
	public Object getFromRedis(String userId) {
		Jedis jedis = JedisUtil.createJedis();
		LoginUser user = null;
		try{
			if(userId != null){
				boolean b = jedis.exists(JedisConstant.DPMONTAL_USER + userId);
				logger.info("【UserRedisService---->getFromRedis--->根据userid来查询用户池中是否存在该用户】:" + JedisConstant.DPMONTAL_USER + userId);
				if(b){
					user = new LoginUser();
					String uid = jedis.hget(JedisConstant.DPMONTAL_USER + userId, "userId");
					String empid = jedis.hget(JedisConstant.DPMONTAL_USER + userId, "empId");
					String empName = jedis.hget(JedisConstant.DPMONTAL_USER + userId, "empName");
					String jobName = jedis.hget(JedisConstant.DPMONTAL_USER + userId, "jobName");
//					String syscodes = jedis.hget(JedisConstant.DPMONTAL_DPMON_EMPLOYEE + userId, "syscodes");
					logger.info("【UserRedisService---->getFromRedis--->根据userid来查询用户池中是否存在该用户】:userId = " + uid + " ,empid = " + empid + " ,empName = "+ empName + " ,jobName = " + jobName);
					user.setUserId(uid);
					user.setEmpId(Long.valueOf(empid));
					user.setEmpName(empName);
					user.setJobName(jobName);
//					user.setSyscodes(syscodes);
				}
			}
		}catch(Exception ex){
			JedisUtil.returnBrokenResource(jedis);
			logger.info("[UserRedisService getFromRedis]" + ex.getMessage());
			ex.printStackTrace();
		}finally{
			//return the Jedis instance to the pool
			JedisUtil.releaseJedis(jedis);
		}
		return user;
	}
	
	/**
	 * 添加用户到redis缓存中
	 */
	@Override
	public void add2Redis(Object o){
		Jedis jedis = JedisUtil.createJedis();
		try{
			
			LoginUser user = (LoginUser)o;
			
			String userId = user.getUserId();
			String empId = user.getEmpId()+"";
			String empName = user.getEmpName();
			String jobName = user.getJobName();
			
			Map<String,String> userMap = new HashMap<String, String>();
			userMap.put("userId", userId);
			userMap.put("empId", empId);
			userMap.put("empName", empName == null ? "" : empName);
			userMap.put("jobName", jobName == null ? "" : jobName);
			
			logger.info("【UserRedisService---->add2Redis---> 添加用户到redis缓存中】: userId = " + userId + " ,empId = " + empId + " ,empName = " + empName + " ,jobName = " + jobName);
			
			jedis.hmset(JedisConstant.DPMONTAL_USER + userId, userMap);
			
		}catch(Exception ex){
			JedisUtil.returnBrokenResource(jedis);
			logger.info("[UserRedisService add2Redis]" + ex.getMessage());
			ex.printStackTrace();
		}finally{
			//return the Jedis instance to the pool
			JedisUtil.releaseJedis(jedis);
		}
	}
	
	
	/**
	 * 设置用户的session时间
	 */
	@Override
	public void setExpiredTime(String sessionId) {
		Jedis jedis = JedisUtil.createJedis();
		try{
			/**
			 * 为key设置过期时间（300 seconds）
			 * 设置最后一次操作的过期时间
			 */
			logger.info("【UserRedisService---->setExpiredTime---> 为key设置最后一次操作的过期时间】，key是：" + JedisConstant.DPMONTAL_USER_SESSION+sessionId);
			jedis.expire(JedisConstant.DPMONTAL_USER_SESSION+sessionId, Integer.valueOf(JedisUtil.getValue("redis.user.timeout")));
		}catch(Exception ex){
			JedisUtil.returnBrokenResource(jedis);
			logger.info("[UserRedisService setExpiredTime]" + ex.getMessage());
			ex.printStackTrace();
		}finally{
			//return the Jedis instance to the pool
			JedisUtil.releaseJedis(jedis);
		}
	}
}
