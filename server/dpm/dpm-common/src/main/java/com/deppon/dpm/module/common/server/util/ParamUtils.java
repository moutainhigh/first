package com.deppon.dpm.module.common.server.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public class ParamUtils {
    
	@SuppressWarnings("unused")
	public static boolean checkUserId(String userId){
	boolean type = true;
	// 参数是否为空
	if(StringUtils.isEmpty(userId)){
		return type;
	}
	// 通讯录匹配正则表达式
	String reg = "^[0-9]{6}$";
	String reg2 = "^T[0-9]{5}$";
	String reg3 = "^W[ABD]{1}[0-9]{6}$";
	
	Pattern pattern = Pattern.compile(reg);
	Pattern pattern2 = Pattern.compile(reg2);
	Pattern pattern3 = Pattern.compile(reg3);
	Matcher matcher = pattern.matcher(userId);
	Matcher matcher2 = pattern2.matcher(userId);
	Matcher matcher3 = pattern3.matcher(userId);
	// 参数是否正确
	if(matcher.matches()||matcher2.matches()||matcher3.matches()){
		type = false;
	}
	return type; 
	}
}
