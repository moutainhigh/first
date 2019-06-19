/**
 * 
 */
package com.deppon.montal.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 系统工具类：各种通用方法
 * @author lin.liu
 */
public final class Util {
	/**
	 * 
	* @MethodName: newBizCode 
	* @description : 生成主键
	* @author：何玲菠 
	* @date： 2014-2-19 上午9:06:08
	* @return long
	 */
	public synchronized static long newBizCode(){
		StringBuffer code = new StringBuffer();
		code.append(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		return Long.parseLong(code.toString());
	}
}
