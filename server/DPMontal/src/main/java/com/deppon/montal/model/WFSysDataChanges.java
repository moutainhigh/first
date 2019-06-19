package com.deppon.montal.model;

import java.math.BigDecimal;

import com.deppon.montal.conf.F_Constants;


   /** 
   * @ClassName: WFSysDataChanges 
   * @Description:TODO(系统变更业务对象) 
   * @TableName:sysdatachange
   * @author 廖建雄 
   * @date 2013-4-10 下午4:18:04 
   * 
   */
public class WFSysDataChanges {
    private BigDecimal processinstid; //流程ID

    private String applyname; //申请人

    private String message; //提示信息

    private String process; //操作流程

    private String reason; //申请事由

    private BigDecimal empid; //员工ID
    private String isfinancial; //是否涉及财务 0是，1否
    private String systemid; //系统类型
    private String currentnode; //当前节点名称

    public BigDecimal getProcessinstid() {
        return processinstid;
    }

    public void setProcessinstid(BigDecimal processinstid) {
        this.processinstid = processinstid;
    }

    public String getApplyname() {
        return applyname;
    }

    public void setApplyname(String applyname) {
        this.applyname = applyname;
    }

    public String getMessage() {
        return F_Constants.chageNull(message);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getProcess() {
        return F_Constants.chageNull(process);
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getReason() {
        return F_Constants.chageNull(reason);
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public BigDecimal getEmpid() {
        return empid;
    }

    public void setEmpid(BigDecimal empid) {
        this.empid = empid;
    }
    
    public String getIsfinancial() {
    
        return F_Constants.chageNull(isfinancial);
    }

    public void setIsfinancial(String isfinancial) {
    
        this.isfinancial = isfinancial;
    }

    public String getSystemid() {
    
        return F_Constants.chageNull(systemid);
    }

    public void setSystemid(String systemid) {
    
        this.systemid = systemid;
    }

    public boolean getCurrentnode() {
    
        return "对应系统负责人".equals(currentnode) ? true : 
            	"对应系统负责人(ID)".equals(currentnode) ? true : false;
    }

    public void setCurrentnode(String currentnode) {
    
        this.currentnode = currentnode;
    }
    
}