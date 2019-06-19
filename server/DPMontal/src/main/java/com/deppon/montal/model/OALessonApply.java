package com.deppon.montal.model;

import java.math.BigDecimal;

import com.deppon.montal.conf.F_Constants;


   /** 
   * @ClassName: OALessonApply 
   * @Description:(课程研发/审核申请实体类) 
   * @TableName:OALESSONAPPLY
   * @author 廖建雄 
   * @date 2013-7-15 下午2:48:43 
   * 
   */
public class OALessonApply {
    private BigDecimal processinstid;

    private String username;

    private String userid;

    private String userdept;

    private String lessontype;

    private String lessonname;

    private BigDecimal lessonid;

    private String managergroup;

    private String whyapply;

    public BigDecimal getProcessinstid() {
        return processinstid;
    }

    public void setProcessinstid(BigDecimal processinstid) {
        this.processinstid = processinstid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserdept() {
        return userdept;
    }

    public void setUserdept(String userdept) {
        this.userdept = userdept;
    }

    public String getLessontype() {
        return lessontype;
    }

    public void setLessontype(String lessontype) {
        this.lessontype = lessontype;
    }

    public String getLessonname() {
        return lessonname;
    }

    public void setLessonname(String lessonname) {
        this.lessonname = lessonname;
    }

    public BigDecimal getLessonid() {
        return lessonid;
    }

    public void setLessonid(BigDecimal lessonid) {
        this.lessonid = lessonid;
    }

    public String getManagergroup() {
        return managergroup;
    }

    public void setManagergroup(String managergroup) {
        this.managergroup = managergroup;
    }

    public String getWhyapply() {
        return F_Constants.chageNull(whyapply);
    }

    public void setWhyapply(String whyapply) {
        this.whyapply = whyapply;
    }
}