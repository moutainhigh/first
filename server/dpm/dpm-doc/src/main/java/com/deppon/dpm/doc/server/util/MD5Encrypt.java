package com.deppon.dpm.doc.server.util;

import java.security.MessageDigest;

import javax.xml.bind.DatatypeConverter;

//import org.apache.commons.codec.binary.Base64;


/**
 * @description md5加密+base64编码 转换工具类
 */
public class MD5Encrypt {
	
	private static final String ALGORITHM = "MD5";
	
	/**
	 * encrypt  md5加密+base64编码<br/>
	 */
	public static String encrypt(String param){
		MessageDigest digest = null;
		String result = null;
		if(param == null){
			return null;
		}
		try {
			digest = MessageDigest.getInstance(ALGORITHM);
			//Base64 base64 = new Base64();
			//result = base64.encodeToString(digest.digest(param.getBytes("UTF-8")));
			result = DatatypeConverter.printBase64Binary(digest.digest(param.getBytes("UTF-8")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
