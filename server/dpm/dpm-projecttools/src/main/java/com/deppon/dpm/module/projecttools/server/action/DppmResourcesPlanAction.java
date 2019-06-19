package com.deppon.dpm.module.projecttools.server.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.common.server.util.StringUtil;
import com.deppon.dpm.module.projecttools.server.service.IDppmMonitorService;
import com.deppon.dpm.module.projecttools.server.service.IDppmResourcesPlanService;
import com.deppon.dpm.module.projecttools.server.util.com.deppon.dpm.module.wfs.server.util.monitor.MonitorUtil;

/**
 * 项目管理工具资源计划
 * @author 251624
 *
 */
public class DppmResourcesPlanAction extends BaseAction{
    
    /****/
    private static final long serialVersionUID = 1L;
    /*** 日志*/
    private Logger logger = LoggerFactory.getLogger(DppmResourcesPlanAction.class);
    private IDppmMonitorService dppmMonitorService;
    private String userId;
    private String dateStr;
    private IDppmResourcesPlanService dppmResourcesPlanService;
    
    /**
     * 资源计划
     */
    public void dppmDeptResPlan(){
        HttpServletResponse response = ServletActionContext.getResponse();
        Map<String,Object> retMap = new HashMap<String,Object>();
        try{
            logger.info("dppmDeptResPlan param is: userId=" + userId + " dateStr=" + dateStr);
            if(StringUtil.isEmpty(userId) || StringUtil.isEmpty(dateStr)){
                logger.info("资源计划-部门人员占比请求参数为空");
                retMap.put("code", 1);
                retMap.put("error", "请求参数错误");
            }else{
                retMap = dppmResourcesPlanService.getDeptPeopleInfo(userId, dateStr);
            }
        }catch(Exception ex){
            retMap.put("code", 1);
            retMap.put("error", "请求出现异常");
            logger.info("资源计划数据请求出现异常",ex);
        } finally {
            //数据监控
            //数据监控
            MonitorUtil monitorUtil = new MonitorUtil();
            monitorUtil.dateMonitor(this.userId, "17", null, dppmMonitorService);
        }
        
        response.setHeader("Access-Control-Allow-Origin", "*");
        writeToPage(response, JsonUtil.mapToJsonString(retMap));
    }
    
    
    public void setDppmResourcesPlanService(
            IDppmResourcesPlanService dppmResourcesPlanService) {
        this.dppmResourcesPlanService = dppmResourcesPlanService;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }
    public void setDppmMonitorService(IDppmMonitorService dppmMonitorService) {
        this.dppmMonitorService = dppmMonitorService;
    }
}
