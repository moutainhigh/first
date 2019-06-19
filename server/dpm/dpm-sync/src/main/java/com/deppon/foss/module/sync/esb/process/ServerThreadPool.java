package com.deppon.foss.module.sync.esb.process;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.deppon.foss.module.sync.esb.definition.Configuration;
import com.deppon.foss.module.sync.esb.exception.ConvertException;
import com.deppon.foss.module.sync.esb.exception.JmsBusinessException;
import com.deppon.foss.module.sync.esb.header.ESBHeader;
import com.deppon.foss.module.sync.esb.header.ServiceMessage;
import com.deppon.foss.module.sync.esb.transfer.IMessageTransform;
import com.deppon.foss.module.sync.esb.util.Constant;
import com.deppon.foss.module.sync.esb.util.HeaderUtils;

/**
 * 线程池
 * 
 * @author 231586
 * 
 */
public class ServerThreadPool {
	/**
	 * The Constant CORE_POOL_SIZE.
	 */
	private static final int CORE_POOL_SIZE = 5;
	/**
	 * The Constant MAX_POOL_SIZE.
	 */
	private static final int MAX_POOL_SIZE = 20;
	/**
	 * The Constant KEEP_ALIVE_TIME.
	 */
	// 一分钟空闲就回收
	private static final long KEEP_ALIVE_TIME = 60000L;
	/**
	 * The Constant UNIT.
	 */
	private static final TimeUnit UNIT = TimeUnit.MILLISECONDS;
	/**
	 * The Constant QUEUE_SIZE.
	 */
	private static final int QUEUE_SIZE = 1000;
	/**
	 * The executor.
	 */
	private ExecutorService executor;
	/**
	 * jms模板
	 */
	private JmsTemplate jmsTemplate;
	/**
	 * logger
	 */
	private static final Log logger = LogFactory.getLog(ServerThreadPool.class);

	/**
	 * Instantiates a new server process thread pool.
	 */
	public ServerThreadPool() {
		executor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE,
				KEEP_ALIVE_TIME, UNIT, new ArrayBlockingQueue<Runnable>(
						QUEUE_SIZE));
	}

	/**
	 * Instantiates a new server process thread pool.
	 * 
	 * @param corePoolSize
	 *            the core pool size
	 * @param maximumPoolSize
	 *            the maximum pool size
	 * @param keepAliveTime
	 *            the keep alive time
	 * @param unit
	 *            the unit
	 */
	public ServerThreadPool(int corePoolSize, int maximumPoolSize,
			long keepAliveTime, TimeUnit unit) {
		executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize,
				keepAliveTime, unit, new ArrayBlockingQueue<Runnable>(
						QUEUE_SIZE));
	}

	/**
	 * 信息处理
	 * 
	 * @param message
	 */
	public void process(final ServiceMessage message) {
		executor.submit(new Runnable() {
			@Override
			public void run() {
				// 逻辑处理
				flowProcess(message);
			}
		});
	}

	/**
	 * 处理
	 * @param message
	 */
	private void flowProcess(ServiceMessage message) {
		// ESBHeader
		ESBHeader header = message.getHeader();
		// 获取相应队列
		String responseQueue = Configuration.getServiceConfigMap()
				.get(header.getBackServiceCode()).getResponseQueue();
		// 获取状态
		String statusQueue = Configuration.getServiceConfigMap()
				.get(header.getBackServiceCode()).getEsbStatusQueue();
		try {
			// 已接收
			sendStatus(statusQueue, Constant.STATUS_302, message);
		} catch (Exception e) {
			// 打印错误信息
			e.printStackTrace();
		}
		// 新建消息
		ServiceMessage responseMessage = null;
		try {
			// 业务逻辑
			responseMessage = businessProcess(message);
		} catch (ConvertException e) {
			// log
			logger.error("error", e);
		}
		if (Constant.DPM_RESPONSE_COME_IN_QUEUE.equals(responseQueue)) {
			/* DPM接收响应 added by 付众 at 2014-8-29 */
			sendStatus(statusQueue, Constant.STATUS_999, responseMessage);
		} else {
			// 业务逻辑处理完成
			sendStatus(statusQueue, Constant.STATUS_305, responseMessage);
			// 发送响应
			sendResponse(responseQueue, responseMessage);
			// 发送完响应
			sendStatus(statusQueue, Constant.STATUS_308, responseMessage);
		}

	}

	/**
	 * 业务逻辑处理
	 * 
	 * @param message
	 * @return
	 * @throws ConvertException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private ServiceMessage businessProcess(ServiceMessage message)
			throws ConvertException {
		// ESBHeader
		ESBHeader header = message.getHeader();
		// 获取服务编码
		String serviceCode = header.getBackServiceCode();
		// 相应id
		header.setResponseId(UUID.randomUUID().toString());
		// 消息实体转换
		IMessageTransform requestTransform = Configuration
				.getServiceConfigMap().get(serviceCode).getReqConvertor();
		Object requestObj = null;
		try {
			// 消息信息
			requestObj = requestTransform.toMessage(message.getBody());
		} catch (ConvertException e1) {
			// 抛异常
			throw e1;
		} catch (UnsupportedEncodingException e) {
			// log
			logger.error("error", e);
		}
		// 调用服务端自己编写的处理类来处理请求
		IProcess process = Configuration.getServiceConfigMap().get(serviceCode)
				.getProcessor();
		Object response = null;
		try {
			// 责任链
			response = process.process(requestObj);
		} catch (JmsBusinessException e) {
			// 异常抛出
			throw e;
		}
		// 空判断
		if (response == null) {
			// 返回新服务消息
			return new ServiceMessage(header, null);
		}
		// 消息实体转换
		IMessageTransform responseTransform = Configuration
				.getServiceConfigMap().get(serviceCode).getResConvertor();
		// 响应信息
		String responseStr = null;
		try {
			// 获取响应信息
			responseStr = responseTransform.fromMessage(response);
		} catch (ConvertException e) {
			// 异常抛出
			throw e;
		}
		// 成功
		header.setResultCode(1);
		// 返回服务消息信息
		return new ServiceMessage(header, responseStr);
	}

	/**
	 * 响应信息
	 * 
	 * @param responseQueueName
	 * @param response
	 */
	public void sendResponse(String responseQueueName,
			final ServiceMessage response) {
		// 发送相应消息
		jmsTemplate.send(responseQueueName, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				// 创建消息类型
				TextMessage message = session.createTextMessage();
				// 创建消息
				message.setText(response.getBody());
				// 把header里面的属性填充到JMSProperty中.
				HeaderUtils.header2JMSProperties(response.getHeader(), message);
				// 返回消息
				return message;
			}
		});
	}

	// @SuppressWarnings("unused")
	// private void sendStatus(String statusQueuName, final String statusId){
	// jmsTemplate.send(statusQueuName,new MessageCreator() {
	// @Override
	// public Message createMessage(Session session) throws JMSException {
	// TextMessage textMessage = session.createTextMessage();
	// textMessage.setText(statusId+"@"+(new Date()).getTime());
	// return textMessage;
	// }
	// });
	// }

	private void sendStatus(String statusQueuName, final String statusId,
			final ServiceMessage message) {
		// 发送状态
		jmsTemplate.send(statusQueuName, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				// 创建消息类型
				TextMessage textMessage = session.createTextMessage();
				// 创建消息
				textMessage.setText(statusId + "@" + (new Date()).getTime());
				// 把header里面的属性填充到JMSProperty中.
				HeaderUtils.header2JMSProperties(message.getHeader(),
						textMessage);
				// 返回消息
				return textMessage;
			}
		});
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
