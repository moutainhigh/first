package com.deppon.montal.model;

import java.math.BigDecimal;
import java.util.List;


   /** 
   * @ClassName: OASealCarveApply 
   * @Description:(刻章申请实体类) 
   * @TableName:oa_sealcarveapply
   * @author 廖建雄 
   * @date 2013-8-20 下午2:36:56 
   * 
   */
public class OASealCarveApply {
    private BigDecimal processinstid;

    private String name;

    private String userid;

    private String deptname;

    private String area;

    private String subcom;

    private String isfirstcarve;

    private String sealname;

    private String sealtype;

    private String providecom;

    private String isrecordinps;

    private String reason;

    private String empid;

    private String financedept;
    
    private List sublist;
    
    private String currentnode;//当前节点
    
    

    public String getCurrentnode() {
	
		return currentnode;
	}

	public void setCurrentnode(String currentnode) {
	
		this.currentnode = currentnode;
	}

	public List getSublist() {
	
		return sublist;
	}

	public void setSublist(List sublist) {
	
		this.sublist = sublist;
	}

	public BigDecimal getProcessinstid() {
        return processinstid;
    }

    public void setProcessinstid(BigDecimal processinstid) {
        this.processinstid = processinstid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSubcom() {
        return subcom;
    }

    public void setSubcom(String subcom) {
        this.subcom = subcom;
    }

    public String getIsfirstcarve() {
        return isfirstcarve;
    }

    public void setIsfirstcarve(String isfirstcarve) {
        this.isfirstcarve = isfirstcarve;
    }

    public String getSealname() {
        return sealname;
    }

    public void setSealname(String sealname) {
        this.sealname = sealname;
    }

    public String getSealtype() {
        return sealtype;
    }

    public void setSealtype(String sealtype) {
        this.sealtype = sealtype;
    }

    public String getProvidecom() {
        return providecom;
    }

    public void setProvidecom(String providecom) {
        this.providecom = providecom;
    }

    public String getIsrecordinps() {
        return isrecordinps;
    }

    public void setIsrecordinps(String isrecordinps) {
        this.isrecordinps = isrecordinps;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getFinancedept() {
        return financedept;
    }

    public void setFinancedept(String financedept) {
        this.financedept = financedept;
    }
}