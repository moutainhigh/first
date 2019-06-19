package com.deppon.dpm.module.common.server.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.shared.domain.LoginCheckBean;
import com.deppon.dpm.module.common.shared.domain.LoginLocationEntity;
import com.deppon.foss.framework.cache.storage.RedisCacheStorage;

/**
 * map、ehcache、redis缓存
 */
public class DpmCacheManager {

	/**
	 * sonar 整改
	 */
	private final static Logger LOG = LoggerFactory
			.getLogger(DpmCacheManager.class);

	/**
	 * ehcache缓存登录时的sessionId和casCookie
	 */
	private static Cache cache;

	/**
	 * map缓存
	 */
	private static Map<String, Object> mapCache = new ConcurrentHashMap<String, Object>();

	/**
	 * redis 缓存 过期时间，单位秒 ,默认保持30分钟
	 */
	private static int expire = MagicNumber.NUM30 * MagicNumber.NUM60;

	/**
	 * redis 缓存
	 */
	private static RedisCacheStorage<String, Object> redisCacheStorage;

	/**
	 * set
	 * 
	 * @param expire
	 */
	@SuppressWarnings("static-access")
	public void setExpire(int expire) {
		this.expire = expire;
	}

	/**
	 * set
	 * 
	 * @param cache
	 */
	@SuppressWarnings("static-access")
	public void setCache(Cache cache) {
		this.cache = cache;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public RedisCacheStorage<String, Object> getRedisCacheStorage() {
		return redisCacheStorage;
	}

	/**
	 * set
	 * 
	 * @param redisCacheStorage
	 */
	@SuppressWarnings("static-access")
	public void setRedisCacheStorage(
			RedisCacheStorage<String, Object> redisCacheStorage) {
		this.redisCacheStorage = redisCacheStorage;
	}

	/**
	 * 保存登陆的session和cookie
	 */
	public static void setCookieAndSession(String key, Object value) {
		Element element = new Element("empcode:" + key, value);
		cache.put(element);
	}

	/**
	 * 获取登陆的session和cookie
	 */
	public static LoginCheckBean getCookieAndSession(String key) {
		// 获取
		Element element = cache.get("empcode:" + key);
		if (element != null) {
			// 返回
			return (LoginCheckBean) element.getValue();
		}
		return null;
	}

	/**
	 * 保存登陆时的地理位置信息
	 */
	public static void setLocationInfo(String userId, Object obj) {
		mapCache.put("location:" + userId, obj);
	}

	/**
	 * 获取登陆时的地理位置信息
	 */
	public static LoginLocationEntity getLocationInfo(String userId) {
		return (LoginLocationEntity) mapCache.get("location:" + userId);
	}

	/**
	 * 保存登陆时的返回结果
	 */
	public static void setWfs(String userId, Object rstLogin) {
		mapCache.put("workflow:" + userId, rstLogin);
	}

	/**
	 * 获取登陆时的返回结果
	 */
	public static Object getWfs(String userId) {
		return mapCache.get("workflow:" + userId);
	}

	/**
	 * redis保存
	 */
	public static void redisSet(String key, Object value, int expire) {
		redisCacheStorage.set(key, value, expire);
	}

	/**
	 * redis保存
	 * 
	 * @param key
	 * @param value
	 */
	public static void redisSet(String key, Object value) {
		redisSet(key, value, expire);
	}

	/**
	 * redis获取
	 */
	public static Object redisGet(String key) {
		// 定义返回值
		Object value = null;
		try {
			// 获取
			value = redisCacheStorage.get(key);
		} catch (Exception e) {
			// logger
			LOG.error("redisGet:", e);
		}
		if (value != null) {
			// redis存储
			redisCacheStorage.set(key, value, expire);
		}
		// 返回
		return value;
	}

	/**
	 * it时间对比，显示小红点与否
	 * 
	 * @param userId
	 * @param time
	 */
	public static void setIt(String userId, Object time) {
		// 存储
		mapCache.put(userId, time);
	}

	/**
	 * 获取时间
	 * 
	 * @param userId
	 * @return
	 */
	public static Object getIt(String userId) {
		// 获取
		return mapCache.get(userId);
	}

}
