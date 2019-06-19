package com.deppon.dpm.module.wfs.shared.domain.dppm;

import java.util.Date;

/**
 * 
 * 变更记录实体类
 * @author 150970
 * @date 2015年1月5日 下午1:40:15
 * @since
 * @version
 */
public class ChangeLogEntity {
    /**
     * id
     */
    private Integer logId;

    /**
     * 变更id
     */
    private Integer changeId;

    /**
     * 变更字段描述
     */
    private String fieldDesc;

    /**
     * 变更字段
     */
    private String fieldName;

    /**
     * 变更前内容
     */
    private String oldValue;

    /**
     * 变更后内容
     */
    private String newValue;

    /**
     * 变更日期
     */
    private Date createTime;
    /**
     * 操作类型（1，新增 2，修改 3，删除）
     */
    private Integer operType;

    /**
     * 是否有效（0：有效 1：无效）
     */
    private Integer isDelete;

    public Integer getLogId() {
		return logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dotp_change_log.change_id
     *
     * @return the value of dotp_change_log.change_id
     *
     * @mbggenerated Fri Dec 12 17:53:35 CST 2014
     */
    public Integer getChangeId() {
        return changeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dotp_change_log.change_id
     *
     * @param changeId the value for dotp_change_log.change_id
     *
     * @mbggenerated Fri Dec 12 17:53:35 CST 2014
     */
    public void setChangeId(Integer changeId) {
        this.changeId = changeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dotp_change_log.field_desc
     *
     * @return the value of dotp_change_log.field_desc
     *
     * @mbggenerated Fri Dec 12 17:53:35 CST 2014
     */
    public String getFieldDesc() {
        return fieldDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dotp_change_log.field_desc
     *
     * @param fieldDesc the value for dotp_change_log.field_desc
     *
     * @mbggenerated Fri Dec 12 17:53:35 CST 2014
     */
    public void setFieldDesc(String fieldDesc) {
        this.fieldDesc = fieldDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dotp_change_log.field_name
     *
     * @return the value of dotp_change_log.field_name
     *
     * @mbggenerated Fri Dec 12 17:53:35 CST 2014
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dotp_change_log.field_name
     *
     * @param fieldName the value for dotp_change_log.field_name
     *
     * @mbggenerated Fri Dec 12 17:53:35 CST 2014
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dotp_change_log.old_value
     *
     * @return the value of dotp_change_log.old_value
     *
     * @mbggenerated Fri Dec 12 17:53:35 CST 2014
     */
    public String getOldValue() {
        return oldValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dotp_change_log.old_value
     *
     * @param oldValue the value for dotp_change_log.old_value
     *
     * @mbggenerated Fri Dec 12 17:53:35 CST 2014
     */
    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dotp_change_log.new_value
     *
     * @return the value of dotp_change_log.new_value
     *
     * @mbggenerated Fri Dec 12 17:53:35 CST 2014
     */
    public String getNewValue() {
        return newValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dotp_change_log.new_value
     *
     * @param newValue the value for dotp_change_log.new_value
     *
     * @mbggenerated Fri Dec 12 17:53:35 CST 2014
     */
    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dotp_change_log.create_time
     *
     * @return the value of dotp_change_log.create_time
     *
     * @mbggenerated Fri Dec 12 17:53:35 CST 2014
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dotp_change_log.create_time
     *
     * @param createTime the value for dotp_change_log.create_time
     *
     * @mbggenerated Fri Dec 12 17:53:35 CST 2014
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	/**
	 * @return  the operType
	 */
	public Integer getOperType() {
		return operType;
	}

	/**
	 * @param operType the operType to set
	 */
	public void setOperType(Integer operType) {
		this.operType = operType;
	}

	/**
	 * @return  the isDelete
	 */
	public Integer getIsDelete() {
		return isDelete;
	}

	/**
	 * @param isDelete the isDelete to set
	 */
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
}