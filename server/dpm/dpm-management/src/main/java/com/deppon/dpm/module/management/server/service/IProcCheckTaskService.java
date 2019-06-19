package com.deppon.dpm.module.management.server.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**   
* @Description: 接收并保存验收任务和查询验收任务数量
* @author 268087 张广波
* @date 2015-11-16 下午1:56:49 
* @version V1.0 
*/
@Path("procCheckTask")
public interface IProcCheckTaskService {
	
	/** 
	* @Description: 保存验收任务
	* @author 268087 张广波
	* @date 2015-11-16 下午1:58:42 
	*  @param jsonParam
	*  @return 
	*/
	@POST
	@Path("saveCheckTask")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)	
	public Response saveCheckTask(String jsonParam);
	
	/** 
	* @Description: 根据当前登录人工号查询验收任务数量
	* @author 268087 张广波
	*  @param empNo
	* @date 2015-8-14 下午3:36:42 
	*  @return 
	*/
	public int queryTaskCount(String empNo);
	
}	
