package com.deppon.dpm.module.wfs.server.util.bpms;

import java.lang.reflect.Method;
import java.util.Map;

import com.deppon.bpmsapi.module.client.api.IBranchRuleManager;
import com.deppon.bpmsapi.module.server.api.exception.BPMSException;

/**
 * 
 * 工作流业务规则管理
 * @author 150970
 * @date 2014年12月31日 下午1:42:52
 * @since
 * @version
 */
public class BranchRuleManagerImpl implements IBranchRuleManager {
	public boolean[] isTrue(String[] rule, @SuppressWarnings("rawtypes") Map map) {
		//BIZ_com.deppon.wfs.regulations.server.BranchRuleManager#isBranchAvailable
		boolean[] res = new boolean[rule.length];
		// 遍历规则数组，进行规则调用
		for (int i = 0; i < rule.length; i++) {
			if (rule[i].equals("true") || rule[i].equals("false")) {// 非报账规则判断
				res[i] = Boolean.parseBoolean(rule[i]);
			} else {// 报账规则调用
				boolean result = false;
				try {
					// BIZ_类全名与方法名的分离
					String[] temp = rule[i].split("#");
					// temp[0]类名,temp[1]方法名,通过类的反射调用报账规则类方法
					Class<?> cl = Class.forName(temp[0].replaceAll("BIZ_", ""));
					// 报账规则类实例化
					Object obj = cl.newInstance();
					// 报账规则类方法获取
					Method me = cl
							.getMethod(temp[1], new Class[] { Map.class });
					// 报账规则类方法调用
					result = (Boolean) me.invoke(obj, new Object[] { map });
				} catch (Exception e) {
					e.printStackTrace();
					// log.error("分支规则" + e);
					throw new BPMSException(e);
				}
				res[i] = result;
			}
		}
		return res;
	}
}
