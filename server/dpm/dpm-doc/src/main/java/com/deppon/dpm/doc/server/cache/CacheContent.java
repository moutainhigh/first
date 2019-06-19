package com.deppon.dpm.doc.server.cache;

public class CacheContent {

	 // 缓存生效时间  
    private  int cacheMillis;  
    // 缓存对象  
    private String element;  
    // 缓存创建时间  
    private long createTime ;
    
    public CacheContent(String value,int cacheMillis,long currentTime){
    	this.cacheMillis = cacheMillis;
    	this.createTime = currentTime;
    	this.element = value;
    }
	public int getCacheMillis() {
		return cacheMillis;
	}
	public void setCacheMillis(int cacheMillis) {
		this.cacheMillis = cacheMillis;
	}
	public String getElement() {
		return element;
	}
	public void setElement(String element) {
		this.element = element;
	}
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
    
    
}
