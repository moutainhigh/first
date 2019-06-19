package com.deppon.dpm.module.management.server.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * 提交上报问题后推送消息给处理人
 * 移动办公IT服务台图标当有任务下发时，右上方显示任务数量
 * @author 237986
 * @date 2015-04-07 17:58:10
 *
 */
@Path("terminalService")
public interface ITerminalMessageService {
	/**
	 * 接收終端消息
	 * @param json
	 * @return
	 */
	@POST
	@Path("receiveTerminalMessage")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response receiveTerminalMessage(String json);
}
