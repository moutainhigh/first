package com.deppon.foss.module.sync.business.jms;

import java.util.List;

/**
 * 明细信息实体类
 * 
 * @author JFeng
 */
public class DetailInfoEntity {
	/**
	 * 单据编号(工作流ID)
	 */
	private String claimNo;

	/**
	 * get
	 * 
	 * @return
	 */
	public String getClaimNo() {
		return claimNo;
	}

	/**
	 * set
	 * 
	 * @param claimNo
	 */
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}

	/**
	 * 明细行Id
	 */
	private String claimLineId;

	/**
	 * 费用类型编码
	 */
	private String scNo;

	/**
	 * 费用类型
	 */
	private String scName;

	/**
	 * 航班订单信息对象
	 */
	private FlightOrderInfoEntity flightOrderInfo;

	/**
	 * 酒店订单信息对象
	 */
	private HotelOrderInfoEntity hotelOrderInfo;

	/**
	 * 航班订单信息列表
	 */
	private List<FlightOrderInfoEntity> flightOrderInfoEntity;

	/**
	 * 酒店订单信息列表
	 */
	private List<HotelOrderInfoEntity> hotelOrderInfoList;

	/**
	 * get
	 * 
	 * @return
	 */
	public FlightOrderInfoEntity getFlightOrderInfo() {
		return flightOrderInfo;
	}

	/**
	 * set
	 * 
	 * @param flightOrderInfo
	 */
	public void setFlightOrderInfo(FlightOrderInfoEntity flightOrderInfo) {
		this.flightOrderInfo = flightOrderInfo;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public HotelOrderInfoEntity getHotelOrderInfo() {
		return hotelOrderInfo;
	}

	/**
	 * set
	 * 
	 * @param hotelOrderInfo
	 */
	public void setHotelOrderInfo(HotelOrderInfoEntity hotelOrderInfo) {
		this.hotelOrderInfo = hotelOrderInfo;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public List<FlightOrderInfoEntity> getFlightOrderInfoEntity() {
		return flightOrderInfoEntity;
	}

	/**
	 * set
	 * 
	 * @param flightOrderInfoEntity
	 */
	public void setFlightOrderInfoEntity(
			List<FlightOrderInfoEntity> flightOrderInfoEntity) {
		this.flightOrderInfoEntity = flightOrderInfoEntity;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public List<HotelOrderInfoEntity> getHotelOrderInfoList() {
		return hotelOrderInfoList;
	}

	/**
	 * set
	 * 
	 * @param hotelOrderInfoList
	 */
	public void setHotelOrderInfoList(
			List<HotelOrderInfoEntity> hotelOrderInfoList) {
		this.hotelOrderInfoList = hotelOrderInfoList;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getClaimLineId() {
		return claimLineId;
	}

	/**
	 * set
	 * 
	 * @param claimLineId
	 */
	public void setClaimLineId(String claimLineId) {
		this.claimLineId = claimLineId;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getScNo() {
		return scNo;
	}

	/**
	 * set
	 * 
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}

	/**
	 * get
	 * 
	 * @return
	 */
	public String getScName() {
		return scName;
	}

	/**
	 * set
	 * 
	 * @param scName
	 */
	public void setScName(String scName) {
		this.scName = scName;
	}

}
