package com.deppon.dpm.module.management.server.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author 274858
 * 
 * 工程维修加注释
 * 
 * 工程维修状态更新接口
 * 
 * 工程维修状态更新接口
 */
@Path("procMaintainStaUpdClass")
public interface IProcMaintainStaticUpdateServieceService {
	/**
	 * 与PC端数据同步接口
	 * 
	 * 
	 * @param json
	 */
	@POST
	@Path("staUpdMet")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateRecSendState(String json);
	//更新东西
	/*
	 * //更新东西
	 * 
	 * 
	 */
	
}
