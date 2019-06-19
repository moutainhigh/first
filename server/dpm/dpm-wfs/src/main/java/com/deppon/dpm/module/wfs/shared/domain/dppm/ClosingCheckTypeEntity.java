package com.deppon.dpm.module.wfs.shared.domain.dppm;

import com.deppon.foss.framework.entity.BaseEntity;

/**
 * 项目验收类型
 * @author 106140
 * @date 2014-11-3 下午2:48:24
 * @since
 * @version
 */
public class ClosingCheckTypeEntity extends BaseEntity {
	
	private static final long serialVersionUID = -8717199361354789513L;
	/**
	 * 业务编号
	 */
	private String busino;
	/**
	 * 验收模块
	 */
	private String checkModule;
	/**
	 * 验收类型
	 */
	private String checkType;
	/**
	 * 负责人
	 */
	private String managerName;
	/**
	 * 负责人工号
	 */
	private String managerCode;
	/**
	 * 
	 * <p>getBusino </p> 
	 * @author 106140
	 * @date 2014-12-24 下午4:27:49
	 * @return
	 * @see
	 */
	public String getBusino() {
		return busino;
	}
	/**
	 * 
	 * <p>setBusino </p> 
	 * @author 106140
	 * @date 2014-12-24 下午4:27:51
	 * @param busino
	 * @see
	 */
	public void setBusino(String busino) {
		this.busino = busino;
	}
	/**
	 * 
	 * <p>getCheckModule </p> 
	 * @author 106140
	 * @date 2014-12-24 下午4:27:53
	 * @return
	 * @see
	 */
	public String getCheckModule() {
		return checkModule;
	}
	/**
	 * 
	 * <p>setCheckModule </p> 
	 * @author 106140
	 * @date 2014-12-24 下午4:27:55
	 * @param checkModule
	 * @see
	 */
	public void setCheckModule(String checkModule) {
		this.checkModule = checkModule;
	}
	/**
	 * 
	 * <p>getCheckType </p> 
	 * @author 106140
	 * @date 2014-12-24 下午4:27:57
	 * @return
	 * @see
	 */
	public String getCheckType() {
		return checkType;
	}
	/**
	 * 
	 * <p>setCheckType </p> 
	 * @author 106140
	 * @date 2014-12-24 下午4:28:00
	 * @param checkType
	 * @see
	 */
	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}
	/**
	 * 
	 * <p>getManagerName </p> 
	 * @author 106140
	 * @date 2014-12-24 下午4:28:02
	 * @return
	 * @see
	 */
	public String getManagerName() {
		return managerName;
	}
	/**
	 * 
	 * <p>setManagerName </p> 
	 * @author 106140
	 * @date 2014-12-24 下午4:28:04
	 * @param managerName
	 * @see
	 */
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	/**
	 * 
	 * <p>getManagerCode </p> 
	 * @author 106140
	 * @date 2014-12-24 下午4:28:06
	 * @return
	 * @see
	 */
	public String getManagerCode() {
		return managerCode;
	}
	/**
	 * 
	 * <p>setManagerCode </p> 
	 * @author 106140
	 * @date 2014-12-24 下午4:28:11
	 * @param managerCode
	 * @see
	 */
	public void setManagerCode(String managerCode) {
		this.managerCode = managerCode;
	}
	  
	  
}
