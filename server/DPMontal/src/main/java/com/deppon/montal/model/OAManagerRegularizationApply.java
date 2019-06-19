package com.deppon.montal.model;

import java.math.BigDecimal;
import java.util.Date;

public class OAManagerRegularizationApply {
    private BigDecimal processinstid;

    private String name;

    private BigDecimal empid;

    private String dept;

    private String deptcode;

    private Date startdate;

    private String istalkspay;

    private Integer talkspay;

    private String reason;

    private String enterprisearea;

    private String userid;

    private String apptype;
    
    private String applytype;
    
    private String growththroughtype;
    
    private String position;
    
    private String inspectionlevel;
    
    private Date appointmentdate;
    
    private String positiveproid;
    
    private Date positivedate;
    
    private String currentnode; //当前节点名称
    
    
    
	public String getApplytype() {
	
		return applytype;
	}

	public void setApplytype(String applytype) {
	
		this.applytype = applytype;
	}

	public String getGrowththroughtype() {
	
		return growththroughtype;
	}

	public void setGrowththroughtype(String growththroughtype) {
	
		this.growththroughtype = growththroughtype;
	}

	public String getPosition() {
	
		return position;
	}

	public void setPosition(String position) {
	
		this.position = position;
	}

	public String getInspectionlevel() {
	
		return inspectionlevel;
	}

	public void setInspectionlevel(String inspectionlevel) {
	
		this.inspectionlevel = inspectionlevel;
	}

	public Date getAppointmentdate() {
	
		return appointmentdate;
	}

	public void setAppointmentdate(Date appointmentdate) {
	
		this.appointmentdate = appointmentdate;
	}

	public String getPositiveproid() {
	
		return positiveproid;
	}

	public void setPositiveproid(String positiveproid) {
	
		this.positiveproid = positiveproid;
	}

	public Date getPositivedate() {
	
		return positivedate;
	}

	public void setPositivedate(Date positivedate) {
	
		this.positivedate = positivedate;
	}

	public String getCurrentnode() {
		return currentnode;
	}

	public void setCurrentnode(String currentnode) {
		this.currentnode = currentnode;
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

    public BigDecimal getEmpid() {
        return empid;
    }

    public void setEmpid(BigDecimal empid) {
        this.empid = empid;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDeptcode() {
        return deptcode;
    }

    public void setDeptcode(String deptcode) {
        this.deptcode = deptcode;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public String getIstalkspay() {
        return istalkspay;
    }

    public void setIstalkspay(String istalkspay) {
        this.istalkspay = istalkspay;
    }

    public Integer getTalkspay() {
        return talkspay;
    }

    public void setTalkspay(Integer talkspay) {
        this.talkspay = talkspay;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getEnterprisearea() {
        return enterprisearea;
    }

    public void setEnterprisearea(String enterprisearea) {
        this.enterprisearea = enterprisearea;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getApptype() {
        return apptype;
    }

    public void setApptype(String apptype) {
        this.apptype = apptype;
    }
}