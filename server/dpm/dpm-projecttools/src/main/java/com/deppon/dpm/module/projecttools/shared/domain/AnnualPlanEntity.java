package com.deppon.dpm.module.projecttools.shared.domain;

import java.util.Date;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 
 * 年度规划项目实体类
 * @author 150970
 * @date 2014年10月23日 下午1:57:18
 * @since
 * @version
 */
public class AnnualPlanEntity extends BaseEntity {

	/**
	* serialVersionUID
	*/
	private static final long serialVersionUID = 1L;
	/**
	 * ID
	 */
	private Integer aiId;
	/**
	 * 项目ID
	 */
	private Integer projectId;
	/**
	 * 项目名称
	 */
	private String ghName;
	/**
	 * 规划年份
	 */
	private Integer ghYear;
	/**
	 * 规划类型
	 */
	private Integer ghType;
	/**
	 * 项目级别
	 */
	private Integer ghLevel;
	/**
	 * 项目状态
	 */
	private Integer ghStatus;
	/**
	 * 创建时间
	 */
	private String createTime;
	/**
	 * 完成时间
	 */
	private String finishTime;
	/**
	 * 上报时间
	 */
	private String commitTime;
	/**
	 * 所属系统
	 */
	private Integer subsys;
	/**
	 * 所属系统名称
	 */
	private String subsysName;
	/**
	 * 版本号
	 */
	private String ghVersion;
	/**
	 * 承接部门
	 */
	private String cjDept;
	/**
	 * 系统分析部门
	 */
	private String xtfxDept;
	//开发部门
	private String kfDept;
	//测试部门
	private String csDept;
	//架构部门
	private String jgDept;
	//运维部门
	private String ywDept;
	
	//基础设施型 部门
	//应用部门
	private String yyDept;
	//数据库部门
	private String sjkDept;
	//基础设施部门
	private String sjssDept;
	//服务部门
	private String fwDept;
	
	private String needMobile;
	private String needUi;
	private String needMobileName;
	private String needUiName;
	/**
	 * 是否需要
	 */
	private Integer needSpread;
	
	private String needSpreadname;
	/**
	 * 是否涉及战略指标
	 */
	private Integer strategic;
	private String strategicName;
	/**
	 * 业务范围
	 */
	private String sphereOfBusiness;
	/**
	 * 系统范围
	 */
	private String sphereOfSys;
	/**
	 * 时间
	 */
	private Date addTime;
	/**
	 * 是否有效
	 */
	private Integer deleted;
	/**
	 * 所属系统描述
	 */
	private String sysLabel;
	/**
	 * 项目类型描述
	 */
	private String ghTypeLabel;
	/**
	 * 项目状态描述
	 */
	private String ghStatusLabel;
	/**
	 * 项目级别描述
	 */
	private String ghLevelLabel;
	/**
	 * 研发型
	 */
	private AnnualPlanExtra1 extra1Entity;
	/**
	 * 管理咨询型
	 */
	private AnnualPlanExtra2 extra2Entity;
	/**
	 * 基础设施型
	 */
	private AnnualPlanExtra3 extra3Entity;

	/**
	 * @return the needMobile
	 */
	public String getNeedMobile() {
		return needMobile;
	}

	/**
	 * @param needMobile
	 */
	public void setNeedMobile(String needMobile) {
		this.needMobile = needMobile;
	}

	/**
	 * @return the needUi
	 */
	public String getNeedUi() {
		return needUi;
	}

	/**
	 * @param needUi
	 */
	public void setNeedUi(String needUi) {
		this.needUi = needUi;
	}

	/**
	 * @return the needMobileName
	 */
	public String getNeedMobileName() {
		return needMobileName;
	}

	/**
	 * @param needMobileName
	 */
	public void setNeedMobileName(String needMobileName) {
		this.needMobileName = needMobileName;
	}

	/**
	 * @return the needUiName
	 */
	public String getNeedUiName() {
		return needUiName;
	}

	/**
	 * @param needUiName
	 */
	public void setNeedUiName(String needUiName) {
		this.needUiName = needUiName;
	}

	/**
	 * @return  the aiId
	 */
	public Integer getAiId() {
		return aiId;
	}

	/**
	 * @return the yyDept
	 */
	public String getYyDept() {
		return yyDept;
	}

	/**
	 * @param yyDept
	 */
	public void setYyDept(String yyDept) {
		this.yyDept = yyDept;
	}

	/**
	 * @return the sjkDept
	 */
	public String getSjkDept() {
		return sjkDept;
	}

	/**
	 * @param sjkDept
	 */
	public void setSjkDept(String sjkDept) {
		this.sjkDept = sjkDept;
	}

	/**
	 * @return the sjssDept
	 */
	public String getSjssDept() {
		return sjssDept;
	}

	/**
	 * @param sjssDept
	 */
	public void setSjssDept(String sjssDept) {
		this.sjssDept = sjssDept;
	}

	/**
	 * @return the fwDept
	 */
	public String getFwDept() {
		return fwDept;
	}

	/**
	 * @param fwDept
	 */
	public void setFwDept(String fwDept) {
		this.fwDept = fwDept;
	}

	/**
	 * @return the extra1Entity
	 */
	public AnnualPlanExtra1 getExtra1Entity() {
		return extra1Entity;
	}

	/**
	 * @param extra1Entity
	 */
	public void setExtra1Entity(AnnualPlanExtra1 extra1Entity) {
		this.extra1Entity = extra1Entity;
	}

	/**
	 * @return the extra2Entity
	 */
	public AnnualPlanExtra2 getExtra2Entity() {
		return extra2Entity;
	}

	/**
	 * @param extra2Entity
	 */
	public void setExtra2Entity(AnnualPlanExtra2 extra2Entity) {
		this.extra2Entity = extra2Entity;
	}

	/**
	 * @return the extra3Entity
	 */
	public AnnualPlanExtra3 getExtra3Entity() {
		return extra3Entity;
	}

	/**
	 * @param extra3Entity
	 */
	public void setExtra3Entity(AnnualPlanExtra3 extra3Entity) {
		this.extra3Entity = extra3Entity;
	}

	/**
	 * @return the needSpreadname
	 */
	public String getNeedSpreadname() {
		return needSpreadname;
	}

	/**
	 * @param needSpreadname
	 */
	public void setNeedSpreadname(String needSpreadname) {
		this.needSpreadname = needSpreadname;
	}

	/**
	 * @return the strategicName
	 */
	public String getStrategicName() {
		return strategicName;
	}

	/**
	 * @param strategicName
	 */
	public void setStrategicName(String strategicName) {
		this.strategicName = strategicName;
	}

	/**
	 * @return the xtfxDept
	 */
	public String getXtfxDept() {
		return xtfxDept;
	}

	/**
	 * @param xtfxDept
	 */
	public void setXtfxDept(String xtfxDept) {
		this.xtfxDept = xtfxDept;
	}

	/**
	 * @return the kfDept
	 */
	public String getKfDept() {
		return kfDept;
	}

	/**
	 * @param kfDept
	 */
	public void setKfDept(String kfDept) {
		this.kfDept = kfDept;
	}

	/**
	 * @return the csDept
	 */
	public String getCsDept() {
		return csDept;
	}

	/**
	 * @param csDept
	 */
	public void setCsDept(String csDept) {
		this.csDept = csDept;
	}

	/**
	 * @return the jgDept
	 */
	public String getJgDept() {
		return jgDept;
	}

	/**
	 * @param jgDept
	 */
	public void setJgDept(String jgDept) {
		this.jgDept = jgDept;
	}

	/**
	 * @return the ywDept
	 */
	public String getYwDept() {
		return ywDept;
	}

	/**
	 * @param ywDept
	 */
	public void setYwDept(String ywDept) {
		this.ywDept = ywDept;
	}

	/**
	 * @return the cjDept
	 */
	public String getCjDept() {
		return cjDept;
	}

	/**
	 * @param cjDept
	 */
	public void setCjDept(String cjDept) {
		this.cjDept = cjDept;
	}

	/**
	 * @return the subsysName
	 */
	public String getSubsysName() {
		return subsysName;
	}

	/**
	 * @param subsysName
	 */
	public void setSubsysName(String subsysName) {
		this.subsysName = subsysName;
	}

	/**
	 * @param aiId the aiId to set
	 */
	public void setAiId(Integer aiId) {
		this.aiId = aiId;
	}

	/**
	 * @return  the projectId
	 */
	public Integer getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	/**
	 * @return  the ghName
	 */
	public String getGhName() {
		return ghName;
	}

	/**
	 * @param ghName the ghName to set
	 */
	public void setGhName(String ghName) {
		this.ghName = ghName;
	}

	/**
	 * @return  the ghYear
	 */
	public Integer getGhYear() {
		return ghYear;
	}

	/**
	 * @param ghYear the ghYear to set
	 */
	public void setGhYear(Integer ghYear) {
		this.ghYear = ghYear;
	}

	/**
	 * @return  the ghType
	 */
	public Integer getGhType() {
		return ghType;
	}

	/**
	 * @param ghType the ghType to set
	 */
	public void setGhType(Integer ghType) {
		this.ghType = ghType;
	}

	/**
	 * @return  the ghLevel
	 */
	public Integer getGhLevel() {
		return ghLevel;
	}

	/**
	 * @param ghLevel the ghLevel to set
	 */
	public void setGhLevel(Integer ghLevel) {
		this.ghLevel = ghLevel;
	}

	/**
	 * @return  the ghStatus
	 */
	public Integer getGhStatus() {
		return ghStatus;
	}

	/**
	 * @param ghStatus the ghStatus to set
	 */
	public void setGhStatus(Integer ghStatus) {
		this.ghStatus = ghStatus;
	}

	/**
	 * @return  the createTime
	 */
	public String getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return  the finishTime
	 */
	public String getFinishTime() {
		return finishTime;
	}

	/**
	 * @param finishTime the finishTime to set
	 */
	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}

	/**
	 * @return  the commitTime
	 */
	public String getCommitTime() {
		return commitTime;
	}

	/**
	 * @param commitTime the commitTime to set
	 */
	public void setCommitTime(String commitTime) {
		this.commitTime = commitTime;
	}

	/**
	 * @return  the subsys
	 */
	public Integer getSubsys() {
		return subsys;
	}

	/**
	 * @param subsys the subsys to set
	 */
	public void setSubsys(Integer subsys) {
		this.subsys = subsys;
	}

	/**
	 * @return  the ghVersion
	 */
	public String getGhVersion() {
		return ghVersion;
	}

	/**
	 * @param ghVersion the ghVersion to set
	 */
	public void setGhVersion(String ghVersion) {
		this.ghVersion = ghVersion;
	}

	/**
	 * @return  the needSpread
	 */
	public Integer getNeedSpread() {
		return needSpread;
	}

	/**
	 * @param needSpread the needSpread to set
	 */
	public void setNeedSpread(Integer needSpread) {
		this.needSpread = needSpread;
	}

	/**
	 * @return  the strategic
	 */
	public Integer getStrategic() {
		return strategic;
	}

	/**
	 * @param strategic the strategic to set
	 */
	public void setStrategic(Integer strategic) {
		this.strategic = strategic;
	}

	/**
	 * @return  the sphereOfBusiness
	 */
	public String getSphereOfBusiness() {
		return sphereOfBusiness;
	}

	/**
	 * @param sphereOfBusiness the sphereOfBusiness to set
	 */
	public void setSphereOfBusiness(String sphereOfBusiness) {
		this.sphereOfBusiness = sphereOfBusiness;
	}

	/**
	 * @return  the sphereOfSys
	 */
	public String getSphereOfSys() {
		return sphereOfSys;
	}

	/**
	 * @param sphereOfSys the sphereOfSys to set
	 */
	public void setSphereOfSys(String sphereOfSys) {
		this.sphereOfSys = sphereOfSys;
	}

	/**
	 * @return  the addTime
	 */
	public Date getAddTime() {
		return addTime;
	}

	/**
	 * @param addTime the addTime to set
	 */
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	/**
	 * @return  the deleted
	 */
	public Integer getDeleted() {
		return deleted;
	}

	/**
	 * @param deleted the deleted to set
	 */
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	/**
	 * @return  the sysLabel
	 */
	public String getSysLabel() {
		return sysLabel;
	}

	/**
	 * @param sysLabel the sysLabel to set
	 */
	public void setSysLabel(String sysLabel) {
		this.sysLabel = sysLabel;
	}

	/**
	 * @return  the ghTypeLabel
	 */
	public String getGhTypeLabel() {
		return ghTypeLabel;
	}

	/**
	 * @param ghTypeLabel the ghTypeLabel to set
	 */
	public void setGhTypeLabel(String ghTypeLabel) {
		this.ghTypeLabel = ghTypeLabel;
	}

	/**
	 * @return  the ghStatusLabel
	 */
	public String getGhStatusLabel() {
		return ghStatusLabel;
	}

	/**
	 * @param ghStatusLabel the ghStatusLabel to set
	 */
	public void setGhStatusLabel(String ghStatusLabel) {
		this.ghStatusLabel = ghStatusLabel;
	}

	/**
	 * @return  the ghLevelLabel
	 */
	public String getGhLevelLabel() {
		return ghLevelLabel;
	}

	/**
	 * @param ghLevelLabel the ghLevelLabel to set
	 */
	public void setGhLevelLabel(String ghLevelLabel) {
		this.ghLevelLabel = ghLevelLabel;
	}
}
