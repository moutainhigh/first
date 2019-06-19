package com.deppon.dpm.module.common.server.util;

import java.io.ByteArrayOutputStream;

/**
 * IHttpClient接口
 * 
 */
public interface IHttpClient {
	/**
	 * addHead
	 * 
	 * @param paramString1
	 * @param paramString2
	 */
	public abstract void addHead(String paramString1, String paramString2);

	/**
	 * isReDirect
	 * 
	 * @return
	 */
	public abstract boolean isReDirect();

	/**
	 * setCookie
	 * 
	 * @param paramString
	 */
	public abstract void setCookie(String paramString);

	/**
	 * setRequestURL
	 * 
	 * @param paramString
	 */
	public abstract void setRequestURL(String paramString);

	/**
	 * setMethod
	 * 
	 * @param paramString
	 */
	public abstract void setMethod(String paramString);

	/**
	 * ByteArrayOutputStream
	 * 
	 * @return
	 */
	public abstract ByteArrayOutputStream getOutputStream();

	/**
	 * fetchCookie
	 * 
	 * @return
	 */
	public abstract String fetchCookie();

	/**
	 * getLocation
	 * 
	 * @return
	 */
	public abstract String getLocation();

	/**
	 * send
	 * 
	 * @param paramString
	 */
	public abstract void send(String paramString);

	/**
	 * send
	 * 
	 * @param paramString1
	 * @param paramString2
	 */
	public abstract void send(String paramString1, String paramString2);
}
