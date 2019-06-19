package com.deppon.dpm.doc.server.vo;

import java.io.Serializable;

public class DidiTicketItemVO implements Serializable {

	
	/**
	 * 构造方法
	 */
	public DidiTicketItemVO(){
		super();
	}
	
	private static final long serialVersionUID = 1L;
	/**
	 * yes 申请应用时分配的client_id
	 */
	private String client_id;
	/**
	 * yes 申请应用时分配的client_secret
	 */
	private String client_secret;
	/**
	 * yes 管理员手机号（作为统一叫车人）
	 */
	private String master_phone;
	/**
	 * yes 乘客手机号(当前用户)
	 */
	private String passenger_phone;
	/**
	 * yes 授权类型：0-非发单（无发单权限）；1-发单（有发单权限及其他所有权限）； ；
	 */
	private int auth_type;
	/**
	 * int no 滴滴订单ID（传该值，跳转到指定订单详情页面；不传值，则进入个人中心通用页面）
	 */
	private String order_id;
	/**
	 * no 用车城市，如不传，则不限制城市；传了城市ID，限制本次叫车只允许在该城市发单；
	 */
	private int city_id;
	/**
	 * no 是否禁止跨城（出发地和目的地不在同一城市）：0-否，1-是，默认0
	 */
	private int forbid_city_cross;
	/**
	 * no 允许可选车型，不传则不限制可选车型
	 */
	private String require_level_list;
	/**
	 * no 当前位置纬度（建议接入方从端获取当前位置，并转换为腾讯地图坐标），提升用户发单体验
	 */
	private float clat;
	/**
	 * no 当前位置经度（建议接入方从端获取当前位置，并转换为腾讯地图坐标），提升用户发单体验
	 */
	private float clng;
	/**
	 * no 是否限制出发地（0-否，1-是；默认0）
	 */
	private int restrict_from_point;
	/**
	 * no 出发地名称
	 */
	private String from_name;
	/**
	 * no 出发地纬度
	 */
	private float flat;
	/**
	 * no 出发地经度
	 */
	private float flng;
	/**
	 * no 是否限制目的地（0-否，1-是；默认0）
	 */
	private int restrict_to_point;
	/**
	 * no 目的地名称
	 */
	private String to_name;
	/**
	 * 备注
	 */
	private String remark;
	
	
	public String getTo_name() {
		return to_name;
	}
	public void setTo_name(String to_name) {
		this.to_name = to_name;
	}
	

	/**
	 * @return the order_id
	 */
	public String getOrder_id() {
		return order_id;
	}
	/**
	 * @param order_id the order_id to set
	 */
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	/**
	 * no 目的地纬度
	 */
	private float tlat;
	/**
	 * no 目的地经度
	 */
	private float tlng;
	/**
	 * no 出发时间，格式：2017-09-20
	 * 21:00:00，出发时间大于当前20分钟，发预约单；如果小于20分钟或不传该字段，发实时单。
	 */
	private String departure_time;
	
	/**
	 * yes 乘车人&用车自定义信息（信息透传），在对账单中会展示该字段
	 */
	private Object callback_info;
	/**
	 * no 员工工号
	 */
	private String employee_number;
	/**
	 * no 接入方系统的订单ID
	 */
	private String client_order_id;
	/**
	 * no 用车人组织（所属部门或分公司等）
	 */
	private String organization;
	/**
	 * no 机场ID
	 */
	private int airport_id;
	/**
	 * no 航班号
	 */
	private String flight_number;
	/**
	 * no 航班时间
	 */
	private String flight_time;
	/**
	 * @return the client_id
	 */
	public String getClient_id() {
		return client_id;
	}
	/**
	 * @param client_id the client_id to set
	 */
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	/**
	 * @return the client_secret
	 */
	public String getClient_secret() {
		return client_secret;
	}
	/**
	 * @param client_secret the client_secret to set
	 */
	public void setClient_secret(String client_secret) {
		this.client_secret = client_secret;
	}
	/**
	 * @return the master_phone
	 */
	public String getMaster_phone() {
		return master_phone;
	}
	/**
	 * @param master_phone the master_phone to set
	 */
	public void setMaster_phone(String master_phone) {
		this.master_phone = master_phone;
	}
	/**
	 * @return the passenger_phone
	 */
	public String getPassenger_phone() {
		return passenger_phone;
	}
	/**
	 * @param passenger_phone the passenger_phone to set
	 */
	public void setPassenger_phone(String passenger_phone) {
		this.passenger_phone = passenger_phone;
	}
	/**
	 * @return the auth_type
	 */
	public int getAuth_type() {
		return auth_type;
	}
	/**
	 * @param auth_type the auth_type to set
	 */
	public void setAuth_type(int auth_type) {
		this.auth_type = auth_type;
	}
	/**
	 * @return the city_id
	 */
	public int getCity_id() {
		return city_id;
	}
	/**
	 * @param city_id the city_id to set
	 */
	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}
	/**
	 * @return the forbid_city_cross
	 */
	public int getForbid_city_cross() {
		return forbid_city_cross;
	}
	/**
	 * @param forbid_city_cross the forbid_city_cross to set
	 */
	public void setForbid_city_cross(int forbid_city_cross) {
		this.forbid_city_cross = forbid_city_cross;
	}
	/**
	 * @return the require_level_list
	 */
	public String getRequire_level_list() {
		return require_level_list;
	}
	/**
	 * @param require_level_list the require_level_list to set
	 */
	public void setRequire_level_list(String require_level_list) {
		this.require_level_list = require_level_list;
	}
	/**
	 * @return the clat
	 */
	public float getClat() {
		return clat;
	}
	/**
	 * @param clat the clat to set
	 */
	public void setClat(float clat) {
		this.clat = clat;
	}
	/**
	 * @return the clng
	 */
	public float getClng() {
		return clng;
	}
	/**
	 * @param clng the clng to set
	 */
	public void setClng(float clng) {
		this.clng = clng;
	}
	/**
	 * @return the restrict_from_point
	 */
	public int getRestrict_from_point() {
		return restrict_from_point;
	}
	/**
	 * @param restrict_from_point the restrict_from_point to set
	 */
	public void setRestrict_from_point(int restrict_from_point) {
		this.restrict_from_point = restrict_from_point;
	}
	/**
	 * @return the from_name
	 */
	public String getFrom_name() {
		return from_name;
	}
	/**
	 * @param from_name the from_name to set
	 */
	public void setFrom_name(String from_name) {
		this.from_name = from_name;
	}
	/**
	 * @return the flat
	 */
	public float getFlat() {
		return flat;
	}
	/**
	 * @param flat the flat to set
	 */
	public void setFlat(float flat) {
		this.flat = flat;
	}
	/**
	 * @return the flng
	 */
	public float getFlng() {
		return flng;
	}
	/**
	 * @param flng the flng to set
	 */
	public void setFlng(float flng) {
		this.flng = flng;
	}
	/**
	 * @return the restrict_to_point
	 */
	public int getRestrict_to_point() {
		return restrict_to_point;
	}
	/**
	 * @param restrict_to_point the restrict_to_point to set
	 */
	public void setRestrict_to_point(int restrict_to_point) {
		this.restrict_to_point = restrict_to_point;
	}
	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * @return the tlat
	 */
	public float getTlat() {
		return tlat;
	}
	/**
	 * @param tlat the tlat to set
	 */
	public void setTlat(float tlat) {
		this.tlat = tlat;
	}
	/**
	 * @return the tlng
	 */
	public float getTlng() {
		return tlng;
	}
	/**
	 * @param tlng the tlng to set
	 */
	public void setTlng(float tlng) {
		this.tlng = tlng;
	}
	/**
	 * @return the departure_time
	 */
	public String getDeparture_time() {
		return departure_time;
	}
	/**
	 * @param departure_time the departure_time to set
	 */
	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}
	/**
	 * @return the callback_info
	 */
	public Object getCallback_info() {
		return callback_info;
	}
	/**
	 * @param callback_info the callback_info to set
	 */
	public void setCallback_info(Object callback_info) {
		this.callback_info = callback_info;
	}
	/**
	 * @return the employee_number
	 */
	public String getEmployee_number() {
		return employee_number;
	}
	/**
	 * @param employee_number the employee_number to set
	 */
	public void setEmployee_number(String employee_number) {
		this.employee_number = employee_number;
	}
	/**
	 * @return the client_order_id
	 */
	public String getClient_order_id() {
		return client_order_id;
	}
	/**
	 * @param client_order_id the client_order_id to set
	 */
	public void setClient_order_id(String client_order_id) {
		this.client_order_id = client_order_id;
	}
	/**
	 * @return the organization
	 */
	public String getOrganization() {
		return organization;
	}
	/**
	 * @param organization the organization to set
	 */
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	/**
	 * @return the airport_id
	 */
	public int getAirport_id() {
		return airport_id;
	}
	/**
	 * @param airport_id the airport_id to set
	 */
	public void setAirport_id(int airport_id) {
		this.airport_id = airport_id;
	}
	/**
	 * @return the flight_number
	 */
	public String getFlight_number() {
		return flight_number;
	}
	/**
	 * @param flight_number the flight_number to set
	 */
	public void setFlight_number(String flight_number) {
		this.flight_number = flight_number;
	}
	/**
	 * @return the flight_time
	 */
	public String getFlight_time() {
		return flight_time;
	}
	/**
	 * @param flight_time the flight_time to set
	 */
	public void setFlight_time(String flight_time) {
		this.flight_time = flight_time;
	}

	
	
	
//	public String getClient_id() {
//		return client_id;
//	}
//	public void setClient_id(String client_id) {
//		this.client_id = client_id;
//	}
//	public String getClient_secret() {
//		return client_secret;
//	}
//	public void setClient_secret(String client_secret) {
//		this.client_secret = client_secret;
//	}
//	public String getMaster_phone() {
//		return master_phone;
//	}
//	public void setMaster_phone(String master_phone) {
//		this.master_phone = master_phone;
//	}
//	public String getPassenger_phone() {
//		return passenger_phone;
//	}
//	public void setPassenger_phone(String passenger_phone) {
//		this.passenger_phone = passenger_phone;
//	}
//	public int getAuth_type() {
//		return auth_type;
//	}
//	public void setAuth_type(int auth_type) {
//		this.auth_type = auth_type;
//	}
//	public int getCity_id() {
//		return city_id;
//	}
//	public void setCity_id(int city_id) {
//		this.city_id = city_id;
//	}
//	public int getForbid_city_cross() {
//		return forbid_city_cross;
//	}
//	public void setForbid_city_cross(int forbid_city_cross) {
//		this.forbid_city_cross = forbid_city_cross;
//	}
//	public String getRequire_level_list() {
//		return require_level_list;
//	}
//	public void setRequire_level_list(String require_level_list) {
//		this.require_level_list = require_level_list;
//	}
//	public float getClat() {
//		return clat;
//	}
//	public void setClat(float clat) {
//		this.clat = clat;
//	}
//	public float getClng() {
//		return clng;
//	}
//	public void setClng(float clng) {
//		this.clng = clng;
//	}
//	public int getRestrict_from_point() {
//		return restrict_from_point;
//	}
//	public void setRestrict_from_point(int restrict_from_point) {
//		this.restrict_from_point = restrict_from_point;
//	}
//	public String getFrom_name() {
//		return from_name;
//	}
//	public void setFrom_name(String from_name) {
//		this.from_name = from_name;
//	}
//	public float getFlat() {
//		return flat;
//	}
//	public void setFlat(float flat) {
//		this.flat = flat;
//	}
//	public float getFlng() {
//		return flng;
//	}
//	public void setFlng(float flng) {
//		this.flng = flng;
//	}
//	public int getRestrict_to_point() {
//		return restrict_to_point;
//	}
//	public void setRestrict_to_point(int restrict_to_point) {
//		this.restrict_to_point = restrict_to_point;
//	}
//	public float getTlat() {
//		return tlat;
//	}
//	public void setTlat(float tlat) {
//		this.tlat = tlat;
//	}
//	public float getTlng() {
//		return tlng;
//	}
//	public void setTlng(float tlng) {
//		this.tlng = tlng;
//	}
//	public String getDeparture_time() {
//		return departure_time;
//	}
//	public void setDeparture_time(String departure_time) {
//		this.departure_time = departure_time;
//	}
//	public Object getCallback_info() {
//		return callback_info;
//	}
//	public void setCallback_info(Object callback_info) {
//		this.callback_info = callback_info;
//	}
//	public String getEmployee_number() {
//		return employee_number;
//	}
//	public void setEmployee_number(String employee_number) {
//		this.employee_number = employee_number;
//	}
//	public String getClient_order_id() {
//		return client_order_id;
//	}
//	public void setClient_order_id(String client_order_id) {
//		this.client_order_id = client_order_id;
//	}
//	public String getOrganization() {
//		return organization;
//	}
//	public void setOrganization(String organization) {
//		this.organization = organization;
//	}
//	public int getAirport_id() {
//		return airport_id;
//	}
//	public void setAirport_id(int airport_id) {
//		this.airport_id = airport_id;
//	}
//	public String getFlight_number() {
//		return flight_number;
//	}
//	public void setFlight_number(String flight_number) {
//		this.flight_number = flight_number;
//	}
//	public String getFlight_time() {
//		return flight_time;
//	}
//	public void setFlight_time(String flight_time) {
//		this.flight_time = flight_time;
//	}
//	public String getRemark() {
//		return remark;
//	}
//	public void setRemark(String remark) {
//		this.remark = remark; 
//	}
	
	

}
