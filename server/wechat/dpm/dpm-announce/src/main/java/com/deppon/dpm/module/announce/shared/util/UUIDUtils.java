package com.deppon.dpm.module.announce.shared.util;

import java.util.UUID;

/**
 * UUID生成器
 * 
 * @author 231586
 * 
 */
public class UUIDUtils {
	/**
	 * get
	 * 
	 * @return
	 */
	public static String getUUID() {
		// 生成静态ID
		return UUID.randomUUID().toString();
	}
}
