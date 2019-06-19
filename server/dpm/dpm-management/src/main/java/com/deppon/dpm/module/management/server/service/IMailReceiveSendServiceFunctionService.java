package com.deppon.dpm.module.management.server.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author 274858
 * 收发室签收、拒绝、注销、催领  服务器
 */
@Path("mailRecSenSerFunImple")
public interface IMailReceiveSendServiceFunctionService {

	/**
	 * 与PC端数据同步接口
	 * @param json
	 */
	@POST
	@Path("updateRecSendState")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateRecSendState(String json);
	//public Response updateRecSendState(String json)
	
	
}
