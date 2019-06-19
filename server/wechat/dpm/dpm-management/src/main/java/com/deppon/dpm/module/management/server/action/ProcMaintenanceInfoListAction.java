package com.deppon.dpm.module.management.server.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.server.util.JsonUtil;
import com.deppon.dpm.module.management.server.service.IProcMaintenanceInfoListService;

/**
 * 工程维修信息action层
 * @author 曹嵩
 * <p>时间:2015.9.29</p>
 */
public class ProcMaintenanceInfoListAction extends BaseAction{

	/**
	 * 序号.
	 */
	private static final long serialVersionUID = 1L;
	
	//日志
	private static Logger logger = LoggerFactory.getLogger(ProcMaintenanceInfoListAction.class);
	
	/**
	 * 当前页面.
	 */
	private int pageNum;
	
	/**
	 * 页面显示多少条数据.
	 */
	private int pageSize;
	
	//注入service
	private IProcMaintenanceInfoListService procMaintenanceInfoListService;
	//get set
	public int getPageNum() {
		return pageNum;
	}
	//get set
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	//get set
	public int getPageSize() {
		return pageSize;
	}
	//get set
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public IProcMaintenanceInfoListService getProcMaintenanceInfoListService() {
		return procMaintenanceInfoListService;
	}

	public void setProcMaintenanceInfoListService(
			IProcMaintenanceInfoListService procMaintenanceInfoListService) {
		this.procMaintenanceInfoListService = procMaintenanceInfoListService;
	}

	/**
	 * 得到工程维修list数据
	 */
	public void procMainListShow(){
		logger.info(">>>>>>>>进入工程维修信息action的方法procMainListShow");
		// 设置页面响应实体
				String res = "";
				HttpServletResponse response = ServletActionContext.getResponse();

				response.setHeader("Access-Control-Allow-Origin", "*");
				//页面响应体
				response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
				response.addHeader(
						"Access-Control-Allow-Headers",
						"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
				try {
					//得到数据
					res = JsonUtil.beanToJsonString(procMaintenanceInfoListService.getProcMainList(pageNum, pageSize, userId));
					logger.info("设置成功.");
				} catch (Exception e) {
					logger.info(">>>>工程维修信息action的方法procMainListShow出现异常"+res);
					e.printStackTrace();
				}
				//写入数据
				writeToPage(response, res);
	}

}
