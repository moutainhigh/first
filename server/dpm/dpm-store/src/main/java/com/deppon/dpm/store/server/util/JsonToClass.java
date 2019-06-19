package com.deppon.dpm.store.server.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import net.sf.json.JSONArray;

import org.apache.poi.ss.formula.functions.T;


/**
 * 
 * @author XiaoTian
 *
 */
public class JsonToClass {
	
	/**
	 * 获取json字符串转换为对象
	 * @author XiaoTian
	 * @param value
	 * @param objectClass
	 * @return Collection
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Collection Tolist(String value, Class objectClass ){
		ArrayList<T> tolist = null;
		try {
			if(value != null && value.length() > 0){
				//将字符串转换为json格式
				JSONArray jsonArray=JSONArray.fromObject(value);
				if(!(null ==jsonArray)){
					//进行对象转换
					tolist= (ArrayList<T>)JSONArray.toCollection(jsonArray, objectClass);
				}			
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new ClassCastException();
		}	
		return tolist;
	}
	/**
	 * 
	 * @param value
	 * @param objectClass
	 * @param map
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	public static Collection Tolist(String value, Class objectClass,Map map){
		ArrayList<T> tolist = null;
		try {
			if(value != null && value.length() > 0){
				//将字符串转换为json格式
				JSONArray jsonArray=JSONArray.fromObject(value);
				if(!(null ==jsonArray)){
					//进行对象转换,map参数为复杂类对象里的对象,定义一个map pu t一个 key为属性 value为 类名.class
					tolist= (ArrayList<T>)JSONArray.toList(jsonArray, objectClass,map);
				}			
			}
		} catch (Exception e) {
			throw new ClassCastException();
		}
		return tolist;
	}
}
