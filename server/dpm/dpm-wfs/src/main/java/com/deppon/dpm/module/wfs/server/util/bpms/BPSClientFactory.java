package com.deppon.dpm.module.wfs.server.util.bpms;

import com.deppon.bpmsapi.module.client.api.IBranchRuleManager;
import com.deppon.bpmsapi.module.client.api.IDpBpmsClientFacade;
import com.deppon.bpmsapi.module.client.api.IParticipantRuleManager;
import com.deppon.bpmsapi.module.client.api.impl.DpBpmsClientFacadeImpl;

/**
* @title: BPSClientFactory 
* @author： lihai
* @date： 2014-7-3 下午01:42:43
 */
public class BPSClientFactory {

	/**
	 *构造函数 
	 */
	private BPSClientFactory() {
	}
	
	/**
	* @methodName: getClient 
	* @author：lihai
	* @date： 2014-7-3 下午01:42:07
	* @param empCode
	* @param empName
	* @return IDpBpmsClientFacade
	 */
	public static IDpBpmsClientFacade getClient(String empCode, String empName) {
		// 分支规则管理器，根据具体情况确定实例化哪个分支规则管理器
		IBranchRuleManager branchRule = new BranchRuleManagerImpl();
		// 参与者规则管理器，，根据具体情况确定实例化哪个参与者规则管理器
		IParticipantRuleManager participantRule = new ParticipantRuleManagerImpl();
		
		// 实例化一个新的bps客户端，四个参数：分支规则manager，选人规则manager，用户工号，用户名
		IDpBpmsClientFacade clientFacade = new DpBpmsClientFacadeImpl(branchRule, participantRule, empCode, empName);
		
		return clientFacade;
	}
	
	
	
}
