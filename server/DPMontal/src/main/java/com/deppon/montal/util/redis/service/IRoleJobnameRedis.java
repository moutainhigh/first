package com.deppon.montal.util.redis.service;

public interface IRoleJobnameRedis {

	/**
	 * 判断是否存在权限登录
	 */
	public boolean validateLoginRole(String userId,String jobName);
}
