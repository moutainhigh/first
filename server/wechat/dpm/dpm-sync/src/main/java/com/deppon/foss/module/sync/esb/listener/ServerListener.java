package com.deppon.foss.module.sync.esb.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import com.deppon.foss.module.sync.esb.definition.Configuration;
import com.deppon.foss.module.sync.esb.header.ESBHeader;
import com.deppon.foss.module.sync.esb.header.ServiceMessage;
import com.deppon.foss.module.sync.esb.util.HeaderUtils;

/**
 * 
 * 消息监听基类
 * <p style="display:none">
 * modifyRecord
 * </p>
 * <p style="display:none">
 * version:V1.0,author:ztjie,date:2013-8-29 上午10:11:51,content:TODO
 * </p>
 * 
 * @author ztjie
 * @date 2013-8-29 上午10:11:51
 * @since
 * @version
 */
public class ServerListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		// ESBHeader
		ESBHeader header;
		try {
			// 把JMSPropertyProperty中与ESB相关的属性封装到ESBHeader中
			header = HeaderUtils.fillServiceHeader(message);
			// 获取消息体中的消息
			String body = ((TextMessage) message).getText();
			// 新建一个ServiceMessage
			ServiceMessage serviceMessage = new ServiceMessage(header, body);
			// 穿件一个线程池处理消息
			Configuration.getServerThreadPool().process(serviceMessage);
		} catch (JMSException e) {
			// 错误打印
			e.printStackTrace();
		}
	}
}
