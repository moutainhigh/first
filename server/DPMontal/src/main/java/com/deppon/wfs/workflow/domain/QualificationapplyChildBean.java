package com.deppon.wfs.workflow.domain;

import java.math.BigDecimal;
import java.util.Date;

public class QualificationapplyChildBean extends Entity{
    /**
	* 
	*/
	private static final long serialVersionUID = 1L;

	/**
     * 主键
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    private String tableid;

    /**
     * 流程序号
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    private String busino;

    /**
     * 通用能力
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    private String  generalAbility;
    /**
     * 通用能力对应业务字典编码
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    private String  generalAbilityCode;

    /**
     * 能力项目
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    private String abilityItem;

    /**
     * 能力描述
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    private String abilityDescription;

    /**
     * 举证名称
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    private String burdenName;

    /**
     * 发生时间	
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    private String happenTime;

    /**
     * 发生地点
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    private String happenPlace;

    /**
     * 扮演角色
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    private String playRole;

    /**
     * 行为频率
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    private String frequencyBehavior;

    /**
     * 相关人员
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    private String relatedPersonnel;

    /**
     *事件过程描述
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    private String eventsDescription;

    /**
     *事件结果
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    private String eventsResult;

    /**
     * 启示和感受
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    private String enlightenmentExperience;
    /**
     * 能力对应分数
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    private String score;

    /**
     * 创建时间
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    private Date createTime;

    /**
     * 修改时间
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    private Date modifyTime;

    /**
     * 业务状态
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    private String isseffective;

    /**
     * 备用字段1
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    private String spareField1;

    /**
     *备用字段2
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    private String spareField2;

    /**
     * 数字字段（扩展）
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    private BigDecimal subnumber;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY_CHILD.TABLEID
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY_CHILD.TABLEID
     *
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    public String getTableid() {
        return tableid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY_CHILD.TABLEID
     *
     * @param tableid the value for T_WFS_QUALIFICATIONAPPLY_CHILD.TABLEID
     *
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    public void setTableid(String tableid) {
        this.tableid = tableid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY_CHILD.BUSINO
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY_CHILD.BUSINO
     *
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    public String getBusino() {
        return busino;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY_CHILD.BUSINO
     *
     * @param busino the value for T_WFS_QUALIFICATIONAPPLY_CHILD.BUSINO
     *
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    public void setBusino(String busino) {
        this.busino = busino;
    }


    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY_CHILD.ABILITY_ITEM
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY_CHILD.ABILITY_ITEM
     *
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    public String getAbilityItem() {
        return abilityItem;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY_CHILD.ABILITY_ITEM
     *
     * @param abilityItem the value for T_WFS_QUALIFICATIONAPPLY_CHILD.ABILITY_ITEM
     *
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    public void setAbilityItem(String abilityItem) {
        this.abilityItem = abilityItem;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY_CHILD.ABILITY_DESCRIPTION
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY_CHILD.ABILITY_DESCRIPTION
     *
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    public String getAbilityDescription() {
        return abilityDescription;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY_CHILD.ABILITY_DESCRIPTION
     *
     * @param abilityDescription the value for T_WFS_QUALIFICATIONAPPLY_CHILD.ABILITY_DESCRIPTION
     *
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    public void setAbilityDescription(String abilityDescription) {
        this.abilityDescription = abilityDescription;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY_CHILD.BURDEN_NAME
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY_CHILD.BURDEN_NAME
     *
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    public String getBurdenName() {
        return burdenName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY_CHILD.BURDEN_NAME
     *
     * @param burdenName the value for T_WFS_QUALIFICATIONAPPLY_CHILD.BURDEN_NAME
     *
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    public void setBurdenName(String burdenName) {
        this.burdenName = burdenName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY_CHILD.HAPPEN_TIME
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY_CHILD.HAPPEN_TIME
     *
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    public String getHappenTime() {
        return happenTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY_CHILD.HAPPEN_TIME
     *
     * @param happenTime the value for T_WFS_QUALIFICATIONAPPLY_CHILD.HAPPEN_TIME
     *
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    public void setHappenTime(String happenTime) {
        this.happenTime = happenTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY_CHILD.HAPPEN_PLACE
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY_CHILD.HAPPEN_PLACE
     *
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    public String getHappenPlace() {
        return happenPlace;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY_CHILD.HAPPEN_PLACE
     *
     * @param happenPlace the value for T_WFS_QUALIFICATIONAPPLY_CHILD.HAPPEN_PLACE
     *
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    public void setHappenPlace(String happenPlace) {
        this.happenPlace = happenPlace;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY_CHILD.PLAY_ROLE
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY_CHILD.PLAY_ROLE
     *
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    public String getPlayRole() {
        return playRole;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY_CHILD.PLAY_ROLE
     *
     * @param playRole the value for T_WFS_QUALIFICATIONAPPLY_CHILD.PLAY_ROLE
     *
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    public void setPlayRole(String playRole) {
        this.playRole = playRole;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY_CHILD.FREQUENCY_BEHAVIOR
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY_CHILD.FREQUENCY_BEHAVIOR
     *
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    public String getFrequencyBehavior() {
        return frequencyBehavior;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY_CHILD.FREQUENCY_BEHAVIOR
     *
     * @param frequencyBehavior the value for T_WFS_QUALIFICATIONAPPLY_CHILD.FREQUENCY_BEHAVIOR
     *
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    public void setFrequencyBehavior(String frequencyBehavior) {
        this.frequencyBehavior = frequencyBehavior;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY_CHILD.RELATED_PERSONNEL
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY_CHILD.RELATED_PERSONNEL
     *
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    public String getRelatedPersonnel() {
        return relatedPersonnel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY_CHILD.RELATED_PERSONNEL
     *
     * @param relatedPersonnel the value for T_WFS_QUALIFICATIONAPPLY_CHILD.RELATED_PERSONNEL
     *
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    public void setRelatedPersonnel(String relatedPersonnel) {
        this.relatedPersonnel = relatedPersonnel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY_CHILD.EVENTS_DESCRIPTION
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY_CHILD.EVENTS_DESCRIPTION
     *
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    public String getEventsDescription() {
        return eventsDescription;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY_CHILD.EVENTS_DESCRIPTION
     *
     * @param eventsDescription the value for T_WFS_QUALIFICATIONAPPLY_CHILD.EVENTS_DESCRIPTION
     *
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    public void setEventsDescription(String eventsDescription) {
        this.eventsDescription = eventsDescription;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY_CHILD.EVENTS_RESULT
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY_CHILD.EVENTS_RESULT
     *
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    public String getEventsResult() {
        return eventsResult;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY_CHILD.EVENTS_RESULT
     *
     * @param eventsResult the value for T_WFS_QUALIFICATIONAPPLY_CHILD.EVENTS_RESULT
     *
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    public void setEventsResult(String eventsResult) {
        this.eventsResult = eventsResult;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY_CHILD.ENLIGHTENMENT_EXPERIENCE
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY_CHILD.ENLIGHTENMENT_EXPERIENCE
     *
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    public String getEnlightenmentExperience() {
        return enlightenmentExperience;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY_CHILD.ENLIGHTENMENT_EXPERIENCE
     *
     * @param enlightenmentExperience the value for T_WFS_QUALIFICATIONAPPLY_CHILD.ENLIGHTENMENT_EXPERIENCE
     *
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    public void setEnlightenmentExperience(String enlightenmentExperience) {
        this.enlightenmentExperience = enlightenmentExperience;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY_CHILD.CREATE_TIME
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY_CHILD.CREATE_TIME
     *
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY_CHILD.CREATE_TIME
     *
     * @param createTime the value for T_WFS_QUALIFICATIONAPPLY_CHILD.CREATE_TIME
     *
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY_CHILD.MODIFY_TIME
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY_CHILD.MODIFY_TIME
     *
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY_CHILD.MODIFY_TIME
     *
     * @param modifyTime the value for T_WFS_QUALIFICATIONAPPLY_CHILD.MODIFY_TIME
     *
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY_CHILD.ISSEFFECTIVE
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY_CHILD.ISSEFFECTIVE
     *
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    public String getIsseffective() {
        return isseffective;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY_CHILD.ISSEFFECTIVE
     *
     * @param isseffective the value for T_WFS_QUALIFICATIONAPPLY_CHILD.ISSEFFECTIVE
     *
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    public void setIsseffective(String isseffective) {
        this.isseffective = isseffective;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY_CHILD.SPARE_FIELD1
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY_CHILD.SPARE_FIELD1
     *
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    public String getSpareField1() {
        return spareField1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY_CHILD.SPARE_FIELD1
     *
     * @param spareField1 the value for T_WFS_QUALIFICATIONAPPLY_CHILD.SPARE_FIELD1
     *
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    public void setSpareField1(String spareField1) {
        this.spareField1 = spareField1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY_CHILD.SPARE_FIELD2
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY_CHILD.SPARE_FIELD2
     *
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    public String getSpareField2() {
        return spareField2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY_CHILD.SPARE_FIELD2
     *
     * @param spareField2 the value for T_WFS_QUALIFICATIONAPPLY_CHILD.SPARE_FIELD2
     *
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    public void setSpareField2(String spareField2) {
        this.spareField2 = spareField2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_WFS_QUALIFICATIONAPPLY_CHILD.SUBNUMBER
     *
     * @return the value of T_WFS_QUALIFICATIONAPPLY_CHILD.SUBNUMBER
     *
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    public BigDecimal getSubnumber() {
        return subnumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_WFS_QUALIFICATIONAPPLY_CHILD.SUBNUMBER
     *
     * @param subnumber the value for T_WFS_QUALIFICATIONAPPLY_CHILD.SUBNUMBER
     *
     * @mbggenerated Sat Dec 28 11:45:43 CST 2013
     */
    public void setSubnumber(BigDecimal subnumber) {
        this.subnumber = subnumber;
    }

	/**
	 * @return the score
	 */
	public String getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(String score) {
		this.score = score;
	}

	/**
	 * @return the generalAbility
	 */
	public String getGeneralAbility() {
		return generalAbility;
	}

	/**
	 * @param generalAbility the generalAbility to set
	 */
	public void setGeneralAbility(String generalAbility) {
		this.generalAbility = generalAbility;
	}

	/**
	 * @return the generalAbilityCode
	 */
	public String getGeneralAbilityCode() {
		return generalAbilityCode;
	}

	/**
	 * @param generalAbilityCode the generalAbilityCode to set
	 */
	public void setGeneralAbilityCode(String generalAbilityCode) {
		this.generalAbilityCode = generalAbilityCode;
	}

}