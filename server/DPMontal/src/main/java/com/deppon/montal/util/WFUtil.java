package com.deppon.montal.util;

import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;

import com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.ApprovalInfo;
import com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain.AttachEntity;
import com.deppon.montal.conf.DictEntryService;
import com.deppon.montal.conf.domain.DictEntry;
import com.deppon.montal.conf.domain.WorkflowInfo;
import com.deppon.montal.util.redis.util.JedisConstant;
import com.deppon.montal.util.redis.util.JedisUtil;
import com.deppon.wfs.workflow.domain.Fileupload;
import com.deppon.wfs.workflow.service.FileuploadServiceImpl;
import com.deppon.wfs.workflow.service.IFileuploadService;
import com.deppon.wfs.workflow.service.WFDetailApplyServiceImpl;

public class WFUtil {
	private static Logger logger = Logger.getLogger(WFUtil.class);
	/**
	 * 
	* @MethodName: getWrokflowInfo 
	* @description : 从缓存中获取该工作流配置信息
	* @author：caibingbing 
	* @date： 2014-6-24 下午2:48:29
	* @param workflowname
	* @return List<WorkflowInfo>
	 */
	public List<WorkflowInfo> getWrokflowInfo(String workflowname){
		Jedis jedis = JedisUtil.createJedis();
		List<WorkflowInfo> list = new ArrayList<WorkflowInfo>();
		WorkflowInfo tp = null;
		try {
			String redisKey = JedisConstant.DPMONTAL_DPMON_WORKFLOW;
			redisKey = redisKey + workflowname;
			
			Set<String> set = jedis.keys(redisKey);
			for (String dictKey : set) {
				tp = new WorkflowInfo();
				String id = jedis.hget(dictKey, "id");
				String workflowname1 = jedis.hget(dictKey, "workflowname");
				String jspname = jedis.hget(dictKey, "jspname");
				String syscode = jedis.hget(dictKey, "syscode");
				String createtime = jedis.hget(dictKey, "createtime");
				String className = jedis.hget(dictKey, "classname");
				String entryProperty = jedis.hget(dictKey, "entryproperty");
				tp.setId(id);
				tp.setJspname(jspname);
				tp.setWorkflowname(workflowname1);
				tp.setSyscode(syscode);
				tp.setClassName(className);
				tp.setEntryProperty(entryProperty);
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				tp.setCreatetime(df.parse(createtime));
				list.add(tp);
			}

		} catch (Exception ex) {
			JedisUtil.returnBrokenResource(jedis);
			logger.info("获取工作流配置信息异常，异常信息：" + ex.getMessage(), ex);
		} finally {
			JedisUtil.releaseJedis(jedis);
		}
		return list;
	}
	/**
	 * 
	* @MethodName: getWFSDetails 
	* @description : 获取工作流详情信息
	* @author：caibingbing 
	* @date： 2014-6-20 上午9:34:40
	* @param bean
	* @param actionUrl
	* @param params
	* @param sid
	* @return
	* @throws IllegalArgumentException
	* @throws UnsupportedEncodingException
	* @throws InstantiationException
	* @throws IllegalAccessException
	* @throws InvocationTargetException
	* @throws ClassNotFoundException Object
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object getWFSDetails(Object bean, String actionUrl, Map<String, String> params, String sid) throws IllegalArgumentException, UnsupportedEncodingException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException{
		boolean flag = false;
		Map classMap = new HashMap<String, Class>();
		// 获取bean属性数组
		Field[] fields = bean.getClass().getDeclaredFields();
		for (Field field : fields) {
			Class<?> fieldClazz = field.getType();
			// 设置可操作状态
			field.setAccessible(true);
			// 获取一个属性
			String name = field.getName();
			// 子集 分录表
			if (fieldClazz.isAssignableFrom(List.class)) {
				//字段有EntryTable注解
				Annotation anno = field.getAnnotation(EntryTable.class);
				if(anno != null){
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
				flag = true;
			}
		}
		if (!flag) {
			// 无分录查询详情
			return new WFDetailApplyServiceImpl().getCommDWFSDetails(bean,actionUrl, params, sid);
		} else {
			// 分录表
			return new WFDetailApplyServiceImpl().getCommDWFSDetailsWithSubEntity(bean, classMap, actionUrl,params, sid);
		}
	}
	/**
	 * 
	* @MethodName: parseJsonToMap 
	* @description : json字符串转换为map集合
	* @author：caibingbing 
	* @date： 2014-6-24 下午8:17:05
	* @param json
	* @return Map<String,Object>
	 */
	public Map<String, Object> parseJsonToMap(String json){
		if("".equals(json) || json == null){
			json = "{}";
		}
	    JSONObject jsonObj = JSONObject.fromObject(json);
	    Map<String, Object> map = new HashMap<String, Object>();
	    for(Object k : jsonObj.keySet()){
	        Object v = jsonObj.get(k);
	            map.put(k.toString(), v);
	    }
	    return map;
	}
	/**
	 * 
	* @MethodName: parseEntityEntry 
	* @description : 工作流详情信息业务字典字段接卸
	* @author：caibingbing 
	* @date： 2014-6-20 下午2:02:10
	* @param entity 工作流详情
	* @param bean 实体bean
	* @param filedMap 属性、业务字典对应关系
	* @return
	* @throws IllegalArgumentException
	* @throws IllegalAccessException Object
	 */
	@SuppressWarnings({"rawtypes", "unchecked" })
	public Object parseEntityEntry(Object entity, Object bean, Map filedMap) throws IllegalArgumentException, IllegalAccessException {
		//待转换业务字典属性集合为空
		if(filedMap == null || filedMap.size() == 0){
			return entity;
		}
		//业务字典服务层对象
		DictEntryService dictEntryService = WFDetailApplyServiceImpl.getDictEntryService();
		//获取bean属性数组
		Field[] fields = bean.getClass().getDeclaredFields();
		for(Field field:fields){
			Class fieldClazz = field.getType(); 
			//设置可操作状态
			field.setAccessible(true);
			//获取一个属性
			String name = field.getName();
			//获取该属性的值，可能为空
			Object value = field.get(entity);
			//子集 分录表
			if(fieldClazz.isAssignableFrom(List.class)){
				//字段有EntryTable注解
				Annotation anno = field.getAnnotation(EntryTable.class);
				if(anno != null){
					continue;
				}
				//属性类型
				Type type = field.getGenericType(); // 关键的地方，如果是List类型，得到其Generic的类型  
	            if(type == null) continue;  
	            if(type instanceof ParameterizedType) //如果是泛型参数的类型   
	            {   
	            	//获取泛型class类
	                ParameterizedType pt = (ParameterizedType) type;  
	                //【4】 得到泛型里的class类型对象。
	                Class genericClazz = (Class)pt.getActualTypeArguments()[0];  
	                //分录集合值
	                Collection<Object> subEntitys = (Collection<Object>) value;
	                try {
//	                	Object subBean = genericClazz.newInstance();
	                   //for遍历list集合  获取每个分录值
	                	for(Object object : subEntitys){
	                	   parseEntityEntry(object,genericClazz.newInstance(),filedMap);
	                	}
					} catch (InstantiationException e) {
						e.printStackTrace();
					}
	             }
			}
			//从业务字典集合中 判断该属性是否需要转换
			String dictEntry = (String) filedMap.get(name);
			if(dictEntry != null && value != null){
				//业务字典转换
				List<DictEntry> entrys = dictEntryService.getDictEntries(dictEntry, (String)value);
				int size = entrys == null?0:entrys.size();
				if(size != 0){
					String entry = entrys.get(0).getDictname();
					field.set(entity, entry);
				}
			}
		}
		return entity;
	}
	/**
	 * 
	* @MethodName: getAllFiles 
	* @description : 获取上传附件集合
	* @author：caibingbing 
	* @date： 2014-6-24 下午8:27:09
	* @param busino
	* @return List<Fileupload>
	 */
	public List<Fileupload> getAllFiles(String busino){
		IFileuploadService fileuploadService = new FileuploadServiceImpl();
		Fileupload fileupload = new Fileupload();
		fileupload.setBusino(busino);
		return fileuploadService.getAllFileupload(fileupload);
	} 
	/**
	 * 
	* @MethodName: parseLmsWFInfo 
	* @description : lms工作流查询结果解析
	* @author：caibingbing 
	* @date： 2014-8-13 下午1:55:15
	* @param processdefname
	* @param comClass
	* @param lmsInfoJson
	* @return Object
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Object parseLmsWFInfo(String processdefname,Class<?> comClass,String lmsInfoJson){
		//工作流工具类
		WFUtil wfUtil = new WFUtil();
		//从缓存中获取8月份lms工作流配置信息
		List<WorkflowInfo> workflowInfos = wfUtil.getWrokflowInfo(processdefname);
		int wfInfoSize = workflowInfos==null?0:workflowInfos.size();
		if(wfInfoSize > 1){
			logger.info("工作流配置信息结果异常，请检查工作流配置。");
		}
		WorkflowInfo wfinfo =  workflowInfos.get(0);
		logger.info("流程定义:"+processdefname+" 实体类:" + wfinfo.getClassName() + " 业务字典属性:" + wfinfo.getEntryProperty());
		
		//通过类的名称反射类
		Class<?> cls = null;
		//lms工作流返回的json解析
		Object objs = null;
		Map classMap = new HashMap<String, Class<?>>();
		try {
			cls = Class.forName(wfinfo.getClassName());
			classMap = parseListField(cls);
			classMap.put("items",cls);
			classMap.put("approvalInfoList",ApprovalInfo.class);
			classMap.put("attachList",AttachEntity.class);
			objs = JSONUtil.translateToSubBean(comClass, classMap, lmsInfoJson);
		} catch (ClassNotFoundException e) {
			logger.error(e.getMessage(), e);
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage(), e);
		} catch (InstantiationException e) {
			logger.error(e.getMessage(), e);
		} catch (IllegalAccessException e) {
			logger.error(e.getMessage(), e);
		} catch (InvocationTargetException e) {
			logger.error(e.getMessage(), e);
		}
		return objs;
	}
	/**
	 * 
	* @MethodName: parseListField 
	* @description : 解析當前類中的list屬性
	* @author：caibingbing 
	* @date： 2014-8-13 下午2:24:56
	* @param cls
	* @return Map
	 */
	public static Map parseListField(Class<?> cls){
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
						//字段有EntryTable注解
						Annotation anno = field.getAnnotation(EntryTable.class);
						if(anno != null){
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
