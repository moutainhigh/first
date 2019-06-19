/**
 * 
 */
package com.deppon.montal.util;

/**
 * @author Administrator
 *
 */
public class StringUtil {
	
	public static boolean isEmptyOrNull(String str){
		if(str==null || "".equals(str.trim())){
			return true;
		}
		return false;
	}
}
