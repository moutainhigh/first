package com.deppon.dpm.doc.server.vo;

import java.io.Serializable;

/**
 * 订单详情VO
 * @author guzf
 *
 */
public class DidiOrderDetailVO implements Serializable {
	
	/**
	 * 构造方法
	 */
	public DidiOrderDetailVO(){
		super();
	}
	
	private static final long serialVersionUID = 1L;
	//订单号
	private String id;
	//订单改派信息
	private Reassign_InfoVO reassign_info;
	//当前状态是否排队，(0:否，1:是)
	private int is_lineup;
	//排队信息。若当前时间没有排队，则不存在此信息集合
	private Lineup_InfoVO lineup_info;
	//订单状态码
	private int status;
	//订单详细状态码
	private int sub_status;
	//城市id
	private int city;
	//订单类型(0:实时、1:预约)
	private int type;
	//乘车人手机号
	private String passenger_phone;
	//司机称呼
	private String driver_name;
	//号码保护中间号（如无号码保护，为司机真实手机号
	private String driver_phone;
	//司机真实手机号
	private String driver_phone_real;
	//已通知司机数量
	private int driver_num;
	//司机车型
	private String driver_car_type;
	//车辆颜色
	private String driver_car_color;
	//司机车牌
	private String driver_card;
	//司机头像
	private String driver_avatar;
	//司机抢单数
	private int driver_order_count;
	//司机星级
	private float driver_level;
	//司机当前实时经度
	private float dlng;
	//司机当前实时维度
	private float dlat;
	//乘客发单时位置经度
	private float clng;
	//乘客发单时位置维度
	private float clat;
	//出发经度
	private float flng;
	//出发维度
	private float flat;
	//目的地经度
	private float tlng;
	//目的地维度
	private float tlat;
	//扩展信息
	private String extra_info;
	//出发地名称
	private String start_name;
	//出发地详细地址
	private String start_address;
	//目的地名称
	private String end_name;
	//目的地详细地址
	private String end_address;
	//出发时间
	private String departure_time;
	//下单时间
	private String order_time;
	//司机接单时间
	private String strive_time;
	//开始计价时间
	private String begin_charge_time;
	//行程结束时间
	private String finish_time;
	//迟到计费时间
	private String delay_time_start;
	//实际行驶公里数
	private String normal_distance;
	//实际行驶时长（分钟）
	private String normal_time;
	//用车类型（100舒适型，400六座商务, 200行政级,600普通快车,900优享快车）
	private int require_level;
	//叫单车型（100舒适型，400六座商务, 200行政级,600普通快车,900优享快车）
	private int strive_level;
	//计价模式：0-普通计价 1-一口价 默认为0
	private int pricing_mode;
	private Object callback_info;
	private String remark;
	
	//是否拼车，0-不拼车，1-拼车
	private int is_carpool;
	
	//是否拼车成功,0-未成功，1-成功
	private int is_carpool_success;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the reassign_info
	 */
	public Reassign_InfoVO getReassign_info() {
		return reassign_info;
	}
	/**
	 * @param reassign_info the reassign_info to set
	 */
	public void setReassign_info(Reassign_InfoVO reassign_info) {
		this.reassign_info = reassign_info;
	}
	/**
	 * @return the is_lineup
	 */
	public int getIs_lineup() {
		return is_lineup;
	}
	/**
	 * @param is_lineup the is_lineup to set
	 */
	public void setIs_lineup(int is_lineup) {
		this.is_lineup = is_lineup;
	}
	/**
	 * @return the lineup_info
	 */
	public Lineup_InfoVO getLineup_info() {
		return lineup_info;
	}
	/**
	 * @param lineup_info the lineup_info to set
	 */
	public void setLineup_info(Lineup_InfoVO lineup_info) {
		this.lineup_info = lineup_info;
	}
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * @return the sub_status
	 */
	public int getSub_status() {
		return sub_status;
	}
	/**
	 * @param sub_status the sub_status to set
	 */
	public void setSub_status(int sub_status) {
		this.sub_status = sub_status;
	}
	/**
	 * @return the city
	 */
	public int getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(int city) {
		this.city = city;
	}
	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
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
	 * @return the driver_name
	 */
	public String getDriver_name() {
		return driver_name;
	}
	/**
	 * @param driver_name the driver_name to set
	 */
	public void setDriver_name(String driver_name) {
		this.driver_name = driver_name;
	}
	/**
	 * @return the driver_phone
	 */
	public String getDriver_phone() {
		return driver_phone;
	}
	/**
	 * @param driver_phone the driver_phone to set
	 */
	public void setDriver_phone(String driver_phone) {
		this.driver_phone = driver_phone;
	}
	/**
	 * @return the driver_phone_real
	 */
	public String getDriver_phone_real() {
		return driver_phone_real;
	}
	/**
	 * @param driver_phone_real the driver_phone_real to set
	 */
	public void setDriver_phone_real(String driver_phone_real) {
		this.driver_phone_real = driver_phone_real;
	}
	/**
	 * @return the driver_num
	 */
	public int getDriver_num() {
		return driver_num;
	}
	/**
	 * @param driver_num the driver_num to set
	 */
	public void setDriver_num(int driver_num) {
		this.driver_num = driver_num;
	}
	/**
	 * @return the driver_car_type
	 */
	public String getDriver_car_type() {
		return driver_car_type;
	}
	/**
	 * @param driver_car_type the driver_car_type to set
	 */
	public void setDriver_car_type(String driver_car_type) {
		this.driver_car_type = driver_car_type;
	}
	/**
	 * @return the driver_car_color
	 */
	public String getDriver_car_color() {
		return driver_car_color;
	}
	/**
	 * @param driver_car_color the driver_car_color to set
	 */
	public void setDriver_car_color(String driver_car_color) {
		this.driver_car_color = driver_car_color;
	}
	/**
	 * @return the driver_card
	 */
	public String getDriver_card() {
		return driver_card;
	}
	/**
	 * @param driver_card the driver_card to set
	 */
	public void setDriver_card(String driver_card) {
		this.driver_card = driver_card;
	}
	/**
	 * @return the driver_avatar
	 */
	public String getDriver_avatar() {
		return driver_avatar;
	}
	/**
	 * @param driver_avatar the driver_avatar to set
	 */
	public void setDriver_avatar(String driver_avatar) {
		this.driver_avatar = driver_avatar;
	}
	/**
	 * @return the driver_order_count
	 */
	public int getDriver_order_count() {
		return driver_order_count;
	}
	/**
	 * @param driver_order_count the driver_order_count to set
	 */
	public void setDriver_order_count(int driver_order_count) {
		this.driver_order_count = driver_order_count;
	}
	/**
	 * @return the driver_level
	 */
	public float getDriver_level() {
		return driver_level;
	}
	/**
	 * @param driver_level the driver_level to set
	 */
	public void setDriver_level(float driver_level) {
		this.driver_level = driver_level;
	}
	/**
	 * @return the dlng
	 */
	public float getDlng() {
		return dlng;
	}
	/**
	 * @param dlng the dlng to set
	 */
	public void setDlng(float dlng) {
		this.dlng = dlng;
	}
	/**
	 * @return the dlat
	 */
	public float getDlat() {
		return dlat;
	}
	/**
	 * @param dlat the dlat to set
	 */
	public void setDlat(float dlat) {
		this.dlat = dlat;
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
	 * @return the extra_info
	 */
	public String getExtra_info() {
		return extra_info;
	}
	/**
	 * @param extra_info the extra_info to set
	 */
	public void setExtra_info(String extra_info) {
		this.extra_info = extra_info;
	}
	/**
	 * @return the start_name
	 */
	public String getStart_name() {
		return start_name;
	}
	/**
	 * @param start_name the start_name to set
	 */
	public void setStart_name(String start_name) {
		this.start_name = start_name;
	}
	/**
	 * @return the start_address
	 */
	public String getStart_address() {
		return start_address;
	}
	/**
	 * @param start_address the start_address to set
	 */
	public void setStart_address(String start_address) {
		this.start_address = start_address;
	}
	/**
	 * @return the end_name
	 */
	public String getEnd_name() {
		return end_name;
	}
	/**
	 * @param end_name the end_name to set
	 */
	public void setEnd_name(String end_name) {
		this.end_name = end_name;
	}
	/**
	 * @return the end_address
	 */
	public String getEnd_address() {
		return end_address;
	}
	/**
	 * @param end_address the end_address to set
	 */
	public void setEnd_address(String end_address) {
		this.end_address = end_address;
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
	 * @return the order_time
	 */
	public String getOrder_time() {
		return order_time;
	}
	/**
	 * @param order_time the order_time to set
	 */
	public void setOrder_time(String order_time) {
		this.order_time = order_time;
	}
	/**
	 * @return the strive_time
	 */
	public String getStrive_time() {
		return strive_time;
	}
	/**
	 * @param strive_time the strive_time to set
	 */
	public void setStrive_time(String strive_time) {
		this.strive_time = strive_time;
	}
	/**
	 * @return the begin_charge_time
	 */
	public String getBegin_charge_time() {
		return begin_charge_time;
	}
	/**
	 * @param begin_charge_time the begin_charge_time to set
	 */
	public void setBegin_charge_time(String begin_charge_time) {
		this.begin_charge_time = begin_charge_time;
	}
	/**
	 * @return the finish_time
	 */
	public String getFinish_time() {
		return finish_time;
	}
	/**
	 * @param finish_time the finish_time to set
	 */
	public void setFinish_time(String finish_time) {
		this.finish_time = finish_time;
	}
	/**
	 * @return the delay_time_start
	 */
	public String getDelay_time_start() {
		return delay_time_start;
	}
	/**
	 * @param delay_time_start the delay_time_start to set
	 */
	public void setDelay_time_start(String delay_time_start) {
		this.delay_time_start = delay_time_start;
	}
	/**
	 * @return the normal_distance
	 */
	public String getNormal_distance() {
		return normal_distance;
	}
	/**
	 * @param normal_distance the normal_distance to set
	 */
	public void setNormal_distance(String normal_distance) {
		this.normal_distance = normal_distance;
	}
	/**
	 * @return the normal_time
	 */
	public String getNormal_time() {
		return normal_time;
	}
	/**
	 * @param normal_time the normal_time to set
	 */
	public void setNormal_time(String normal_time) {
		this.normal_time = normal_time;
	}
	/**
	 * @return the require_level
	 */
	public int getRequire_level() {
		return require_level;
	}
	/**
	 * @param require_level the require_level to set
	 */
	public void setRequire_level(int require_level) {
		this.require_level = require_level;
	}
	/**
	 * @return the strive_level
	 */
	public int getStrive_level() {
		return strive_level;
	}
	/**
	 * @param strive_level the strive_level to set
	 */
	public void setStrive_level(int strive_level) {
		this.strive_level = strive_level;
	}
	/**
	 * @return the pricing_mode
	 */
	public int getPricing_mode() {
		return pricing_mode;
	}
	/**
	 * @param pricing_mode the pricing_mode to set
	 */
	public void setPricing_mode(int pricing_mode) {
		this.pricing_mode = pricing_mode;
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
	public int getIs_carpool() {
		return is_carpool;
	}
	public void setIs_carpool(int is_carpool) {
		this.is_carpool = is_carpool;
	}
	public int getIs_carpool_success() {
		return is_carpool_success;
	}
	public void setIs_carpool_success(int is_carpool_success) {
		this.is_carpool_success = is_carpool_success;
	}
	
	
	
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public Reassign_InfoVO getReassign_info() {
//		return reassign_info;
//	}
//	public void setReassign_info(Reassign_InfoVO reassign_info) {
//		this.reassign_info = reassign_info;
//	}
//	public int getIs_lineup() {
//		return is_lineup;
//	}
//	public void setIs_lineup(int is_lineup) {
//		this.is_lineup = is_lineup;
//	}
//	public Lineup_InfoVO getLineup_info() {
//		return lineup_info;
//	}
//	public void setLineup_info(Lineup_InfoVO lineup_info) {
//		this.lineup_info = lineup_info;
//	}
//	public int getStatus() {
//		return status;
//	}
//	public void setStatus(int status) {
//		this.status = status;
//	}
//	public int getSub_status() {
//		return sub_status;
//	}
//	public void setSub_status(int sub_status) {
//		this.sub_status = sub_status;
//	}
//	public int getCity() {
//		return city;
//	}
//	public void setCity(int city) {
//		this.city = city;
//	}
//	public int getType() {
//		return type;
//	}
//	public void setType(int type) {
//		this.type = type;
//	}
//	public String getPassenger_phone() {
//		return passenger_phone;
//	}
//	public void setPassenger_phone(String passenger_phone) {
//		this.passenger_phone = passenger_phone;
//	}
//	public String getDriver_name() {
//		return driver_name;
//	}
//	public void setDriver_name(String driver_name) {
//		this.driver_name = driver_name;
//	}
//	public String getDriver_phone() {
//		return driver_phone;
//	}
//	public void setDriver_phone(String driver_phone) {
//		this.driver_phone = driver_phone;
//	}
//	public String getDriver_phone_real() {
//		return driver_phone_real;
//	}
//	public void setDriver_phone_real(String driver_phone_real) {
//		this.driver_phone_real = driver_phone_real;
//	}
//	public int getDriver_num() {
//		return driver_num;
//	}
//	public void setDriver_num(int driver_num) {
//		this.driver_num = driver_num;
//	}
//	public String getDriver_car_type() {
//		return driver_car_type;
//	}
//	public void setDriver_car_type(String driver_car_type) {
//		this.driver_car_type = driver_car_type;
//	}
//	public String getDriver_car_color() {
//		return driver_car_color;
//	}
//	public void setDriver_car_color(String driver_car_color) {
//		this.driver_car_color = driver_car_color;
//	}
//	public String getDriver_card() {
//		return driver_card;
//	}
//	public void setDriver_card(String driver_card) {
//		this.driver_card = driver_card;
//	}
//	public String getDriver_avatar() {
//		return driver_avatar;
//	}
//	public void setDriver_avatar(String driver_avatar) {
//		this.driver_avatar = driver_avatar;
//	}
//	public int getDriver_order_count() {
//		return driver_order_count;
//	}
//	public void setDriver_order_count(int driver_order_count) {
//		this.driver_order_count = driver_order_count;
//	}
//	public float getDriver_level() {
//		return driver_level;
//	}
//	public void setDriver_level(float driver_level) {
//		this.driver_level = driver_level;
//	}
//	public float getDlng() {
//		return dlng;
//	}
//	public void setDlng(float dlng) {
//		this.dlng = dlng;
//	}
//	public float getDlat() {
//		return dlat;
//	}
//	public void setDlat(float dlat) {
//		this.dlat = dlat;
//	}
//	public float getClng() {
//		return clng;
//	}
//	public void setClng(float clng) {
//		this.clng = clng;
//	}
//	public float getClat() {
//		return clat;
//	}
//	public void setClat(float clat) {
//		this.clat = clat;
//	}
//	public float getFlng() {
//		return flng;
//	}
//	public void setFlng(float flng) {
//		this.flng = flng;
//	}
//	public float getFlat() {
//		return flat;
//	}
//	public void setFlat(float flat) {
//		this.flat = flat;
//	}
//	public float getTlng() {
//		return tlng;
//	}
//	public void setTlng(float tlng) {
//		this.tlng = tlng;
//	}
//	public float getTlat() {
//		return tlat;
//	}
//	public void setTlat(float tlat) {
//		this.tlat = tlat;
//	}
//	public String getExtra_info() {
//		return extra_info;
//	}
//	public void setExtra_info(String extra_info) {
//		this.extra_info = extra_info;
//	}
//	public String getStart_name() {
//		return start_name;
//	}
//	public void setStart_name(String start_name) {
//		this.start_name = start_name;
//	}
//	public String getStart_address() {
//		return start_address;
//	}
//	public void setStart_address(String start_address) {
//		this.start_address = start_address;
//	}
//	public String getEnd_name() {
//		return end_name;
//	}
//	public void setEnd_name(String end_name) {
//		this.end_name = end_name;
//	}
//	public String getEnd_address() {
//		return end_address;
//	}
//	public void setEnd_address(String end_address) {
//		this.end_address = end_address;
//	}
//	public String getDeparture_time() {
//		return departure_time;
//	}
//	public void setDeparture_time(String departure_time) {
//		this.departure_time = departure_time;
//	}
//	public String getOrder_time() {
//		return order_time;
//	}
//	public void setOrder_time(String order_time) {
//		this.order_time = order_time;
//	}
//	public String getStrive_time() {
//		return strive_time;
//	}
//	public void setStrive_time(String strive_time) {
//		this.strive_time = strive_time;
//	}
//	public String getBegin_charge_time() {
//		return begin_charge_time;
//	}
//	public void setBegin_charge_time(String begin_charge_time) {
//		this.begin_charge_time = begin_charge_time;
//	}
//	public String getFinish_time() {
//		return finish_time;
//	}
//	public void setFinish_time(String finish_time) {
//		this.finish_time = finish_time;
//	}
//	public String getDelay_time_start() {
//		return delay_time_start;
//	}
//	public void setDelay_time_start(String delay_time_start) {
//		this.delay_time_start = delay_time_start;
//	}
//	public String getNormal_distance() {
//		return normal_distance;
//	}
//	public void setNormal_distance(String normal_distance) {
//		this.normal_distance = normal_distance;
//	}
//	public String getNormal_time() {
//		return normal_time;
//	}
//	public void setNormal_time(String normal_time) {
//		this.normal_time = normal_time;
//	}
//	public int getRequire_level() {
//		return require_level;
//	}
//	public void setRequire_level(int require_level) {
//		this.require_level = require_level;
//	}
//	public int getStrive_level() {
//		return strive_level;
//	}
//	public void setStrive_level(int strive_level) {
//		this.strive_level = strive_level; 
//	}
//	public int getPricing_mode() {
//		return pricing_mode;
//	}
//	public void setPricing_mode(int pricing_mode) {
//		this.pricing_mode = pricing_mode;
//	}
//	public Object getCallback_info() {
//		return callback_info;
//	}
//	public void setCallback_info(Object callback_info) {
//		this.callback_info = callback_info;
//	}
//	public String getRemark() {
//		return remark;
//	}
//	public void setRemark(String remark) {
//		this.remark = remark;
//	}
	
}
