package com.deppon.foss.module.sync.business.rocket;

import com.deppon.dpboot.framework.logging.Logger;
import com.deppon.dpboot.framework.logging.LoggerFactory;

import com.deppon.dpboot.module.mq.client.producer.impl.GenericsConcurrentlyProducer;
import com.deppon.dpboot.module.mq.client.utils.DateUtil;

public class StringConcurrentlyProducer {
	public static Logger logger = LoggerFactory
			.getLogger(StringConcurrentlyProducer.class);
	protected GenericsConcurrentlyProducer<String> producer = new GenericsConcurrentlyProducer<String>();

	public StringConcurrentlyProducer() {

	}

	public void startup() {
		// 指定一个生产者名，如不指定，则随机生成，随机生成则有可能影响消息接续消费
		producer.setProducerGroup("my_json_msg_producer");
		// 多个namesrvAddr多个地址之间用;分隔，如：10.230.20.224:8765;10.230.20.225:8765
		producer.setNamesrvAddr("10.230.20.224:8765");
		try {
			producer.startup();
		} catch (Throwable e) {
			logger.error("StringConcurrentlyProducer start fail,", e);
		}
	}

	public void shutdown() {
		producer.shutdown();
	}

	public void doSend(int count) {
		String now = DateUtil.getNowStr();
		String va= "7568000,'workCode':'T87623'},{'accountChangeId':'37428cfba5e24d879fe21c7c271a0969','active':true,'changeDate':1524188820627,'changeType':'1','desPassword':'xman850.','empCode':'T88442','empName':'usertest','gender':'男','invalidDate':1522425600000,'lastModifyTime':1522377055000,'orgBenchmarkCode':'DP18373','orgCode':'W0000000001','orgName':'中山横栏镇祥安市场营业部','position':'中型接送司机','roleInfo':[],'sysName':'CUBC','temp':true,'userName':'T88442','validDate':1522377054000,'workCode':'T88442'},{'accountChangeId':'3b849a3b64d741d58f4c3b8737f842d4','active':true,'changeDate':1524188820627,'changeType':'1','desPassword':'vfsr795^','empCode':'T88482','empName':'李无无','gender':'男','invalidDate':1649952000000,'lastModifyTime':1523096054000,'orgBenchmarkCode':'DP37278','orgCode':'W0000019446','orgName':'IT服务中心','position':'中级一等IT热线处理工程师','roleInfo':[],'sysName':'CUBC','temp':true,'userName':'T88482','validDate':1523096053000,'workCode':'T88482'},{'accountChangeId':'bf0d42fb016d4fc6b241ddc167e06fbb','active':true,'changeDate':1524188820627,'changeType':'2','desPassword':'vfsr795^','empCode':'T88482','empName':'李无无','gender':'男','invalidDate':1649952000000,'lastModifyTime':1523096128000,'orgBenchmarkCode':'DP37278','orgCode':'W0000019446','orgName':'IT服务中心','position':'中级一等IT热线处理工程师','roleInfo':[],'sysName':'CUBC','temp':true,'userName':'T88482','validDate':1523096053000,'workCode':'T88482'},{'accountChangeId':'f72b01f2d42d447096c758ce1a9fc9a8','active':true,'changeDate':1524188820627,'changeType':'1','desPassword':'nzvg395^','empCode':'T88502','empName':'李建超','gender':'男','invalidDate':1531324800000,'lastModifyTime':1523233872000,'orgBenchmarkCode':'DP28158','orgCode':'W0000010119','orgName':'跨境业务研发部','position':'资深四等软件开发工程师','roleInfo':[],'sysName':'CUBC','temp':true,'userName':'T88502','validDate':1523233870000,'workCode':'T88502'},{'accountChangeId':'bbab91afdd87477880e71daec90c21fb','active':true,'changeDate':1524188820627,'changeType':'1','desPassword':'ncok842*','empCode':'T88523','empName':'花千骨','gender':'女','invalidDate':1535644800000,'lastModifyTime':1523341940000,'orgBenchmarkCode':'DP00002','orgCode':'DIP','orgName':'办公门户机构人员','position':'事业合伙人本部总裁','roleInfo':[],'sysName':'CUBC','temp':true,'userName':'T88523','validDate':1523341938000,'workCode':'T88523'},{'accountChangeId':'e00f1a54d6004f94a6ed5d1ac3ca52fd','active':true,'changeDate':1524188820627,'changeType':'1','desPassword':'ncok842*','empCode':'T88523','empName':'花千骨','gender':'女','invalidDate':1535644800000,'lastModifyTime':1523341940000,'orgBenchmarkCode':'DP00002','orgCode':'DIP','orgName':'办公门户机构人员','position':'事业合伙人本部总裁','roleInfo':[],'sysName':'CUBC','temp':true,'userName':'T88523','validDate':1523341938000,'workCode':'T88523'}]";
		va = va.concat("\n").concat(va);
//		va = va.concat("\n").concat(va);
//		va = va.concat("\n").concat(va);
//		va = va.concat("\n").concat(va);
//		va = va.concat("\n").concat(va);
		producer.setMaxMessageSize(Integer.MAX_VALUE);

	
		for (int i = 0; i <= count; i++) {
			producer.send("edas_topic_str", "TAG" + i, "KEY" + i,
					//"Concurrently String[" + i + "]" + "," + now
					now+va);
		}
	}

}
