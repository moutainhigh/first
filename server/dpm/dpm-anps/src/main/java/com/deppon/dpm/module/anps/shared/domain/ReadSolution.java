package com.deppon.dpm.module.anps.shared.domain;
//阅读情况统计
public class ReadSolution {
	//读取数量
	private Integer readNum;
	//部门以及下属部门总人数
	private Integer totalNum;
    //组织名称
	private String orgIName;
	//组织id
	private Integer orgId;
	//阅读率
	private String readRate;
	//阅读率sort
	private Double readRateSort;
	//阅读率的颜色
	private String readRateColour;
    
	
	
	
	public Integer getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public Double getReadRateSort() {
		return readRateSort;
	}

	public void setReadRateSort(Double readRateSort) {
		this.readRateSort = readRateSort;
	}

	public String getReadRateColour() {
		return readRateColour;
	}

	public void setReadRateColour(String readRateColour) {
		this.readRateColour = readRateColour;
	}

	public Integer getReadNum() {
		return readNum;
	}

	public void setReadNum(Integer readNum) {
		this.readNum = readNum;
	}

	public String getOrgIName() {
		return orgIName;
	}

	public void setOrgIName(String orgIName) {
		this.orgIName = orgIName;
	}

	public String getReadRate() {
		return readRate;
	}

	public void setReadRate(String readRate) {
		this.readRate = readRate;
	}
	
	

}
