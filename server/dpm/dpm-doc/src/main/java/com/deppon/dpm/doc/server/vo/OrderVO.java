package com.deppon.dpm.doc.server.vo;

import java.io.Serializable;
/**
 * 滴滴订单详情
 * @author guzf
 *
 */
public class OrderVO implements Serializable {

	/**
	 * 构造方法
	 */ 
	public OrderVO(){
		super();
	}
	
	private static final long serialVersionUID = 1L;

	private DidiOrderDetailVO order;
	private PriceVO price;
//	public DidiOrderDetailVO getOrder() {
//		return order;
//	}
//	public void setOrder(DidiOrderDetailVO order) {
//		this.order = order;
//	}
//	public PriceVO getPrice() {
//		return price;
//	}
//	public void setPrice(PriceVO price) {
//		this.price = price;
//	}
	/**
	 * @return the order
	 */
	public DidiOrderDetailVO getOrder() {
		return order;
	}
	/**
	 * @param order the order to set
	 */
	public void setOrder(DidiOrderDetailVO order) {
		this.order = order;
	}
	/**
	 * @return the price
	 */
	public PriceVO getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(PriceVO price) {
		this.price = price;
	}
	
	
}
