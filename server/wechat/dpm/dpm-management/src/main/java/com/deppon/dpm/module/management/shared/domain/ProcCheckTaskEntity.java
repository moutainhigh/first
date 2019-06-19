package com.deppon.dpm.module.management.shared.domain;

import java.util.Date;

import com.deppon.foss.framework.entity.BaseEntity;

/**   
* @Description: 验收任务推送表
* @author 268087 张广波
* @date 2015-8-12 上午9:54:06 
* @version V1.0 
*/
public class ProcCheckTaskEntity  extends BaseEntity{
	/** 
	* @Fields id 主键ID
	*/ 
	private int taskId;
	/** 
	* @Fields deptCode 项目编码
	*/ 
	private String deptCode;
	/** 
	* @Fields deptName 营业部名称
	*/ 
	private String deptName;
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	/** 
	* @Fields providerName 供应商
	*/ 
	private String providerName;
	/** 
	* @Fields branchIsCheck 店面是否需要验收
	*/ 
	private int branchIsCheck;
	/** 
	* @Fields isCurrentCheck 当前是否在验收
	*/
	private int isCurrentCheck;
	/** 
	* @Fields checkCurrentEmpNo 当前验收工号
	*/ 
	private String checkCurrentEmpNo;
	/** 
	* @Fields updateDate 更新时间
	*/ 
	private Date updateDate;
	/** 
	* @Fields checkEmpNo 验收人工号
	*/ 
	private String checkEmpNo;
	/** 
	* @Fields checkEmpName 验收人名称
	*/ 
	private String checkEmpName;
	/** 
	* @Fields remark 备注
	*/ 
	private String remark;
	/** 
	* @Description: 获取验收任务主键
	* @author 268087 张广波
	* @date 2015-11-16 下午2:20:44 
	*  @return 
	*/
	public int getTaskId() {
		return taskId;
	}
	/** 
	* @Description: 设置验收任务主键
	* @author 268087 张广波
	* @date 2015-11-16 下午2:20:59 
	*  @param taskId 
	*/
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	/** 
	* @Description: 获取部门编码
	* @author 268087 张广波
	* @date 2015-11-16 下午2:21:02 
	*  @return 
	*/
	public String getDeptCode() {
		return deptCode;
	}
	/** 
	* @Description: 设置部门编码
	* @author 268087 张广波
	* @date 2015-11-16 下午2:21:04 
	*  @param deptCode 
	*/
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	/** 
	* @Description: 获取供应商
	* @author 268087 张广波
	* @date 2015-11-16 下午2:21:06 
	*  @return 
	*/
	public String getProviderName() {
		return providerName;
	}
	/** 
	* @Description: 设置供应商
	* @author 268087 张广波
	* @date 2015-11-16 下午2:21:08 
	*  @param providerName 
	*/
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	/** 
	* @Description: 获取店面是否验收状态值
	* @author 268087 张广波
	* @date 2015-11-16 下午2:21:11 
	*  @return 
	*/
	public int getBranchIsCheck() {
		return branchIsCheck;
	}
	/** 
	* @Description: 设置店面是否验收状态值
	* @author 268087 张广波
	* @date 2015-11-16 下午2:21:13 
	*  @param branchIsCheck 
	*/
	public void setBranchIsCheck(int branchIsCheck) {
		this.branchIsCheck = branchIsCheck;
	}
	/** 
	* @Description: 获取当前是否检查状态值
	* @author 268087 张广波
	* @date 2015-11-16 下午2:21:15 
	*  @return 
	*/
	public int getIsCurrentCheck() {
		return isCurrentCheck;
	}
	/** 
	* @Description: 设置当前是否检查状态值
	* @author 268087 张广波
	* @date 2015-11-16 下午2:21:17 
	*  @param isCurrentCheck 
	*/
	public void setIsCurrentCheck(int isCurrentCheck) {
		this.isCurrentCheck = isCurrentCheck;
	}
	/** 
	* @Description: 获取当前验收员工号
	* @author 268087 张广波
	* @date 2015-11-16 下午2:21:19 
	*  @return 
	*/
	public String getCheckCurrentEmpNo() {
		return checkCurrentEmpNo;
	}
	/** 
	* @Description: 设置当前验收员工号
	* @author 268087 张广波
	* @date 2015-11-16 下午2:21:21 
	*  @param checkCurrentEmpNo 
	*/
	public void setCheckCurrentEmpNo(String checkCurrentEmpNo) {
		this.checkCurrentEmpNo = checkCurrentEmpNo;
	}
	/** 
	* @Description: 获取更新时间
	* @author 268087 张广波
	* @date 2015-11-16 下午2:21:23 
	*  @return 
	*/
	public Date getUpdateDate() {
		return updateDate;
	}
	/** 
	* @Description: 设置更新时间
	* @author 268087 张广波
	* @date 2015-11-16 下午2:21:25 
	*  @param updateDate 
	*/
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	/** 
	* @Description: 获取验收人工号
	* @author 268087 张广波
	* @date 2015-11-16 下午2:21:27 
	*  @return 
	*/
	public String getCheckEmpNo() {
		return checkEmpNo;
	}
	/** 
	* @Description: 设置验收人工号
	* @author 268087 张广波
	* @date 2015-11-16 下午2:21:29 
	*  @param checkEmpNo 
	*/
	public void setCheckEmpNo(String checkEmpNo) {
		this.checkEmpNo = checkEmpNo;
	}
	/** 
	* @Description: 获取验收人姓名
	* @author 268087 张广波
	* @date 2015-11-16 下午2:21:31 
	*  @return 
	*/
	public String getCheckEmpName() {
		return checkEmpName;
	}
	/** 
	* @Description: 设置验收人姓名
	* @author 268087 张广波
	* @date 2015-11-16 下午2:21:33 
	*  @param checkEmpName 
	*/
	public void setCheckEmpName(String checkEmpName) {
		this.checkEmpName = checkEmpName;
	}
	/** 
	* @Description: 获取备注
	* @author 268087 张广波
	* @date 2015-11-16 下午2:21:35 
	*  @return 
	*/
	public String getRemark() {
		return remark;
	}
	/** 
	* @Description: 设置备注
	* @author 268087 张广波
	* @date 2015-11-16 下午2:21:44 
	*  @param remark 
	*/
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
