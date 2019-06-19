package com.deppon.dpm.module.wfs.server.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WFUtil {

	/**
	 * 
	 * @MethodName: parseListField
	 * @description : 解析當前類中的list屬性
	 * @author：caibingbing
	 * @date： 2014-8-13 下午2:24:56
	 * @param cls
	 * @return Map
	 */
	public static Map parseListField(Class<?> cls) {
		Map classMap = new HashMap<String, Class>();
		// 获取bean属性数组
		Field[] fields = cls.getDeclaredFields();
		for (Field field : fields) {
			Class<?> fieldClazz = field.getType();
			// 设置可操作状态
			field.setAccessible(true);
			// 获取一个属性
			String name = field.getName();
			// 子集 分录表
			if (fieldClazz.isAssignableFrom(List.class)) {
				// 字段有EntryTable注解
				Annotation anno = field.getAnnotation(EntryTable.class);
				if (anno != null) {
					continue;
				}
				// 属性类型
				Type type = field.getGenericType(); // 关键的地方，如果是List类型，得到其Generic的类型
				if (type == null)
					continue;
				// 【3】如果是泛型参数的类型
				if (type instanceof ParameterizedType) {
					ParameterizedType pt = (ParameterizedType) type;
					// 【4】 得到泛型里的class类型对象。
					Class genericClazz = (Class) pt.getActualTypeArguments()[0];
					classMap.put(name, genericClazz);
				}
			}
		}
		return classMap;
	}
}
