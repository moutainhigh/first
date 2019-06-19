package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author 268101
 * 省市级联
 *
 */
public class ServeAddressBean implements Serializable {

	/**
	 * 版本号
	 */
	private static final long serialVersionUID = -8612388236250610889L;
	//国
	private String china;
	//省
	private String province;
	//市
	private String city;
	//县
	private String county;
	//父code
	private String parCode;
	//自己code
	private String code;
	//拼音缩写
	private String abbr;
	//行政级别
	private String degree;
	//名字
	private String name;
	//市集合
	private List<ServeAddressBean> beanList;
	//工号
	private String userNo;
	//监控点
	private int type;
	/**
	 * @return 国
	 */
	public String getChina() {
		return china;
	}
	/**
	 * @param china 国
	 */
	public void setChina(String china) {
		this.china = china;
	}
	/**
	 * @return 省
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * @param province 省
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * @return 市
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city 市
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return 县
	 */
	public String getCounty() {
		return county;
	}
	/**
	 * @param county 县
	 */
	public void setCounty(String county) {
		this.county = county;
	}
	/**
	 * @return 父code
	 */
	public String getParCode() {
		return parCode;
	}
	/**
	 * @param parCode 父code
	 */
	public void setParCode(String parCode) {
		this.parCode = parCode;
	}
	/**
	 * @return 自己code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code 自己code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	public String getAbbr() {
		return abbr;
	}
	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return 市集合
	 */
	public List<ServeAddressBean> getBeanList() {
		return beanList;
	}
	/**
	 * @param beanList 市集合
	 */
	public void setBeanList(List<ServeAddressBean> beanList) {
		this.beanList = beanList;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	/**
	 * @return 监控点
	 */
	public int getType() {
		return type;
	}
	/**
	 * @param type 监控点
	 */
	public void setType(int type) {
		this.type = type;
	}
	@Override
	//组装
	public String toString() {
		return "ServeAddressBean [china=" + china + ", province=" + province
				+ ", city=" + city + ", county=" + county + ", parCode="
				+ parCode + ", code=" + code + ", abbr=" + abbr + ", degree="
				+ degree + ", name=" + name + ", beanList=" + beanList
				+ ", userNo=" + userNo + ", type=" + type + "]";
	}
	
	
}
