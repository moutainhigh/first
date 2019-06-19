package com.deppon.montal.model;

import java.math.BigDecimal;


   /** 
   * @ClassName: OAaddAttendance 
   * @Description:TODO(补考勤实体类)
   * @TableName: OA_ADDATTENDANCE
   * @author 廖建雄 
   * @date 2013-4-27 上午9:35:23 
   * 
   */
public class OAaddAttendance {
    
	private BigDecimal processinstid;

    private BigDecimal empid;

    private String name;

    private String remark;

    private String area;

    private String adddept;

    private String adddate;

    private String addtype;

    private String reference;

    private String reason;

    private String addman;
    
    private String areaname;

    public BigDecimal getProcessinstid() {
        return processinstid;
    }

    public void setProcessinstid(BigDecimal processinstid) {
        this.processinstid = processinstid;
    }

    public BigDecimal getEmpid() {
        return empid;
    }

    public void setEmpid(BigDecimal empid) {
        this.empid = empid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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
        return addtype;
    }

    public void setAddtype(String addtype) {
        this.addtype = addtype;
    }

    public String getReference() {
        return reference;
    }    

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getAddman() {
        return addman;
    }

    public void setAddman(String addman) {
        this.addman = addman;
    }

	public String getAreaname() {
		return areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}
    
    
}