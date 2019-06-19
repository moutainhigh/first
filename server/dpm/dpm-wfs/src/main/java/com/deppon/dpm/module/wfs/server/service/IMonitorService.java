package com.deppon.dpm.module.wfs.server.service;

import javax.servlet.http.HttpSession;

import com.deppon.dpm.module.wfs.shared.vo.WfsMonitorVo;
/**
 * 
 * 工作流数据监控 Interface
 **/
public interface IMonitorService {

	public void addWfsMonitor(WfsMonitorVo vo);
	public void warningForB9(HttpSession session,String errorInfo,WfsMonitorVo vo);
}
