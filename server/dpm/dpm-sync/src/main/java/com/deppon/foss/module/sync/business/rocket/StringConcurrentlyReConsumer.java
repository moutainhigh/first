package com.deppon.foss.module.sync.business.rocket;

import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.deppon.dpboot.framework.logging.Logger;
import com.deppon.dpboot.framework.logging.LoggerFactory;
import com.deppon.dpboot.module.mq.client.consumer.GenericsMessageReConsumer;
import com.deppon.dpboot.module.mq.client.consumer.impl.GenericsConcurrentlyReConsumer;

public class StringConcurrentlyReConsumer implements GenericsMessageReConsumer<String> {
	public static Logger logger = LoggerFactory
			.getLogger(StringConcurrentlyReConsumer.class);
	protected GenericsConcurrentlyReConsumer<String> consumer = new GenericsConcurrentlyReConsumer<String>();


	public StringConcurrentlyReConsumer(){
		
	}
	
	public void startup() {
		consumer.setConsumeThreadMax(64);
		consumer.setConsumeThreadMin(20);
		consumer.setNamesrvAddr("10.230.20.224:8765");
		consumer.setConsumerGroup("consumer_string");
		consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
		consumer.setTopic("edas_topic_str");
		consumer.setMessageReConsumer(this);
		try {
			consumer.startup();
		} catch (Throwable e) {
			logger.error("StringConcurrentlyConsumer start fail,", e);
		}
	}
	
	public void shutdown() {
		consumer.shutdown();
	}

	@Override
	public Boolean onReConsume(String messageObject) {
		System.out.println(messageObject);
		logger.info("StringConcurrentlyConsumer  "+Thread.currentThread().getName() + "  Received: "
				+ messageObject);
		return true;
	}


	@Override
	public void onConsume(String messageObject) {

	}
}
