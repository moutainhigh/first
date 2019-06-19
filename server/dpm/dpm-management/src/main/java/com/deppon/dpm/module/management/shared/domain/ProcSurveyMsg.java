package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 工程勘测基础信息
 * 
 * @author 293888
 * 
 */
public class ProcSurveyMsg implements Serializable {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 主键ID
	 */
	private String id;
	/**
	 * 勘测部位code
	 */
	private String partCode;
	/**
	 * 勘测部位名称
	 */
	private String partName;
	/**
	 * 勘测项目code
	 */
	private String proCode;
	/**
	 * 勘测项目名称
	 */
	private String proName;
	/**
	 * 项目说明code
	 */
	private String explainCode;
	/**
	 * 项目说明名称
	 */
	private String explainName;
	/**
	 * 行标
	 */
	private String lineId;
	/**
	 * 排序
	 */
	private String orderId;

	/**
	 * 拼装的code
	 */
	private String arrayCode;
	/**
	 * 拼装的name
	 */
	private String arrayName;
	
	/**
	 * 是否选取标志位
	 */
	private Long isSelect;

	
	
	
	/**
	 * 是否选取标志位
	 * @return
	 */
	public Long getIsSelect() {
		return isSelect;
	}

	public void setIsSelect(Long isSelect) {
		this.isSelect = isSelect;
	}

	private List<ProcSurveyMsg> lisMsgs = new ArrayList<ProcSurveyMsg>();

	/**
	 * list
	 * @return
	 */
	public List<ProcSurveyMsg> getLisMsgs() {
		return lisMsgs;
	}

	public void setLisMsgs(List<ProcSurveyMsg> lisMsgs) {
		this.lisMsgs = lisMsgs;
	}
	/**
	 * 拼装的name
	 * @return
	 */
	public String getArrayName() {
		return arrayName;
	}

	public void setArrayName(String arrayName) {
		this.arrayName = arrayName;
	}

	
	/**
	 * 勘测部位code
	 * 
	 * @return
	 */
	public String getPartCode() {
		return partCode;
	}

	public void setPartCode(String partCode) {
		this.partCode = partCode;
	}

	/**
	 * 勘测部位名称
	 * 
	 * @return
	 */
	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	/**
	 * 勘测项目code
	 * 
	 * @return
	 */
	public String getProCode() {
		return proCode;
	}

	public void setProCode(String proCode) {
		this.proCode = proCode;
	}

	/**
	 * 勘测项目名称
	 * 
	 * @return
	 */
	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}
	/**
	 * 项目说明code
	 * @return
	 */
	public String getExplainCode() {
		return explainCode;
	}

	public void setExplainCode(String explainCode) {
		this.explainCode = explainCode;
	}
	/**
	 * 项目说明名称
	 * @return
	 */
	public String getExplainName() {
		return explainName;
	}

	public void setExplainName(String explainName) {
		this.explainName = explainName;
	}
	/**
	 * 主键
	 * @return
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 行标
	 * @return
	 */
	public String getLineId() {
		return lineId;
	}

	public void setLineId(String lineId) {
		this.lineId = lineId;
	}
	/**
	 * 订单id
	 * @return
	 */
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	/**
	 * 拼装code
	 * @return
	 */
	public String getArrayCode() {
		return arrayCode;
	}

	public void setArrayCode(String arrayCode) {
		this.arrayCode = arrayCode;
	}

}
