/*
 * Copyright by Deppon and the original author or authors.
 * 
 * This document only allow internal use ,Any of your behaviors using the file
 * not internal will pay legal responsibility.
 *
 * You may learn more information about Deppon from
 *
 *      http://www.deppon.com
 *
 */
package com.deppon.dpm.module.wfs.shared.domain.dppm;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 项目结项指标
 * 
 * @author 106140
 * @date 2014-11-3 下午2:48:24
 * @since
 * @version
 */
public class ClosingIndexEntity extends BaseEntity {
	private static final long serialVersionUID = -5917452449523397684L;
	/**
	 * '业务编号',
	 */
	private String busino;
	/**
	 * '目标指标',
	 */
	private String objective;
	/**
	 * '指标值',
	 */
	private String indicator;
	/**
	 * '量化指标公式',
	 */
	private String formula;
	/**
	 * '数据提供部门',
	 */
	private String deptProvider;
	/**
	 * '数据审核部门',
	 */
	private String deptAudit;
	/**
	 * '数据审核阶段',
	 */
	private String objState;
	/**
	 * '是否短期目标',
	 */
	private String isShortTarget;
	/**
	 * '是否为可量化目标',
	 */
	private String quantitative;
	/**
	 * '目标达成值',
	 */
	private String completeValue;
	/**
	 * '完成状态'
	 */
	private String completeCondition;
	/**
	 * 指标id
	 */
	private int objId;

	/**
	 * 
	 * <p>
	 * getBusino
	 * </p>
	 * 
	 * @author 106140
	 * @date 2014-12-24 下午4:29:26
	 * @return
	 * @see
	 */
	public String getBusino() {
		return busino;
	}

	/**
	 * 
	 * <p>
	 * setBusino
	 * </p>
	 * 
	 * @author 106140
	 * @date 2014-12-24 下午4:29:30
	 * @param busino
	 * @see
	 */
	public void setBusino(String busino) {
		this.busino = busino;
	}

	/**
	 * 
	 * <p>
	 * getObjective
	 * </p>
	 * 
	 * @author 106140
	 * @date 2014-12-24 下午4:29:32
	 * @return
	 * @see
	 */
	public String getObjective() {
		return objective;
	}

	/**
	 * 
	 * <p>
	 * setObjective
	 * </p>
	 * 
	 * @author 106140
	 * @date 2014-12-24 下午4:29:34
	 * @param objective
	 * @see
	 */
	public void setObjective(String objective) {
		this.objective = objective;
	}

	/**
	 * 
	 * <p>
	 * getIndicator
	 * </p>
	 * 
	 * @author 106140
	 * @date 2014-12-24 下午4:29:36
	 * @return
	 * @see
	 */
	public String getIndicator() {
		return indicator;
	}

	/**
	 * 
	 * <p>
	 * setIndicator
	 * </p>
	 * 
	 * @author 106140
	 * @date 2014-12-24 下午4:29:39
	 * @param indicator
	 * @see
	 */
	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}

	/**
	 * 
	 * <p>
	 * getFormula
	 * </p>
	 * 
	 * @author 106140
	 * @date 2014-12-24 下午4:29:41
	 * @return
	 * @see
	 */
	public String getFormula() {
		return formula;
	}

	/**
	 * 
	 * <p>
	 * setFormula
	 * </p>
	 * 
	 * @author 106140
	 * @date 2014-12-24 下午4:29:43
	 * @param formula
	 * @see
	 */
	public void setFormula(String formula) {
		this.formula = formula;
	}

	/**
	 * 
	 * <p>
	 * getDeptProvider
	 * </p>
	 * 
	 * @author 106140
	 * @date 2014-12-24 下午4:29:45
	 * @return
	 * @see
	 */
	public String getDeptProvider() {
		return deptProvider;
	}

	/**
	 * 
	 * <p>
	 * setDeptProvider
	 * </p>
	 * 
	 * @author 106140
	 * @date 2014-12-24 下午4:29:47
	 * @param deptProvider
	 * @see
	 */
	public void setDeptProvider(String deptProvider) {
		this.deptProvider = deptProvider;
	}

	/**
	 * 
	 * <p>
	 * getDeptAudit
	 * </p>
	 * 
	 * @author 106140
	 * @date 2014-12-24 下午4:29:49
	 * @return
	 * @see
	 */
	public String getDeptAudit() {
		return deptAudit;
	}

	/**
	 * 
	 * <p>
	 * setDeptAudit
	 * </p>
	 * 
	 * @author 106140
	 * @date 2014-12-24 下午4:29:52
	 * @param deptAudit
	 * @see
	 */
	public void setDeptAudit(String deptAudit) {
		this.deptAudit = deptAudit;
	}

	/**
	 * 
	 * <p>
	 * getObjState
	 * </p>
	 * 
	 * @author 106140
	 * @date 2014-12-24 下午4:29:56
	 * @return
	 * @see
	 */
	public String getObjState() {
		return objState;
	}

	/**
	 * 
	 * <p>
	 * setObjState
	 * </p>
	 * 
	 * @author 106140
	 * @date 2014-12-24 下午4:29:58
	 * @param objState
	 * @see
	 */
	public void setObjState(String objState) {
		this.objState = objState;
	}

	/**
	 * 
	 * <p>
	 * getIsShortTarget
	 * </p>
	 * 
	 * @author 106140
	 * @date 2014-12-24 下午4:30:00
	 * @return
	 * @see
	 */
	public String getIsShortTarget() {
		return isShortTarget;
	}

	/**
	 * 
	 * <p>
	 * setIsShortTarget
	 * </p>
	 * 
	 * @author 106140
	 * @date 2014-12-24 下午4:30:04
	 * @param isShortTarget
	 * @see
	 */
	public void setIsShortTarget(String isShortTarget) {
		this.isShortTarget = isShortTarget;
	}

	/**
	 * 
	 * <p>
	 * getQuantitative
	 * </p>
	 * 
	 * @author 106140
	 * @date 2014-12-24 下午4:30:06
	 * @return
	 * @see
	 */
	public String getQuantitative() {
		return quantitative;
	}

	/**
	 * 
	 * <p>
	 * setQuantitative
	 * </p>
	 * 
	 * @author 106140
	 * @date 2014-12-24 下午4:30:08
	 * @param quantitative
	 * @see
	 */
	public void setQuantitative(String quantitative) {
		this.quantitative = quantitative;
	}

	/**
	 * 
	 * <p>
	 * getCompleteValue
	 * </p>
	 * 
	 * @author 106140
	 * @date 2014-12-24 下午4:30:10
	 * @return
	 * @see
	 */
	public String getCompleteValue() {
		return completeValue;
	}

	/**
	 * 
	 * <p>
	 * setCompleteValue
	 * </p>
	 * 
	 * @author 106140
	 * @date 2014-12-24 下午4:30:13
	 * @param completeValue
	 * @see
	 */
	public void setCompleteValue(String completeValue) {
		this.completeValue = completeValue;
	}

	/**
	 * 
	 * <p>
	 * getCompleteCondition
	 * </p>
	 * 
	 * @author 106140
	 * @date 2014-12-24 下午4:30:16
	 * @return
	 * @see
	 */
	public String getCompleteCondition() {
		return completeCondition;
	}

	/**
	 * 
	 * <p>
	 * setCompleteCondition
	 * </p>
	 * 
	 * @author 106140
	 * @date 2014-12-24 下午4:30:19
	 * @param completeCondition
	 * @see
	 */
	public void setCompleteCondition(String completeCondition) {
		this.completeCondition = completeCondition;
	}

	/**
	 * 
	 * <p>
	 * getObjId
	 * </p>
	 * 
	 * @author 106140
	 * @date 2014-12-24 下午4:30:22
	 * @return
	 * @see
	 */
	public int getObjId() {
		return objId;
	}

	/**
	 * 
	 * <p>
	 * setObjId
	 * </p>
	 * 
	 * @author 106140
	 * @date 2014-12-24 下午4:30:25
	 * @param objId
	 * @see
	 */
	public void setObjId(int objId) {
		this.objId = objId;
	}

}
