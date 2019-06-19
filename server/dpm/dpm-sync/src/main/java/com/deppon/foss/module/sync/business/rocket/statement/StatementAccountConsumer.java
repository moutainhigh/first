package com.deppon.foss.module.sync.business.rocket.statement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.deppon.dpboot.framework.logging.Logger;
import com.deppon.dpboot.framework.logging.LoggerFactory;
import com.deppon.dpboot.module.common.serializer.factory.impl.GenericsHessianFactory;
import com.deppon.dpboot.module.mq.client.consumer.GenericsMessageReConsumer;
import com.deppon.dpboot.module.mq.client.consumer.impl.GenericsConcurrentlyReConsumer;

public class StatementAccountConsumer implements GenericsMessageReConsumer<String>{

	 public static Logger logger = LoggerFactory

             .getLogger(StatementAccountConsumer.class);

    protected GenericsConcurrentlyReConsumer<String> consumer = new GenericsConcurrentlyReConsumer<String>();

    private String namesrvAddr;

	private String consumerGroup;

    private String topic;

    private String tag;
    
    public StatementService statementService;
    
    
    public StatementAccountConsumer(){
    	
    }
    
    public void startup() {
		
		logger.error("启动接收主数据人员服务：StatementAccountConsumer");
		
        consumer.setNamesrvAddr(namesrvAddr);

        consumer.setConsumerGroup(consumerGroup);

        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

        // Serializer 如不显示调用setSerializer，默认自动生成Kryo实例器。生产者和消费者必须使用一致的消息序列器。

        // 设置序列器,对消息对象，没有要求必须实现Serializable，请使用Kryo，

        // consumer.setSerializer(new GenericsKryoFactory<User>()

        // .getSerializer());

        // 设置序列器,要求消息对象，必须实现Serializable，JDK1.6下无法使用fst，JDK1.7以上才能使用fst

        // consumer.setSerializer(new GenericsFstFactory<User>()

        // .getSerializer());

        // 设置序列器,要求消息对象，必须实现Serializable，推荐使用。

        // consumer.setSerializer(new GenericsHessianFactory<User>()

        // .getSerializer());
        
        // CONSUME_FROM_TIMESTAMP

        // consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_TIMESTAMP);

        // 从当前时间往前推5分钟以内的消息都会拉取下来
        // consumer.setConsumeTimestamp(60*5);
       consumer.setSerializer(new GenericsHessianFactory<String>().getSerializer());
       //请根据业务实际情况，调整消费线程数。
       consumer.setConsumeThreadMax(64);
       //请根据业务实际情况，调整消费线程数。
       consumer.setConsumeThreadMin(20);
       consumer.setTopic(topic);
       consumer.setTag(tag);
       consumer.setMessageReConsumer(this);
       try {
            consumer.startup();
       } catch (Throwable e) {
            logger.error("StatementAccountConsumer start fail,", e);
       }
    }

    public void shutdown() {
        consumer.shutdown();
    }
    
	@Override
	public Boolean onReConsume(String messageObject) {
		logger.error("StatementAccountConsumer开始消费消息 "+Thread.currentThread().getName() + "  Received: " + messageObject);
		try {
			JSONObject json = JSON.parseObject(messageObject);
			if(null != json && json.getBoolean("success")){
				String bizDataUUID = json.getString("bizDataUUID");
				String workflowNum = json.getJSONObject("data").getString("claimNo");
				String workflowStatus = json.getJSONObject("data").getString("state");
				statementService.updateStatementSummaryByMessage(workflowNum, bizDataUUID, workflowStatus);
				logger.error("StatementAccountConsumer消费消息成功 "+Thread.currentThread().getName() + "  Received: " + messageObject);
//				String company = (String)map.get("applyCompName");
//				String offTime = ((String)map.get("bizOccurDate")).substring(0, 7).replaceAll("-","");
//				
//				int num = statementService.queryStatementSummaryByNum(workflowNum);
//				if(num==0){
//					statementService.updateStatementSummary(workflowNum, workflowStatus, company, offTime);
//				}else{
//					statementService.updateStatementSummaryByWF(workflowNum, workflowStatus, company);
//				}
			}else{
				logger.error("StatementAccountConsumer消费消息失败 "+Thread.currentThread().getName() + "  Received: " + messageObject);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("StatementAccountConsumer 报错:"+Thread.currentThread().getName() + " Received: " + messageObject 
					+ "报错内容:" + e.getMessage());
		}
		return Boolean.TRUE;
	}
	
	@Override
	public void onConsume(String message) {
		
	}
	
	public String getNamesrvAddr() {
		return namesrvAddr;
	}
	
	public void setNamesrvAddr(String namesrvAddr) {
		this.namesrvAddr = namesrvAddr;
	}

	public String getConsumerGroup() {
		return consumerGroup;
	}

	public void setConsumerGroup(String consumerGroup) {
		this.consumerGroup = consumerGroup;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public StatementService getStatementService() {
		return statementService;
	}

	public void setStatementService(StatementService statementService) {
		this.statementService = statementService;
	}

}
