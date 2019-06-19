
    package com.deppon.montal.module.workitems.webservice.client; 
   /** 
 * @Title: HTTPBo.java
 * @Package com.deppon.montal.module.workitems.webservice.client 
 * @Description: TODO(添加描述) 
 * @author 廖建雄 
 * @date 2013-4-12 下午5:24:48 
 * @version V1.0 
 */
public class HTTPBo {
    String processinstId; // 工作流id
    String cookie;
    String sId; 
    String userName; //用户名
    String userId; // 用户id
    String approvever; //审批意见
    String isagree; //是否同意
    String devId; // 开发员ID
    String devManagerId; //开发经理ID
    String need; //是否需要总裁审批标识符 1需要 0不需要
    String localPersonnel;//所属事业部
    String isNeed;//是否需要财务信息化审批
    String level; //审批人职级
    
    
    
    public String getLevel() {
	
		return level;
	}
	public void setLevel(String level) {
	
		this.level = level;
	}
	public String getProcessinstId() {
    
        return processinstId.trim();
    }
    public void setProcessinstId(String processinstId) {
    
        this.processinstId = processinstId;
    }
    public String getCookie() {
    
        return cookie;
    }
    public void setCookie(String cookie) {
    
        this.cookie = cookie;
    }
    public String getsId() {
    
        return sId;
    }
    public void setsId(String sId) {
    
        this.sId = sId;
    }
    public String getUserName() {
    
        return userName;
    }
    public void setUserName(String userName) {
    
        this.userName = userName;
    }
    public String getUserId() {
    
        return userId;
    }
    public void setUserId(String userId) {
    
        this.userId = userId;
    }
    public String getApprovever() {
    
        return approvever;
    }
    public void setApprovever(String approvever) {
    
        this.approvever = approvever;
    }
    public String getIsagree() {
    
        return isagree;
    }
    public void setIsagree(String isagree) {
    
        this.isagree = isagree;
    }
    
    public String getDevId() {
    
        return devId;
    }
    public void setDevId(String devId) {
    
        this.devId = devId;
    }
    public String getDevManagerId() {
    
        return devManagerId;
    }
    public void setDevManagerId(String devManagerId) {
    
        this.devManagerId = devManagerId;
    }
    public String getNeed() {
    
        return need;
    }
    public void setNeed(String need) {
    
        this.need = need;
    }
	public String getLocalPersonnel() {
		return localPersonnel;
	}
	public void setLocalPersonnel(String localPersonnel) {
		this.localPersonnel = localPersonnel;
	}
	public String getIsNeed() {
	
		return isNeed;
	}
	public void setIsNeed(String isNeed) {
	
		this.isNeed = isNeed;
	}
    
    
}

