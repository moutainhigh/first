package com.deppon.montal.util;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;

public class JSONUtil {
	
	private static  ObjectMapper mapper = new ObjectMapper();
	
	static{
		//new date Format
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//对json里面的date做格式转换
		mapper.setDateFormat(df);
		mapper.getDeserializationConfig().set(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,false);
	}
	
	/**
	 * 
	* @Title: translateToBean 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @author dpyuanjb@deppon.com/092039
	* 2014年9月1日下午5:43:40
	* @param @param clazz
	* @param @param jsonString
	* @param @return
	* @param @throws InstantiationException
	* @param @throws IllegalAccessException
	* @param @throws IllegalArgumentException
	* @param @throws InvocationTargetException    设定文件 
	* @return T    返回类型 
	* @throws
	* @deprecated
	 */
	public static <T> T translateToBean (Class<T> clazz,String jsonString) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		setDataFormat2JAVA();
        Object t = JSONObject.toBean(jsonObject, clazz);  
		return (T)t;
	}
	/**
	 * 
	* @Title: setDataFormat2JAVA 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @author dpyuanjb@deppon.com/092039
	* 2014年9月1日下午5:44:11
	* @param     设定文件 
	* @return void    返回类型 
	* @throws
	* @deprecated
	 */
	public static void setDataFormat2JAVA(){
		JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(new String[] {"yyyy-MM-dd't'HH:mm:ss" , "yyyy-MM-dd HH:mm:ss" , "yyyy-MM-dd"}));  
	}
	
	/**
	 * 
	* @Title: translateToSubBean 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @author dpyuanjb@deppon.com/092039
	* 2014年9月1日下午5:40:40
	* @param @param class1
	* @param @param classMap2
	* @param @param jsonString
	* @param @return
	* @param @throws InstantiationException
	* @param @throws IllegalAccessException
	* @param @throws IllegalArgumentException
	* @param @throws InvocationTargetException    设定文件 
	* @return T    返回类型 
	* @throws
	* @deprecated
	 */
	public static <T> T translateToSubBean (Class<T> class1,Map<String, Class> classMap2, String jsonString) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		setDataFormat2JAVA();
        Object t = JSONObject.toBean(jsonObject, class1,classMap2);  
		return (T)t;
	}
	
	
	/**
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 * 
	* @Title: parseJsonToObject 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @author dpyuanjb@deppon.com/092039
	* 2014年9月1日下午5:31:50
	* @param @param clazz
	* @param @param jsonStr
	* @param @return    设定文件 
	* @return T    返回类型 
	* @throws
	 */
	public static <T> T parseJsonToObject(Class<T> clazz, String jsonStr) throws JsonParseException, JsonMappingException, IOException{
			return mapper.readValue(jsonStr, clazz);
	
	}
	/**
	 * 
	* @Title: encapsulateJsonObject 
	* @Description:object 转换成String
	* @author dpyuanjb@deppon.com/092039
	* 2014年9月1日下午5:39:51
	* @param @param obj
	* @param @return
	* @param @throws JsonGenerationException
	* @param @throws JsonMappingException
	* @param @throws IOException    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static String encapsulateJsonObject(Object obj) throws JsonGenerationException, JsonMappingException, IOException{
			return mapper.writeValueAsString(obj);
	}
	
	/**
	 * jsonToList<T> 带泛型
	 * jsonStr  
	 * clazz  集合元素类型
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	
	public static <T> List<T> toList(String jsonStr,Class<T> clazz) throws JsonParseException, JsonMappingException, IOException{
		JavaType javaType = getCollectionType(List.class,clazz);
			return mapper.readValue(jsonStr, javaType);
	}
	
	/**
	 * jsonToMap<T> 带泛型
	 * jsonStr  json字符串
	 * keyClazz     key class
	 * valueClazz 	value class
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public static <K,V> Map<K, V> toMap(String jsonStr,Class<K> keyClazz,Class<V> valueClazz) throws JsonParseException, JsonMappingException, IOException{
		JavaType javaType = mapper.getTypeFactory().constructParametricType(Map.class, keyClazz,valueClazz);
			return mapper.readValue(jsonStr, javaType);
	}
	
	public static JavaType getCollectionType(Class<?> collectionClass,
			Class<?>... elementClasses) {
		return mapper.getTypeFactory().constructParametricType(collectionClass,
				elementClasses);
	}
	
	
}
