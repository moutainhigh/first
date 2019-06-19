package com.deppon.wfs.workflow.domain;

import java.math.BigDecimal;
import java.util.Date;

public class SystempowerapplyChildBean extends Entity{
    /**
	* 
	*/
	private static final long serialVersionUID = 1L;

	/**
     * 主键
     * @mbggenerated Mon Jan 13 22:45:14 CST 2014
     */
    private String tableid;

    /**
     * 流程序号
     * @mbggenerated Mon Jan 13 22:45:14 CST 2014
     */
    private String busino;

    /**
     *  所属系统
     * @mbggenerated Mon Jan 13 22:45:14 CST 2014
     */
    private String belongSystem;
    /**
     *  所属系统业务字典编码
     * @mbggenerated Mon Jan 13 22:45:14 CST 2014
     */
    private String belongSystemCode;
    /**
     * 所属模块
     * @mbggenerated Mon Jan 13 22:45:14 CST 2014
     */
    private String belongModular;
    /**
     * 所属模块业务字典编码
     * @mbggenerated Mon Jan 13 22:45:14 CST 2014
     */
    private String belongModularCode;

    /**
     * 权限描述
     * @mbggenerated Mon Jan 13 22:45:14 CST 2014
     */
    private String authorityDescription;

    /**
     * 创建时间
     * @mbggenerated Mon Jan 13 22:45:14 CST 2014
     */
    private Date createTime;

    /**
     * 修改时间
     * @mbggenerated Mon Jan 13 22:45:14 CST 2014
     */
    private Date modifyTime;

    /**
     *业务状态
     * @mbggenerated Mon Jan 13 22:45:14 CST 2014
     */
    private String isseffective;

    /**
     * 备用字段1
     * @mbggenerated Mon Jan 13 22:45:14 CST 2014
     */
    private String spareField1;

    /**
     *备用字段2
     * @mbggenerated Mon Jan 13 22:45:14 CST 2014
     */
    private String spareField2;

    /**
     * 数字字段（扩展）
     * @mbggenerated Mon Jan 13 22:45:14 CST 2014
     */
    private BigDecimal subnumber;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_SYSTEMPOWERAPPLY_CHILD.TABLEID
     *
     * @return the value of T_WFS_SYSTEMPOWERAPPLY_CHILD.TABLEID
     *
     * @mbggenerated Mon Jan 13 22:45:14 CST 2014
     */
    public String getTableid() {
        return tableid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_SYSTEMPOWERAPPLY_CHILD.TABLEID
     *
     * @param tableid the value for T_WFS_SYSTEMPOWERAPPLY_CHILD.TABLEID
     *
     * @mbggenerated Mon Jan 13 22:45:14 CST 2014
     */
    public void setTableid(String tableid) {
        this.tableid = tableid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_SYSTEMPOWERAPPLY_CHILD.BUSINO
     *
     * @return the value of T_WFS_SYSTEMPOWERAPPLY_CHILD.BUSINO
     *
     * @mbggenerated Mon Jan 13 22:45:14 CST 2014
     */
    public String getBusino() {
        return busino;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_SYSTEMPOWERAPPLY_CHILD.BUSINO
     *
     * @param busino the value for T_WFS_SYSTEMPOWERAPPLY_CHILD.BUSINO
     *
     * @mbggenerated Mon Jan 13 22:45:14 CST 2014
     */
    public void setBusino(String busino) {
        this.busino = busino;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_SYSTEMPOWERAPPLY_CHILD.BELONG_SYSTEM
     *
     * @return the value of T_WFS_SYSTEMPOWERAPPLY_CHILD.BELONG_SYSTEM
     *
     * @mbggenerated Mon Jan 13 22:45:14 CST 2014
     */
    public String getBelongSystem() {
        return belongSystem;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_SYSTEMPOWERAPPLY_CHILD.BELONG_SYSTEM
     *
     * @param belongSystem the value for T_WFS_SYSTEMPOWERAPPLY_CHILD.BELONG_SYSTEM
     *
     * @mbggenerated Mon Jan 13 22:45:14 CST 2014
     */
    public void setBelongSystem(String belongSystem) {
        this.belongSystem = belongSystem;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_SYSTEMPOWERAPPLY_CHILD.BELONG_MODULAR
     *
     * @return the value of T_WFS_SYSTEMPOWERAPPLY_CHILD.BELONG_MODULAR
     *
     * @mbggenerated Mon Jan 13 22:45:14 CST 2014
     */
    public String getBelongModular() {
        return belongModular;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_SYSTEMPOWERAPPLY_CHILD.BELONG_MODULAR
     *
     * @param belongModular the value for T_WFS_SYSTEMPOWERAPPLY_CHILD.BELONG_MODULAR
     *
     * @mbggenerated Mon Jan 13 22:45:14 CST 2014
     */
    public void setBelongModular(String belongModular) {
        this.belongModular = belongModular;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_SYSTEMPOWERAPPLY_CHILD.AUTHORITY_DESCRIPTION
     *
     * @return the value of T_WFS_SYSTEMPOWERAPPLY_CHILD.AUTHORITY_DESCRIPTION
     *
     * @mbggenerated Mon Jan 13 22:45:14 CST 2014
     */
    public String getAuthorityDescription() {
        return authorityDescription;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_SYSTEMPOWERAPPLY_CHILD.AUTHORITY_DESCRIPTION
     *
     * @param authorityDescription the value for T_WFS_SYSTEMPOWERAPPLY_CHILD.AUTHORITY_DESCRIPTION
     *
     * @mbggenerated Mon Jan 13 22:45:14 CST 2014
     */
    public void setAuthorityDescription(String authorityDescription) {
        this.authorityDescription = authorityDescription;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_SYSTEMPOWERAPPLY_CHILD.CREATE_TIME
     *
     * @return the value of T_WFS_SYSTEMPOWERAPPLY_CHILD.CREATE_TIME
     *
     * @mbggenerated Mon Jan 13 22:45:14 CST 2014
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_SYSTEMPOWERAPPLY_CHILD.CREATE_TIME
     *
     * @param createTime the value for T_WFS_SYSTEMPOWERAPPLY_CHILD.CREATE_TIME
     *
     * @mbggenerated Mon Jan 13 22:45:14 CST 2014
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_SYSTEMPOWERAPPLY_CHILD.MODIFY_TIME
     *
     * @return the value of T_WFS_SYSTEMPOWERAPPLY_CHILD.MODIFY_TIME
     *
     * @mbggenerated Mon Jan 13 22:45:14 CST 2014
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_SYSTEMPOWERAPPLY_CHILD.MODIFY_TIME
     *
     * @param modifyTime the value for T_WFS_SYSTEMPOWERAPPLY_CHILD.MODIFY_TIME
     *
     * @mbggenerated Mon Jan 13 22:45:14 CST 2014
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_SYSTEMPOWERAPPLY_CHILD.ISSEFFECTIVE
     *
     * @return the value of T_WFS_SYSTEMPOWERAPPLY_CHILD.ISSEFFECTIVE
     *
     * @mbggenerated Mon Jan 13 22:45:14 CST 2014
     */
    public String getIsseffective() {
        return isseffective;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_SYSTEMPOWERAPPLY_CHILD.ISSEFFECTIVE
     *
     * @param isseffective the value for T_WFS_SYSTEMPOWERAPPLY_CHILD.ISSEFFECTIVE
     *
     * @mbggenerated Mon Jan 13 22:45:14 CST 2014
     */
    public void setIsseffective(String isseffective) {
        this.isseffective = isseffective;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_SYSTEMPOWERAPPLY_CHILD.SPARE_FIELD1
     *
     * @return the value of T_WFS_SYSTEMPOWERAPPLY_CHILD.SPARE_FIELD1
     *
     * @mbggenerated Mon Jan 13 22:45:14 CST 2014
     */
    public String getSpareField1() {
        return spareField1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_SYSTEMPOWERAPPLY_CHILD.SPARE_FIELD1
     *
     * @param spareField1 the value for T_WFS_SYSTEMPOWERAPPLY_CHILD.SPARE_FIELD1
     *
     * @mbggenerated Mon Jan 13 22:45:14 CST 2014
     */
    public void setSpareField1(String spareField1) {
        this.spareField1 = spareField1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_SYSTEMPOWERAPPLY_CHILD.SPARE_FIELD2
     *
     * @return the value of T_WFS_SYSTEMPOWERAPPLY_CHILD.SPARE_FIELD2
     *
     * @mbggenerated Mon Jan 13 22:45:14 CST 2014
     */
    public String getSpareField2() {
        return spareField2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_SYSTEMPOWERAPPLY_CHILD.SPARE_FIELD2
     *
     * @param spareField2 the value for T_WFS_SYSTEMPOWERAPPLY_CHILD.SPARE_FIELD2
     *
     * @mbggenerated Mon Jan 13 22:45:14 CST 2014
     */
    public void setSpareField2(String spareField2) {
        this.spareField2 = spareField2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_SYSTEMPOWERAPPLY_CHILD.SUBNUMBER
     *
     * @return the value of T_WFS_SYSTEMPOWERAPPLY_CHILD.SUBNUMBER
     *
     * @mbggenerated Mon Jan 13 22:45:14 CST 2014
     */
    public BigDecimal getSubnumber() {
        return subnumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_SYSTEMPOWERAPPLY_CHILD.SUBNUMBER
     *
     * @param subnumber the value for T_WFS_SYSTEMPOWERAPPLY_CHILD.SUBNUMBER
     *
     * @mbggenerated Mon Jan 13 22:45:14 CST 2014
     */
    public void setSubnumber(BigDecimal subnumber) {
        this.subnumber = subnumber;
    }
    public SystempowerapplyChildBean(){}

	/**
	 * @return the belongSystemCode
	 */
	public String getBelongSystemCode() {
		return belongSystemCode;
	}

	/**
	 * @param belongSystemCode the belongSystemCode to set
	 */
	public void setBelongSystemCode(String belongSystemCode) {
		this.belongSystemCode = belongSystemCode;
	}

	/**
	 * @return the belongModularCode
	 */
	public String getBelongModularCode() {
		return belongModularCode;
	}

	/**
	 * @param belongModularCode the belongModularCode to set
	 */
	public void setBelongModularCode(String belongModularCode) {
		this.belongModularCode = belongModularCode;
	}
}