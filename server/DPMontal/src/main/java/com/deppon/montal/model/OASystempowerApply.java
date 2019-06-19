package com.deppon.montal.model;

import java.math.BigDecimal;
import java.util.Date;

import com.deppon.montal.conf.F_Constants;

/**
 * 系统权限申请entity
 * @author yin
 *
 */
public class OASystempowerApply {
    private BigDecimal processinstid;

    private String empid;

    private String applyname;

    private String empdept;

    private String empposition;

    private String powertype;

    private String username;

    private String userid;

    private Date entrydate;

    private String userposition;

    private Date endtime;

    private String whyapply;
    
    private String applytype;
    
    private String fixedassetcode;
    
    private String iscertification;
    
    private String subcom;
    
    private String beforedept;
    
    private String beforeposition;
    
    private String currentnode;//当前节点
    
    private String wfrelatedata;//缓冲数据区

    public BigDecimal getProcessinstid() {
        return processinstid;
    }

    public void setProcessinstid(BigDecimal processinstid) {
        this.processinstid = processinstid;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getApplyname() {
        return applyname;
    }

    public void setApplyname(String applyname) {
        this.applyname = applyname;
    }

    public String getEmpdept() {
        return empdept;
    }

    public void setEmpdept(String empdept) {
        this.empdept = empdept;
    }

    public String getEmpposition() {
        return empposition;
    }

    public void setEmpposition(String empposition) {
        this.empposition = empposition;
    }

    public String getPowertype() {
    	StringBuffer typeBuf = new StringBuffer();
    	if(null != powertype){
        	String[] arr = powertype.split(",");
        	for(int i=0; i<arr.length; i++){
        		typeBuf.append(F_Constants.SYSTEMPOWER_TYPE_MAP.get(arr[i])).append("  ");
        	}
        	
        }
    	return typeBuf.toString();
    }
    
    public String getDefPowertype(){
    	return powertype;
    }

    public void setPowertype(String powertype) {
        this.powertype = powertype;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Date getEntrydate() {
        return entrydate;
    }

    public void setEntrydate(Date entrydate) {
        this.entrydate = entrydate;
    }

    public String getUserposition() {
        return userposition;
    }

    public void setUserposition(String userposition) {
        this.userposition = userposition;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getWhyapply() {
    	return whyapply;
    }

    public void setWhyapply(String whyapply) {
        this.whyapply = whyapply;
    }
    
    public String getCurrentnode() {
        return currentnode;
    }

    public void setCurrentnode(String currentnode) {
        this.currentnode = currentnode;
    }

	public String getApplytype() {
	
		return applytype;
	}

	public void setApplytype(String applytype) {
	
		this.applytype = applytype;
	}

	public String getFixedassetcode() {
	
		return fixedassetcode;
	}

	public void setFixedassetcode(String fixedassetcode) {
	
		this.fixedassetcode = fixedassetcode;
	}

	public String getIscertification() {
	
		return iscertification;
	}

	public void setIscertification(String iscertification) {
	
		this.iscertification = iscertification;
	}

	public String getSubcom() {
	
		return subcom;
	}

	public void setSubcom(String subcom) {
	
		this.subcom = subcom;
	}

	public String getBeforedept() {
	
		return beforedept;
	}

	public void setBeforedept(String beforedept) {
	
		this.beforedept = beforedept;
	}

	public String getBeforeposition() {
	
		return beforeposition;
	}

	public void setBeforeposition(String beforeposition) {
	
		this.beforeposition = beforeposition;
	}

	
	public String getWfrelatedata() {
		return wfrelatedata;
	}

	public void setWfrelatedata(String wfrelatedata) {
	
		this.wfrelatedata = wfrelatedata;
	}
	
	/**
	  * 解析出是否财务审批
	   * @Title: getWfrelatedata 
	   * @Description:TODO(这里用一句话描述这个方法的作用)
	   * @date 2013-8-9 上午10:00:16
	 */
    public String getIsFanical(){
    	if(wfrelatedata==null){
			return "0";
		}
		int begin = wfrelatedata.indexOf("<isFanical __type=\"java:java.lang.String\">");
		if(begin == -1){
			return "0";
		}
		int end = wfrelatedata.indexOf("</isFanical>");
		String tempStr = wfrelatedata.substring(begin, end);
		tempStr = tempStr.substring(tempStr.indexOf(">")+1, tempStr.length());
		return tempStr;
    }
}