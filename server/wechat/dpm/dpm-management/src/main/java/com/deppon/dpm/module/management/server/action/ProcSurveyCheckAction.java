package com.deppon.dpm.module.management.server.action;

import java.io.BufferedReader;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSONObject;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.module.management.server.service.IProcSurveyCheckService;
import com.deppon.dpm.module.management.shared.domain.ProcSurveyCheck;

/**
 * 勘测
 * @author 293888
 *
 */
public class ProcSurveyCheckAction extends BaseAction {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * service
	 */
	private IProcSurveyCheckService procSurveyCheckService;

	public void getProjectList() {
		//返回
		HttpServletResponse response = null;
		//拼装结构集
		Result<List<ProcSurveyCheck>> result = null;
		try {
			//响应
			response = ServletActionContext.getResponse();
			// 设置页面响应实体
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Methods",
					"GET, POST, OPTIONS");
			response.addHeader(
					"Access-Control-Allow-Headers",
					"Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
			BufferedReader bu = ServletActionContext.getRequest().getReader();
			String str = com.deppon.dpm.module.common.server.util.StringUtil
					.bufferString(bu);
			JSONObject json = new JSONObject().parseObject(str);
			result = new Result<List<ProcSurveyCheck>>();
			//非空判断
			if (null != json) {
				//获得参数
				String userNo = json.getString("userNo").trim();
				if (null != userNo && !"".equals(userNo)) {
					//调用service
					List<ProcSurveyCheck> list = procSurveyCheckService
							.getProjectList(userNo, null);
					result.setData(list);
					if (null != list) {
						result.setCount(list.size());
					}
				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		//返回结果
		writeToPage(response, result);
	}

	/**
	 * service
	 * 
	 * @return
	 */
	public IProcSurveyCheckService getProcSurveyCheckService() {
		return procSurveyCheckService;
	}

	public void setProcSurveyCheckService(
			IProcSurveyCheckService procSurveyCheckService) {
		this.procSurveyCheckService = procSurveyCheckService;
	}

}
