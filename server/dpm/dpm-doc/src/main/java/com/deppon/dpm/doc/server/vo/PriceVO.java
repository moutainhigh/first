package com.deppon.dpm.doc.server.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 滴滴价格
 * @author guzf
 *
 */
public class PriceVO implements Serializable {

	/**
	 * 构造方法
	 */
	public PriceVO(){ 
		super();
	}
	
	private static final long serialVersionUID = 1L;
	//总费用
	private float total_price;
	//预估价
	private float estimate_price;
	//费用异议信息。为空没有费用异议,不为空有费用异议,
	private Object fee_objection;
	
	private List<PriceDetailVO> detail;

	/**
	 * @return the total_price
	 */
	public float getTotal_price() {
		return total_price;
	}

	/**
	 * @param total_price the total_price to set
	 */
	public void setTotal_price(float total_price) {
		this.total_price = total_price;
	}

	public float getEstimate_price() {
		return estimate_price;
	}

	public void setEstimate_price(float estimate_price) {
		this.estimate_price = estimate_price;
	}

	/**
	 * @return the fee_objection
	 */
	public Object getFee_objection() {
		return fee_objection;
	}

	/**
	 * @param fee_objection the fee_objection to set
	 */
	public void setFee_objection(Object fee_objection) {
		this.fee_objection = fee_objection;
	}

	/**
	 * @return the detail
	 */
	public List<PriceDetailVO> getDetail() {
		return detail;
	}

	/**
	 * @param detail the detail to set
	 */
	public void setDetail(List<PriceDetailVO> detail) {
		this.detail = detail;
	}

//	public float getTotal_price() {
//		return total_price;
//	}
//
//	public void setTotal_price(float total_price) {
//		this.total_price = total_price;
//	}
//
//	public Object getFee_objection() {
//		return fee_objection;
//	}
//
//	public void setFee_objection(Object fee_objection) {
//		this.fee_objection = fee_objection;
//	}
//
//	public List<PriceDetailVO> getDetail() {
//		return detail;
//	}
//
//	public void setDetail(List<PriceDetailVO> detail) {
//		this.detail = detail;
//	}
	
	
}
