package com.deppon.dpm.doc.server.entity;

/**
 * 返款实体类
 * @author Administrator
 *
 */
public class DiDiCashBackEntity {
	/**
	 * 构造方法
	 */
	public DiDiCashBackEntity(){
		super();
	}
	
	//pk
    private Integer id ;
    //行程单号
    private String order_id ;
    //叫单时间
    private String create_time;
    //用车方式 
    private String use_car_type;
    // 车型
    private String require_level;
    //城市ID 
    private String city;
    //城市名称
    private String city_name;
    // 出发地地址
    private String start_name;
    //目的地地址
    private String end_name;
    //出发时间 
    private String departure_time;
    //结束计价时间
    private String finish_time;
    //订单状态（2-已支付 3-已退款 4-已取消 7-部分退款）
    private Integer status;
    //支付方式（0企业支付 1个人垫付 2混合支付）
    private Integer pay_type;
    //员工在滴滴企业的ID（同员工新增接口中返回的id） 
    private String member_id;
    //支付时间 
    private String pay_time;
    //打车总里程
    private String normal_distance ;
    //费用
    private float total_price ;
    //实付金额（总金额-券抵扣金额）
    private float actual_price ;
    //退款金额
    private float refund_price ;
    //公司支付金额 
    private float company_pay ;
    //公司出行卡支付金额
    private float company_card_pay ;
    //个人支付金额
    private float personal_pay ;
    //公司实付金额 
    private float company_real_pay ;
    //个人实付金额
    private float personal_real_pay ;
    //公司实际退款金额 
    private float company_real_refund ;
    //个人实际退款金额
    private float personal_real_refund ;
    //报销开票状态（1：开过 0：未开） 
    private Integer is_invoice;
    //叫车人手机号 
    private String call_phone;
    //乘车人手机号 
    private String passenger_phone;
    //成本中心ID 
    private String budget_center_id;
    //费用科目ID 
    private String budget_item_id;
    //用车规则ID 
    private String use_car_config_id;
    //订单来源(0-Web 1-滴滴出行App 2-H5 3-OpenAPI 4-企业APP 5-邀约券 6-SDK) 
    private Integer order_source;
    // 是否拼车(0-不是 1-是)
    private Integer is_carpool;
    //价格加密信息 
    private String encrypted_info;
    //滴滴内部审批单ID 
    private String approval_id;
    //接入方内部审批单ID 
    private String out_approval_id;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @return the order_id
	 */
	public String getOrder_id() {
		return order_id;
	}
	/**
	 * @return the create_time
	 */
	public String getCreate_time() {
		return create_time;
	}
	/**
	 * @return the use_car_type
	 */
	public String getUse_car_type() {
		return use_car_type;
	}
	/**
	 * @return the require_level
	 */
	public String getRequire_level() {
		return require_level;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @return the city_name
	 */
	public String getCity_name() {
		return city_name;
	}
	/**
	 * @return the start_name
	 */
	public String getStart_name() {
		return start_name;
	}
	/**
	 * @return the end_name
	 */
	public String getEnd_name() {
		return end_name;
	}
	/**
	 * @return the departure_time
	 */
	public String getDeparture_time() {
		return departure_time;
	}
	/**
	 * @return the finish_time
	 */
	public String getFinish_time() {
		return finish_time;
	}
	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * @return the pay_type
	 */
	public Integer getPay_type() {
		return pay_type;
	}
	/**
	 * @return the member_id
	 */
	public String getMember_id() {
		return member_id;
	}
	/**
	 * @return the pay_time
	 */
	public String getPay_time() {
		return pay_time;
	}
	/**
	 * @return the normal_distance
	 */
	public String getNormal_distance() {
		return normal_distance;
	}
	/**
	 * @return the total_price
	 */
	public float getTotal_price() {
		return total_price;
	}
	/**
	 * @return the actual_price
	 */
	public float getActual_price() {
		return actual_price;
	}
	/**
	 * @return the refund_price
	 */
	public float getRefund_price() {
		return refund_price;
	}
	/**
	 * @return the company_pay
	 */
	public float getCompany_pay() {
		return company_pay;
	}
	/**
	 * @return the company_card_pay
	 */
	public float getCompany_card_pay() {
		return company_card_pay;
	}
	/**
	 * @return the personal_pay
	 */
	public float getPersonal_pay() {
		return personal_pay;
	}
	/**
	 * @return the company_real_pay
	 */
	public float getCompany_real_pay() {
		return company_real_pay;
	}
	/**
	 * @return the personal_real_pay
	 */
	public float getPersonal_real_pay() {
		return personal_real_pay;
	}
	/**
	 * @return the company_real_refund
	 */
	public float getCompany_real_refund() {
		return company_real_refund;
	}
	/**
	 * @return the personal_real_refund
	 */
	public float getPersonal_real_refund() {
		return personal_real_refund;
	}
	/**
	 * @return the is_invoice
	 */
	public Integer getIs_invoice() {
		return is_invoice;
	}
	/**
	 * @return the call_phone
	 */
	public String getCall_phone() {
		return call_phone;
	}
	/**
	 * @return the passenger_phone
	 */
	public String getPassenger_phone() {
		return passenger_phone;
	}
	/**
	 * @return the budget_center_id
	 */
	public String getBudget_center_id() {
		return budget_center_id;
	}
	/**
	 * @return the budget_item_id
	 */
	public String getBudget_item_id() {
		return budget_item_id;
	}
	/**
	 * @return the use_car_config_id
	 */
	public String getUse_car_config_id() {
		return use_car_config_id;
	}
	/**
	 * @return the order_source
	 */
	public Integer getOrder_source() {
		return order_source;
	}
	/**
	 * @return the is_carpool
	 */
	public Integer getIs_carpool() {
		return is_carpool;
	}
	/**
	 * @return the encrypted_info
	 */
	public String getEncrypted_info() {
		return encrypted_info;
	}
	/**
	 * @return the approval_id
	 */
	public String getApproval_id() {
		return approval_id;
	}
	/**
	 * @return the out_approval_id
	 */
	public String getOut_approval_id() {
		return out_approval_id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @param order_id the order_id to set
	 */
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	/**
	 * @param create_time the create_time to set
	 */
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	/**
	 * @param use_car_type the use_car_type to set
	 */
	public void setUse_car_type(String use_car_type) {
		this.use_car_type = use_car_type;
	}
	/**
	 * @param require_level the require_level to set
	 */
	public void setRequire_level(String require_level) {
		this.require_level = require_level;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @param city_name the city_name to set
	 */
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	/**
	 * @param start_name the start_name to set
	 */
	public void setStart_name(String start_name) {
		this.start_name = start_name;
	}
	/**
	 * @param end_name the end_name to set
	 */
	public void setEnd_name(String end_name) {
		this.end_name = end_name;
	}
	/**
	 * @param departure_time the departure_time to set
	 */
	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}
	/**
	 * @param finish_time the finish_time to set
	 */
	public void setFinish_time(String finish_time) {
		this.finish_time = finish_time;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * @param pay_type the pay_type to set
	 */
	public void setPay_type(Integer pay_type) {
		this.pay_type = pay_type;
	}
	/**
	 * @param member_id the member_id to set
	 */
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	/**
	 * @param pay_time the pay_time to set
	 */
	public void setPay_time(String pay_time) {
		this.pay_time = pay_time;
	}
	/**
	 * @param normal_distance the normal_distance to set
	 */
	public void setNormal_distance(String normal_distance) {
		this.normal_distance = normal_distance;
	}
	/**
	 * @param total_price the total_price to set
	 */
	public void setTotal_price(float total_price) {
		this.total_price = total_price;
	}
	/**
	 * @param actual_price the actual_price to set
	 */
	public void setActual_price(float actual_price) {
		this.actual_price = actual_price;
	}
	/**
	 * @param refund_price the refund_price to set
	 */
	public void setRefund_price(float refund_price) {
		this.refund_price = refund_price;
	}
	/**
	 * @param company_pay the company_pay to set
	 */
	public void setCompany_pay(float company_pay) {
		this.company_pay = company_pay;
	}
	/**
	 * @param company_card_pay the company_card_pay to set
	 */
	public void setCompany_card_pay(float company_card_pay) {
		this.company_card_pay = company_card_pay;
	}
	/**
	 * @param personal_pay the personal_pay to set
	 */
	public void setPersonal_pay(float personal_pay) {
		this.personal_pay = personal_pay;
	}
	/**
	 * @param company_real_pay the company_real_pay to set
	 */
	public void setCompany_real_pay(float company_real_pay) {
		this.company_real_pay = company_real_pay;
	}
	/**
	 * @param personal_real_pay the personal_real_pay to set
	 */
	public void setPersonal_real_pay(float personal_real_pay) {
		this.personal_real_pay = personal_real_pay;
	}
	/**
	 * @param company_real_refund the company_real_refund to set
	 */
	public void setCompany_real_refund(float company_real_refund) {
		this.company_real_refund = company_real_refund;
	}
	/**
	 * @param personal_real_refund the personal_real_refund to set
	 */
	public void setPersonal_real_refund(float personal_real_refund) {
		this.personal_real_refund = personal_real_refund;
	}
	/**
	 * @param is_invoice the is_invoice to set
	 */
	public void setIs_invoice(Integer is_invoice) {
		this.is_invoice = is_invoice;
	}
	/**
	 * @param call_phone the call_phone to set
	 */
	public void setCall_phone(String call_phone) {
		this.call_phone = call_phone;
	}
	/**
	 * @param passenger_phone the passenger_phone to set
	 */
	public void setPassenger_phone(String passenger_phone) {
		this.passenger_phone = passenger_phone;
	}
	/**
	 * @param budget_center_id the budget_center_id to set
	 */
	public void setBudget_center_id(String budget_center_id) {
		this.budget_center_id = budget_center_id;
	}
	/**
	 * @param budget_item_id the budget_item_id to set
	 */
	public void setBudget_item_id(String budget_item_id) {
		this.budget_item_id = budget_item_id;
	}
	/**
	 * @param use_car_config_id the use_car_config_id to set
	 */
	public void setUse_car_config_id(String use_car_config_id) {
		this.use_car_config_id = use_car_config_id;
	}
	/**
	 * @param order_source the order_source to set
	 */
	public void setOrder_source(Integer order_source) {
		this.order_source = order_source;
	}
	/**
	 * @param is_carpool the is_carpool to set
	 */
	public void setIs_carpool(Integer is_carpool) {
		this.is_carpool = is_carpool;
	}
	/**
	 * @param encrypted_info the encrypted_info to set
	 */
	public void setEncrypted_info(String encrypted_info) {
		this.encrypted_info = encrypted_info;
	}
	/**
	 * @param approval_id the approval_id to set
	 */
	public void setApproval_id(String approval_id) {
		this.approval_id = approval_id;
	}
	/**
	 * @param out_approval_id the out_approval_id to set
	 */
	public void setOut_approval_id(String out_approval_id) {
		this.out_approval_id = out_approval_id;
	}
    
	
	
}
