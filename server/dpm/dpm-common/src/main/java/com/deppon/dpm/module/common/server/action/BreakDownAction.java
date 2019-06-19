package com.deppon.dpm.module.common.server.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.dpm.module.common.server.service.IBreakDownService;
import com.deppon.dpm.module.common.shared.domain.BreakDownEntity;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BreakDownAction extends ActionSupport implements ModelDriven<BreakDownEntity>{
	//序列号
	private static final long serialVersionUID = -6974844971613385042L;
	//获取日志
	private final static Logger LOG = LoggerFactory.getLogger(BreakDownAction.class);
	//封装参数的实体类
	private BreakDownEntity entity = new BreakDownEntity();
	//接口
	private IBreakDownService breakDownService;
	//setter
	public void setBreakDownService(IBreakDownService breakDownService) {
		this.breakDownService = breakDownService;
	}
	//复写ModelDriven的方法
	@Override
	public BreakDownEntity getModel() {
		return entity;
	}
	//当app崩溃后再次启动调用
	public void handleBreakDownInfo(){
		//日志输出
		LOG.info("开始处理崩溃信息，参数====>{empCode:"+entity.getEmpCode()+",osType:"+entity.getOsType()
				+",version:"+entity.getVersion()+",occurTime:"
				+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(entity.getOccurTime())
				+",reason:"+entity.getReason()+"}");
		//定义打印流
		PrintWriter writer = null;
		try {
			//获取response的输出流
			writer = ServletActionContext.getResponse().getWriter();
			//保存崩溃信息
			int i = breakDownService.saveBreakBownInfo(entity);
			//0表示成功，1表示失败
			if( i == 1){
				writer.write("{\"status\":200}");
			}else{
				writer.write("{\"status\":500}");
			}
		} catch (Exception e) {
			//异常处理
			if( null != writer){
				writer.write("{\"status\":500}");
			}
			//日志
			LOG.error("处理崩溃信息失败!!!参数====>{empCode:"+entity.getEmpCode()+",osType:"+entity.getOsType()
				+",version:"+entity.getVersion()+",occurTime:"
				+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(entity.getOccurTime())
				+",reason:"+entity.getReason()+"}");
		}finally{
			if (null != writer) {
				// 关闭流
				writer.close();
			}
		}
	}
}
