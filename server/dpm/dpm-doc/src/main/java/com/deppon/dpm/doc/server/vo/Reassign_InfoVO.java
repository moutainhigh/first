package com.deppon.dpm.doc.server.vo;

import java.io.Serializable;

/**
 * 订单改派信息
 * @author Administrator
 *
 */
public class Reassign_InfoVO implements Serializable {

	/**
	 * 构造方法
	 */
	public Reassign_InfoVO(){ 
		super();
	}
	
	private static final long serialVersionUID = 1L;
	
	//改派前订单id，即此订单由哪个订单id改派而生成（当值为0时，表示该订单不是因为改派而生成的）
	private String pre_order_id;
	//改派后订单id，即由于订单改派而产生的订单id（当值为0时，表示当前订单未被改派而产生新订单）
	private String next_order_id;
	//第一个被改派的订单id
	private String init_order_id;
	//最新被指派的订单id
	private String latest_order_id;
//	public int getPre_order_id() {
//		return pre_order_id;
//	}
//	public void setPre_order_id(int pre_order_id) {
//		this.pre_order_id = pre_order_id;
//	}
//	public int getNext_order_id() {
//		return next_order_id;
//	}
//	public void setNext_order_id(int next_order_id) {
//		this.next_order_id = next_order_id;
//	}
//	public int getInit_order_id() {
//		return init_order_id;
//	}
//	public void setInit_order_id(int init_order_id) {
//		this.init_order_id = init_order_id;
//	}
//	public int getLatest_order_id() {
//		return latest_order_id;
//	}
//	public void setLatest_order_id(int latest_order_id) {
//		this.latest_order_id = latest_order_id;
//	}
	/**
	 * @return the pre_order_id
	 */
	public String getPre_order_id() {
		return pre_order_id;
	}
	/**
	 * @param pre_order_id the pre_order_id to set
	 */
	public void setPre_order_id(String pre_order_id) {
		this.pre_order_id = pre_order_id;
	}
	/**
	 * @return the next_order_id
	 */
	public String getNext_order_id() {
		return next_order_id;
	}
	/**
	 * @param next_order_id the next_order_id to set
	 */
	public void setNext_order_id(String next_order_id) {
		this.next_order_id = next_order_id;
	}
	/**
	 * @return the init_order_id
	 */
	public String getInit_order_id() {
		return init_order_id;
	}
	/**
	 * @param init_order_id the init_order_id to set
	 */
	public void setInit_order_id(String init_order_id) {
		this.init_order_id = init_order_id;
	}
	/**
	 * @return the latest_order_id
	 */
	public String getLatest_order_id() {
		return latest_order_id;
	}
	/**
	 * @param latest_order_id the latest_order_id to set
	 */
	public void setLatest_order_id(String latest_order_id) {
		this.latest_order_id = latest_order_id;
	}

	
}
