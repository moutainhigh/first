package com.deppon.montal.model;

import java.math.BigDecimal;

import com.deppon.montal.conf.F_Constants;


   /** 
   * @ClassName: OAChangeAndresignApply 
   * @Description:(异动调动申请实体类) 
   * @TableName:OA_CHANGEANDRESIGNAPPLY
   * @author 廖建雄 
   * @date 2013-5-28 上午9:34:33 
   * 
   */
public class OAChangeAndresignApply {
    private BigDecimal processinstid;

    private String name;

    private BigDecimal empid;

    private String applytype;

    private String deptnature;

    private String areapersonneldept;

    private String enterprisepersonneldept;

    private String beforedept;

    private String beforedeptcode;

    private String beforeposition;

    private String afterdept;

    private String afterdeptcode;

    private String afterposition;

    private String reason;

    private String userid;

    private String deploybusinesstype;

    private String deployreason;

    private String deploydate;

    private String deployafterdept;

    private String deployafterpersontype;

    private String deployafterposition;

    private String deployafterpositionlevel;

    private String deployafterpositionid;

    private String deployaftersalarylevel;

    private String deployafterannualization;

    private String deployofficelevel;

    private String deployafterallowance;

    private String addpersonno;

    private String property;

    private String tNativespace;

    private String tNowposduretime;

    private String tWanttoplace;

    private String tLastsixmark;

    private String tLastsixcompetency;

    private String tIsrelegation;

    private String tIspersonorcompany;

    private String attachment;

    private String isusephone;

    private String phonenumber;

    private String billid;

    private String afteruser;

    private String usercode;

    private String money;

    private String istelhand;

    private String ismanagertrain;

    private String isvaraddress;

    private String joblevel;

    private String backoriginno;

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

    public String getApplytype() {
        return applytype;
    }

    public void setApplytype(String applytype) {
        this.applytype = applytype;
    }

    public String getDeptnature() {
        return F_Constants.chageNull(deptnature);
    }

    public void setDeptnature(String deptnature) {
        this.deptnature = deptnature;
    }

    public String getAreapersonneldept() {
        return F_Constants.chageNull(areapersonneldept);
    }

    public void setAreapersonneldept(String areapersonneldept) {
        this.areapersonneldept = areapersonneldept;
    }

    public String getEnterprisepersonneldept() {
        return enterprisepersonneldept;
    }

    public void setEnterprisepersonneldept(String enterprisepersonneldept) {
        this.enterprisepersonneldept = enterprisepersonneldept;
    }

    public String getBeforedept() {
        return F_Constants.chageNull(beforedept);
    }

    public void setBeforedept(String beforedept) {
        this.beforedept = beforedept;
    }

    public String getBeforedeptcode() {
        return F_Constants.chageNull(beforedeptcode);
    }

    public void setBeforedeptcode(String beforedeptcode) {
        this.beforedeptcode = beforedeptcode;
    }

    public String getBeforeposition() {
        return F_Constants.chageNull(beforeposition);
    }

    public void setBeforeposition(String beforeposition) {
        this.beforeposition = beforeposition;
    }

    public String getAfterdept() {
        return F_Constants.chageNull(afterdept);
    }

    public void setAfterdept(String afterdept) {
        this.afterdept = afterdept;
    }

    public String getAfterdeptcode() {
        return F_Constants.chageNull(afterdeptcode);
    }

    public void setAfterdeptcode(String afterdeptcode) {
        this.afterdeptcode = afterdeptcode;
    }

    public String getAfterposition() {
        return F_Constants.chageNull(afterposition);
    }

    public void setAfterposition(String afterposition) {
        this.afterposition = afterposition;
    }

    public String getReason() {
        return F_Constants.chageNull(reason);
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getUserid() {
        return F_Constants.chageNull(userid);
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getDeploybusinesstype() {
        return F_Constants.chageNull(deploybusinesstype);
    }

    public void setDeploybusinesstype(String deploybusinesstype) {
        this.deploybusinesstype = deploybusinesstype;
    }

    public String getDeployreason() {
        return F_Constants.chageNull(deployreason);
    }

    public void setDeployreason(String deployreason) {
        this.deployreason = deployreason;
    }

    public String getDeploydate() {
        return F_Constants.chageNull(deploydate);
    }

    public void setDeploydate(String deploydate) {
        this.deploydate = deploydate;
    }

    public String getDeployafterdept() {
        return F_Constants.chageNull(deployafterdept);
    }

    public void setDeployafterdept(String deployafterdept) {
        this.deployafterdept = deployafterdept;
    }

    public String getDeployafterpersontype() {
        return F_Constants.chageNull(deployafterpersontype);
    }

    public void setDeployafterpersontype(String deployafterpersontype) {
        this.deployafterpersontype = deployafterpersontype;
    }

    public String getDeployafterposition() {
        return F_Constants.chageNull(deployafterposition);
    }

    public void setDeployafterposition(String deployafterposition) {
        this.deployafterposition = deployafterposition;
    }

    public String getDeployafterpositionlevel() {
        return F_Constants.chageNull(deployafterpositionlevel);
    }

    public void setDeployafterpositionlevel(String deployafterpositionlevel) {
        this.deployafterpositionlevel = deployafterpositionlevel;
    }

    public String getDeployafterpositionid() {
        return F_Constants.chageNull(deployafterpositionid);
    }

    public void setDeployafterpositionid(String deployafterpositionid) {
        this.deployafterpositionid = deployafterpositionid;
    }

    public String getDeployaftersalarylevel() {
        return F_Constants.chageNull(deployaftersalarylevel);
    }

    public void setDeployaftersalarylevel(String deployaftersalarylevel) {
        this.deployaftersalarylevel = deployaftersalarylevel;
    }

    public String getDeployafterannualization() {
        return F_Constants.chageNull(deployafterannualization);
    }

    public void setDeployafterannualization(String deployafterannualization) {
        this.deployafterannualization = deployafterannualization;
    }

    public String getDeployofficelevel() {
        return F_Constants.chageNull(deployofficelevel);
    }

    public void setDeployofficelevel(String deployofficelevel) {
        this.deployofficelevel = deployofficelevel;
    }

    public String getDeployafterallowance() {
        return F_Constants.chageNull(deployafterallowance);
    }

    public void setDeployafterallowance(String deployafterallowance) {
        this.deployafterallowance = deployafterallowance;
    }

    public String getAddpersonno() {
        return F_Constants.chageNull(addpersonno);
    }

    public void setAddpersonno(String addpersonno) {
        this.addpersonno = addpersonno;
    }

    public String getProperty() {
        return F_Constants.chageNull(property);
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String gettNativespace() {
        return F_Constants.chageNull(tNativespace);
    }

    public void settNativespace(String tNativespace) {
        this.tNativespace = tNativespace;
    }

    public String gettNowposduretime() {
        return F_Constants.chageNull(tNowposduretime);
    }

    public void settNowposduretime(String tNowposduretime) {
        this.tNowposduretime = tNowposduretime;
    }

    public String gettWanttoplace() {
        return F_Constants.chageNull(tWanttoplace);
    }

    public void settWanttoplace(String tWanttoplace) {
        this.tWanttoplace = tWanttoplace;
    }

    public String gettLastsixmark() {
        return F_Constants.chageNull(tLastsixmark);
    }

    public void settLastsixmark(String tLastsixmark) {
        this.tLastsixmark = tLastsixmark;
    }

    public String gettLastsixcompetency() {
        return F_Constants.chageNull(tLastsixcompetency);
    }

    public void settLastsixcompetency(String tLastsixcompetency) {
        this.tLastsixcompetency = tLastsixcompetency;
    }

    public String gettIsrelegation() {
        return F_Constants.chageNull(tIsrelegation);
    }

    public void settIsrelegation(String tIsrelegation) {
        this.tIsrelegation = tIsrelegation;
    }

    public String gettIspersonorcompany() {
        return F_Constants.chageNull(tIspersonorcompany);
    }

    public void settIspersonorcompany(String tIspersonorcompany) {
        this.tIspersonorcompany = tIspersonorcompany;
    }

    public String getAttachment() {
        return F_Constants.chageNull(attachment);
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getIsusephone() {
        return F_Constants.chageNull(isusephone);
    }

    public void setIsusephone(String isusephone) {
        this.isusephone = isusephone;
    }

    public String getPhonenumber() {
        return F_Constants.chageNull(phonenumber);
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getBillid() {
        return F_Constants.chageNull(billid);
    }

    public void setBillid(String billid) {
        this.billid = billid;
    }

    public String getAfteruser() {
        return F_Constants.chageNull(afteruser);
    }

    public void setAfteruser(String afteruser) {
        this.afteruser = afteruser;
    }

    public String getUsercode() {
        return F_Constants.chageNull(usercode);
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getMoney() {
        return F_Constants.chageNull(money);
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getIstelhand() {
        return F_Constants.chageNull(istelhand);
    }

    public void setIstelhand(String istelhand) {
        this.istelhand = istelhand;
    }

    public String getIsmanagertrain() {
        return F_Constants.chageNull(ismanagertrain);
    }

    public void setIsmanagertrain(String ismanagertrain) {
        this.ismanagertrain = ismanagertrain;
    }

    public String getIsvaraddress() {
        return F_Constants.chageNull(isvaraddress);
    }

    public void setIsvaraddress(String isvaraddress) {
        this.isvaraddress = isvaraddress;
    }

    public String getJoblevel() {
        return F_Constants.chageNull(joblevel);
    }

    public void setJoblevel(String joblevel) {
        this.joblevel = joblevel;
    }

    public String getBackoriginno() {
        return F_Constants.chageNull(backoriginno);
    }

    public void setBackoriginno(String backoriginno) {
        this.backoriginno = backoriginno;
    }
}