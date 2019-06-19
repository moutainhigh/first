package com.deppon.dpm.module.lsp.server.service;
import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("stockTask")
public interface IReceiveStockTaskService {
	/**
	 * 接收LSP推送的盘点任务列表和资产更新消息
	 * @date 2015/03/18 09:10:11
	 * @author 237986
	 * @param stn
	 * @return //这是接口
	 */
	@POST
	@Path("processRestResponse")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response processRestResponse(String strJson) throws  IOException;
}
