package com.deppon.dpm.module.projecttools.shared.domain;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 
 * 项目目标实体类
 * @author 150970
 * @date 2014年11月13日 下午4:12:54
 * @since
 * @version
 */
public class ProjectObjectiveEntity extends BaseEntity {
	
	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 自增ID
	 */
    private Integer objId;
    /**
	 * 项目编码
	 */
    private String projectCode;
    /**
	 * 是否短期目标
	 */
    private String shortTerm;
    /**
	 * 目标类型
	 */
    private Integer objType;
    private String objTypeName;
    /**
	 * 数据提供部门
	 */
    private String deptProvider;
    //是否项目组
    private String isProvDept;
    /**
	 * 数据审核部门
	 */
    private String deptAudit;
    //是否项目组
    private String isAuditDept;
    /**
	 * 数据审核阶段
	 */
    private String objState;
    /**
	 * 目标承接部门
	 */
    private String overtaken;
    //是否项目组
    private String isTakenDept;
    /**
	 * 是否涉及战略级指标
	 */
    private Integer strategic;
    private String strategicName;
    /**
	 * 是否为可量化目标
	 */
    private Integer quantitative;
    /**
	 * 目标指标
	 */
    private String objective;
    /**
	 * 指标值
	 */
    private String indicator;
    /**
	 * 量化指标公式
	 */
    private String formula;
    
    
	

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
	 * @return the isProvDept
	 */
	public String getIsProvDept() {
		return isProvDept;
	}

	/**
	 * @param isProvDept
	 */
	public void setIsProvDept(String isProvDept) {
		this.isProvDept = isProvDept;
	}

	/**
	 * @return the isAuditDept
	 */
	public String getIsAuditDept() {
		return isAuditDept;
	}

	/**
	 * @param isAuditDept
	 */
	public void setIsAuditDept(String isAuditDept) {
		this.isAuditDept = isAuditDept;
	}

	/**
	 * @return the isTakenDept
	 */
	public String getIsTakenDept() {
		return isTakenDept;
	}

	/**
	 * @param isTakenDept
	 */
	public void setIsTakenDept(String isTakenDept) {
		this.isTakenDept = isTakenDept;
	}

	/**
	 * @return the objTypeName
	 */
	public String getObjTypeName() {
		return objTypeName;
	}

	/**
	 * @param objTypeName
	 */
	public void setObjTypeName(String objTypeName) {
		this.objTypeName = objTypeName;
	}

	/**
	 * @return  the objId
	 */
	public Integer getObjId() {
		return objId;
	}

	/**
	 * @param objId the objId to set
	 */
	public void setObjId(Integer objId) {
		this.objId = objId;
	}

	/**
	 * @return  the projectCode
	 */
	public String getProjectCode() {
		return projectCode;
	}

	/**
	 * @param projectCode the projectCode to set
	 */
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	

	/**
	 * @return the shortTerm
	 */
	public String getShortTerm() {
		return shortTerm;
	}

	/**
	 * @param shortTerm
	 */
	public void setShortTerm(String shortTerm) {
		this.shortTerm = shortTerm;
	}

	/**
	 * @return  the objType
	 */
	public Integer getObjType() {
		return objType;
	}

	/**
	 * @param objType the objType to set
	 */
	public void setObjType(Integer objType) {
		this.objType = objType;
	}

	/**
	 * @return  the deptProvider
	 */
	public String getDeptProvider() {
		return deptProvider;
	}

	/**
	 * @param deptProvider the deptProvider to set
	 */
	public void setDeptProvider(String deptProvider) {
		this.deptProvider = deptProvider;
	}

	/**
	 * @return  the deptAudit
	 */
	public String getDeptAudit() {
		return deptAudit;
	}

	/**
	 * @param deptAudit the deptAudit to set
	 */
	public void setDeptAudit(String deptAudit) {
		this.deptAudit = deptAudit;
	}

	/**
	 * @return  the objState
	 */
	public String getObjState() {
		return objState;
	}

	/**
	 * @param objState the objState to set
	 */
	public void setObjState(String objState) {
		this.objState = objState;
	}

	/**
	 * @return  the overtaken
	 */
	public String getOvertaken() {
		return overtaken;
	}

	/**
	 * @param overtaken the overtaken to set
	 */
	public void setOvertaken(String overtaken) {
		this.overtaken = overtaken;
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
	 * @return  the quantitative
	 */
	public Integer getQuantitative() {
		return quantitative;
	}

	/**
	 * @param quantitative the quantitative to set
	 */
	public void setQuantitative(Integer quantitative) {
		this.quantitative = quantitative;
	}

	/**
	 * @return  the objective
	 */
	public String getObjective() {
		return objective;
	}

	/**
	 * @param objective the objective to set
	 */
	public void setObjective(String objective) {
		this.objective = objective;
	}

	/**
	 * @return  the indicator
	 */
	public String getIndicator() {
		return indicator;
	}

	/**
	 * @param indicator the indicator to set
	 */
	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}

	/**
	 * @return  the formula
	 */
	public String getFormula() {
		return formula;
	}

	/**
	 * @param formula the formula to set
	 */
	public void setFormula(String formula) {
		this.formula = formula;
	}
}