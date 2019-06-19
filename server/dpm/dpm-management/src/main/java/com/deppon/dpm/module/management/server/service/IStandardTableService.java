package com.deppon.dpm.module.management.server.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



/**
 * 
 * @author 王亚男
 * 验收明细基础数据表接口
 *
 */
@Path("synchroData")
public interface IStandardTableService {
	
	/**
	 * 与PC端数据同步接口
	 * @param json
	 */
	@POST
	@Path("updateStandardTable")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateStandardTable(String json);
	
	/**
	 * 得到所有基础数据
	 * @return
	 */
//	public List<StandardTableEntity> getStandardList();
	

}
