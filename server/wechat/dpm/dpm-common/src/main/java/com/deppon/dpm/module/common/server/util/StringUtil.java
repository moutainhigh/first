package com.deppon.dpm.module.common.server.util;

import java.io.BufferedReader;

/**
 * 工具类
 */
public class StringUtil {
	/**
	 * 将缓冲流读取为string
	 * 
	 * @param bu
	 * @return
	 */
	public static final String bufferString(BufferedReader bu) {
		// 实例化
		StringBuffer str = new StringBuffer();
		try {
			// 定义字段用以接收读取信息
			String str1 = "";
			try {
				// 循环读取
				while ((str1 = bu.readLine()) != null) {
					// 循环追加
					str.append(str1);
				}
				// catch异常
			} catch (Exception ce) {
				// 打印异常
				ce.printStackTrace();
			} finally {
				// 关闭流
				bu.close();
			}
			// catch异常
		} catch (Exception ce) {
			// 打印异常
			ce.printStackTrace();
		}
		// 返回读取的字符串
		return str.toString();
	}
	
	public static boolean isEmpty(String str) {
        return ((str == null) || (str.length() == 0));
    }

    public static boolean isNotEmpty(String str) {
        return ((str != null) && (str.length() > 0));
    }
}
