package com.deppon.dpm.module.wfs.server.util.bpms;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.deppon.bpms.module.shared.domain.BpmsParticipant;
import com.deppon.bpmsapi.module.client.api.IParticipantRuleManager;
import com.deppon.bpmsapi.module.client.domain.ParticipantRule;
import com.deppon.bpmsapi.module.server.api.exception.BPMSException;
import com.deppon.dpm.module.wfs.util.Constants;
/**
 * 
 * 工作流业务规则公共类
 * @author 150970
 * @date 2014年12月31日 下午1:43:54
 * @since
 * @version
 */
public class ParticipantRuleManagerImpl implements IParticipantRuleManager{
	public Map<String, BpmsParticipant[]> getParticipants(
			ParticipantRule[] rules, @SuppressWarnings("rawtypes") Map context) {
		Map<String, BpmsParticipant[]> res = new HashMap<String, BpmsParticipant[]>();
		//遍历规则数组，进行规则调用
		for (int i = 0; i < rules.length; i++) {
			try {
				//BIZ_类全名与方法名的分离
				String[] temp = rules[i].getRule().split("#");
				// temp[0]类名,temp[1]方法名,通过类的反射调用报账规则类方法
				Class<?> cl = Class.forName(temp[0].replaceAll("BIZ_", ""));
				//报账规则类实例化
				Object obj = cl.newInstance();
				//传递参数判断
				if (temp.length == 2) {
					//报账规则类方法获取
					Method me = cl.getMethod(temp[1], new Class[] {
							ParticipantRule.class, Map.class });
					//报账规则类方法调用
					BpmsParticipant[] bps = (BpmsParticipant[]) me.invoke(obj,
							new Object[] { rules[i], context });
					//将获取到的参与者添加到返回队列中
					res.put(rules[i].getNextActivityDefId(), bps);
				} else if (temp.length == Constants.CONSTANT_FOUR) {
					//针对部门及岗位的配对关系设置，后两个为标志:A1,B1;A2,B2;A3,B3
					//报账规则类方法获取
					Method me = cl.getMethod(temp[1], new Class[] {
							ParticipantRule.class, Map.class, String.class,
							String.class });
					//报账规则类方法调用
					BpmsParticipant[] bps = (BpmsParticipant[]) me
							.invoke(obj, new Object[] { rules[i], context,
									temp[2], temp[Constants.CONSTANT_THREE] });
					//将获取到的参与者添加到返回队列中
					res.put(rules[i].getNextActivityDefId(), bps);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new BPMSException(e);
			}
		}
		return res;
	}
}
