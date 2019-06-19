package com.deppon.dpm.module.management.server.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.deppon.dpm.module.management.shared.domain.ProcCheckTaskEntity;
import com.deppon.dpm.module.management.shared.domain.TaskSubmitEntity;

/**
 * 验收记录查询相关
 * @author 王亚男
 *
 */
@Path("get")
public interface IProcRecordService {
	
	/**
	 * 分页查询验收任务信息
	 * @param pageNum 页码数
	 * @param pageSize 每页长度
	 * @return 
	 */
	public List<ProcCheckTaskEntity> getCheckTaskPage(int pageNum,int pageSize,String deptName,String userId);
	
	/**
	 * 推送任务总数
	 * @return
	 */
	public int getCount(String deptName,String userId);
	
	/**
	 * 向PC推送数据 最终提交
	 * @param number 项目编码
	 * @return JONS TaskSubmitEntity
	 */
	public String getTaskToPC(String number);
	
	/**
	 * PC端项移动端请求数据 task
	 * @param json 任务头信息
	 * @return JONS TaskSubmitEntity
	 */
	@POST
	@Path("getTaskForPC")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTaskForPC(String json);
	
	/**
	 * 根据项目编码得到要推送数据 明细信息
	 * @param number 项目编码
	 * @return TaskSubmitEntity
	 */
	public TaskSubmitEntity getTaskSubmitEntity(String number);


}
