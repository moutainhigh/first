package com.deppon.dpm.login.server.util;

import org.apache.commons.codec.binary.Base64;

/**
 * 令牌序列化与反序列化
 * Function: TODO ADD FUNCTION. <br/>
 * date: 2014-8-19 上午10:28:56 <br/>
 *
 * @author 157229-zxy
 * @version 
 * @since JDK 1.6
 */
final public class TokenMarshal {
	private TokenMarshal(){
	}

	/**
	 * 
	 * <p>序列化(Base64编码)</p> 
	 * @param token
	 * @return
	 * @see
	 */
	public static String marshal(MacToken token) {
		return new String(Base64.encodeBase64String(token.toBytes()));
	}

	/**
	 * 序列化(Base64编码)
	 * 
	 * @param token
	 * @return
	 * @see
	 */
	public static String marshal(Token token) {
		return new String(Base64.encodeBase64String(token.toBytes()));
	}
	
	/**
	 * 
	 * <p>反序列化（Base64解码）</p> 
	 * @param tokenStr
	 * @return
	 * @see
	 */
	public static MacToken unMarshal(String tokenStr) {
		return new MacToken(Base64.decodeBase64(tokenStr));
	}
	
	/**
	 * 反序列化（Base64解码）
	 * 
	 * @param tokenStr
	 * @return
	 * @see
	 */
	public static Token unMarshalToken(String tokenStr) {
		return new Token(Base64.decodeBase64(tokenStr));
	}
}

