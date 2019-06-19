package com.deppon.montal.util;

import java.io.IOException;
import java.text.SimpleDateFormat;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * @ClassName: JacksonTransformer
 * @Description: 默认Json转换器
 * @author Bruce
 * @date 2014年7月8日 上午9:46:32
 */
public class JacksonTransformer {

	/**
	 * @Fields mapper : 对象映射器
	 */
	private static ObjectMapper mapper;

	static {
		mapper = new ObjectMapper();
		mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		mapper.setDateFormat(format);
	}

	public static String java2String(Object obj) throws JsonGenerationException, JsonMappingException, IOException {
		return mapper.writeValueAsString(obj);
	}

	public static <T> T string2java(String str, Class<T> clazz) throws JsonParseException, JsonMappingException, IOException {
		return mapper.readValue(str, clazz);
	}

}