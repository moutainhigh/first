package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;

/**
 * 
 * @author 王亚男
 *
 */
public class StandardTableEntity implements Serializable {

	/**
	 * 构造函数
	 */
	public StandardTableEntity(){}
	/**
	 * 序列
	 */
	private static final long serialVersionUID = -4196101346278153143L;
	
	/**
	 * 主键
	 */
	private String id;
	/**
	 * code
	 */
	private String navCode;
	/**
	 * 名字
	 */
	private String navName;
	/**
	 * code
	 */
	private String origItemCode;
	/**
	 * origItem名字
	 */
	private String origItemName;
	/**
	 * standard名字
	 */
	private String standardName;
	/**
	 * 标示
	 */
	private String isKeyPro;
	/**
	 * score
	 */
	private int score;
	/**
	 * 检测方法标示
	 */
	private String checkMethod;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 同步数据标志位, 0-插入,1-修改,2-删除,
	 */
	private String status;//同步数据标志位, 0-插入,1-修改,2-删除,
	
	
	/**
	 *  主键
	 * @return
	 */
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * code
	 * @return
	 */
	public String getNavCode() {
		return navCode;
	}
	public void setNavCode(String navCode) {
		this.navCode = navCode;
	}
	/**
	 * 名字
	 * @return
	 */
	public String getNavName() {
		return navName;
	}
	public void setNavName(String navName) {
		this.navName = navName;
	}
	/**
	 * OrigItemCode
	 * @return
	 */
	public String getOrigItemCode() {
		return origItemCode;
	}
	public void setOrigItemCode(String origItemCode) {
		this.origItemCode = origItemCode;
	}
	/**
	 * OrigItem名字
	 * @return
	 */
	public String getOrigItemName() {
		return origItemName;
	}
	public void setOrigItemName(String origItemName) {
		this.origItemName = origItemName;
	}
	/**
	 * Standard名字
	 * @return
	 */
	public String getStandardName() {
		return standardName;
	}
	public void setStandardName(String standardName) {
		this.standardName = standardName;
	}
	/**
	 * 标示
	 * @return
	 */
	public String getIsKeyPro() {
		return isKeyPro;
	}
	public void setIsKeyPro(String isKeyPro) {
		if("是".equals(isKeyPro)){
			this.isKeyPro="Y";
		}else{
			this.isKeyPro = "N";
		}
	}
	/**
	 * score
	 * @return
	 */
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	/**
	 * 检车方法
	 * @return
	 */
	public String getCheckMethod() {
		return checkMethod;
	}
	public void setCheckMethod(String checkMethod) {
		this.checkMethod = checkMethod;
	}
	/**
	 * 备注
	 * @return
	 */
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 状态
	 * @return
	 */
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
