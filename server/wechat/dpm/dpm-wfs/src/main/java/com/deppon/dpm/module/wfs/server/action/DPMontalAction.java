package com.deppon.dpm.module.wfs.server.action;

import java.io.BufferedReader;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.StringUtil;
import com.deppon.dpm.module.wfs.server.service.IMonitorService;
import com.deppon.dpm.module.wfs.server.util.monitor.WFSMonitorUtil;
import com.deppon.dpm.module.wfs.shared.vo.WfsMonitorVo;

/**
 * DPMontal 对于老系统中的工作流 进行数据监控
 * @author 195406 高春玲
 * @date 2015-6-3 下午17:45:08
 * @version
 */
public class DPMontalAction extends BaseAction {
	//service
	private IMonitorService monitorService;

	/**
	 * 工作流查看
	 * @author 195406 高春玲
	 * @date 2015-6-3 下午17:45:08
	 */
	public String queryWorkInfo() {
		BufferedReader bu;
		try {
			bu = ServletActionContext.getRequest().getReader();
			String str = StringUtil.bufferString(bu);
			//保存数据监控
			WfsMonitorVo vo = new WfsMonitorVo();
			vo = JSONObject.parseObject(str,
					WfsMonitorVo.class);
			vo.setType("0");
			WFSMonitorUtil.addMonitor(null, null, null, null, null, 
					null, vo.getErrorInfo(), ServletActionContext.getRequest().getSession(), this.monitorService,vo,str);
			
		} catch (Exception e) {
			//打印出报错信息
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 工作流审批
	 */
	public String approveWorkInfo() {
		BufferedReader bu;
		try {
			bu = ServletActionContext.getRequest().getReader();
			String str = StringUtil.bufferString(bu);
			//保存数据监控
			WfsMonitorVo vo=new WfsMonitorVo();
			vo = JSONObject.parseObject(str,
					WfsMonitorVo.class);
			vo.setType("1");
			vo.setRemark2(str);
			WFSMonitorUtil.addMonitor(null, null, null, null, null, 
					null, vo.getErrorInfo(), ServletActionContext.getRequest().getSession(), this.monitorService,vo,"");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	 /**
   	 * @param monitorService the monitorService to set
   	 */
	public void setMonitorService(IMonitorService monitorService) {
		this.monitorService = monitorService;
	}

}