package com.deppon.dpm.module.common.server.action;

import java.io.PrintWriter;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.deppon.dpm.module.common.server.service.INazaInvokeMonitorService;
import com.deppon.dpm.module.common.shared.domain.NazaInvokeMonitorEntity;
import com.opensymphony.xwork2.ModelDriven;

public class NazaInvokeMonitorAction extends BaseAction implements ModelDriven<NazaInvokeMonitorEntity>{

	// 创建实例
	private NazaInvokeMonitorEntity entity = new NazaInvokeMonitorEntity();
	
	// service
	private INazaInvokeMonitorService nazaInvokeMonitorService;
	
	// 模型
	public NazaInvokeMonitorEntity getModel() {
		return entity;
	}
	
	/**
	 * 保存
	 */
	public void save(){
		//定义打印流
		PrintWriter writer = null;
		try {
			//获取response的输出流
			writer = ServletActionContext.getResponse().getWriter();
			//保存信息
			nazaInvokeMonitorService.save(getModel());
			writer.write("{\"status\":200}");
		} catch (Exception e) {
			//异常处理
			if( null != writer){
				writer.write("{\"status\":500}");
			}
		}finally{
			if (null != writer) {
				// 关闭流
				writer.close();
			}
		}
	}
	
	public void queryByCondition(){
		List<NazaInvokeMonitorEntity> list = nazaInvokeMonitorService.queryByCondition(entity);
		writeToPage(list);
	}
	
	// setter
	public void setNazaInvokeMonitorService(
			INazaInvokeMonitorService nazaInvokeMonitorService) {
		this.nazaInvokeMonitorService = nazaInvokeMonitorService;
	}
}
