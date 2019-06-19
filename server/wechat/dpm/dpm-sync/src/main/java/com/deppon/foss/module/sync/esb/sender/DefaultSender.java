package com.deppon.foss.module.sync.esb.sender;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.commons.lang.StringUtils;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.deppon.foss.module.sync.esb.header.ESBHeader;
import com.deppon.foss.module.sync.esb.util.HeaderUtils;

/**
 * 发送JMS异步消息基类
 * 
 * @author 038590-foss-wanghui
 * @date 2013-8-6 上午10:09:32
 */
public class DefaultSender {
	/**
	 * jms模板
	 */
	private JmsTemplate jmsTemplate;
	/**
	 * 队列名称
	 */
	private String queueName;

	/**
	 * 
	 * 发送JMS异步消息
	 * 
	 * @author 038590-foss-wanghui
	 * @date 2013-8-6 上午10:10:02
	 */
	public void sendJms(final ESBHeader esbHeader, final String body) {
		// 队列名称为空，抛异常
		if (StringUtils.isEmpty(queueName)) {
			// 异常抛出
			throw new IllegalArgumentException("队列名称不能为空");
		}
		// 发送异步消息
		jmsTemplate.send(queueName, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				// 创建文本信息
				TextMessage message = session.createTextMessage();
				// 头转换
				HeaderUtils.header2JMSProperties(esbHeader, message);
				// 设置消息
				message.setText(body);
				// 返回消息
				return message;
			}
		});
	}
	/**
	 * get
	 * 
	 * @return
	 */
	public String getQueueName() {
		return queueName;
	}

	/**
	 * set
	 * 
	 * @param queueName
	 */
	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	/**
	 * set
	 * 
	 * @param jmsTemplate
	 */
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
}
