/**
 * 
 */
package com.deppon.dpm.module.news.server.service.impl;

/**
 * @author zzwjrl
 * 
 */
public class TpushAddressService {
	/**
	 * tpush地址
	 */
	private String tpushAddress;
	/**
	 * tpush appKey
	 */
	private String tpushAppKey;
	/**
	 * tpush密钥
	 */
	private String tpushMasterSercret;
	/**
	 * 消息存活时间
	 */
	private String tpushTimeLive;

	/**
	 * get
	 * 
	 * @return
	 */
	public String getTpushAddress() {
		return tpushAddress;
	}

	/**
	 * set
	 * 
	 * @param tpushAddress
	 */
	public void setTpushAddress(String tpushAddress) {
		this.tpushAddress = tpushAddress;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getTpushAppKey() {
		return tpushAppKey;
	}

	/**
	 * set
	 * 
	 * @param tpushAppKey
	 */
	public void setTpushAppKey(String tpushAppKey) {
		this.tpushAppKey = tpushAppKey;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getTpushMasterSercret() {
		return tpushMasterSercret;
	}

	/**
	 * set
	 * 
	 * @param tpushMasterSercret
	 */
	public void setTpushMasterSercret(String tpushMasterSercret) {
		this.tpushMasterSercret = tpushMasterSercret;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getTpushTimeLive() {
		return tpushTimeLive;
	}

	/**
	 * set
	 * 
	 * @param tpushTimeLive
	 */
	public void setTpushTimeLive(String tpushTimeLive) {
		this.tpushTimeLive = tpushTimeLive;
	}

}
