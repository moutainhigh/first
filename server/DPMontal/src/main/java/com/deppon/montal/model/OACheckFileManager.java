package com.deppon.montal.model;

import java.math.BigDecimal;


   /** 
   * @ClassName: OACheckFileManager 
   * @Description:(发文审核申请业务实体类) 
   * @TableName:OA_CHECKFILEMANAGER
   * @author 廖建雄 
   * @date 2013-8-20 下午2:32:45 
   * 
   */
public class OACheckFileManager {
    private BigDecimal id;

    private String userid;

    private String empname;

    private String processinstid;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getProcessinstid() {
        return processinstid;
    }

    public void setProcessinstid(String processinstid) {
        this.processinstid = processinstid;
    }
}