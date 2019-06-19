package com.deppon.dpm.login.server.util;

import java.io.UnsupportedEncodingException;

import org.apache.commons.lang.CharEncoding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.util.MagicNumber;

public class MacToken {

	/**
	 * 日志打印对象声明
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(MacToken.class);
	
	/**
	 * 客户端MAC地址
	 */
	private String mac;
	
	/**
	 * 有效时间，单位毫秒，默认为当前系统毫秒数
	 */
	private Long expireTime = System.currentTimeMillis();
	
	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public Long getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Long expireTime) {
		this.expireTime = expireTime;
	}

	/**
	 * 
	 * <p>创建一个新的实例 MacToken</p>
	 * @param mac
	 * @param expireSecond
	 */
	public MacToken(String mac) {
		this(mac,System.currentTimeMillis());
	}

	/**
	 * 
	 * <p>创建一个新的实例 MacToken</p>
	 * @param mac
	 * @param expireSecond
	 */
	public MacToken(String mac, Long expireTime) {
		this.setMac(mac);
		this.setExpireTime(expireTime);
	}
	
	/**
	 * 
	 * <p>byte[]数组的内容复制到Token中</p> 
	 * @param tokenBytes
	 * @see
	 */
	public MacToken(byte[] tokenBytes) {
		try {
			String token = new String(tokenBytes, CharEncoding.UTF_8);
			this.setMac(token);
		} catch (UnsupportedEncodingException e) {
			LOGGER.error(e.getMessage(),e);
		}
	}

	/**
	 * 返回该对象的byte[]数组表示
	 * 
	 * @return
	 * @see
	 */
	public byte[] toBytes() {
		try {
			return this.toString().getBytes(CharEncoding.UTF_8);
		} catch (UnsupportedEncodingException e) {
			LOGGER.error(e.getMessage(),e);
		}
		return null;
	}

	/**
	 * 
	 * <p>返回该对象的字符串表示</p> 
	 * @return 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		super.toString();
		StringBuffer sb = new StringBuffer(MagicNumber.NUM8);
		sb.append(getMac());//.append(",");
		return sb.toString();
	}
	
}
