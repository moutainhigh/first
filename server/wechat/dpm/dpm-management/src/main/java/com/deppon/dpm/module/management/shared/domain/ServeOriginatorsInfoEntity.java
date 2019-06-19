package com.deppon.dpm.module.management.shared.domain;

import java.io.Serializable;
import java.util.Date;
/**
 * 发布信息表
 * @author 293888 zyf
 *
 */
public class ServeOriginatorsInfoEntity implements Serializable{

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	/**
	 *	主键id 
	 */
	private int id;
	
	/**
	 * 发布者工号
	 */
	private String origNo;
	
	/**
	 * 发布者姓名
	 */
	private String origName;
	
	/**
	 * 发布者手机号
	 */
	private String origTel;
	
	/**
	 * 主题
	 */
	private String origTitle;
	
	/**
	 * 图片
	 */
	private String origImg;
	
	/**
	 * 出发地
	 */
	private String startPlace;
	
	/**
	 * 途经地
	 */
	private String midPlace;
	
	/**
	 * 目的地
	 */
	private String endPlace;
	
	/**
	 * 实际人数
	 */
	private int partNum;
	
	/**
	 * 上限人数
	 */
	private int limitNum;
	
	/**
	 * 出发时间
	 */
	private Date startTime;
	
	/**
	 * 格式化出发时间
	 */
	private String startDate;
	
	/**
	 * 报名截止时间
	 */
	private Date partTime;
	/**
	 * 格式化报名截止时间
	 */
	private String partDate;
	/**
	 * 个人头像
	 */
	private String imgSrc;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 格式化创建时间
	 */
	private String createDate;
	
	/**
	 * 类型(0:上班车 1:下班车 2:活动)
	 */
	private int origType;
	
	/**
	 * 状态(0:进行中 1:已取消)	
	 */
	private int origState;
	
	/**
	 * 更新时间
	 */
	private Date updateTime;
	
	//出发省
	private String startProvinceCode;
	/**
	 * 出发省名字
	 */
	private String startProvinceName;
	//出发市
	private String startCityCode;
	/**
	 * 出发市名字
	 */
	private String startCityName;
	
	//目的省
	private String endProvinceCode;
	/**
	 * 目的省
	 */
	private String endProvinceName;
	//目的市
	private String endCityCode;
	/**
	 * 目的市
	 */
	private String endCityName;
	/**
	 * 修改时间
	 */
	private String updateDate;
	/**
	 * 状态信息
	 */
	private String partState;
	
	/**
	 * 车辆类型  0:自有车 1：蹭车 2：打的
	 */
	private int carType;
	
	/**费用类型  0:免费 1：有偿
	 * 
	 */
	private int payType;
	
	/**
	 * 费用金额 费用金额，整数值
	 */
	private int payMoney;
	
	/**
	 * 出发省code
	 * @return
	 */
	public String getStartProvinceCode() {
		return startProvinceCode;
	}

	public void setStartProvinceCode(String startProvinceCode) {
		this.startProvinceCode = startProvinceCode;
	}
	/**
	 * 出发省name
	 * @return
	 */
	public String getStartProvinceName() {
		return startProvinceName;
	}

	public void setStartProvinceName(String startProvinceName) {
		this.startProvinceName = startProvinceName;
	}
	
	/**
	 * 出发市code
	 * @return
	 */
	public String getStartCityCode() {
		return startCityCode;
	}

	public void setStartCityCode(String startCityCode) {
		this.startCityCode = startCityCode;
	}

	/**
	 * 出发市name
	 * @return
	 */
	public String getStartCityName() {
		return startCityName;
	}

	public void setStartCityName(String startCityName) {
		this.startCityName = startCityName;
	}

	/**
	 * 到达省code
	 * @return
	 */
	public String getEndProvinceCode() {
		return endProvinceCode;
	}

	public void setEndProvinceCode(String endProvinceCode) {
		this.endProvinceCode = endProvinceCode;
	}

	/**
	 * 到达省name
	 * @return
	 */
	public String getEndProvinceName() {
		return endProvinceName;
	}

	public void setEndProvinceName(String endProvinceName) {
		this.endProvinceName = endProvinceName;
	}

	/**
	 * 到达市code
	 * @return
	 */
	public String getEndCityCode() {
		return endCityCode;
	}

	public void setEndCityCode(String endCityCode) {
		this.endCityCode = endCityCode;
	}

	/**
	 * 到达市name
	 * @return
	 */
	public String getEndCityName() {
		return endCityName;
	}

	public void setEndCityName(String endCityName) {
		this.endCityName = endCityName;
	}
	/**
	 * 标示
	 */
	private String flag;
	

	/**
	 * id
	 * @return
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 工号
	 * @return
	 */
	public String getOrigNo() {
		return origNo;
	}

	public void setOrigNo(String origNo) {
		this.origNo = origNo;
	}

	/**
	 * name
	 * @return
	 */
	public String getOrigName() {
		return origName;
	}

	public void setOrigName(String origName) {
		this.origName = origName;
	}

	/**
	 * 电话
	 * @return
	 */
	public String getOrigTel() {
		return origTel;
	}

	public void setOrigTel(String origTel) {
		this.origTel = origTel;
	}

	/**
	 * 标题
	 * @return
	 */
	public String getOrigTitle() {
		return origTitle;
	}

	public void setOrigTitle(String origTitle) {
		this.origTitle = origTitle;
	}

	/**
	 * 个人头像
	 * @return
	 */
	public String getOrigImg() {
		return origImg;
	}

	public void setOrigImg(String origImg) {
		this.origImg = origImg;
	}

	/**
	 * 出发地
	 * @return
	 */
	public String getStartPlace() {
		return startPlace;
	}

	public void setStartPlace(String startPlace) {
		this.startPlace = startPlace;
	}

	/**
	 * 途径
	 * @return
	 */
	public String getMidPlace() {
		return midPlace;
	}

	public void setMidPlace(String midPlace) {
		this.midPlace = midPlace;
	}

	/**
	 * 目的地
	 * @return
	 */
	public String getEndPlace() {
		return endPlace;
	}

	public void setEndPlace(String endPlace) {
		this.endPlace = endPlace;
	}

	/**
	 * 参与人数
	 * @return
	 */
	public int getPartNum() {
		return partNum;
	}

	public void setPartNum(int partNum) {
		this.partNum = partNum;
	}

	/**
	 * 参与人数
	 * @return
	 */
	public int getLimitNum() {
		return limitNum;
	}

	public void setLimitNum(int limitNum) {
		this.limitNum = limitNum;
	}

	/**
	 * 出发时间
	 * @return
	 */
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * 报名截止时间
	 * @return
	 */
	public Date getPartTime() {
		return partTime;
	}

	public void setPartTime(Date partTime) {
		this.partTime = partTime;
	}

	/**
	 * 创建时间
	 * @return
	 */
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 拼车类型
	 * @return
	 */
	public int getOrigType() {
		return origType;
	}

	public void setOrigType(int origType) {
		this.origType = origType;
	}

	/**
	 * 状态
	 * @return
	 */
	public int getOrigState() {
		return origState;
	}

	public void setOrigState(int origState) {
		this.origState = origState;
	}

	/**
	 * 修改时间
	 * @return
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 *   开始时间       
	 * @return
	 */
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * 截止时间
	 * @return
	 */
	public String getPartDate() {
		return partDate;
	}

	public void setPartDate(String partDate) {
		this.partDate = partDate;
	}

	/**
	 * 创建时间
	 * @return
	 */
	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	/**
	 * 修改时间
	 * @return
	 */
	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * 个人头像
	 * @return
	 */
	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	/**
	 * 标示
	 * @return
	 */
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * 状态
	 * @return
	 */
	public String getPartState() {
		return partState;
	}

	public void setPartState(String partState) {
		this.partState = partState;
	}

	/**
	 * 车辆类型  0:自有车 1：蹭车 2：打的
	 * @return
	 */
	public int getCarType() {
		return carType;
	}

	public void setCarType(int carType) {
		this.carType = carType;
	}
	/**
	 * 费用类型  0:免费 1：有偿
	 * @return
	 */
	public int getPayType() {
		return payType;
	}

	public void setPayType(int payType) {
		this.payType = payType;
	}
	/**
	 * 费用金额 费用金额，整数值
	 * @return
	 */
	public int getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(int payMoney) {
		this.payMoney = payMoney;
	}

	
	
}
