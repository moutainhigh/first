package com.deppon.wfs.workflow.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 成立接货开单查询组申请实体bean
 * @author caibingbing
 * @Date 2013-10-15 14:28:14
 */
 
public class FoundQueryTeamBean implements Serializable {
	
	/** 
	* The Constant serialVersionUID. 
	*/
	private static final long serialVersionUID = 1L;
	
	/** 
	* 业务编号，主键 
	*/
	private String busino;
	/** 
	* 工作流序号 
	*/
	private Long processinstid;
	/** 
	* 申请人 
	*/
	private String applyPersonName;
	/** 
	* 申请人工号 
	*/
	private String applyPersonId;
	/** 
	* 当地选拔组 
	*/
	private String localPersonnel;
	/** 
	* 对应运作是否发线 
	*/
	private String isSendLine;
	/** 
	* 连续半个月日均集中开单票数 
	*/
	private String billingNum;
	/** 
	* 参与集中接货部门数  
	*/
	private String deptNum;
	/** 
	* 申请事由 
	*/
	private String reason;
	/** 
	* 是否有效 
	*/
	private String isseffective;
	/** 
	* 起草时间 
	*/
	private Date draftDate;
	/** 
	* 创建时间 
	*/
	private Date createTime;
	/** 
	* 修改时间 
	*/
	private Date modifyTime;
	/**
	 * 负责集中接货的车队是否为经营管辖车队
	 */
	private String isOperateCar;
	/**
	 * 集中接货车辆累计装载率
	 */
	private String cubedOut;
	/**
	 * 累计单票接货里程
	 */
	private String mileAge;
	/**
	 * 平均每天开单数
	 */
	private String billnumAvg;
	/**
	 * 无参构造器
	 */
	public FoundQueryTeamBean(){
		
	}
	/**
	 * 负责集中接货的车队是否为经营管辖车队
	 */
	public String getIsOperateCar() {
		return isOperateCar;
	}
	/**
	 * 负责集中接货的车队是否为经营管辖车队
	 */
	public void setIsOperateCar(String isOperateCar) {
		this.isOperateCar = isOperateCar;
	}
	/**
	 * 集中接货车辆累计装载率
	 */
	public String getCubedOut() {
		return cubedOut;
	}
	/**
	 * 集中接货车辆累计装载率
	 */
	public void setCubedOut(String cubedOut) {
		this.cubedOut = cubedOut;
	}
	/**
	 * 累计单票接货里程
	 */
	public String getMileAge() {
		return mileAge;
	}
	/**
	 * 累计单票接货里程
	 */
	public void setMileAge(String mileAge) {
		this.mileAge = mileAge;
	}
	/**
	 * 平均每天开单数
	 */
	public String getBillnumAvg() {
		return billnumAvg;
	}
	/**
	 * 平均每天开单数
	 */
	public void setBillnumAvg(String billnumAvg) {
		this.billnumAvg = billnumAvg;
	}

	/**
	* 鑾峰彇 业务编号，主键.
	*
	* @return 业务编号，主键.
	*/
	public String getBusino() {
		return busino;
	}

	/**
	* 璁剧疆 业务编号，主键.
	*
	* @param 业务编号，主键.
	*/
	public void setBusino(String busino) {
		this.busino = busino;
	}
	/**
	* 鑾峰彇 工作流序号.
	*
	* @return 工作流序号.
	*/
	public Long getProcessinstid() {
		return processinstid;
	}

	/**
	* 璁剧疆 工作流序号.
	*
	* @param 工作流序号.
	*/
	public void setProcessinstid(Long processinstid) {
		this.processinstid = processinstid;
	}
	/**
	* 鑾峰彇 申请人.
	*
	* @return 申请人.
	*/
	public String getApplyPersonName() {
		return applyPersonName;
	}

	/**
	* 璁剧疆 申请人.
	*
	* @param 申请人.
	*/
	public void setApplyPersonName(String applyPersonName) {
		this.applyPersonName = applyPersonName;
	}
	/**
	* 鑾峰彇 申请人工号.
	*
	* @return 申请人工号.
	*/
	public String getApplyPersonId() {
		return applyPersonId;
	}

	/**
	* 璁剧疆 申请人工号.
	*
	* @param 申请人工号.
	*/
	public void setApplyPersonId(String applyPersonId) {
		this.applyPersonId = applyPersonId;
	}
	/**
	* 鑾峰彇 当地选拔组.
	*
	* @return 当地选拔组.
	*/
	public String getLocalPersonnel() {
		return localPersonnel;
	}

	/**
	* 璁剧疆 当地选拔组.
	*
	* @param 当地选拔组.
	*/
	public void setLocalPersonnel(String localPersonnel) {
		this.localPersonnel = localPersonnel;
	}
	/**
	* 鑾峰彇 对应运作是否发线.
	*
	* @return 对应运作是否发线.
	*/
	public String getIsSendLine() {
		return isSendLine;
	}

	/**
	* 璁剧疆 对应运作是否发线.
	*
	* @param 对应运作是否发线.
	*/
	public void setIsSendLine(String isSendLine) {
		this.isSendLine = isSendLine;
	}
	/**
	* 鑾峰彇 连续半个月日均集中开单票数.
	*
	* @return 连续半个月日均集中开单票数.
	*/
	public String getBillingNum() {
		return billingNum;
	}

	/**
	* 璁剧疆 连续半个月日均集中开单票数.
	*
	* @param 连续半个月日均集中开单票数.
	*/
	public void setBillingNum(String billingNum) {
		this.billingNum = billingNum;
	}
	/**
	* 鑾峰彇 参与集中接货部门数 .
	*
	* @return 参与集中接货部门数 .
	*/
	public String getDeptNum() {
		return deptNum;
	}

	/**
	* 璁剧疆 参与集中接货部门数 .
	*
	* @param 参与集中接货部门数 .
	*/
	public void setDeptNum(String deptNum) {
		this.deptNum = deptNum;
	}
	/**
	* 鑾峰彇 申请事由.
	*
	* @return 申请事由.
	*/
	public String getReason() {
		return reason;
	}

	/**
	* 璁剧疆 申请事由.
	*
	* @param 申请事由.
	*/
	public void setReason(String reason) {
		this.reason = reason;
	}
	/**
	* 鑾峰彇 是否有效.
	*
	* @return 是否有效.
	*/
	public String getIsseffective() {
		return isseffective;
	}

	/**
	* 璁剧疆 是否有效.
	*
	* @param 是否有效.
	*/
	public void setIsseffective(String isseffective) {
		this.isseffective = isseffective;
	}
	/**
	* 鑾峰彇 起草时间.
	*
	* @return 起草时间.
	*/
	public Date getDraftDate() {
		return draftDate;
	}

	/**
	* 璁剧疆 起草时间.
	*
	* @param 起草时间.
	*/
	public void setDraftDate(Date draftDate) {
		this.draftDate = draftDate;
	}
	/**
	* 鑾峰彇 创建时间.
	*
	* @return 创建时间.
	*/
	public Date getCreateTime() {
		return createTime;
	}

	/**
	* 璁剧疆 创建时间.
	*
	* @param 创建时间.
	*/
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	* 鑾峰彇 修改时间.
	*
	* @return 修改时间.
	*/
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	* 璁剧疆 修改时间.
	*
	* @param 修改时间.
	*/
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

}
