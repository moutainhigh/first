package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
import java.util.Date;
/**
 * 参与者信息
 * @author 293888 zyf
 *
 */
public class ServeParticipantsInfoEntity implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	private int id;
	
	/**
	 * 发布信息表主键
	 */
	private int origId;
	
	/**
	 * 参与者工号
	 */
	private String partNO;
	
	/**
	 * 参与者姓名
	 */
	private String partName;
	
	/**
	 * 参与者手机号
	 */
	private String partTel;
	
	/**
	 * 留言
	 */
	private String remark;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 更新时间
	 */
	private Date updateTime;
	
	/**
	 * 更新人工号
	 */
	private String updateNO;
	
	/**
	 * 状态
	 */
	private int partState;
	
	/**
	 * 消息提醒标志（0表示未提醒，1表示提醒）
	 */
	private int msgRemind;
	/**
	 * id
	 * @return
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	/**
	 * 外键
	 * @return
	 */
	public int getOrigId() {
		return origId;
	}

	public void setOrigId(int origId) {
		this.origId = origId;
	}

	/**
	 * 工号
	 * @return
	 */
	public String getPartNO() {
		return partNO;
	}

	public void setPartNO(String partNO) {
		this.partNO = partNO;
	}
	/**
	 * 姓名
	 * @return
	 */
	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}
	/**
	 * 电话
	 * @return
	 */
	public String getPartTel() {
		return partTel;
	}

	public void setPartTel(String partTel) {
		this.partTel = partTel;
	}
	/**
	 * 留言
	 * @return
	 */
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 创建时间
	 * @return
	 */
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 修改时间
	 * @return
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 修改工号
	 * @return
	 */
	public String getUpdateNO() {
		return updateNO;
	}

	public void setUpdateNO(String updateNO) {
		this.updateNO = updateNO;
	}
	/**
	 * 状态
	 * @return
	 */
	public int getPartState() {
		return partState;
	}

	public void setPartState(int partState) {
		this.partState = partState;
	}

	/**
	 * 消息提醒标志（0表示未提醒，1表示提醒）
	 * @return
	 */
	public int getMsgRemind() {
		return msgRemind;
	}

	public void setMsgRemind(int msgRemind) {
		this.msgRemind = msgRemind;
	}
	
	
}
