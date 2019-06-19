package com.deppon.foss.module.sync.business.rocket.statement;

import com.deppon.dpboot.framework.logging.Logger;
import com.deppon.dpboot.framework.logging.LoggerFactory;
import com.deppon.dpboot.module.common.serializer.factory.impl.GenericsHessianFactory;
import com.deppon.dpboot.module.mq.client.producer.impl.GenericsConcurrentlyProducer;

public class StatementAccountProducer {

	public static Logger logger = LoggerFactory

            .getLogger(StatementAccountProducer.class);

   protected GenericsConcurrentlyProducer<String> producer = new GenericsConcurrentlyProducer<String>();

   private String namesrvAddr;

   private String producerGroup;

   private String topic;

   private String tag;

   public String getNamesrvAddr() {
       return namesrvAddr;
   }

   public void setNamesrvAddr(String namesrvAddr) {
       this.namesrvAddr = namesrvAddr;
   }

   public String getProducerGroup() {
       return producerGroup;
   }

   public void setProducerGroup(String producerGroup) {
       this.producerGroup = producerGroup;
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
   
   public StatementAccountProducer() {

   }

   public void startup() {

       producer.setProducerGroup(producerGroup);

       producer.setNamesrvAddr(namesrvAddr);

       // Serializer 如不显示调用setSerializer，默认自动生成Kryo实例器。生产者和消费者必须使用一致的消息序列器。

       // 设置序列器,对消息对象，没有要求必须实现Serializable，请使用Kryo，

       // producer.setSerializer(new GenericsKryoFactory<User>()

       // .getSerializer());

       // 设置序列器,要求消息对象，必须实现Serializable，JDK1.6下无法使用fst，JDK1.7以上才能使用fst

       // producer.setSerializer(new GenericsFstFactory<User>()

       // .getSerializer());

       // 设置序列器,要求消息对象，必须实现Serializable，推荐使用。

       producer.setSerializer(new GenericsHessianFactory<String>().getSerializer());

       // .getSerializer());
       
       producer.setMaxMessageSize(1024*1024*20);//设置消息大小最大为20M

       try {
            producer.startup();
       } catch (Throwable e) {
            logger.error("StatementAccountProducer start fail,", e);
       }

   }

   public void shutdown() {
       producer.shutdown();
   }

   public boolean sendMessage(String message,String key) throws Exception{
	   logger.error("对账 StatementAccountProducer 开始推送数据 send statement message:"+key);
	   boolean isSuccess =producer.send(topic, tag, key, message, null);
	   if(isSuccess){
		   logger.error("对账StatementAccountProducer推送数据成功 send statement message success:"+key);
	   }else{
		   logger.error("对账StatementAccountProducer推送数据失败 send statement message failed:"+key);
	   }
	   return isSuccess;
   }

}
