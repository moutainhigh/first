package com.deppon.dpm.login.server.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


@Produces("application/json")
@Consumes("application/json")
public interface IModifyLoginPasswordService {
	/**
	 * 修改密码
	 * @param request
	 */
	@POST
	@Path("/modify")
	public Response modifyPassword(String request);
	
	/**
	 * 发送验证码
	 * @param request
	 */
	@POST
	@Path("/send")
	public Response sendMsm(String request);
}
