package com.deppon.dpm.doc.server.cache;

import java.util.HashMap;
import java.util.Map;
  
  
public class LocalCache {  
  
    //缓存Map  
    private static Map<String,CacheContent> map = new HashMap<String,CacheContent>();  
    private static  LocalCache localCache = new LocalCache();  
  
    private LocalCache(){
    	
    }  
  
    public  String getLocalCache(String key) {  
        CacheContent cc = map.get(key);  
  
        if(null == cc) {  
            return null;  
        }  
        long currentTime = System.currentTimeMillis();  
        if(cc.getCacheMillis() > 0 && currentTime - cc.getCreateTime() > cc.getCacheMillis()) {  
        	map.remove(key);  
            return null;  
        } else {  
            return cc.getElement();  
        }  
    }  
  
    public void setLocalCache(String key,int cacheMillis,String value) {  
        long currentTime = System.currentTimeMillis();  
        CacheContent cc = new CacheContent(value, cacheMillis, currentTime);  
        map.put(key,cc);  
    }  
  
    public static LocalCache getInStance(){  
        return localCache;  
    }  
  
}  
