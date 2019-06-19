package com.deppon.lsp.module.mobileworkflowlist.controlcenter.shared.domain;

import com.deppon.bpms.module.shared.domain.ApprovalInfo;

// TODO: Auto-generated Javadoc
/**
 * The Class WorkflowEntity.
 */
/**
 * @author 148023
 *
 */
public class WorkflowEntity {
	//单据附件列表
	/** The attach list. */
	private AttachEntity[] attachList;
	// 流程动态
	/** The Approval info list. */
	private ApprovalInfo[] ApprovalInfoList;
	//项目可行性评估单
	/** The pro fas asses entity vo. */
	private ProFassAssessVo  proFasAssesEntityVo;
	//车辆申请单数据
	/** The vehicleapplyvo list. */
	private VehicleapplyVo  vehicleapplyvoList;
	//定标单业务数据
	/** The calibratebill vo. */
	private CalibratebillVo calibratebillVo;
	//定标变更单业务数据
	/** The calibratebill change vo. */
	private CalibratebillChangeVo calibratebillChangeVo;
	//设计变更单业务数据
	/** The project design change vo. */
	private ProjectDesignChangeVo projectDesignChangeVo;
	//车辆更新申请单
	/** 车辆更新申请单. */
	private VehicleRenovateApplyVo vehicleRenovateApplyVo;
	//工程预算调整单
	/** The projectbudge vo. */
	private ProjectbudgeVo  projectbudgeVo;
	//立项单
	/** The projectapproval vo. */
	private ProjectapprovalVo projectapprovalVo;
	//维修申请单
	/** The maintenrequest vo. */
	private MaintenrequestVo maintenrequestVo;
	//新点物料申请单
	/** The newsalesmaterial vo. */
	private NewsalesmaterialVo newsalesmaterialVo;
	
	//工程量单变更单实体
	/** The programmeChangeNoticeVo vo. */
	private ProgrammeChangeNoticeVo programmeChangeNoticeVo;
	
	//工程项目结算单实体
	/** The projectclearVo vo. */
	private ProjectclearVo projectclearVo;
	
	//决算单实体
	/** The finalAccountApplyVo vo. */
	private FinalAccountApplyVo finalAccountApplyVo;
	
	//工程项目状态申请单业务数据
	/** The project status vo. */
	private ProjectStatusVo projectStatusVo;
		
	//工程项目规划单业务数据
	/** The project programme vo. */
	private ProjectProgrammeVo projectProgrammeVo;
	
	//维修保养单
	/** The maintenancebill vo. */
	private MaintenancebillVo maintenancebillVo;
	
	//备货维护单
	/** The stockmaintainVo vo. */
	private StockmaintainVo stockmaintainVo;
	
	//备货申请单
	/** The stock applybill vo. */
	private StockApplybillVo stockApplybillVo;
	/**
	 * Gets the pro fas asses entity vo.
	 *
	 * @return the pro fas asses entity vo
	 */
	public ProFassAssessVo getProFasAssesEntityVo() {
		if (proFasAssesEntityVo == null) {
			proFasAssesEntityVo = new ProFassAssessVo();
		}
		return proFasAssesEntityVo;
	}
	
	/**
	 * Sets the pro fas asses entity vo.
	 *
	 * @param proFasAssesEntityVo the new pro fas asses entity vo
	 */
	public void setProFasAssesEntityVo(ProFassAssessVo proFasAssesEntityVo) {
		this.proFasAssesEntityVo = proFasAssesEntityVo;
	}
	
	/**
	 * Gets the attach list.
	 *
	 * @return the attachList
	 */
	public AttachEntity[] getAttachList() {
		return attachList;
	}
	
	/**
	 * Sets the attach list.
	 *
	 * @param attachList the attachList to set
	 */
	public void setAttachList(AttachEntity[] attachList) {
		this.attachList = attachList;
	}

	/**
	 * Gets the vehicleapplyvo list.
	 *
	 * @return the vehicleapplyvoList
	 */
	public VehicleapplyVo getVehicleapplyvoList() {
		if (vehicleapplyvoList == null) {
			vehicleapplyvoList = new VehicleapplyVo();
		}
		return vehicleapplyvoList;
	}
	
	/**
	 * Sets the vehicleapplyvo list.
	 *
	 * @param vehicleapplyvoList the vehicleapplyvoList to set
	 */
	public void setVehicleapplyvoList(VehicleapplyVo vehicleapplyvoList) {
		this.vehicleapplyvoList = vehicleapplyvoList;
	}
	
	/**
	 * Gets the calibratebill vo.
	 *
	 * @return the calibratebillVo
	 */
	public CalibratebillVo getCalibratebillVo() {
		return calibratebillVo;
	}
	
	/**
	 * Sets the calibratebill vo.
	 *
	 * @param calibratebillVo the calibratebillVo to set
	 */
	public void setCalibratebillVo(CalibratebillVo calibratebillVo) {
		this.calibratebillVo = calibratebillVo;
	}
	
	/**
	 * Gets the calibratebill change vo.
	 *
	 * @return the calibratebillChangeVo
	 */
	public CalibratebillChangeVo getCalibratebillChangeVo() {
		if (calibratebillChangeVo == null) {
			calibratebillChangeVo = new CalibratebillChangeVo();
		}
		return calibratebillChangeVo;
	}
	
	/**
	 * Sets the calibratebill change vo.
	 *
	 * @param calibratebillChangeVo the calibratebillChangeVo to set
	 */
	public void setCalibratebillChangeVo(CalibratebillChangeVo calibratebillChangeVo) {
		this.calibratebillChangeVo = calibratebillChangeVo;
	}
	
	/**
	 * Gets the approval info list.
	 *
	 * @return the approval info list
	 */
	public ApprovalInfo[] getApprovalInfoList() {
		return ApprovalInfoList;
	}
	
	/**
	 * Sets the approval info list.
	 *
	 * @param approvalInfoList the new approval info list
	 */
	public void setApprovalInfoList(ApprovalInfo[] approvalInfoList) {
		ApprovalInfoList = approvalInfoList;
	}
	
	/**
	 * Gets the project design change vo.
	 *
	 * @return the project design change vo
	 */
	public ProjectDesignChangeVo getProjectDesignChangeVo() {
		if (projectDesignChangeVo == null) {
			projectDesignChangeVo = new ProjectDesignChangeVo();
		}
		return projectDesignChangeVo;
	}
	
	/**
	 * Sets the project design change vo.
	 *
	 * @param projectDesignChangeVo the new project design change vo
	 */
	public void setProjectDesignChangeVo(ProjectDesignChangeVo projectDesignChangeVo) {
		this.projectDesignChangeVo = projectDesignChangeVo;
	}

	/**
	 * Gets the vehicle renovate apply vo.
	 *
	 * @return the vehicle renovate apply vo
	 */
	public VehicleRenovateApplyVo getVehicleRenovateApplyVo() {
		if (vehicleRenovateApplyVo == null) {
			vehicleRenovateApplyVo = new VehicleRenovateApplyVo();
		}
		return vehicleRenovateApplyVo;
	}

	/**
	 * Sets the vehicle renovate apply vo.
	 *
	 * @param vehicleRenovateApplyVo the new vehicle renovate apply vo
	 */
	public void setVehicleRenovateApplyVo(VehicleRenovateApplyVo vehicleRenovateApplyVo) {
		this.vehicleRenovateApplyVo = vehicleRenovateApplyVo;
	}

	/**
	 * Gets the projectbudge vo.
	 *
	 * @return the projectbudge vo
	 */
	public ProjectbudgeVo getProjectbudgeVo() {
		return projectbudgeVo;
	}

	/**
	 * Sets the projectbudge vo.
	 *
	 * @param projectbudgeVo the new projectbudge vo
	 */
	public void setProjectbudgeVo(ProjectbudgeVo projectbudgeVo) {
		this.projectbudgeVo = projectbudgeVo;
	}

	/**
	 * Gets the projectapproval vo.
	 *
	 * @return the projectapproval vo
	 */
	public ProjectapprovalVo getProjectapprovalVo() {
		return projectapprovalVo;
	}

	/**
	 * Sets the projectapproval vo.
	 *
	 * @param projectapprovalVo the new projectapproval vo
	 */
	public void setProjectapprovalVo(ProjectapprovalVo projectapprovalVo) {
		this.projectapprovalVo = projectapprovalVo;
	}

	/**
	 * Gets the maintenrequest vo.
	 *
	 * @return the maintenrequest vo
	 */
	public MaintenrequestVo getMaintenrequestVo() {
		return maintenrequestVo;
	}

	/**
	 * Sets the maintenrequest vo.
	 *
	 * @param maintenrequestVo the new maintenrequest vo
	 */
	public void setMaintenrequestVo(MaintenrequestVo maintenrequestVo) {
		this.maintenrequestVo = maintenrequestVo;
	}

	/**
	 * Gets the newsalesmaterial vo.
	 *
	 * @return the newsalesmaterial vo
	 */
	public NewsalesmaterialVo getNewsalesmaterialVo() {
		return newsalesmaterialVo;
	}

	/**
	 * Sets the newsalesmaterial vo.
	 *
	 * @param newsalesmaterialVo the new newsalesmaterial vo
	 */
	public void setNewsalesmaterialVo(NewsalesmaterialVo newsalesmaterialVo) {
		this.newsalesmaterialVo = newsalesmaterialVo;
	}

	/**
	 * Gets the programme change notice vo.
	 *
	 * @return the programme change notice vo
	 */
	public ProgrammeChangeNoticeVo getProgrammeChangeNoticeVo() {
		return programmeChangeNoticeVo;
	}

	/**
	 * Sets the programme change notice vo.
	 *
	 * @param programmeChangeNoticeVo the new programme change notice vo
	 */
	public void setProgrammeChangeNoticeVo(
			ProgrammeChangeNoticeVo programmeChangeNoticeVo) {
		this.programmeChangeNoticeVo = programmeChangeNoticeVo;
	}

	/**
	 * Gets the projectclear vo.
	 *
	 * @return the projectclear vo
	 */
	public ProjectclearVo getProjectclearVo() {
		return projectclearVo;
	}

	/**
	 * Sets the projectclear vo.
	 *
	 * @param projectclearVo the new projectclear vo
	 */
	public void setProjectclearVo(ProjectclearVo projectclearVo) {
		this.projectclearVo = projectclearVo;
	}

	/**
	 * Gets the final account apply vo.
	 *
	 * @return the final account apply vo
	 */
	public FinalAccountApplyVo getFinalAccountApplyVo() {
		return finalAccountApplyVo;
	}

	/**
	 * Sets the final account apply vo.
	 *
	 * @param finalAccountApplyVo the new final account apply vo
	 */
	public void setFinalAccountApplyVo(FinalAccountApplyVo finalAccountApplyVo) {
		this.finalAccountApplyVo = finalAccountApplyVo;
	}

	/**
	 * Gets the project status vo.
	 *
	 * @return the project status vo
	 */
	public ProjectStatusVo getProjectStatusVo() {
		return projectStatusVo;
	}

	/**
	 * Sets the project status vo.
	 *
	 * @param projectStatusVo the new project status vo
	 */
	public void setProjectStatusVo(ProjectStatusVo projectStatusVo) {
		this.projectStatusVo = projectStatusVo;
	}

	/**
	 * Gets the project programme vo.
	 *
	 * @return the project programme vo
	 */
	public ProjectProgrammeVo getProjectProgrammeVo() {
		return projectProgrammeVo;
	}

	/**
	 * Sets the project programme vo.
	 *
	 * @param projectProgrammeVo the new project programme vo
	 */
	public void setProjectProgrammeVo(ProjectProgrammeVo projectProgrammeVo) {
		this.projectProgrammeVo = projectProgrammeVo;
	}

	/**
	 * Gets the maintenancebill vo.
	 *
	 * @return the maintenancebill vo
	 */
	public MaintenancebillVo getMaintenancebillVo() {
		return maintenancebillVo;
	}

	/**
	 * Sets the maintenancebill vo.
	 *
	 * @param maintenancebillVo the new maintenancebill vo
	 */
	public void setMaintenancebillVo(MaintenancebillVo maintenancebillVo) {
		this.maintenancebillVo = maintenancebillVo;
	}

	/**
	 * Gets the stockmaintain vo.
	 *
	 * @return the stockmaintain vo
	 */
	public StockmaintainVo getStockmaintainVo() {
		return stockmaintainVo;
	}

	/**
	 * Sets the stockmaintain vo.
	 *
	 * @param stockmaintainVo the new stockmaintain vo
	 */
	public void setStockmaintainVo(StockmaintainVo stockmaintainVo) {
		this.stockmaintainVo = stockmaintainVo;
	}

	/**
	 * Gets the stock applybill vo.
	 *
	 * @return the stock applybill vo
	 */
	public StockApplybillVo getStockApplybillVo() {
		return stockApplybillVo;
	}

	/**
	 * Sets the stock applybill vo.
	 *
	 * @param stockApplybillVo the new stock applybill vo
	 */
	public void setStockApplybillVo(StockApplybillVo stockApplybillVo) {
		this.stockApplybillVo = stockApplybillVo;
	}
}
