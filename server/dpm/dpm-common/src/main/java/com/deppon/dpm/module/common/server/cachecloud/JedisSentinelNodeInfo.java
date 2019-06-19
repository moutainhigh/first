package com.deppon.dpm.module.common.server.cachecloud;

import java.util.Set;

/**
 * JedisSentinelNodeInfo
 * 
 * @author 
 * @创建时间： 2017-2-20 下午5:52:20
 * @描述：redis 主备模式，连接信息
 *
 */
public class JedisSentinelNodeInfo {

	/**
	 * 主节点名称
	 */
	private String masterName;
	
	/**
	 * 节点信息
	 */
	private Set<String> sentinels;

	/**
	 ******************************************
	 ******************************************
	 *@author 作者名 
	 *@date 日期2019-3-26
	 *@version （版本标识）1.0
	 *@throws 异常类及抛出条件
	 * @return the masterName to get
	 ******************************************
	 ******************************************
	 */
	public String getMasterName() {
		return masterName;
	}

	/**
	 ******************************************
	 ******************************************
	 *@author 作者名 
	 *@date 日期2019-3-26
	 *@version （版本标识）1.0
	 *@parameter 参数及其意义masterName the masterName to set
	 *@return 返回值
	 *@throws 异常类及抛出条件
	 * @param masterName the masterName to set
	 ******************************************
	 ******************************************
	 */
	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}

	/**
	 ******************************************
	 ******************************************
	 *@author 作者名 
	 *@date 日期2019-3-26
	 *@version （版本标识）1.0
	 *@throws 异常类及抛出条件
	 * @return the sentinels to get
	 ******************************************
	 ******************************************
	 */
	public Set<String> getSentinels() {
		return sentinels;
	}

	/**
	 ******************************************
	 ******************************************
	 *@author 作者名 
	 *@date 日期2019-3-26
	 *@version （版本标识）1.0
	 *@parameter 参数及其意义sentinels the sentinels to set
	 *@return 返回值
	 *@throws 异常类及抛出条件
	 * @param sentinels the sentinels to set
	 ******************************************
	 ******************************************
	 */
	public void setSentinels(Set<String> sentinels) {
		this.sentinels = sentinels;
	}


	
	
}
