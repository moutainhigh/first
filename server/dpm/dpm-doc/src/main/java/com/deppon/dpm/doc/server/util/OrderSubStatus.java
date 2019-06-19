package com.deppon.dpm.doc.server.util;

import java.util.EnumSet;

public enum OrderSubStatus {
	
	UNKNOWN(0,"未知"),
	WAITING_ORDER(3000,"等待抢单"),
	DRIVER_ORDERING(3001,"有司机抢单"),
	DRIVER_ORDERING_TO_NEGOTIATION(3002,"确定某个司机抢单，但是需要进入协商"),
	NEGOTIATING(3003,"协商状态"),
	TIMEOUT(3101,"订单超时（超时没有司机接单）"),
	REASSIGNNING(4000,"改派中"),
	WAITTING_TO_PICKUP(4001,"等待接驾"),
	DRIVER_LATE(4002,"司机迟到"),
	PASSENGER_LATE(4004,"乘客迟到"),
	LATE_CHARGE(4005,"迟到计费"),
	DRIVER_ARRIVED(4101,"司机到达"),
	ON_SERVICE_OR_BILLING(5000,"服务中/计费中"),
	PAYABLE(6001,"正常订单待支付"),
	CANCLE_PAYABLE(6002,"取消订单待支付"),
	NO_PAYMENT_REQUIRED(6101,"取消订单无需支付"),
	CANCLE_PAID(6102,"取消订单已支付"),
	CUSTOMER_SERVICE_CLOSE(6103,"客服关单"),
	DRIVER_REASSIGN_CLOSE(6104,"司机改派关单"),
	NOT_COMPLETED_SERVICE_CLOSE(6105,"未完成服务关闭"),
	DONE(7000,"订单已完成");

    //防止字段值被修改，增加的字段也统一final表示常量
	
    private final Integer code;
    
    private final String message;
    
    /**
     * 待审核的订单类型
     * */
    public static final EnumSet<OrderSubStatus> AUDIT_SET = EnumSet.of(OrderSubStatus.PAYABLE,OrderSubStatus.CANCLE_PAYABLE,
    													OrderSubStatus.CANCLE_PAID,OrderSubStatus.DONE);
    
    private OrderSubStatus(Integer code,String message){
        this.code = code;
        this.message = message;
    }
    
    public Integer getCode() {
        return code;
    }
    
    public String getMessage() {
        return message;
    }
}
