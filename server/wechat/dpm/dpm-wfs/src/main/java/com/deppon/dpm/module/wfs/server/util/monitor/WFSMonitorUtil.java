package com.deppon.dpm.module.wfs.server.util.monitor;

import java.util.Date;

import javax.servlet.http.HttpSession;

import com.deppon.dpm.module.wfs.server.service.IMonitorService;
import com.deppon.dpm.module.wfs.shared.vo.WfsMonitorVo;
/**
 * 报错预警 异步调用 公共方法
 * @author gcl
 * 2015-08-31
 */
public class WFSMonitorUtil {
	/**
	 * 保存数据监控 公共方法
	 * @param userId  当前审批人
	 * @param type    查看 审批类型  0查看  1审批
	 * @param flowtype  工作流类型 流程定义ID
	 * @param begindate 开始时间（记录后台处理时间）
	 * @param busino   工作流申请单编号
	 * @param issuccess 查看或者申请是否成功
	 * @param errorInfo 失败时错误信息
	 * @param session
	 * @param monSrv  预警接口 
	 */
	public static void addMonitor(String userId,String type,String flowtype,Date begindate,
			String busino,String issuccess,String errorInfo,HttpSession session,
			IMonitorService monSrv,WfsMonitorVo vo,String remark2){
		//保存数据监控
		if(vo == null){
			vo = new WfsMonitorVo();
			vo.setUserId(userId);
			vo.setType(type);
			vo.setWorkflowname(flowtype);
			vo.setBegindate(begindate);
			vo.setEnddate(new Date());
			vo.setRemark(busino);
			vo.setRemark2(remark2);
			vo.setIssuccess(issuccess);
		}
		
		WorkFlowMonitor wm = new WorkFlowMonitor();
		wm.monitorService = monSrv;
		wm.vo = vo;
		wm.errorInfo = errorInfo;
		wm.session = session;
		
		Thread thread = new Thread(wm);
		thread.start();
	}

}
