package com.deppon.dpm.module.wfs.server.util.monitor;

import javax.servlet.http.HttpSession;

import com.deppon.dpm.module.wfs.server.service.IMonitorService;
import com.deppon.dpm.module.wfs.shared.vo.WfsMonitorVo;
/**
 * 报错预警 异步调用
 * @author gcl
 */
public class WorkFlowMonitor implements Runnable {
    public IMonitorService monitorService; 
    public WfsMonitorVo vo;
    public String errorInfo;
    public HttpSession session;
    
    
    @Override
    public void run() {
    	try{
    		//kpi监测
    		monitorService.addWfsMonitor(vo);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	//报错预警
        monitorService.warningForB9(session,errorInfo, vo);
    }

}
