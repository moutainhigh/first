package com.deppon.montal.model;

import java.math.BigDecimal;

import com.deppon.montal.conf.F_Constants;


   /** 
   * @ClassName: OADataProvideApply 
   * @Description:(数据提供审批实体类) 
   * @TableName:oa_dataprovideapply
   * @author 廖建雄 
   * @date 2013-5-28 上午9:19:37 
   * 
   */
public class OADataProvideApply {
    private BigDecimal processinstid;

    private BigDecimal empid;

    private String name;

    private String target;

    private String whyapply;

    private String area;
    private String currentnode; //当前节点名称

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

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getWhyapply() {
        return F_Constants.chageNull(whyapply);
    }

    public void setWhyapply(String whyapply) {
        this.whyapply = whyapply;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCurrentnode() {
    
        return currentnode;
    }

    public void setCurrentnode(String currentnode) {
    
        this.currentnode = currentnode;
    }
    
}