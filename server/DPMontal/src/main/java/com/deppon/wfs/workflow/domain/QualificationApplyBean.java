package com.deppon.wfs.workflow.domain;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
* @title: QualificationApplyBean 
* @description：TODO
* @author： 高雅哲
* @date： 2013-10-12 下午3:38:01
*/
public class QualificationApplyBean extends Entity{
    /**
	* 
	*/
	private static final long serialVersionUID = 1L;
	/**
	 * 能力模型材料举证信息(通用能力)
	 */
	private List<QualificationapplyChildBean> qualificationapplyList;
	/**
	 * 能力模型材料举证信息(业务技能)
	 */
	private List<QualificationapplySkillBean> qualificationapplySkillList;
	/** 
	 * 能力模型材料举证表信息(通用能力)的json字符串
	 */
	private String qualificationapplyChild;	/** 
	 * 能力模型材料举证表信息(业务技能)的json字符串
	 */
	private String qualificationapplySkill;
	/**
     *流程序号,主键,含有字母
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    private String busino;

    /**
     * 流程实例ID，相当于工作流号
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    private Long processinstid;

    /**
     * 申请人姓名
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    private String applyPersonName;

    /**
     * 申请人员工ID
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    private String applyPersonId;

    /**
     *  申请人员工MEPID
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    private String empid;

    /**
     * 部门名称
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    private String department;

    /**
     * 申请职位
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    private String applyPost;

    /**
     * 申请人性别
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    private String empsex;

    /**
     * 申请类别
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    private String apptype;

    /**
     * 身份证号（接口）
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    private String idCard;

    /**
     * 入职时间（接口）
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    private Date enrollmentDate;
    /**
     * 入职时间进行转换
     */
    private String enrollmentDateStr;
    
    /**
     * 学历（接口）
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    private String empDegree;

    /**
     * 入申报岗位时间（接口）
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    private Date inapplyDate;
    /**
     * 入申报岗位时间（接口）(不允许被修改，只允许插入，目的与前面的时间做对比，判断字段是否变色)
     */
    private String inapplyDateImpl;
    /**
     * 入申报岗位时间（接口）(不允许被修改，只允许插入，目的与前面的时间做对比，判断字段是否变色),转换成date
     */
    private Date inapplyDateImplDate;
    /**
     * 入申报岗位时长
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    private String inapplyDuration;

    /**
     * 员工绩效考核（接口）
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    private String empPerformance;

    /**
     * 管理级别
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    private String managementLevel;

    /**
     * 管理岗位绩效（接口）
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    private String managerPerformance;

    /**
     * 申请通道
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    private String applyChannel;
    /**
     * 中级申请时:申请通道
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    private String applyMiddleChannel;
    

    /**
     *申请通道岗位
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    private String applyProfessionalPost;

    /**
     *当前等级
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    private String nowLevel;

    /**
     * 申请等级
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    private String applyLevel;
    /**
     * 中级申请时:申请等级
     * @mbggenerated Fri Act 11 19:48:39 CST 2013
     */
    private String applyMiddleLevel;
    /**
     * 当前绩效等级
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    private String nowPerformanceLevel;

    /**
     * 申请绩效等级
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    private String applyPerformanceLevel;

    /**
     * 目前薪资
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    private BigDecimal nowSalary;

    /**
     * 申请薪资
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    private BigDecimal applySalary;

    /**
     * 是否总监推荐
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    private String ischiefRecommend;

    /**
     *是否有专业外部经验
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    private String isoutExperience;

    /**
     * 专业外部经验时长
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    private Long outexperienceDuration;

    /**
     * 认证通过时间
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    private Date certificationPassdate;

    /**
     *复审通道工作时间
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    private Date reexaminationDate;

    /**
     * 复审通道现属等级
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    private String reexaminationnowLevel;

    /**
     *复审通道
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    private String reexaminationChannel;

    /**
     * 复审等级
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    private String reexaminationLevel;

    /**
     * 复审岗位
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    private String reexaminationProfesspost;
    /**
     * 保存业务字典编码
     */
    private String applyChannelCode;
    /**
     * 保存业务字典编码
     */
    private String applyProfessionalPostCode;
    /**
     * 保存业务字典编码
     */
    private String reexaminationChannelCode;
    /**
     * 保存业务字典编码
     */
    private String reexaminationProfesspostCode;

    /**
     * 申请事由
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    private String reason;

    /**
     *创建时间
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    private Date createTime;

    /**
     * 修改时间
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    private Date modifyTime;

    /**
     *业务状态
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    private String isseffective;

    /**
     * 备用字段1
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    private Object spareField1;

    /**
     * 备用字段2
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    private Object spareField2;

    /**
     * 数字型备用字段
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    private BigDecimal subnumber;

    /**
     * 直接上级判断是否通过。‘1’：通过；‘0’：不通过
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    private String isPass;
    /**
     * 审批：表现优秀方面
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    private String excellentSide;
    /**
     * 审批：有待提升方面
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    private String enhancedSide;
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY.BUSINO
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY.BUSINO
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public String getBusino() {
        return busino;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY.BUSINO
     *
     * @param busino the value for T_WFS_QUALIFICATIONAPPLY.BUSINO
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public void setBusino(String busino) {
        this.busino = busino;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY.PROCESSINSTID
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY.PROCESSINSTID
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public Long getProcessinstid() {
        return processinstid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY.PROCESSINSTID
     *
     * @param processinstid the value for T_WFS_QUALIFICATIONAPPLY.PROCESSINSTID
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public void setProcessinstid(Long processinstid) {
        this.processinstid = processinstid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY.EMPNAME
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY.EMPNAME
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public String getApplyPersonName() {
        return applyPersonName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY.EMPNAME
     *
     * @param empname the value for T_WFS_QUALIFICATIONAPPLY.EMPNAME
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public void setApplyPersonName(String applyPersonName) {
        this.applyPersonName = applyPersonName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY.applyPersonId
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY.applyPersonId
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public String getApplyPersonId() {
        return applyPersonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY.EMPCODE
     *
     * @param empcode the value for T_WFS_QUALIFICATIONAPPLY.EMPCODE
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public void setApplyPersonId(String applyPersonId) {
        this.applyPersonId = applyPersonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY.EMPID
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY.EMPID
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public String getEmpid() {
        return empid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY.EMPID
     *
     * @param empid the value for T_WFS_QUALIFICATIONAPPLY.EMPID
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public void setEmpid(String empid) {
        this.empid = empid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY.DEPARTMENT
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY.DEPARTMENT
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public String getDepartment() {
        return department;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY.DEPARTMENT
     *
     * @param department the value for T_WFS_QUALIFICATIONAPPLY.DEPARTMENT
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY.APPLY_POST
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY.APPLY_POST
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public String getApplyPost() {
        return applyPost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY.APPLY_POST
     *
     * @param applyPost the value for T_WFS_QUALIFICATIONAPPLY.APPLY_POST
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public void setApplyPost(String applyPost) {
        this.applyPost = applyPost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY.EMPSEX
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY.EMPSEX
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public String getEmpsex() {
        return empsex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY.EMPSEX
     *
     * @param empsex the value for T_WFS_QUALIFICATIONAPPLY.EMPSEX
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public void setEmpsex(String empsex) {
        this.empsex = empsex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY.APPTYPE
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY.APPTYPE
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public String getApptype() {
        return apptype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY.APPTYPE
     *
     * @param apptype the value for T_WFS_QUALIFICATIONAPPLY.APPTYPE
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public void setApptype(String apptype) {
        this.apptype = apptype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY.ID_CARD
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY.ID_CARD
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY.ID_CARD
     *
     * @param idCard the value for T_WFS_QUALIFICATIONAPPLY.ID_CARD
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY.ENROLLMENT_DATE
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY.ENROLLMENT_DATE
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY.ENROLLMENT_DATE
     *
     * @param enrollmentDate the value for T_WFS_QUALIFICATIONAPPLY.ENROLLMENT_DATE
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY.EMP_DEGREE
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY.EMP_DEGREE
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public String getEmpDegree() {
        return empDegree;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY.EMP_DEGREE
     *
     * @param empDegree the value for T_WFS_QUALIFICATIONAPPLY.EMP_DEGREE
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public void setEmpDegree(String empDegree) {
        this.empDegree = empDegree;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY.INAPPLY_DATE
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY.INAPPLY_DATE
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public Date getInapplyDate() {
        return inapplyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY.INAPPLY_DATE
     *
     * @param inapplyDate the value for T_WFS_QUALIFICATIONAPPLY.INAPPLY_DATE
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public void setInapplyDate(Date inapplyDate) {
        this.inapplyDate = inapplyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY.INAPPLY_DURATION
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY.INAPPLY_DURATION
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public String getInapplyDuration() {
        return inapplyDuration;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY.INAPPLY_DURATION
     *
     * @param inapplyDuration the value for T_WFS_QUALIFICATIONAPPLY.INAPPLY_DURATION
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public void setInapplyDuration(String inapplyDuration) {
        this.inapplyDuration = inapplyDuration;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY.EMP_PERFORMANCE
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY.EMP_PERFORMANCE
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public String getEmpPerformance() {
        return empPerformance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY.EMP_PERFORMANCE
     *
     * @param empPerformance the value for T_WFS_QUALIFICATIONAPPLY.EMP_PERFORMANCE
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public void setEmpPerformance(String empPerformance) {
        this.empPerformance = empPerformance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY.MANAGEMENT_LEVEL
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY.MANAGEMENT_LEVEL
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public String getManagementLevel() {
        return managementLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY.MANAGEMENT_LEVEL
     *
     * @param managementLevel the value for T_WFS_QUALIFICATIONAPPLY.MANAGEMENT_LEVEL
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public void setManagementLevel(String managementLevel) {
        this.managementLevel = managementLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY.MANAGER_PERFORMANCE
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY.MANAGER_PERFORMANCE
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public String getManagerPerformance() {
        return managerPerformance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY.MANAGER_PERFORMANCE
     *
     * @param managerPerformance the value for T_WFS_QUALIFICATIONAPPLY.MANAGER_PERFORMANCE
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public void setManagerPerformance(String managerPerformance) {
        this.managerPerformance = managerPerformance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY.APPLY_CHANNEL
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY.APPLY_CHANNEL
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public String getApplyChannel() {
        return applyChannel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY.APPLY_CHANNEL
     *
     * @param applyChannel the value for T_WFS_QUALIFICATIONAPPLY.APPLY_CHANNEL
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public void setApplyChannel(String applyChannel) {
        this.applyChannel = applyChannel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY.APPLY_PROFESSIONAL_POST
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY.APPLY_PROFESSIONAL_POST
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public String getApplyProfessionalPost() {
        return applyProfessionalPost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY.APPLY_PROFESSIONAL_POST
     *
     * @param applyProfessionalPost the value for T_WFS_QUALIFICATIONAPPLY.APPLY_PROFESSIONAL_POST
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public void setApplyProfessionalPost(String applyProfessionalPost) {
        this.applyProfessionalPost = applyProfessionalPost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY.NOW_LEVEL
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY.NOW_LEVEL
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public String getNowLevel() {
        return nowLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY.NOW_LEVEL
     *
     * @param nowLevel the value for T_WFS_QUALIFICATIONAPPLY.NOW_LEVEL
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public void setNowLevel(String nowLevel) {
        this.nowLevel = nowLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY.APPLY_LEVEL
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY.APPLY_LEVEL
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public String getApplyLevel() {
        return applyLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY.APPLY_LEVEL
     *
     * @param applyLevel the value for T_WFS_QUALIFICATIONAPPLY.APPLY_LEVEL
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public void setApplyLevel(String applyLevel) {
        this.applyLevel = applyLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY.NOW_PERFORMANCE_LEVEL
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY.NOW_PERFORMANCE_LEVEL
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public String getNowPerformanceLevel() {
        return nowPerformanceLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY.NOW_PERFORMANCE_LEVEL
     *
     * @param nowPerformanceLevel the value for T_WFS_QUALIFICATIONAPPLY.NOW_PERFORMANCE_LEVEL
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public void setNowPerformanceLevel(String nowPerformanceLevel) {
        this.nowPerformanceLevel = nowPerformanceLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY.APPLY_PERFORMANCE_LEVEL
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY.APPLY_PERFORMANCE_LEVEL
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public String getApplyPerformanceLevel() {
        return applyPerformanceLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY.APPLY_PERFORMANCE_LEVEL
     *
     * @param applyPerformanceLevel the value for T_WFS_QUALIFICATIONAPPLY.APPLY_PERFORMANCE_LEVEL
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public void setApplyPerformanceLevel(String applyPerformanceLevel) {
        this.applyPerformanceLevel = applyPerformanceLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY.NOW_SALARY
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY.NOW_SALARY
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public BigDecimal getNowSalary() {
        return nowSalary;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY.NOW_SALARY
     *
     * @param nowSalary the value for T_WFS_QUALIFICATIONAPPLY.NOW_SALARY
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public void setNowSalary(BigDecimal nowSalary) {
        this.nowSalary = nowSalary;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY.APPLY_SALARY
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY.APPLY_SALARY
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public BigDecimal getApplySalary() {
        return applySalary;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY.APPLY_SALARY
     *
     * @param applySalary the value for T_WFS_QUALIFICATIONAPPLY.APPLY_SALARY
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public void setApplySalary(BigDecimal applySalary) {
        this.applySalary = applySalary;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY.ISCHIEF_RECOMMEND
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY.ISCHIEF_RECOMMEND
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public String getIschiefRecommend() {
        return ischiefRecommend;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY.ISCHIEF_RECOMMEND
     *
     * @param ischiefRecommend the value for T_WFS_QUALIFICATIONAPPLY.ISCHIEF_RECOMMEND
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public void setIschiefRecommend(String ischiefRecommend) {
        this.ischiefRecommend = ischiefRecommend;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY.ISOUT_EXPERIENCE
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY.ISOUT_EXPERIENCE
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public String getIsoutExperience() {
        return isoutExperience;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY.ISOUT_EXPERIENCE
     *
     * @param isoutExperience the value for T_WFS_QUALIFICATIONAPPLY.ISOUT_EXPERIENCE
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public void setIsoutExperience(String isoutExperience) {
        this.isoutExperience = isoutExperience;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY.OUTEXPERIENCE_DURATION
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY.OUTEXPERIENCE_DURATION
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public Long getOutexperienceDuration() {
        return outexperienceDuration;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY.OUTEXPERIENCE_DURATION
     *
     * @param outexperienceDuration the value for T_WFS_QUALIFICATIONAPPLY.OUTEXPERIENCE_DURATION
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public void setOutexperienceDuration(Long outexperienceDuration) {
        this.outexperienceDuration = outexperienceDuration;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY.CERTIFICATION_PASSDATE
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY.CERTIFICATION_PASSDATE
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public Date getCertificationPassdate() {
        return certificationPassdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY.CERTIFICATION_PASSDATE
     *
     * @param certificationPassdate the value for T_WFS_QUALIFICATIONAPPLY.CERTIFICATION_PASSDATE
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public void setCertificationPassdate(Date certificationPassdate) {
        this.certificationPassdate = certificationPassdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY.REEXAMINATION_DATE
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY.REEXAMINATION_DATE
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public Date getReexaminationDate() {
        return reexaminationDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY.REEXAMINATION_DATE
     *
     * @param reexaminationDate the value for T_WFS_QUALIFICATIONAPPLY.REEXAMINATION_DATE
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public void setReexaminationDate(Date reexaminationDate) {
        this.reexaminationDate = reexaminationDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY.REEXAMINATIONNOW_LEVEL
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY.REEXAMINATIONNOW_LEVEL
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public String getReexaminationnowLevel() {
        return reexaminationnowLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY.REEXAMINATIONNOW_LEVEL
     *
     * @param reexaminationnowLevel the value for T_WFS_QUALIFICATIONAPPLY.REEXAMINATIONNOW_LEVEL
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public void setReexaminationnowLevel(String reexaminationnowLevel) {
        this.reexaminationnowLevel = reexaminationnowLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY.REEXAMINATION_CHANNEL
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY.REEXAMINATION_CHANNEL
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public String getReexaminationChannel() {
        return reexaminationChannel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY.REEXAMINATION_CHANNEL
     *
     * @param reexaminationChannel the value for T_WFS_QUALIFICATIONAPPLY.REEXAMINATION_CHANNEL
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public void setReexaminationChannel(String reexaminationChannel) {
        this.reexaminationChannel = reexaminationChannel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY.REEXAMINATION_LEVEL
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY.REEXAMINATION_LEVEL
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public String getReexaminationLevel() {
        return reexaminationLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY.REEXAMINATION_LEVEL
     *
     * @param reexaminationLevel the value for T_WFS_QUALIFICATIONAPPLY.REEXAMINATION_LEVEL
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public void setReexaminationLevel(String reexaminationLevel) {
        this.reexaminationLevel = reexaminationLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY.REEXAMINATION_PROFESSPOST
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY.REEXAMINATION_PROFESSPOST
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public String getReexaminationProfesspost() {
        return reexaminationProfesspost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY.REEXAMINATION_PROFESSPOST
     *
     * @param reexaminationProfesspost the value for T_WFS_QUALIFICATIONAPPLY.REEXAMINATION_PROFESSPOST
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public void setReexaminationProfesspost(String reexaminationProfesspost) {
        this.reexaminationProfesspost = reexaminationProfesspost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY.REASON
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY.REASON
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public String getReason() {
        return reason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY.REASON
     *
     * @param reason the value for T_WFS_QUALIFICATIONAPPLY.REASON
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY.CREATE_TIME
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY.CREATE_TIME
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY.CREATE_TIME
     *
     * @param createTime the value for T_WFS_QUALIFICATIONAPPLY.CREATE_TIME
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY.MODIFY_TIME
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY.MODIFY_TIME
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY.MODIFY_TIME
     *
     * @param modifyTime the value for T_WFS_QUALIFICATIONAPPLY.MODIFY_TIME
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY.ISSEFFECTIVE
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY.ISSEFFECTIVE
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public String getIsseffective() {
        return isseffective;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY.ISSEFFECTIVE
     *
     * @param isseffective the value for T_WFS_QUALIFICATIONAPPLY.ISSEFFECTIVE
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public void setIsseffective(String isseffective) {
        this.isseffective = isseffective;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY.SPARE_FIELD1
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY.SPARE_FIELD1
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public Object getSpareField1() {
        return spareField1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY.SPARE_FIELD1
     *
     * @param spareField1 the value for T_WFS_QUALIFICATIONAPPLY.SPARE_FIELD1
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public void setSpareField1(Object spareField1) {
        this.spareField1 = spareField1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY.SPARE_FIELD2
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY.SPARE_FIELD2
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public Object getSpareField2() {
        return spareField2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY.SPARE_FIELD2
     *
     * @param spareField2 the value for T_WFS_QUALIFICATIONAPPLY.SPARE_FIELD2
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public void setSpareField2(Object spareField2) {
        this.spareField2 = spareField2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY.SUBNUMBER
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY.SUBNUMBER
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public BigDecimal getSubnumber() {
        return subnumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY.SUBNUMBER
     *
     * @param subnumber the value for T_WFS_QUALIFICATIONAPPLY.SUBNUMBER
     *
     * @mbggenerated Fri Oct 11 19:48:39 CST 2013
     */
    public void setSubnumber(BigDecimal subnumber) {
        this.subnumber = subnumber;
    }
    public QualificationApplyBean(){
    	
    }

	/**
	 * 入职时间进行转换
	 */
	public String getEnrollmentDateStr() {
		SimpleDateFormat getStrDate = new SimpleDateFormat("yyyy-MM-dd");
	
		return getStrDate.format(enrollmentDate);
	}

	/**
	 * @return the inapplyDateImpl
	 */
	public String getInapplyDateImpl() {
		return inapplyDateImpl;
	}
	/**
	 * @return the inapplyDateImplDate
	 * @throws ParseException 
	 */
	public Date getInapplyDateImplDate() throws ParseException  {
		SimpleDateFormat getStrDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return getStrDate.parse(inapplyDateImpl);
	}
	/**
	 * @param inapplyDateImpl the inapplyDateImpl to set
	 */
	public void setInapplyDateImpl(String inapplyDateImpl) {
		this.inapplyDateImpl = inapplyDateImpl;
	}

	/**
	 * @return the applyChannelCode
	 */
	public String getApplyChannelCode() {
		return applyChannelCode;
	}

	/**
	 * @param applyChannelCode the applyChannelCode to set
	 */
	public void setApplyChannelCode(String applyChannelCode) {
		this.applyChannelCode = applyChannelCode;
	}

	/**
	 * @return the applyProfessionalPostCode
	 */
	public String getApplyProfessionalPostCode() {
		return applyProfessionalPostCode;
	}

	/**
	 * @param applyProfessionalPostCode the applyProfessionalPostCode to set
	 */
	public void setApplyProfessionalPostCode(String applyProfessionalPostCode) {
		this.applyProfessionalPostCode = applyProfessionalPostCode;
	}

	/**
	 * @return the reexaminationChannelCode
	 */
	public String getReexaminationChannelCode() {
		return reexaminationChannelCode;
	}

	/**
	 * @param reexaminationChannelCode the reexaminationChannelCode to set
	 */
	public void setReexaminationChannelCode(String reexaminationChannelCode) {
		this.reexaminationChannelCode = reexaminationChannelCode;
	}

	/**
	 * @return the reexaminationProfesspostCode
	 */
	public String getReexaminationProfesspostCode() {
		return reexaminationProfesspostCode;
	}

	/**
	 * @param reexaminationProfesspostCode the reexaminationProfesspostCode to set
	 */
	public void setReexaminationProfesspostCode(String reexaminationProfesspostCode) {
		this.reexaminationProfesspostCode = reexaminationProfesspostCode;
	}

	/**
	 * @return the qualificationapplyList
	 */
	public List<QualificationapplyChildBean> getQualificationapplyList() {
		return qualificationapplyList;
	}

	/**
	 * @param qualificationapplyList the qualificationapplyList to set
	 */
	public void setQualificationapplyList(
			List<QualificationapplyChildBean> qualificationapplyList) {
		this.qualificationapplyList = qualificationapplyList;
	}

	/**
	 * @return the qualificationapplyChild
	 */
	public String getQualificationapplyChild() {
		return qualificationapplyChild;
	}

	/**
	 * @param qualificationapplyChild the qualificationapplyChild to set
	 */
	public void setQualificationapplyChild(String qualificationapplyChild) {
		this.qualificationapplyChild = qualificationapplyChild;
	}

	/**
	 * @param enrollmentDateStr the enrollmentDateStr to set
	 */
	public void setEnrollmentDateStr(String enrollmentDateStr) {
		this.enrollmentDateStr = enrollmentDateStr;
	}

	/**
	 * @param inapplyDateImplDate the inapplyDateImplDate to set
	 */
	public void setInapplyDateImplDate(Date inapplyDateImplDate) {
		this.inapplyDateImplDate = inapplyDateImplDate;
	}

	/**
	 * @return the isPass
	 */
	public String getIsPass() {
		return isPass;
	}

	/**
	 * @param isPass the isPass to set
	 */
	public void setIsPass(String isPass) {
		this.isPass = isPass;
	}

	/**
	 * @return the excellentSide
	 */
	public String getExcellentSide() {
		return excellentSide;
	}

	/**
	 * @param excellentSide the excellentSide to set
	 */
	public void setExcellentSide(String excellentSide) {
		this.excellentSide = excellentSide;
	}

	/**
	 * @return the enhancedSide
	 */
	public String getEnhancedSide() {
		return enhancedSide;
	}

	/**
	 * @param enhancedSide the enhancedSide to set
	 */
	public void setEnhancedSide(String enhancedSide) {
		this.enhancedSide = enhancedSide;
	}

	/**
	 * @return the applyMiddleChannel
	 */
	public String getApplyMiddleChannel() {
		return applyMiddleChannel;
	}

	/**
	 * @param applyMiddleChannel the applyMiddleChannel to set
	 */
	public void setApplyMiddleChannel(String applyMiddleChannel) {
		this.applyMiddleChannel = applyMiddleChannel;
	}

	/**
	 * @return the applyMiddleLevel
	 */
	public String getApplyMiddleLevel() {
		return applyMiddleLevel;
	}

	/**
	 * @param applyMiddleLevel the applyMiddleLevel to set
	 */
	public void setApplyMiddleLevel(String applyMiddleLevel) {
		this.applyMiddleLevel = applyMiddleLevel;
	}

	/**
	 * @return the qualificationapplySkillList
	 */
	public List<QualificationapplySkillBean> getQualificationapplySkillList() {
		return qualificationapplySkillList;
	}

	/**
	 * @param qualificationapplySkillList the qualificationapplySkillList to set
	 */
	public void setQualificationapplySkillList(
			List<QualificationapplySkillBean> qualificationapplySkillList) {
		this.qualificationapplySkillList = qualificationapplySkillList;
	}

	/**
	 * @return the qualificationapplySkill
	 */
	public String getQualificationapplySkill() {
		return qualificationapplySkill;
	}

	/**
	 * @param qualificationapplySkill the qualificationapplySkill to set
	 */
	public void setQualificationapplySkill(String qualificationapplySkill) {
		this.qualificationapplySkill = qualificationapplySkill;
	}
}