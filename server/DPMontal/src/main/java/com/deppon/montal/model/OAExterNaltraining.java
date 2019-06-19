package com.deppon.montal.model;

import java.math.BigDecimal;


   /** 
   * @ClassName: OAExterNaltraining 
   * @Description:(外训申请实体类)
   * @TableName:OA_EXTERNALTRAINING 
   * @author 廖建雄 
   * @date 2013-7-15 下午3:03:26 
   * 
   */
public class OAExterNaltraining {
    private BigDecimal processinstid;

    private String name;

    private BigDecimal empid;

    private String personel;

    private String participant;

    private String trainsdate;

    private String trainedate;

    private String trainplace;

    private String coursename;

    private String sponsoringorg;

    private BigDecimal coursefee;

    private String reason;

    private String apppersonnumber;

    private String apppersonorgname;

    private String isremark;

    private BigDecimal apppersonorgid;

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

    public String getPersonel() {
        return personel;
    }

    public void setPersonel(String personel) {
        this.personel = personel;
    }

    public String getParticipant() {
        return participant;
    }

    public void setParticipant(String participant) {
        this.participant = participant;
    }

    public String getTrainsdate() {
        return trainsdate;
    }

    public void setTrainsdate(String trainsdate) {
        this.trainsdate = trainsdate;
    }

    public String getTrainedate() {
        return trainedate;
    }

    public void setTrainedate(String trainedate) {
        this.trainedate = trainedate;
    }

    public String getTrainplace() {
        return trainplace;
    }

    public void setTrainplace(String trainplace) {
        this.trainplace = trainplace;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getSponsoringorg() {
        return sponsoringorg;
    }

    public void setSponsoringorg(String sponsoringorg) {
        this.sponsoringorg = sponsoringorg;
    }

    public BigDecimal getCoursefee() {
        return coursefee;
    }

    public void setCoursefee(BigDecimal coursefee) {
        this.coursefee = coursefee;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getApppersonnumber() {
        return apppersonnumber;
    }

    public void setApppersonnumber(String apppersonnumber) {
        this.apppersonnumber = apppersonnumber;
    }

    public String getApppersonorgname() {
        return apppersonorgname;
    }

    public void setApppersonorgname(String apppersonorgname) {
        this.apppersonorgname = apppersonorgname;
    }

    public String getIsremark() {
        return isremark;
    }

    public void setIsremark(String isremark) {
        this.isremark = isremark;
    }

    public BigDecimal getApppersonorgid() {
        return apppersonorgid;
    }

    public void setApppersonorgid(BigDecimal apppersonorgid) {
        this.apppersonorgid = apppersonorgid;
    }
}