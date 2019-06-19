
    package com.deppon.montal.model; 

import java.util.HashMap;
import java.util.Map;
   /** 
 * @Title: OAaddAttendanceEntry.java
 * @Package com.deppon.montal.model 
 * @Description: TODO(补考勤业务实体类) 
 * @author 廖建雄 
 * @date 2013-4-27 上午10:20:12 
 * @version V1.0 
 */
public class OAaddAttendanceEntry {
    private String addman;
    private String adddept;
    private String adddate;
    private String addtype;
    private String reason;
    private String reference;
    public String getAddman() {
    
        return addman;
    }
    public void setAddman(String addman) {
    
        this.addman = addman;
    }
    public String getAdddept() {
    
        return adddept;
    }
    public void setAdddept(String adddept) {
    
        this.adddept = adddept;
    }
    public String getAdddate() {
    
        return adddate;
    }
    public void setAdddate(String adddate) {
    
        this.adddate = adddate;
    }
    public String getAddtype() {
    
        return getAddType(addtype);
    }
    public void setAddtype(String addtype) {
    
        this.addtype = addtype;
    }
    public String getReason() {
    
        return reason;
    }
    public void setReason(String reason) {
    
        this.reason = reason;
    }
    public String getReference() {
    
        return reference;
    }
    public void setReference(String reference) {
    
        this.reference = reference;
    }
    
    public static String getAddType(String code){
	Map<String, String> map = new HashMap<String, String>();
	map.put("1", "上班卡");
	map.put("2", "下班卡");
	map.put("3", "全天卡");
	if (!map.containsKey(code))
	    return "";
	
	return map.get(code);
    }
}

