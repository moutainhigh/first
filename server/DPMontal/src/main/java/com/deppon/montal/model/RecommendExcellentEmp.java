package com.deppon.montal.model;

import java.math.BigDecimal;

import com.deppon.montal.conf.F_Constants;


   /** 
   * @ClassName: RecommendExcellenTemp 
   * @Description:(优秀人才推荐实体类)
   * @TableName:recommendexcellentemp
   * @author 廖建雄 
   * @date 2013-8-20 下午2:16:28 
   * 
   */
public class RecommendExcellentEmp {
    private BigDecimal processinstid;

    private BigDecimal empid;

    private String applyname;

    private String recommendemp;

    private String recommendorg;

    private String reason;

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

    public String getApplyname() {
        return applyname;
    }

    public void setApplyname(String applyname) {
        this.applyname = applyname;
    }

    public String getRecommendemp() {
        return recommendemp;
    }

    public void setRecommendemp(String recommendemp) {
        this.recommendemp = recommendemp;
    }

    public String getRecommendorg() {
        return recommendorg;
    }

    public void setRecommendorg(String recommendorg) {
        this.recommendorg = recommendorg;
    }

    public String getReason() {
        return F_Constants.chageNull(reason);
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}