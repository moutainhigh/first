package com.deppon.dpm.module.wfs.server.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.deppon.dpm.module.common.server.action.BaseAction;
import com.deppon.dpm.module.common.shared.vo.Result;
import com.deppon.dpm.module.wfs.server.service.IWfsInterceptService;
import com.deppon.dpm.tongxunlu.server.util.CookieNotCheckedRequired;

public class WfsInterceptAction extends BaseAction{

	private IWfsInterceptService wfsInterceptService;
	
	/**
	 * 工作流拦截器状态
	 */
	private String wfstatus;

    @CookieNotCheckedRequired
	public void updateWfsSwitch(){
		Result<String> result = new Result<String>();
		try {
			wfsInterceptService.updateWfsSwitch(wfstatus);
		} catch (Exception e) {
			// TODO: handle exception
		}
		//data 
		result.setData("更改工作流拦截器状态为：" + wfstatus);
		// 返回给前端
		writeToPage(result);
	}
	
	
    /**
	 * 重写writeToPage
	 */
	protected void writeToPage(Object result) {
		// TODO Auto-generated method stub
		// 定义输出流
		PrintWriter writer = null;
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			// 设置响应类型
			response.setContentType("text/html;charset=utf-8");
			// 跨域设置
			response.setHeader("Access-Control-Allow-Origin", "*");
			// 获取一个printWriter对象
			writer = response.getWriter();
			// 打印,将null值输出为空字符串
			// writer.write(JSON.toJSONString(result,
			// SerializerFeature.WriteNullStringAsEmpty));
			writer.write(JSON.toJSONString(result,
					SerializerFeature.DisableCircularReferenceDetect));
		} catch (IOException e) {
			// 错误打印
			e.printStackTrace();
		} finally {
			if (writer != null) {
				// 关闭流
				writer.close();
			}
		}
	}


	public String getWfstatus() {
		return wfstatus;
	}

	public void setWfstatus(String wfstatus) {
		this.wfstatus = wfstatus;
	}


	public IWfsInterceptService getWfsInterceptService() {
		return wfsInterceptService;
	}


	public void setWfsInterceptService(IWfsInterceptService wfsInterceptService) {
		this.wfsInterceptService = wfsInterceptService;
	}

	
}
