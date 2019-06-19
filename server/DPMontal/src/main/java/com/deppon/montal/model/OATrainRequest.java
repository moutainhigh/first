package com.deppon.montal.model;

import java.math.BigDecimal;
import java.util.Date;


   /** 
   * @ClassName: OATrainRequest 
   * @Description:(培训需求实体类) 
   * @TableName:OA_TRAINREQUEST
   * @author yin
   * @date 2013-8-20 下午2:24:15 
   * 
   */
public class OATrainRequest {
    private BigDecimal processinstid;

    private String applyname;

    private String applyuserid;

    private String applydeptname;

    private Date begintraindate;

    private Date endtraindate;

    private String expectednum;

    private String trainmanagerposition;

    private String isconsultant;

    private String lecturername;

    private String lectureruserid;

    private String trainsubjects;

    private String traintype;

    private String managerlevel;

    private BigDecimal applyorgid;

    private String directoruserid;

    private String trainorg;

    private String trainorgName;

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

    public String getApplyuserid() {
        return applyuserid;
    }

    public void setApplyuserid(String applyuserid) {
        this.applyuserid = applyuserid;
    }

    public String getApplydeptname() {
        return applydeptname;
    }

    public void setApplydeptname(String applydeptname) {
        this.applydeptname = applydeptname;
    }

    public Date getBegintraindate() {
        return begintraindate;
    }

    public void setBegintraindate(Date begintraindate) {
        this.begintraindate = begintraindate;
    }

    public Date getEndtraindate() {
        return endtraindate;
    }

    public void setEndtraindate(Date endtraindate) {
        this.endtraindate = endtraindate;
    }

    public String getExpectednum() {
        return expectednum;
    }

    public void setExpectednum(String expectednum) {
        this.expectednum = expectednum;
    }

    public String getTrainmanagerposition() {
        return trainmanagerposition;
    }

    public void setTrainmanagerposition(String trainmanagerposition) {
        this.trainmanagerposition = trainmanagerposition;
    }

    public String getIsconsultant() {
        return isconsultant;
    }

    public void setIsconsultant(String isconsultant) {
        this.isconsultant = isconsultant;
    }

    public String getLecturername() {
        return lecturername;
    }

    public void setLecturername(String lecturername) {
        this.lecturername = lecturername;
    }

    public String getLectureruserid() {
        return lectureruserid;
    }

    public void setLectureruserid(String lectureruserid) {
        this.lectureruserid = lectureruserid;
    }

    public String getTrainsubjects() {
        return trainsubjects;
    }

    public void setTrainsubjects(String trainsubjects) {
        this.trainsubjects = trainsubjects;
    }

    public String getTraintype() {
        return traintype;
    }

    public void setTraintype(String traintype) {
        this.traintype = traintype;
    }

    public String getManagerlevel() {
        return managerlevel;
    }

    public void setManagerlevel(String managerlevel) {
        this.managerlevel = managerlevel;
    }

    public BigDecimal getApplyorgid() {
        return applyorgid;
    }

    public void setApplyorgid(BigDecimal applyorgid) {
        this.applyorgid = applyorgid;
    }

    public String getDirectoruserid() {
        return directoruserid;
    }

    public void setDirectoruserid(String directoruserid) {
        this.directoruserid = directoruserid;
    }

    public String getTrainorg() {
        return trainorg;
    }

    public void setTrainorg(String trainorg) {
        this.trainorg = trainorg;
    }

    public String getTrainorgName() {
        return trainorgName;
    }

    public void setTrainorgName(String trainorgName) {
        this.trainorgName = trainorgName;
    }
}