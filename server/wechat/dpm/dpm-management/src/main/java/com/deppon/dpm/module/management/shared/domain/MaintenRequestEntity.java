package com.deppon.dpm.module.management.shared.domain;


import java.math.BigDecimal;
import java.util.Date;

import com.deppon.foss.framework.entity.BaseEntity;
/**
 * 
 *  维修申请单表头实体
 *  
 * @author wangmingzhao
 * @date 2013-8-28 下午3:39:42
 * @since
 * @version
 */
public class MaintenRequestEntity extends BaseEntity {
    
	private static final long serialVersionUID = 9159471728282925566L;

	
    //创建人
    private FUser creator;
    private String creatorId;
    //创建时间
    private Date  createTime;
    //最后修改人
    private FUser lastUpdateUser;
    private String lastUpdateUserId;

    //最后修改时间
    private Date lastUpdateTime;

    //管理单元ID
    private String controlUnitId;

    //单据编码
    private String fnumber;

    //审核时间
    private Date bizDate;

    //经手人
    private FUser handler;

    //参考信息
    private String description;

    //是否曾经生效
    private Long fhaseffected;

    //审核人
    private FUser auditor;
    private String auditorId;

    //原始单据ID
    private String sourceBillId;

    //来源功能
    private String sourceFunction;

    //是否生产凭证
    private Long fivouchered;

    //申请部门  行政组织单元
    private AdminOrgUnit applyDepart;
    private String applyDepartId;

    //申请时间
    private Date applyTime;

    //工程项目基础信息
    private BaseProjectInfo proNumber;
    private String proNumberId;
    
    //项目名称
    private String proName;

    //维修项目所在地
    private String repproLocation;

    //项目竣工时间
    private Date endTime;

    //处理方式
    private String approach;

    //申请事由
    private String applyReason;

    //单据状态
    private String billState;

    //所属大区
    private AdminOrgUnit belongsArea;
    private String belongsAreaId;
   //期望维修时间
    private Date cfexpRepairTime;
    //所属工程部
    private AdminOrgUnit belongProDept;
    private String belongProDeptId;

    //预计维修金额
    private BigDecimal estimatedAmount;
    
    //项目维修分类
    private String cfmaintenType;
    
    //维修性质
    private String cfrepairNature;
    //维修类别
    private String frepairSort;
    
  
    
    
	public String getFrepairSort() {
		return frepairSort;
	}
	public void setFrepairSort(String frepairSort) {
		this.frepairSort = frepairSort;
	}
	public String getCfrepairNature() {
		return cfrepairNature;
	}
	public void setCfrepairNature(String cfrepairNature) {
		this.cfrepairNature = cfrepairNature;
	}
	/**
	 * 返回维修性质
	 * @return
	 */
	public String getCfmaintenType() {
		return cfmaintenType;
	}
	public void setCfmaintenType(String cfmaintenType) {
		this.cfmaintenType = cfmaintenType;
	}
	/**
     *  @return 创建人
    */
	public FUser getCreator() {
		return creator;
	}
	/**
     * @param 创建人
    */
	public void setCreator(FUser creator) {
		this.creator = creator;
	}
	
	/**
     * @return 创建时间
    */
	public Date getCreateTime() {
		return createTime;
	}
	/**
     * @param 创建时间
    */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
     * @return 最后修改人
    */
	public FUser getLastUpdateUser() {
		return lastUpdateUser;
	}
	/**
     * @param 最后修改人
    */
	public void setLastUpdateUser(FUser lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}
	

	/**
     * @return 最后修改时间
    */
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	/**
     * @param 最后修改时间
    */
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	/**
     * @return 所属子公司ID
    */
	public String getControlUnitId() {
		return controlUnitId;
	}
	/**
     * @param 所属子公司ID
    */
	public void setControlUnitId(String controlUnitId) {
		this.controlUnitId = controlUnitId==null?null:controlUnitId.trim();
	}

	/**
     * @return 单据编码
    */
	public String getFnumber() {
		return fnumber;
	}
	/**
     * @param 单据编码
    */
	public void setFnumber(String fnumber) {
		this.fnumber = fnumber==null?null:fnumber.trim();
	}

	/**
     * @return 审核日期
    */
	public Date getBizDate() {
		return bizDate;
	}
	/**
     * @param 审核日期
    */
	public void setBizDate(Date bizDate) {
		this.bizDate = bizDate;
	}

	/**
     * @return 经手人
    */
	public FUser getHandler() {
		return handler;
	}
	/**
     * @param 经手人
    */
	public void setHandler(FUser handler) {
		this.handler = handler;
	}

	/**
     * @return 参考信息
    */
	public String getDescription() {
		return description;
	}
	/**
     * @param 参考信息
    */
	public void setDescription(String description) {
		this.description = description==null?null:description.trim();
	}

	/**
     * @return 是否曾经生效
    */
	public Long getFhaseffected() {
		return fhaseffected;
	}
	/**
     * @param 是否曾经生效
    */
	public void setFhaseffected(Long fhaseffected) {
		this.fhaseffected = fhaseffected;
	}
	/**
     * @return 审核人
    */
	public FUser getAuditor() {
		return auditor;
	}
	/**
     * @param 审核人
    */
	public void setAuditor(FUser auditor) {
		this.auditor = auditor;
	}
	/**
     * @return 原单据ID
    */
	public String getSourceBillId() {
		return sourceBillId;
	}
	/**
     * @param 原单据ID
    */
	public void setSourceBillId(String sourceBillId) {
		this.sourceBillId = sourceBillId==null?null:sourceBillId.trim();
	}
	/**
     * @return 原单据功能
    */
	public String getSourceFunction() {
		return sourceFunction;
	}
	/**
     * @param 原单据功能
    */
	public void setSourceFunction(String sourceFunction) {
		this.sourceFunction = sourceFunction==null?null:sourceFunction.trim();
	}
	/**
     * @return 是否生产凭证
    */
	public Long getFivouchered() {
		return fivouchered;
	}
	/**
     * @param 是否生产凭证
    */
	public void setFivouchered(Long fivouchered) {
		this.fivouchered = fivouchered;
	}
	
	/**
     * @return 申请部门
    */
	public AdminOrgUnit getApplyDepart() {
		return applyDepart;
	}
	/**
     * @param 申请部门
    */
	public void setApplyDepart(AdminOrgUnit applyDepart) {
		this.applyDepart = applyDepart;
	}
	/**
     * @return 申请时间
    */
	public Date getApplyTime() {
		return applyTime;
	}
	/**
     * @param 申请时间
    */
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	/**
     * @return 项目编号
    */
	public BaseProjectInfo getProNumber() {
		return proNumber;
	}
	/**
     * @param 项目编号
    */
	public void setProNumber(BaseProjectInfo proNumber) {
		this.proNumber = proNumber;
	}
	/**
     * @return 项目名称
    */
	public String getProName() {
		return proName;
	}
	/**
     * @param 项目名称
    */
	public void setProName(String proName) {
		this.proName = proName==null?null:proName.trim();
	}
	/**
     * @return 项目所在地
    */
	public String getRepproLocation() {
		return repproLocation;
	}
	/**
     * @param 项目所在地
    */
	public void setRepproLocation(String repproLocation) {
		this.repproLocation = repproLocation==null?null:repproLocation.trim();
	}
	/**
     * @return 项目竣工时间
    */
	public Date getEndTime() {
		return endTime;
	}
	/**
     * @param 项目竣工时间
    */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	/**
     * @return 处理方式
    */
	public String getApproach() {
		return approach;
	}
	/**
     * @param 处理方式
    */
	public void setApproach(String approach) {
		this.approach = approach==null?null:approach.trim();
	}
	/**
     * @return 申请事由
    */
	public String getApplyReason() {
		return applyReason;
	}
	/**
     * @param 申请事由
    */
	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason==null?null:applyReason.trim();
	}
	/**
     * @return 单据状态
    */
	public String getBillState() {
		return billState;
	}
	/**
     * @param 单据状态
    */
	public void setBillState(String billState) {
		this.billState = billState==null?null:billState.trim();
	}
	/**
     * @return 所属大区
    */
	public AdminOrgUnit getBelongsArea() {
		return belongsArea;
	}
	/**
     * @param 所属大区
    */
	public void setBelongsArea(AdminOrgUnit belongsArea) {
		this.belongsArea = belongsArea;
	}
	/**
     * @return 所属工程部
    */
	public AdminOrgUnit getBelongProDept() {
		return belongProDept;
	}
	/**
     * @param 所属工程部
    */
	public void setBelongProDept(AdminOrgUnit belongProDept) {
		this.belongProDept = belongProDept;
	}
	/**
     * @return 预计维修金额
    */
	public BigDecimal getEstimatedAmount() {
		return estimatedAmount;
	}
	/**
     * @param 预计维修金额
    */
	public void setEstimatedAmount(BigDecimal estimatedAmount) {
		this.estimatedAmount = estimatedAmount;
	}

	/**
     * @return 创建人ID
    */
	public String getCreatorId() {
		return creatorId;
	}
	/**
     * @param 创建人ID
    */
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}
	/**
     * @return 最后修改人ID
    */
	public String getLastUpdateUserId() {
		return lastUpdateUserId;
	}
	/**
     * @param 最后修改人ID
    */
	public void setLastUpdateUserId(String lastUpdateUserId) {
		this.lastUpdateUserId = lastUpdateUserId;
	}
	/**
     * @return 审批人ID
    */
	public String getAuditorId() {
		return auditorId;
	}
	/**
     * @param 审批人ID
    */
	public void setAuditorId(String auditorId) {
		this.auditorId = auditorId;
	}
	/**
     * @return 申请部门ID
    */
	public String getApplyDepartId() {
		return applyDepartId;
	}
	/**
     * @param 申请部门ID
    */
	public void setApplyDepartId(String applyDepartId) {
		this.applyDepartId = applyDepartId;
	}
	/**
     * @return 项目编号ID
    */
	public String getProNumberId() {
		return proNumberId;
	}
	/**
     * @param 项目编号ID
    */
	public void setProNumberId(String proNumberId) {
		this.proNumberId = proNumberId;
	}
	/**
     * @return 所属大区ID
    */
	public String getBelongsAreaId() {
		return belongsAreaId;
	}
	/**
     * @param 所属大区ID
    */
	public void setBelongsAreaId(String belongsAreaId) {
		this.belongsAreaId = belongsAreaId;
	}
	/**
     * @return 所属工程部ID
    */
	public String getBelongProDeptId() {
		return belongProDeptId;
	}
	/**
     * @param 所属工程部ID
    */
	public void setBelongProDeptId(String belongProDeptId) {
		this.belongProDeptId = belongProDeptId;
	}
	public Date getCfexpRepairTime() {
		return cfexpRepairTime;
	}
	public void setCfexpRepairTime(Date cfexpRepairTime) {
		this.cfexpRepairTime = cfexpRepairTime;
	}
	@Override
	public String toString() {
		return "MaintenRequestEntity [creator=" + creator + ", creatorId="
				+ creatorId + ", createTime=" + createTime
				+ ", lastUpdateUser=" + lastUpdateUser + ", lastUpdateUserId="
				+ lastUpdateUserId + ", lastUpdateTime=" + lastUpdateTime
				+ ", controlUnitId=" + controlUnitId + ", fnumber=" + fnumber
				+ ", bizDate=" + bizDate + ", handler=" + handler
				+ ", description=" + description + ", fhaseffected="
				+ fhaseffected + ", auditor=" + auditor + ", auditorId="
				+ auditorId + ", sourceBillId=" + sourceBillId
				+ ", sourceFunction=" + sourceFunction + ", fivouchered="
				+ fivouchered + ", applyDepart=" + applyDepart
				+ ", applyDepartId=" + applyDepartId + ", applyTime="
				+ applyTime + ", proNumber=" + proNumber + ", proNumberId="
				+ proNumberId + ", proName=" + proName + ", repproLocation="
				+ repproLocation + ", endTime=" + endTime + ", approach="
				+ approach + ", applyReason=" + applyReason + ", billState="
				+ billState + ", belongsArea=" + belongsArea
				+ ", belongsAreaId=" + belongsAreaId + ", cfexpRepairTime="
				+ cfexpRepairTime + ", belongProDept=" + belongProDept
				+ ", belongProDeptId=" + belongProDeptId + ", estimatedAmount="
				+ estimatedAmount + ", cfmaintenType=" + cfmaintenType
				+ ", cfrepairNature=" + cfrepairNature + ", frepairSort="
				+ frepairSort + "]";
	}
	
   
}