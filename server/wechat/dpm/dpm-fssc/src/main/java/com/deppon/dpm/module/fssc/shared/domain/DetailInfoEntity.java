package com.deppon.dpm.module.fssc.shared.domain;

import java.util.List;

/**
 * 明细信息实体类
 * @author JFeng
 */
public class DetailInfoEntity {
	/**
	 * 单据编号(工作流ID)
	 */
	private String claimNo;
	
	
	/**
	 * @return  单据编号(工作流ID)
	 */
	public String getClaimNo() {
		return claimNo;
	}

	/**
	 * @param claimNo  单据编号(工作流ID)
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
	 * @return 航班订单信息对象
	 */
	public FlightOrderInfoEntity getFlightOrderInfo() {
		return flightOrderInfo;
	}

	/**
	 * @param flightOrderInfo 航班订单信息对象
	 */
	public void setFlightOrderInfo(FlightOrderInfoEntity flightOrderInfo) {
		this.flightOrderInfo = flightOrderInfo;
	}

	/**
	 * @return 酒店订单信息对象
	 */
	public HotelOrderInfoEntity getHotelOrderInfo() {
		return hotelOrderInfo;
	}

	/**
	 * @param hotelOrderInfo 酒店订单信息对象
	 */
	public void setHotelOrderInfo(HotelOrderInfoEntity hotelOrderInfo) {
		this.hotelOrderInfo = hotelOrderInfo;
	}

	/**
	 * @return 航班订单信息列表
	 */
	public List<FlightOrderInfoEntity> getFlightOrderInfoEntity() {
		return flightOrderInfoEntity;
	}

	/**
	 * @param flightOrderInfoEntity 航班订单信息列表
	 */
	public void setFlightOrderInfoEntity(
			List<FlightOrderInfoEntity> flightOrderInfoEntity) {
		this.flightOrderInfoEntity = flightOrderInfoEntity;
	}

	/**
	 * @return 酒店订单信息列表
	 */
	public List<HotelOrderInfoEntity> getHotelOrderInfoList() {
		return hotelOrderInfoList;
	}

	/**
	 * @param hotelOrderInfoList 酒店订单信息列表
	 */
	public void setHotelOrderInfoList(List<HotelOrderInfoEntity> hotelOrderInfoList) {
		this.hotelOrderInfoList = hotelOrderInfoList;
	}

	/**
	 * @return 明细行Id
	 */
	public String getClaimLineId() {
		return claimLineId;
	}

	/**
	 * @param claimLineId 明细行Id
	 */
	public void setClaimLineId(String claimLineId) {
		this.claimLineId = claimLineId;
	}

	/**
	 * @return 费用类型编码
	 */
	public String getScNo() {
		return scNo;
	}

	/**
	 * @param scNo 费用类型编码
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}

	/**
	 * @return 费用类型
	 */
	public String getScName() {
		return scName;
	}

	/**
	 * @param scName 费用类型
	 */
	public void setScName(String scName) {
		this.scName = scName;
	}
	
}
