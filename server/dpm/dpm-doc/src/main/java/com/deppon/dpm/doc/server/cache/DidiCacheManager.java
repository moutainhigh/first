package com.deppon.dpm.doc.server.cache;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 
 * @author Administrator
 *
 */
public class DidiCacheManager {

    //key唯一名称
    public  static final String strFormDict = "formDictformMain";

    /************************************************后台 缓存 ********************************************************/
    public  static final  String findAllEstate="findAllEstate";
   
    /************************************************后台 缓存  end********************************************************/


    private static Map<String,Object> cacheMap = new HashMap<String,Object> ();

    //单实例构造方法
    private DidiCacheManager() {
        super();
    }
    //获取布尔值的缓存
    public static boolean getSimpleFlag(String key){
        try{
            return (Boolean) cacheMap.get(key);
        }catch(NullPointerException e){
        }
        return false;
    }
    public static long getServerStartdt(String key){
        try {
            return (Long)cacheMap.get(key);
        } catch (Exception ex) {
            return 0;
        }
    }
    //设置布尔值的缓存
    public synchronized static boolean setSimpleFlag(String key,boolean flag){
        if (flag && getSimpleFlag(key)) {//假如为真不允许被覆盖
            return false;
        }else{
            cacheMap.put(key, flag);
            return true;
        }
    }
    public synchronized static boolean setSimpleFlag(String key,long serverbegrundt){
        if (cacheMap.get(key) == null) {
            cacheMap.put(key,serverbegrundt);
            return true;
        }else{
            return false;
        }
    }


    //得到缓存。同步静态方法
    private synchronized static DidiEntityCache getCache(String key) {
        return (DidiEntityCache) cacheMap.get(key);
    }

    //判断是否存在一个缓存
    private synchronized static boolean hasCache(String key) {
        return cacheMap.containsKey(key);
    }

    //清除所有缓存
    public synchronized static void clearAll() {
        cacheMap.clear();
    }

    //清除某类一特定缓存,通过遍历HASHMAP下的所有对象，来判断它的KEY与传入的TYPE是否匹配
    @SuppressWarnings("rawtypes")
	public synchronized static void clearAll(String type) {
        Iterator i = cacheMap.entrySet().iterator();
        String key;
        ArrayList<String> arr = new ArrayList<String>();
        try {
            while (i.hasNext()) {
                java.util.Map.Entry entry = (java.util.Map.Entry) i.next();
                key = (String) entry.getKey();
                if (key.startsWith(type)) { //如果匹配则删除掉
                    arr.add(key);
                }
            }
            for (int k = 0; k < arr.size(); k++) {
                clearOnly(arr.get(k));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //清除指定的缓存
    public synchronized static void clearOnly(String key) {
        cacheMap.remove(key);
    }

    //载入缓存
    public synchronized static void putCache(String key, DidiEntityCache obj) {
        cacheMap.put(key, obj);
    }

    //获取缓存信息
    public static DidiEntityCache getCacheInfo(String key) {

        if (hasCache(key)) {
        	DidiEntityCache Cache = getCache(key);
            if (CacheExpired(Cache)) { //调用判断是否终止方法
                Cache.setExpired(true);
                clearOnly(key);
            }
            return Cache;
        }else
            return null;
    }

    //载入缓存信息
    public static void putCacheInfo(String key, DidiEntityCache obj, long dt,boolean expired) {
    	DidiEntityCache Cache = new DidiEntityCache();
        Cache.setKey(key);
        Cache.setTimeOut(dt + System.currentTimeMillis()); //设置多久后更新缓存
        Cache.setValue(obj);
        Cache.setExpired(expired); //缓存默认载入时，终止状态为FALSE
        cacheMap.put(key, Cache);
    }
    //重写载入缓存信息方法
    public static void putCacheInfo(String key,DidiEntityCache obj,long dt){
    	DidiEntityCache Cache = new DidiEntityCache();
        Cache.setKey(key);
        Cache.setTimeOut(dt+System.currentTimeMillis());
        Cache.setValue(obj);
        Cache.setExpired(false);
        cacheMap.put(key,Cache);
    }

    //判断缓存是否终止
    public static boolean CacheExpired(DidiEntityCache Cache) {
        if (null == Cache) { //传入的缓存不存在
            return false;
        }
        long nowDt = System.currentTimeMillis(); //系统当前的毫秒数
        long CacheDt = Cache.getTimeOut(); //缓存内的过期毫秒数
        if (CacheDt <= 0||CacheDt>nowDt) { //过期时间小于等于零时,或者过期时间大于当前时间时，则为FALSE
            return false;
        } else { //大于过期时间 即过期
            return true;
        }
    }

    //获取缓存中的大小
    public static int getCacheSize() {
        return cacheMap.size();
    }

    //获取指定的类型的大小
    @SuppressWarnings("rawtypes")
	public static int getCacheSize(String type) {
        int k = 0;
        Iterator i = cacheMap.entrySet().iterator();
        String key;
        try {
            while (i.hasNext()) {
                java.util.Map.Entry entry = (java.util.Map.Entry) i.next();
                key = (String) entry.getKey();
                if (key.indexOf(type) != -1) { //如果匹配则删除掉
                    k++;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return k;
    }

    //获取缓存对象中的所有键值名称
    @SuppressWarnings({ "unchecked", "rawtypes", "finally" })
	public static ArrayList<String> getCacheAllkey() {
        ArrayList a = new ArrayList();
        try {
            Iterator i = cacheMap.entrySet().iterator();
            while (i.hasNext()) {
                java.util.Map.Entry entry = (java.util.Map.Entry) i.next();
                a.add((String) entry.getKey());
            }
        } catch (Exception ex) {} finally {
            return a;
        }
    }

    //获取缓存对象中指定类型 的键值名称
    @SuppressWarnings({ "rawtypes", "finally", "unchecked" })
	public static ArrayList<String> getCacheListkey(String type) {
        ArrayList a = new ArrayList();
        String key;
        try {
            Iterator i = cacheMap.entrySet().iterator();
                while (i.hasNext()) {
                java.util.Map.Entry entry = (java.util.Map.Entry) i.next();
                key = (String) entry.getKey();
                if (key.indexOf(type) != -1) {
                    a.add(key);
                }
            }
        } catch (Exception ex) {} finally {
            return a;
        }
    }

}