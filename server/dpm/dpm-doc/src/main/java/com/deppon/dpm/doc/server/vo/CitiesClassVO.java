package com.deppon.dpm.doc.server.vo;

import java.io.Serializable;
import java.util.List;

public class CitiesClassVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private List<CitiesInfoVO> cities;
//	public String getName() {  
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public List<CitiesInfoVO> getCities() {
//		return cities;
//	}
//	public void setCities(List<CitiesInfoVO> cities) {
//		this.cities = cities;
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
	 * @return the cities
	 */
	public List<CitiesInfoVO> getCities() {
		return cities;
	}
	/**
	 * @param cities the cities to set
	 */
	public void setCities(List<CitiesInfoVO> cities) {
		this.cities = cities;
	}
	
	
}
