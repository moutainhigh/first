package com.deppon.dpm.doc.server.vo;

import java.io.Serializable;

public class CitiesInfoVO implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 城市名称
	 */
	private String name;
	/**
	 * 城市ID
	 */
	private int cityid;
	/**
	 * 是否开通专车 1-开通 0-未开通
	 */
	private int open_zhuanche;
	/**
	 * 是否开通快车 1-开通 0-未开通
	 */
	private int open_kuaiche;
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public int getCityid() {
//		return cityid;
//	}
//	public void setCityid(int cityid) {
//		this.cityid = cityid;
//	}
//	public int getOpen_zhuanche() {
//		return open_zhuanche;
//	}
//	public void setOpen_zhuanche(int open_zhuanche) {
//		this.open_zhuanche = open_zhuanche;
//	}
//	public int getOpen_kuaiche() {
//		return open_kuaiche;
//	}
//	public void setOpen_kuaiche(int open_kuaiche) {
//		this.open_kuaiche = open_kuaiche;
//	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the cityid
	 */
	public int getCityid() {
		return cityid;
	}
	/**
	 * @param cityid the cityid to set
	 */
	public void setCityid(int cityid) {
		this.cityid = cityid;
	}
	/**
	 * @return the open_zhuanche
	 */
	public int getOpen_zhuanche() {
		return open_zhuanche;
	}
	/**
	 * @param open_zhuanche the open_zhuanche to set
	 */
	public void setOpen_zhuanche(int open_zhuanche) {
		this.open_zhuanche = open_zhuanche;
	}
	/**
	 * @return the open_kuaiche
	 */
	public int getOpen_kuaiche() {
		return open_kuaiche;
	}
	/**
	 * @param open_kuaiche the open_kuaiche to set
	 */
	public void setOpen_kuaiche(int open_kuaiche) {
		this.open_kuaiche = open_kuaiche;
	}
	

}
