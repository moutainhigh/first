package com.deppon.dpm.module.wfs.server.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 
* @title: EntryTable 
* @description：分录表注解
* @author： caibingbing
* @date： 2014-7-10 上午7:58:17
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
public @interface EntryTable {
	/**
	 *子表枚举
	 */
	public enum SonTable{YES,NO};
	/**
	 * 是否子表
	 * */
	SonTable isSonTable() default SonTable.NO;
}
