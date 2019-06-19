package com.deppon.montal.model;

import java.math.BigDecimal;


   /** 
   * @ClassName: OACheckFileApply 
   * @Description:(发文审核申请实体类) 
   * @TableName:OA_CHECKFILEAPPLY
   * @author 廖建雄 
   * @date 2013-8-20 下午2:31:39 
   * 
   */
public class OACheckFileApply {
    private BigDecimal processinstid;

    private BigDecimal empid;

    private String name;

    private String filename;

    private String remark;

    private String jobno;

    private String applydept;

    private String filecategory;

    private String prevfilename;

    private String editfilenum;

    private String usearea;

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

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getJobno() {
        return jobno;
    }

    public void setJobno(String jobno) {
        this.jobno = jobno;
    }

    public String getApplydept() {
        return applydept;
    }

    public void setApplydept(String applydept) {
        this.applydept = applydept;
    }

    public String getFilecategory() {
        return filecategory;
    }

    public void setFilecategory(String filecategory) {
        this.filecategory = filecategory;
    }

    public String getPrevfilename() {
        return prevfilename;
    }

    public void setPrevfilename(String prevfilename) {
        this.prevfilename = prevfilename;
    }

    public String getEditfilenum() {
        return editfilenum;
    }

    public void setEditfilenum(String editfilenum) {
        this.editfilenum = editfilenum;
    }

    public String getUsearea() {
        return usearea;
    }

    public void setUsearea(String usearea) {
        this.usearea = usearea;
    }
}