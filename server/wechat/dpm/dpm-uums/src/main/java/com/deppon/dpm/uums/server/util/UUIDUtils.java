/**
 * Project Name:dpm-uums
 * File Name:UUIDUtils.java
 * Package Name:com.deppon.dpm.uums.server.util
 * Date:2014-8-18下午2:09:42
 * Copyright (c) 2014, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.deppon.dpm.uums.server.util;

import java.util.UUID;

/**
 * ClassName:UUIDUtils <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * 
 * Date:     2014-8-18 下午2:09:42 <br/>
 * @author   157229-zxy
 * @version  
 * @since    JDK 1.6
 */
public class UUIDUtils {

	/**
	 * 
	 * getUUID: <br/>
	 * 
	 * Date:2014-8-18下午2:09:54
	 * @author 157229-zxy
	 * @return
	 * @since JDK 1.6
	 */
	public static String getUUID() {
		// 使用JDK自带的UUID生成器
		return UUID.randomUUID().toString();
	}
}

