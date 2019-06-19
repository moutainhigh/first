package com.deppon.dpm.module.common.server.interceptor;

import javax.servlet.http.HttpServletResponse;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

/**
 * 输出消息异常拦截器
 */
public class OutFaultPhaseInterceptor extends AbstractPhaseInterceptor<Message> {
	
	// 消息头
	private static final String ESB_RESULT_CODE = "ESB-ResultCode";
	
	// 构造，协议拦截
	public OutFaultPhaseInterceptor() {
		super(Phase.PRE_PROTOCOL);
	}

	// 复写方法
	@Override
	public void handleMessage(Message message) throws Fault {
		// 获取response
		Object obj = message.get("HTTP.RESPONSE");
		// 判断
		if (obj != null) {
			// 强转
			HttpServletResponse rs = (HttpServletResponse) obj;
			// 这是响应头
			rs.setHeader(ESB_RESULT_CODE, "0");
		}

	}

}
