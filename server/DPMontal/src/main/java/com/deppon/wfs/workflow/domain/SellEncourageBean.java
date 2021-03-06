package com.deppon.wfs.workflow.domain;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 
* @title: SellEncourageBean 
* @description：TODO
* @author： chenmingyan
* @date： 2013-10-24 下午04:07:37
 */

public class SellEncourageBean  extends Entity{
    /**
	* 序列号
	*/
	private static final long serialVersionUID = 1L;

	/**
     * 主键ID
     * @mbggenerated Thu Oct 24 14:18:19 CST 2013
     */
    private String busino;

    /**
     * 流程实例ID
     * @mbggenerated Thu Oct 24 14:18:19 CST 2013
     */
    private Long processinstid;

    /**
     *申请人工号
     * @mbggenerated Thu Oct 24 14:18:19 CST 2013
     */
    private String applyPersonId;

    /**
     *申请人姓名
     * @mbggenerated Thu Oct 24 14:18:19 CST 2013
     */
    private String applyPersonName;

    /**
     *申请人部门NO
     * @mbggenerated Thu Oct 24 14:18:19 CST 2013
     */
    private String applyDeptNo;

    /**
     *申请人部门
     * @mbggenerated Thu Oct 24 14:18:19 CST 2013
     */
    private String applyDeptName;

    /**
     *申请事由
     * @mbggenerated Thu Oct 24 14:18:19 CST 2013
     */
    private String applyReason;

    /**
     *创建时间
     * @mbggenerated Thu Oct 24 14:18:19 CST 2013
     */
    private Date createTime;

    /**
     *修改时间
     * @mbggenerated Thu Oct 24 14:18:19 CST 2013
     */
    private Date modifyTime;

    /**
     *扩展1
     * @mbggenerated Thu Oct 24 14:18:19 CST 2013
     */
    private Object extend1;

    /**
     *扩展2
     * @mbggenerated Thu Oct 24 14:18:19 CST 2013
     */
    private Object extend2;

    /**
     *扩展3
     * @mbggenerated Thu Oct 24 14:18:19 CST 2013
     */
    private Object extend3;

    /**
     *扩展4
     * @mbggenerated Thu Oct 24 14:18:19 CST 2013
     */
    private BigDecimal extend4;

    /**
     *业务状态
     * @mbggenerated Thu Oct 24 14:18:19 CST 2013
     */
    private String isseffective;
    
    /**
     *申请人部门标杆编码
     * @mbggenerated Thu Oct 24 14:18:19 CST 2013
     */
    private String applyFinasyscode;
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_SELLENCOURAGE.BUSINO
     *
     * @return the value of T_WFS_SELLENCOURAGE.BUSINO
     *
     * @mbggenerated Thu Oct 24 14:18:19 CST 2013
     */
    public String getBusino() {
        return busino;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_SELLENCOURAGE.BUSINO
     *
     * @param busino the value for T_WFS_SELLENCOURAGE.BUSINO
     *
     * @mbggenerated Thu Oct 24 14:18:19 CST 2013
     */
    public void setBusino(String busino) {
        this.busino = busino;
    }

   /**
    * 
   * @MethodName: getProcessinstid 
   * @description : TODO
   * @author：chenmingyan 
   * @date： 2013-10-24 下午04:07:13
   * @return Long
    */
    public Long getProcessinstid() {
		return processinstid;
	}
    /**
     * 
    * @MethodName: setProcessinstid 
    * @description : TODO
    * @author：chenmingyan 
    * @date： 2013-10-24 下午04:07:19
    * @param processinstid void
     */
	public void setProcessinstid(Long processinstid) {
		this.processinstid = processinstid;
	}
	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_SELLENCOURAGE.APPLY_PERSON_ID
     *
     * @return the value of T_WFS_SELLENCOURAGE.APPLY_PERSON_ID
     *
     * @mbggenerated Thu Oct 24 14:18:19 CST 2013
     */
    public String getApplyPersonId() {
        return applyPersonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_SELLENCOURAGE.APPLY_PERSON_ID
     *
     * @param applyPersonId the value for T_WFS_SELLENCOURAGE.APPLY_PERSON_ID
     *
     * @mbggenerated Thu Oct 24 14:18:19 CST 2013
     */
    public void setApplyPersonId(String applyPersonId) {
        this.applyPersonId = applyPersonId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_SELLENCOURAGE.APPLY_PERSON_NAME
     *
     * @return the value of T_WFS_SELLENCOURAGE.APPLY_PERSON_NAME
     *
     * @mbggenerated Thu Oct 24 14:18:19 CST 2013
     */
    public String getApplyPersonName() {
        return applyPersonName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_SELLENCOURAGE.APPLY_PERSON_NAME
     *
     * @param applyPersonName the value for T_WFS_SELLENCOURAGE.APPLY_PERSON_NAME
     *
     * @mbggenerated Thu Oct 24 14:18:19 CST 2013
     */
    public void setApplyPersonName(String applyPersonName) {
        this.applyPersonName = applyPersonName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_SELLENCOURAGE.APPLY_DEPT_NO
     *
     * @return the value of T_WFS_SELLENCOURAGE.APPLY_DEPT_NO
     *
     * @mbggenerated Thu Oct 24 14:18:19 CST 2013
     */
    public String getApplyDeptNo() {
        return applyDeptNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_SELLENCOURAGE.APPLY_DEPT_NO
     *
     * @param applyDeptNo the value for T_WFS_SELLENCOURAGE.APPLY_DEPT_NO
     *
     * @mbggenerated Thu Oct 24 14:18:19 CST 2013
     */
    public void setApplyDeptNo(String applyDeptNo) {
        this.applyDeptNo = applyDeptNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_SELLENCOURAGE.APPLY_DEPT_NAME
     *
     * @return the value of T_WFS_SELLENCOURAGE.APPLY_DEPT_NAME
     *
     * @mbggenerated Thu Oct 24 14:18:19 CST 2013
     */
    public String getApplyDeptName() {
        return applyDeptName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_SELLENCOURAGE.APPLY_DEPT_NAME
     *
     * @param applyDeptName the value for T_WFS_SELLENCOURAGE.APPLY_DEPT_NAME
     *
     * @mbggenerated Thu Oct 24 14:18:19 CST 2013
     */
    public void setApplyDeptName(String applyDeptName) {
        this.applyDeptName = applyDeptName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_SELLENCOURAGE.APPLY_REASON
     *
     * @return the value of T_WFS_SELLENCOURAGE.APPLY_REASON
     *
     * @mbggenerated Thu Oct 24 14:18:19 CST 2013
     */
    public String getApplyReason() {
        return applyReason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_SELLENCOURAGE.APPLY_REASON
     *
     * @param applyReason the value for T_WFS_SELLENCOURAGE.APPLY_REASON
     *
     * @mbggenerated Thu Oct 24 14:18:19 CST 2013
     */
    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_SELLENCOURAGE.CREATE_TIME
     *
     * @return the value of T_WFS_SELLENCOURAGE.CREATE_TIME
     *
     * @mbggenerated Thu Oct 24 14:18:19 CST 2013
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_SELLENCOURAGE.CREATE_TIME
     *
     * @param createTime the value for T_WFS_SELLENCOURAGE.CREATE_TIME
     *
     * @mbggenerated Thu Oct 24 14:18:19 CST 2013
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_SELLENCOURAGE.MODIFY_TIME
     *
     * @return the value of T_WFS_SELLENCOURAGE.MODIFY_TIME
     *
     * @mbggenerated Thu Oct 24 14:18:19 CST 2013
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_SELLENCOURAGE.MODIFY_TIME
     *
     * @param modifyTime the value for T_WFS_SELLENCOURAGE.MODIFY_TIME
     *
     * @mbggenerated Thu Oct 24 14:18:19 CST 2013
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_SELLENCOURAGE.EXTEND1
     *
     * @return the value of T_WFS_SELLENCOURAGE.EXTEND1
     *
     * @mbggenerated Thu Oct 24 14:18:19 CST 2013
     */
    public Object getExtend1() {
        return extend1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_SELLENCOURAGE.EXTEND1
     *
     * @param extend1 the value for T_WFS_SELLENCOURAGE.EXTEND1
     *
     * @mbggenerated Thu Oct 24 14:18:19 CST 2013
     */
    public void setExtend1(Object extend1) {
        this.extend1 = extend1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_SELLENCOURAGE.EXTEND2
     *
     * @return the value of T_WFS_SELLENCOURAGE.EXTEND2
     *
     * @mbggenerated Thu Oct 24 14:18:19 CST 2013
     */
    public Object getExtend2() {
        return extend2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_SELLENCOURAGE.EXTEND2
     *
     * @param extend2 the value for T_WFS_SELLENCOURAGE.EXTEND2
     *
     * @mbggenerated Thu Oct 24 14:18:19 CST 2013
     */
    public void setExtend2(Object extend2) {
        this.extend2 = extend2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_SELLENCOURAGE.EXTEND3
     *
     * @return the value of T_WFS_SELLENCOURAGE.EXTEND3
     *
     * @mbggenerated Thu Oct 24 14:18:19 CST 2013
     */
    public Object getExtend3() {
        return extend3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_SELLENCOURAGE.EXTEND3
     *
     * @param extend3 the value for T_WFS_SELLENCOURAGE.EXTEND3
     *
     * @mbggenerated Thu Oct 24 14:18:19 CST 2013
     */
    public void setExtend3(Object extend3) {
        this.extend3 = extend3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_SELLENCOURAGE.EXTEND4
     *
     * @return the value of T_WFS_SELLENCOURAGE.EXTEND4
     *
     * @mbggenerated Thu Oct 24 14:18:19 CST 2013
     */
    public BigDecimal getExtend4() {
        return extend4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_SELLENCOURAGE.EXTEND4
     *
     * @param extend4 the value for T_WFS_SELLENCOURAGE.EXTEND4
     *
     * @mbggenerated Thu Oct 24 14:18:19 CST 2013
     */
    public void setExtend4(BigDecimal extend4) {
        this.extend4 = extend4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_SELLENCOURAGE.ISSEFFECTIVE
     *
     * @return the value of T_WFS_SELLENCOURAGE.ISSEFFECTIVE
     *
     * @mbggenerated Thu Oct 24 14:18:19 CST 2013
     */
    public String getIsseffective() {
        return isseffective;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_SELLENCOURAGE.ISSEFFECTIVE
     *
     * @param isseffective the value for T_WFS_SELLENCOURAGE.ISSEFFECTIVE
     *
     * @mbggenerated Thu Oct 24 14:18:19 CST 2013
     */
    public void setIsseffective(String isseffective) {
        this.isseffective = isseffective;
    }
    /**
     * 
    * @MethodName: getApplyFinasyscode 
    * @description : TODO
    * @author：chenmingyan
    * @date： 2013-10-26 下午2:37:54
    * @return String
     */
	public String getApplyFinasyscode() {
		return applyFinasyscode;
	}
	/**
	 * 
	* @MethodName: setApplyFinasyscode 
	* @description : TODO
	* @author：chenmingyan
	* @date： 2013-10-26 下午2:38:00
	* @param applyFinasyscode void
	 */
	public void setApplyFinasyscode(String applyFinasyscode) {
		this.applyFinasyscode = applyFinasyscode;
	}
}