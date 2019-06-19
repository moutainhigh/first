package com.deppon.dpm.module.management.util;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.deppon.dpm.module.common.server.util.MagicNumber;

/**
 * 密码加密解密<br>
 * 算法与ios android一致，可以互相加密解密
 */
public class DES {

	/**
	 * 声明一变量
	 */
	private static byte[] iv = { MagicNumber.NUM1, MagicNumber.NUM2, MagicNumber.NUM3, MagicNumber.NUM4, 
			MagicNumber.NUM5, MagicNumber.NUM6, MagicNumber.NUM7, MagicNumber.NUM8 };

	/**
	 * 声明一静态变量
	 */
	private static String keyEnc = "20120401";

	/**
	 * @param encryptString 参数
	 * @return str
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidAlgorithmParameterException 
	 * @throws InvalidKeyException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 * @throws Exception 抛出异常
	 */
	public static String encryptDES(String encryptString) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		//new 一个新对象
		IvParameterSpec zeroIv = new IvParameterSpec(iv);
		//new 一个新对象
		SecretKeySpec key = new SecretKeySpec(keyEnc.getBytes(), "DES");
		//得到cipher
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key, zeroIv);
		//encryptedData
		byte[] encryptedData = cipher.doFinal(encryptString.getBytes());
		//返回数据
		return Base64.encode(encryptedData);
	}

	/**
	 * @param buf 参数
	 * @return str
	 */
	public static String parseByte2HexStr(byte buf[]) {
		// 组装sb
		StringBuffer sb = new StringBuffer();
		//循环拼装
		for (int i = 0; i < buf.length; i++) {
			//转换数据格式
			String hex = Integer.toHexString(buf[i] & 0xFF);
			//判断
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			//拼装
			sb.append(hex.toUpperCase());
		}
		//返回数据
		return sb.toString();
	}

	/**
	 * @param decryptString 参数
	 * @return str
	 * @throws NoSuchAlgorithmException 抛出异常
	 * @throws NoSuchPaddingException 抛出异常
	 * @throws InvalidKeyException 抛出异常
	 * @throws InvalidAlgorithmParameterException 抛出异常
	 * @throws IllegalBlockSizeException 抛出异常
	 * @throws BadPaddingException 抛出异常
	 */
	public static String decryptDES(String decryptString)
			throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, InvalidAlgorithmParameterException,
			IllegalBlockSizeException, BadPaddingException {
		byte[] byteMi = Base64.decode(decryptString);
		IvParameterSpec zeroIv = new IvParameterSpec(iv);
		SecretKeySpec key = new SecretKeySpec(keyEnc.getBytes(), "DES");
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, key, zeroIv);
		byte decryptedData[] = cipher.doFinal(byteMi);
		return new String(decryptedData);
	}

}