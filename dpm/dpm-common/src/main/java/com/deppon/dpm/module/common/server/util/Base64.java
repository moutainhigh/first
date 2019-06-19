package com.deppon.dpm.module.common.server.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.foss.framework.exception.BusinessException;

/**
 * Base64工具类
 * 
 */
public class Base64 {

	/**
	 * 日志
	 */
	private final static Logger LOG = LoggerFactory.getLogger(Base64.class);
	
	// 数字0
	private static final int NUM0 = 0;
	// 数字1
	private static final int NUM1 = 1;
	// 数字2
	private static final int NUM2 = 2;
	// 数字3
	private static final int NUM3 = 3;
	// 数字4
	private static final int NUM4 = 4;
	// 数字6
	private static final int NUM6 = 6;
	// 数字8
	private static final int NUM8 = 8;
	// 数字12
	private static final int NUM12 = 12;
	// 数字14
	private static final int NUM14 = 14;
	// 数字16
	private static final int NUM16 = 16;
	// 数字18
	private static final int NUM18 = 18;
	// 数字26
	private static final int NUM26 = 26;
	// 数字48
	private static final int NUM48 = 48;
	// 数字62
	private static final int NUM62 = 62;
	// 数字63
	private static final int NUM63 = 63;
	// 数字65
	private static final int NUM65 = 65;
	// 数字97
	private static final int NUM97 = 97;
	// 数字255
	private static final int NUM255 = 255;
	
	/**
	 * 定义字符数组
	 */
	private static final char[] legalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"
			.toCharArray();

	/**
	 * 加密
	 */
	public static String encode(byte[] data) {
		// 变量
		int start = NUM0;
		// 字节数组大小
		int len = data.length;
		// 返回值
		StringBuffer buf = new StringBuffer(data.length * NUM3 / NUM2);
		// 循环的结束位
		int end = len - NUM3;
		// 角标
		int i = start;
		// 标记位
		int n = NUM0;
		// 循环
		while (i <= end) {
			// 位运算
			int d = ((((int) data[i]) & 0x0ff) << NUM16)
					| ((((int) data[i + NUM1]) & 0x0ff) << NUM8)
					| (((int) data[i + NUM2]) & 0x0ff);
			// 拼接
			buf.append(legalChars[(d >> NUM18) & NUM63]);
			// 拼接
			buf.append(legalChars[(d >> NUM12) & NUM63]);
			// 拼接
			buf.append(legalChars[(d >> NUM6) & NUM63]);
			// 拼接
			buf.append(legalChars[d & NUM63]);
			// 角标加3
			i += NUM3;
			// 判断
			if (n++ >= NUM14) {
				// 重置n为0
				n = NUM0;
				// 拼接一个空字符串
				buf.append(" ");
			}
		}
		// 判断
		if (i == start + len - NUM2) {
			// 位运算
			int d = ((((int) data[i]) & 0x0ff) << NUM16)
					| ((((int) data[i + NUM1]) & NUM255) << NUM8);
			// 拼接
			buf.append(legalChars[(d >> NUM18) & NUM63]);
			// 拼接
			buf.append(legalChars[(d >> NUM12) & NUM63]);
			// 拼接
			buf.append(legalChars[(d >> NUM6) & NUM63]);
			// 拼接
			buf.append("=");
		} else if (i == start + len - NUM1) {
			// 位运算
			int d = (((int) data[i]) & 0x0ff) << NUM16;
			// 拼接
			buf.append(legalChars[(d >> NUM18) & NUM63]);
			// 拼接
			buf.append(legalChars[(d >> NUM12) & NUM63]);
			// 拼接
			buf.append("==");
		}
		// 返回
		return buf.toString();
	}

	/**
	 * 解密
	 */
	public static byte[] decode(String s) {
		// 功能流
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			// 调用方法
			decode(s, bos);
		} catch (IOException e) {
			// sonar 整改
			LOG.error("decode+IOException::", e);
		}
		// 将输出流中的数据专为byte数组
		byte[] decodedBytes = bos.toByteArray();
		try {
			// 关闭流
			bos.close();
			// 断开引用
			bos = null;
		} catch (IOException ex) {
			// sonar 整改
			LOG.error("decode+IOException::", ex);
		}
		// 返回
		return decodedBytes;

	}

	/**
	 * decode 处理字符串
	 * 
	 * @param s
	 * @param os
	 * @throws IOException
	 */
	private static void decode(String s, OutputStream os) throws IOException {
		// 角标
		int i = NUM0;
		// 传入字符串的长度
		int len = s.length();
		// 循环
		while (true) {
			// 循环
			while (i < len && s.charAt(i) <= ' ')
				// 自增
				i++;
			// 判断
			if (i == len)
				// 结束循环
				break;
			// 处理字节
			int tri = (decode(s.charAt(i)) << NUM18)
					+ (decode(s.charAt(i + NUM1)) << NUM12)
					+ (decode(s.charAt(i + NUM2)) << NUM6)
					+ (decode(s.charAt(i + NUM3)));
			// 写出
			os.write((tri >> NUM16) & NUM255);
			// 判断
			if (s.charAt(i + NUM2) == '=')
				// 结束循环
				break;
			// 写出
			os.write((tri >> NUM8) & NUM255);
			// 判断
			if (s.charAt(i + NUM3) == '=')
				// 结束循环
				break;
			// 写出
			os.write(tri & NUM255);
			// 角标+4
			i += NUM4;
		}
	}

	/**
	 * decode 处理字节
	 * 
	 * @param c
	 * @return
	 */
	private static int decode(char c) {
		// 判断
		if (c >= 'A' && c <= 'Z')
			// 返回
			return ((int) c) - NUM65;
		// 判断
		else if (c >= 'a' && c <= 'z')
			// 返回
			return ((int) c) - NUM97 + NUM26;
		// 判断
		else if (c >= '0' && c <= '9')
			// 返回
			return ((int) c) - NUM48 + NUM26 + NUM26;
		// 判断
		else
			switch (c) {
			// 如果c为+
			case '+':
				// 返回
				return NUM62;
			// 如果c为/
			case '/':
				// 返回
				return NUM63;
			// 如果c为=
			case '=':
				// 返回
				return NUM0;
			// 如果都不是
			default:
				// 抛出异常
				throw new BusinessException("unexpected code: " + c);
			}
	}
}