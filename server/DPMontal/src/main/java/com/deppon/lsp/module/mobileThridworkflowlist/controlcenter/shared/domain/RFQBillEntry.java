package com.deppon.lsp.module.mobileThridworkflowlist.controlcenter.shared.domain;

import java.math.BigDecimal;

import com.deppon.foss.framework.entity.BaseEntity;

public class RFQBillEntry extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**单据头*/
	private String parent;
	
	/**物品编码*/
	private String materiaNumber;
	
	/**物品名称*/
	private String materiaName;
	
	/**物品类型*/
	private String materiaType;
	
	/**物品规格*/
	private String materiaStandard;
	
	/**计量单位*/
	private String measureUnit;
	
	/**是否含运费*/
	private boolean freight;
	
	/**是否含税*/
	private boolean revenue;
	
	/**开票类型*/
	private String invoiceType;
	
	/**供货时效(天)*/
	private int date;
	
	/**备注*/
	private String remark;
	
	/**数量*/
	private BigDecimal quantity;
	
	/**是否打样*/
	private boolean makeProof;
	
	/**单据分录序列号*/
	private int seq;
	
	/**id*/
	private String fid;
	
	//将BigDecimal转换为String类型，便于接口传递数据
	private String quantityDto;

	public String getQuantityDto() {
		return quantityDto;
	}

	public void setQuantityDto(String quantityDto) {
		this.quantityDto = quantityDto;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:06:18
	* @version：
	* @return String
	 */
	public String getParent() {
		return parent;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:06:21
	* @version：
	* @param parent void
	 */
	public void setParent(String parent) {
		this.parent = parent;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:06:25
	* @version：
	* @return String
	 */
	public String getMateriaNumber() {
		return materiaNumber;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:06:28
	* @version：
	* @param materiaNumber void
	 */
	public void setMateriaNumber(String materiaNumber) {
		this.materiaNumber = materiaNumber;
	}

	/**
	 * 
	* TODO
	* @description： 
	* @author：130355
	* @date：2014-4-9 下午5:06:34
	* @version：
	* @return String
	 */
	public String getMateriaName() {
		return materiaName;
	}

	public void setMateriaName(String materiaName) {
		this.materiaName = materiaName;
	}

	public String getMateriaType() {
		return materiaType;
	}

	public void setMateriaType(String materiaType) {
		this.materiaType = materiaType;
	}

	public String getMateriaStandard() {
		return materiaStandard;
	}

	public void setMateriaStandard(String materiaStandard) {
		this.materiaStandard = materiaStandard;
	}

	public String getMeasureUnit() {
		return measureUnit;
	}

	public void setMeasureUnit(String measureUnit) {
		this.measureUnit = measureUnit;
	}

	public boolean isFreight() {
		return freight;
	}

	public void setFreight(boolean freight) {
		this.freight = freight;
	}

	public boolean isRevenue() {
		return revenue;
	}

	public void setRevenue(boolean revenue) {
		this.revenue = revenue;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public boolean isMakeProof() {
		return makeProof;
	}

	public void setMakeProof(boolean makeProof) {
		this.makeProof = makeProof;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}


	

}
