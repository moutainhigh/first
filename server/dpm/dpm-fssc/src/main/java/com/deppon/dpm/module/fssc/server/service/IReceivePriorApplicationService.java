package com.deppon.dpm.module.fssc.server.service;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author 268101 差旅接口
 *
 */
@Path("priorApplication")
public interface IReceivePriorApplicationService {
	/**
	 * 接收事前申请单的消息和更新事前申请单的消息
	 * @author 曹嵩
	 * @date 2015-6-2
	 * @param strJson
	 * @return //这个是接口
	 * @throws IOException
	 */
	@POST
	@Path("process")
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Response process(String strJson) throws IOException;
}
