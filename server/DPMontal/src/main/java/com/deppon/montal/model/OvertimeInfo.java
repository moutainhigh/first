
    package com.deppon.montal.model; 
   /** 
 * @Title: OvertimeInfo.java
 * @Package com.deppon.montal.model 
 * @Description: TODO(加班申请临时实体) 
 * @author 何玲菠 
 * @date 2013-6-20 下午3:27:53 
 * @version V1.0 
 */
public class OvertimeInfo {
	public String ottype;
	public String begindate;
	public String enddate;
	public String getOttype() {
	
		return ottype;
	}
	public void setOttype(String ottype) {
	
		this.ottype = ottype;
	}
	public String getBegindate() {
	
		return begindate;
	}
	public void setBegindate(String begindate) {
	
		this.begindate = begindate;
	}
	public String getEnddate() {
	
		return enddate;
	}
	public void setEnddate(String enddate) {
	
		this.enddate = enddate;
	}
	
	public OvertimeInfo(){}
	public OvertimeInfo(String ottype,String begindate,String endate){
		this.ottype = ottype;
		this.begindate = begindate;
		this.enddate = endate;
	}
}

