package com.deppon.montal.util.redis.service;

public interface IRedis {
	//向redis缓存总添加一条记录
	public void add2Redis(String sessionId,String userId);
	
	public void add2Redis(Object o);
	
	//从redis缓存中删除指定的信息
	public void removeFromRedis(String sessionId);
	//从redis缓存中获取信息
	public Object getFromRedisBySession(String sessionId);
	//判断用户是否存在
	public boolean checkExists(String sessionId);
	//设置会话过期时间
	public void setExpiredTime(String sessionId);
	
	//判断用户池中是否存在该用户
	public Object getFromRedis(String userId);
}
