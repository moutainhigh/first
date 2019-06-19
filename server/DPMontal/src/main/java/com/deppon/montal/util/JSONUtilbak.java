package com.deppon.montal.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

public class JSONUtilbak {
	public static <T> T translateToBean (Class<T> clazz,String jsonString) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		setDataFormat2JAVA();
        Object t = JSONObject.toBean(jsonObject, clazz);  
		return (T)t;
	}
	public static void setDataFormat2JAVA(){
		JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(new String[] {"yyyy-MM-dd't'HH:mm:ss" , "yyyy-MM-dd HH:mm:ss" , "yyyy-MM-dd"})); 
	}
	
	public static <T> T translateToSubBean (Class<T> class1,Map<String, Class> classMap2, String jsonString) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		setDataFormat2JAVA();
        Object t = JSONObject.toBean(jsonObject, class1,classMap2);  
		return (T)t;
	}
}
