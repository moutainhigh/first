package com.deppon.dpm.module.common.server.util;



import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * JSON转换工具类
 * @author 237986
 * @date 2015-04-18 11:13:11
 */
public class JsonUtil {
	/**
	 * 将json文本转换为JSONObject对象
	 * @param str
	 * @return JSONObject对象
	 */
	public static JSONObject parseObject(String str){
		return JSONObject.parseObject(str);	
		  
	}
	
	/**
	 * 将json文本转换为JSONObject对象后根据key取value
	 * @param str
	 * @param key
	 * @return string
	 */
	public static String jsonGetValueBykey(String str,String key){
		return JSONObject.parseObject(str).getString(key);	
		  
	}
	
	/**
	 * 将json文本转换为JSONObject对象后根据key取value
	 * @param str
	 * @param key
	 * @return Integer
	 */
	public static Integer jsonToInteger(String str,String key){
		return JSONObject.parseObject(str).getInteger(key);	
	}
	
	/**
	 * 将json文本转换为javaBean
	 * @param <T> 目标javaBean
	 * @param str
	 * @param t
	 * @return 转换后的javaBean
	 */
	public static <T> T jsonToEntity(String str,Class<T> t){
		return JSONObject.parseObject(str, t);
	}
	
	/**
	 * 将json文本转换为List
	 * @param <T> 目标javaBean
	 * @param str
	 * @param t
	 * @return 转换后的javaBean
	 */
	public static <T> List<T>  jsonToList(String str,Class<T> t){
		return JSON.parseArray(str, t);
	}
	
	/**
	 * 将Map转换为JSONString
	 * @param map
	 * @return JSONString
	 */
	public static <K,V> String mapToJsonString(Map<K, V> map){
		return JSON.toJSONString(map);
	}
	
	/**
	 * 将List转换为JSONString
	 * @param <T>
	 * @param list
	 * @return JSONString
	 */
	public static <T> String listToJsonString(List<T>  list){
		return JSON.toJSONString(list);
	}
	
	/**
	 * 将javaBean转换为JSONString
	 * @param <T>
	 * @param t
	 * @return JSONString
	 */
	public static <T> String beanToJsonString(T t){
		return JSON.toJSONString(t);
	}
	
	/**
	 * 从JSONString中根据key取出JSONArray的第一个对象
	 * @param str
	 * @param key
	 * @return JSONString
	 */
	public static String jsonStrToArray(String str,String key){
		return JSONObject.parseObject(str).getJSONArray(key).getString(0);
	}
	
	/**
	 * 将map转换为JSONObject
	 * @param <K>
	 * @param <V>
	 * @param map
	 * @return JSONObject
	 */
	public static <K,V> JSONObject mapToJsonObject(Map<K, V> map){
		return JSONObject.parseObject(JSON.toJSONString(map));
	}
	
	/**
	 * 将javaBean转换为JSONObject
	 * @param <T>
	 * @param t
	 * @return JSONObject
	 */
	public static <T> JSONObject beanToJSONObject(T t){
		return (JSONObject) JSON.toJSON(t);
	}
	
	/**
	 * 判断Json中是否存在keyName
	 * @param jsonStr
	 * @param keyName
	 * @return boolean
	 */
	public static boolean isExistKey(String jsonStr, String keyName){
		return JSONObject.parseObject(jsonStr).containsKey(keyName);
	}
	
	/**
	 * 将javaBean转换为JSONString,显示null属性
	 * @param <T>
	 * @param t
	 * @return JSONString
	 */
	public static <T> String beanToJsonNullValue(T t){
		return JSON.toJSONString(t,SerializerFeature.WriteMapNullValue);
	}
}
