package com.deppon.dpm.module.common.server.interceptor;

import javax.servlet.http.HttpServletResponse;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

/**
 * 输出拦截
 */
public class OutPhaseInterceptor extends AbstractPhaseInterceptor<Message>{
	// 响应头
	private static final String ESB_RESULT_CODE = "ESB-ResultCode";
	// 构造，在响应消息时拦截
	public OutPhaseInterceptor() {
		super(Phase.PRE_STREAM);
	}
	// 复写的方法
	@Override
	public void handleMessage(Message message) throws Fault {
		// 响应头
		Object obj = message.get("HTTP.RESPONSE");
		// 判断
		if (obj != null) {
			// 强转
			HttpServletResponse rs = (HttpServletResponse) obj;
			// 设置响应头
			rs.setHeader(ESB_RESULT_CODE, "1");
		}
		
	}

}
