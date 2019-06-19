package com.deppon.foss.module.sync.esb.definition;

import java.util.HashMap;
import java.util.Map;

import com.deppon.foss.module.sync.esb.process.ServerThreadPool;

/**
 * 队列信息以及线程池
 * 
 * @author 231586
 * 
 */
public class Configuration {
	/**
	 * 用以存放队列信息
	 */
	private static  Map<String, ServiceConfiguration> serviceConfigMap = new HashMap<String, ServiceConfiguration>();
	/**
	 * 使用线程执行
	 */
	private static ServerThreadPool serverThreadPool;

	/**
	 * get
	 * 
	 * @return
	 */
	public static Map<String, ServiceConfiguration> getServiceConfigMap() {
		return serviceConfigMap;
	}

	/**
	 * set
	 * 
	 * @param serviceConfigMap
	 */
	public void setServiceConfigMap(
			Map<String, ServiceConfiguration> serviceConfigMap) {
		this.serviceConfigMap = serviceConfigMap;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public static ServerThreadPool getServerThreadPool() {
		return serverThreadPool;
	}

	/**
	 * set
	 * 
	 * @param serverThreadPool
	 */
	public void setServerThreadPool(ServerThreadPool serverThreadPool) {
		Configuration.serverThreadPool = serverThreadPool;
	}
}
