package com.deppon.montal.model;

import java.math.BigDecimal;
import java.util.Date;


   /** 
   * @ClassName: OAConverterApply 
   * @Description:(转正申请实体类)
   * @TableName：OA_CONVERTERAPPLY
   * @author 廖建雄 
   * @date 2013-6-20 下午2:50:04 
   * 
   */
public class OAConverterApply {
    private BigDecimal regularizedno;

    private BigDecimal applycode;

    private String name;

    private String dept;

    private String idcard;

    private String position;

    private Date boarddate;

    private Date exacrossdate;

    private String isnewpx;

    private String ispro;

    private String abandinfo;

    private String phone;

    private String familynm;

    private BigDecimal age;

    private String relations;

    private String familyphone;

    private String familyaddr;

    private String zip;

    private String oname;

    private String oinfo;

    private String oaccount;

    private String remark;

    private String gwflag;

    private BigDecimal culture;

    private BigDecimal typing;

    private BigDecimal expertise;

    private BigDecimal cknowledge;

    private BigDecimal driversinfo;

    private String experience;

    private String comments;

    private String collevaluation;

    private String leadevaluation;

    private String fileid;

    private BigDecimal processinstid;

    private BigDecimal empid;

    private Date startdate;

    private String userid;

    private String reason;

    private String isjoinfund;
    
    private String currentnode;//当前节点
    
    private String  flowtype;//意见类型
    
    public String getFlowtype() {

		return flowtype;
	}
    
    public void setFlowtype(String flowtype) {

		this.flowtype = flowtype;
	}
    
    public String getCurrentnode() {

		return currentnode;
	}
    
    public void setCurrentnode(String currentnode) {

		this.currentnode = currentnode;
	}

    
    
    public BigDecimal getRegularizedno() {
	
		return regularizedno;
	}

	public void setRegularizedno(BigDecimal regularizedno) {
	
		this.regularizedno = regularizedno;
	}

	public BigDecimal getApplycode() {
	
		return applycode;
	}

	public void setApplycode(BigDecimal applycode) {
	
		this.applycode = applycode;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getBoarddate() {
        return boarddate;
    }

    public void setBoarddate(Date boarddate) {
        this.boarddate = boarddate;
    }

    public Date getExacrossdate() {
        return exacrossdate;
    }

    public void setExacrossdate(Date exacrossdate) {
        this.exacrossdate = exacrossdate;
    }

    public String getIsnewpx() {
        return isnewpx;
    }

    public void setIsnewpx(String isnewpx) {
        this.isnewpx = isnewpx;
    }

    public String getIspro() {
        return ispro;
    }

    public void setIspro(String ispro) {
        this.ispro = ispro;
    }

    public String getAbandinfo() {
        return abandinfo;
    }

    public void setAbandinfo(String abandinfo) {
        this.abandinfo = abandinfo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFamilynm() {
        return familynm;
    }

    public void setFamilynm(String familynm) {
        this.familynm = familynm;
    }

    public BigDecimal getAge() {
        return age;
    }

    public void setAge(BigDecimal age) {
        this.age = age;
    }

    public String getRelations() {
        return relations;
    }

    public void setRelations(String relations) {
        this.relations = relations;
    }

    public String getFamilyphone() {
        return familyphone;
    }

    public void setFamilyphone(String familyphone) {
        this.familyphone = familyphone;
    }

    public String getFamilyaddr() {
        return familyaddr;
    }

    public void setFamilyaddr(String familyaddr) {
        this.familyaddr = familyaddr;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname;
    }

    public String getOinfo() {
        return oinfo;
    }

    public void setOinfo(String oinfo) {
        this.oinfo = oinfo;
    }

    public String getOaccount() {
        return oaccount;
    }

    public void setOaccount(String oaccount) {
        this.oaccount = oaccount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getGwflag() {
        return gwflag;
    }

    public void setGwflag(String gwflag) {
        this.gwflag = gwflag;
    }

    public BigDecimal getCulture() {
        return culture;
    }

    public void setCulture(BigDecimal culture) {
        this.culture = culture;
    }

    public BigDecimal getTyping() {
        return typing;
    }

    public void setTyping(BigDecimal typing) {
        this.typing = typing;
    }

    public BigDecimal getExpertise() {
        return expertise;
    }

    public void setExpertise(BigDecimal expertise) {
        this.expertise = expertise;
    }

    public BigDecimal getCknowledge() {
        return cknowledge;
    }

    public void setCknowledge(BigDecimal cknowledge) {
        this.cknowledge = cknowledge;
    }

    public BigDecimal getDriversinfo() {
        return driversinfo;
    }

    public void setDriversinfo(BigDecimal driversinfo) {
        this.driversinfo = driversinfo;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCollevaluation() {
        return collevaluation;
    }

    public void setCollevaluation(String collevaluation) {
        this.collevaluation = collevaluation;
    }

    public String getLeadevaluation() {
        return leadevaluation;
    }

    public void setLeadevaluation(String leadevaluation) {
        this.leadevaluation = leadevaluation;
    }

    public String getFileid() {
        return fileid;
    }

    public void setFileid(String fileid) {
        this.fileid = fileid;
    }

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

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getIsjoinfund() {
        return isjoinfund;
    }

    public void setIsjoinfund(String isjoinfund) {
        this.isjoinfund = isjoinfund;
    }
}