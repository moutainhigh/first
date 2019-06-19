package com.deppon.dpm.module.wfs.server.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.deppon.dpm.module.wfs.server.dao.IWorkflowPageDao;
import com.deppon.dpm.module.wfs.shared.domain.WorkflowPageInfo;
import com.deppon.foss.framework.server.components.dataaccess.ibatis.iBatis3DaoImpl;
import com.primeton.das.entity.impl.hibernate.mapping.Array;

public class workflowPageDao extends iBatis3DaoImpl implements IWorkflowPageDao {

	/**
	 * namespace
	 */
	private static final String NAME_SPACE = "com.deppon.dpm.module.wfs.server.dao.workitems.";
	
	@Override
	@SuppressWarnings("unchecked")
	public List<WorkflowPageInfo> pageInfo() {
		//获取详情信息对应表
		return getSqlSession().selectList(NAME_SPACE + "queryWfsPageInfo");
	}

	@Override
	public HashMap<String, List<WorkflowPageInfo>> allWorkflow() {
		List<WorkflowPageInfo> pageInfo = getSqlSession().selectList(NAME_SPACE + "queryWfsPageInfo");
		HashMap<String, List<WorkflowPageInfo>> map =dealData(pageInfo);
		return map;
	}
	// 按工作流系统类型分类 处理 返回给前端
	private HashMap<String, List<WorkflowPageInfo>> dealData(List<WorkflowPageInfo> pageInfo){
		//以系统编码为key  实体为value
		HashMap<String, List<WorkflowPageInfo>> map = new HashMap<String, List<WorkflowPageInfo>>();
		//获取所有系统类型
		List<String> keys= getAllKey(pageInfo);
		
		for (String key : keys) {
			//map对应的value值
			List<WorkflowPageInfo> value = new ArrayList<WorkflowPageInfo>();;
			for (WorkflowPageInfo entity : pageInfo) {
				//H5页面名称
				String htmlStr = entity.getWorkflowPage();
				String[] strArr = htmlStr.split("/");
				String sysCode = strArr[0];
				//去掉空格
				sysCode = sysCode.trim();
				if (sysCode.equals(key)) {
					value.add(entity);
				}
			}
			map.put(key, value);
		}
		
		return map;
	}
	//获取所有系统类型
	private List<String> getAllKey(List<WorkflowPageInfo> pageInfo){
		List<String> result = new ArrayList<String>();
		for (WorkflowPageInfo info : pageInfo) {
			//H5页面名称
			String htmlStr = info.getWorkflowPage();
			String[] strArr = htmlStr.split("/");
			String sysCode = strArr[0];
			//去掉空格
			sysCode = sysCode.trim();
			if (!result.contains(sysCode)) {
				result.add(sysCode);
				System.out.println("-------------"+sysCode);
			}
		}
		return result;
	}

}
